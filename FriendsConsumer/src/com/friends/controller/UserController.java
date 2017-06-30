package com.friends.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/regUser")
	public String showUserReg(ModelMap map){
		return "UserReg";
	}
	@RequestMapping("/loginUser")
	public String showUserLogin(){
		return "UserLogin";
	}

}
