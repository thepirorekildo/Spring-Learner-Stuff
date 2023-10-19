package com.rekildo.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("home")
	@ResponseBody
	public String run() {
		System.out.println("Hi rek.. $#$#$$");
		return "home.jsp";
	}
}
