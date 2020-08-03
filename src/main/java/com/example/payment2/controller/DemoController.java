package com.example.payment2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		
		return "index";
	}
	
	@GetMapping("systems")
	public String showSystems() {
		
		return "systems";
	}
}
