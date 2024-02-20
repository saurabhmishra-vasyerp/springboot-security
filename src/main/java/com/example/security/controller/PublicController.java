package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.security.dto.UserDetailDto;
import com.example.security.service.UsersAndAuthorityService;

@Controller
@RequestMapping("/public")
public class PublicController {
	private UsersAndAuthorityService usersAndAuthorityService;

	public PublicController(UsersAndAuthorityService usersAndAuthorityService) {
		this.usersAndAuthorityService = usersAndAuthorityService;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("IndexPage");
		return mav;
	}
	
	
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("Registerpage");
		return mav;
	}
	
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam String username,
            @RequestParam String password,
            @RequestParam String role) {
		UserDetailDto userDetailDto = new UserDetailDto();
		userDetailDto.setUsername(username);
		userDetailDto.setPassword(password);
		userDetailDto.setAuthority(role);
		usersAndAuthorityService.addUserDetail(userDetailDto);
		return "redirect:/login";
	}
	

}
