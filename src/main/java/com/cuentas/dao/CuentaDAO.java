package com.cuentas.dao;

import java.util.List;

import com.cuentas.pojos.Cuenta;

public interface CuentaDAO {
	
	public Cuenta validarCuenta(String user, String password);
	public List<Cuenta> obtenerCuentas();

}
