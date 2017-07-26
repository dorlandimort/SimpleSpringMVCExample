package com.cuentas.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public String doLogout(HttpServletRequest request) {
		request.getSession().removeAttribute("cuenta");
		return "redirect:/";
	}

}
