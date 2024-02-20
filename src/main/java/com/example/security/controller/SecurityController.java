package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {
	@GetMapping("/user")
	public ModelAndView user() {
		ModelAndView mav = new ModelAndView("UserPage");
		return mav;
	}

	@GetMapping("/admin")
	public ModelAndView admin() {
		ModelAndView mav = new ModelAndView("AdminPage");
		return mav;
	}
//	@GetMapping("/customLogin")
//	public ModelAndView login() {
//		ModelAndView mav = new ModelAndView("LoginPage");
//		return mav;
//	}

}
