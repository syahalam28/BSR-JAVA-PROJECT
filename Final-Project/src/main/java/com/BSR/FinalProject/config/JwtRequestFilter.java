package com.BSR.FinalProject.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.BSR.FinalProject.service.JwtUserDetailService;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

//@Component sama seperti library
@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUserDetailService jwtUserDetailService;


	private final JwtToken jwtTokenUtil;

	public JwtRequestFilter(JwtToken jwtTokenUtil) {

		this.jwtTokenUtil = jwtTokenUtil;
	}

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");
		System.out.println(requestTokenHeader);
		String username = null;
		String jwtToken = null;

//		Header Authorization: Bearer (Tokennya)
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//			Ambil Tokennya
			jwtToken = requestTokenHeader.substring(7);
			try {
//				Mengambil Token Untuk name get jwt Token name
				username = jwtTokenUtil.getUsernameFormToken(jwtToken);

			} catch (IllegalArgumentException e) {
				// TODO: handle exception
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				// TODO: handle exception
				System.out.println("JWT Token has expired");
			}

		} else if (requestTokenHeader == null) {
			logger.info("Does Not Provide Authorization Header");
		} else if (!requestTokenHeader.startsWith("Bearer ")) {
			logger.warn("JWT Token Does Not Begin With Bearer");
		}

//		Membandingkan Username
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			Compare Username
			 UserDetails userDetails = this.jwtUserDetailService.loadUserByUsername(username);
			  if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
				  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
						  new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				  usernamePasswordAuthenticationToken
				  .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				  SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				  
			  }
		}
		
		 filterChain.doFilter(request, response);

	}

}
