package com.ashima.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashima.pma.entities.UserAccount;
import com.ashima.pma.service.UserService;

@Controller
@RequestMapping("/register")
public class UserController {


	@Autowired
	UserService userService;
	
	@GetMapping()
	public String register(Model model) {
		UserAccount userAccount = new UserAccount();
		model.addAttribute("userAccount", userAccount);
		return "security/register";
	}
	
	@PostMapping("/save")
	public String saveUserAccount(Model model, UserAccount user) {
		userService.saveUser(user);
		return "redirect:/";
		
	}
}
