package h.h.bank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout() {
		return "logout";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "join";
	}
}
