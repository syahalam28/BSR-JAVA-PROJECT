package com.BSR.FinalProject.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtToken implements Serializable {
	private static final long serialVersionUID = -2550185165626007488L;

	  public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;

//	Method untuk parser/ekstrak token menjadi Object
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

//	 Method mengambil token untuk getUsername parsing token ke dalam bentuk object json untuk ambil name
	public String getUsernameFormToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

//	Parsing token expire ke dalam date
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

//	Pengecekan token expired berdasarkan date yang terbentuk pada token dan date sekarang
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

//	Membuat Validasi Token yang diambil dari jwt 
	public Boolean validateToken(String token, UserDetails userDetail) {
		final String username = getUsernameFormToken(token);
		return (username.equals(userDetail.getUsername()) && !isTokenExpired(token));

	}

//	Membuat Method Generate token
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		  return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
	                .signWith(SignatureAlgorithm.HS512, secret).compact();
	}

}

