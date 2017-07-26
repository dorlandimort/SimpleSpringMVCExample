package com.cuentas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceImpl implements DataSource {
	
	private javax.sql.DataSource dataSource;

	public Object executeQuery(String query) {
		ResultSet rs = null;
		try {
			Connection conn = this.dataSource.getConnection();
			Statement st = conn.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public javax.sql.DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(javax.sql.DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

}
