package com.cuentas.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cuentas.pojos.Cuenta;

@Controller
public class BaseController {
	
	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse res) {
		Cuenta cuenta = (Cuenta) request.getSession().getAttribute("cuenta");
		if (cuenta != null)
			return "redirect:/cuentas";
		return "index";
	}

}
