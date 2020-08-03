package com.example.payment2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.payment2.entity.User;
import com.example.payment2.service.UserService;
import com.example.payment2.user.CrmUser;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String getAllUser(Model theModel) {
		
		List<User> userList= userService.getAllUser();
		theModel.addAttribute("users", userList);
		
		return "list-users";
	}
	
	@GetMapping(value = "/showFormForUpdate", params = "userId")
	public String showFormForUpdate(@RequestParam(value = "userId", required = true) int userId,
									Model theModel) {
		User theUser = userService.getUser(userId);
		CrmUser theCrmUser = new CrmUser(theUser.getUserName(),theUser.getFirstName(),
										 theUser.getLastName(),theUser.getEmail());
		theModel.addAttribute("crmUser", theCrmUser);
		//theModel.addAttribute("crmUser", new CrmUser());
		return "registration-form-update";
	}
	
	@GetMapping(value = "/delete", params = "userId")
	public String deleteCustomer(@RequestParam(value = "userId", required = true) int userId) {
		userService.deleteUser(userId);
		return "redirect:/user";
	}
}
