package com.cuentas.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cuentas.dao.CuentaDAO;
import com.cuentas.pojos.Cuenta;

@Controller
public class LoginController {
	
	CuentaDAO dao;
	
	@RequestMapping("/login")
	public String doLogin(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String user = request.getParameter("usuario");
		String password = request.getParameter("password");
		Cuenta cuenta = dao.validarCuenta(user, password);
		
		if (cuenta != null) {
			request.getSession().setAttribute("cuenta", cuenta);
			return "redirect:/cuentas";
		} else {
			model.addAttribute("mensaje", "Error, usuario y/o contraseña no válidos");
			return "index";
		}
			
	}

	public CuentaDAO getDao() {
		return dao;
	}

	public void setDao(CuentaDAO dao) {
		this.dao = dao;
	}
	
}
