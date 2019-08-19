package com.ngoctuan.endpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

	@GetMapping(value = "/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
	
	@GetMapping(value = "/")
	public String root() {
		return "login";
	}

}
