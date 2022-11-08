package com.BSR.FinalProject.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.BSR.FinalProject.entity.User;

@Controller
public class AuthenticationController {
	@GetMapping(value = {"/", "/login"})
	public String login(Model model) {
		model.addAttribute("authentication", new User());
		return "login";

	}
	
	@GetMapping("/register")
	
		public String register(Model model) {
		model.addAttribute("register", new User());
		return "register";
			
		}
		
	

}
