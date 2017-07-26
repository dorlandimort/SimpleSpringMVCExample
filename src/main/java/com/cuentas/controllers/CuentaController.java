package com.cuentas.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cuentas.dao.CuentaDAO;
import com.cuentas.pojos.Cuenta;

@Controller
public class CuentaController {
	
	private CuentaDAO dao;
	
	@RequestMapping("/cuentas")
	public String cuentas(ModelMap model, HttpServletRequest request) {
		Cuenta cuenta = (Cuenta) request.getSession().getAttribute("cuenta");
		if (cuenta == null)
			return "redirect:/";
		List<Cuenta> cuentas = dao.obtenerCuentas();
		model.addAttribute("cuentas", cuentas);
		return "cuentas";
	}

	public CuentaDAO getDao() {
		return dao;
	}

	public void setDao(CuentaDAO dao) {
		this.dao = dao;
	}
	
	
	

}
