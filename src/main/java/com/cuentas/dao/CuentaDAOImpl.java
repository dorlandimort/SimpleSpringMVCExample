package com.cuentas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cuentas.pojos.Cuenta;
import com.cuentas.pojos.Perfil;
import com.cuentas.pojos.Persona;


public class CuentaDAOImpl implements CuentaDAO {
	
	private DataSource dataSource;

	public Cuenta validarCuenta(String user, String password) {
		String query = "Select c.id, c.usuario, c.contrasena, c.estado, " +
				"p.id, p.nombre, p.email, p.estado, " +
				"pr.id, pr.nombre, pr.descripcion, pr.estado " +
				"from cuenta c, persona p, perfil pr " +
				"where c.persona_id = p.id and c.perfil_id = pr.id " +
				"and c.usuario = '" + user + "' " +
				"and c.contrasena = '" + password + "'";
		
		ResultSet rs = (ResultSet) this.dataSource.executeQuery(query);
		Cuenta cuenta = new Cuenta();
		Persona persona = new Persona();
		Perfil perfil = new Perfil();
		cuenta.setPerfil(perfil);
		cuenta.setPersona(persona);
		
		if (rs != null) {
			try {
				if (rs.next()) {
					cuenta.setId(rs.getInt(1));
					cuenta.setUsuario(rs.getString(2));
					cuenta.setContrasena(rs.getString(3));
					cuenta.setEstado(rs.getString(4));
					cuenta.getPersona().setId(rs.getInt(5));
					cuenta.getPersona().setNombre(rs.getString(6));
					cuenta.getPersona().setEmail(rs.getString(7));
					cuenta.getPersona().setEstado(rs.getString(8));
					cuenta.getPerfil().setId(rs.getInt(9));
					cuenta.getPerfil().setNombre(rs.getString(10));
					cuenta.getPerfil().setDescripcion(rs.getString(11));
					cuenta.getPerfil().setEstado(rs.getString(12));
					return cuenta;
					
				}
			} catch (SQLException e ) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Cuenta> obtenerCuentas() {
		String query = "Select c.id, c.usuario, c.contrasena, c.estado, " +
				"p.id, p.nombre, p.email, p.estado, " +
				"pr.id, pr.nombre, pr.descripcion, pr.estado " +
				"from cuenta c, persona p, perfil pr " +
				"where c.persona_id = p.id and c.perfil_id = pr.id";
		
		ResultSet rs = (ResultSet) this.dataSource.executeQuery(query);
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		
		if (rs != null) {
			try {
				while(rs.next()) {
					Cuenta c = new Cuenta();
					Persona persona = new Persona();
					Perfil perfil = new Perfil();
					c.setPerfil(perfil);
					c.setPersona(persona);
					
					c.setId(rs.getInt(1));
					c.setUsuario(rs.getString(2));
					c.setContrasena(rs.getString(3));
					c.setEstado(rs.getString(4));
					c.getPersona().setId(rs.getInt(5));
					c.getPersona().setNombre(rs.getString(6));
					c.getPersona().setEmail(rs.getString(7));
					c.getPersona().setEstado(rs.getString(8));
					c.getPerfil().setId(rs.getInt(9));
					c.getPerfil().setNombre(rs.getString(10));
					c.getPerfil().setDescripcion(rs.getString(11));
					c.getPerfil().setEstado(rs.getString(12));
					cuentas.add(c);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cuentas;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

}
