package com.cs309.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cs309.services.UserService;
import com.cs309.users.Users;

@Controller
public class LoginController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSequence(@RequestParam String username, @RequestParam String password) {
		Users user = service.userLogin(username, password);

		if (user == null) {
			return "login";
		}

		return "redirect:/";

	}

}
