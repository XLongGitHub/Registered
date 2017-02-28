package org.at.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private int id;
	private String username;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void init(ResultSet rs) {
		try {
			setId(rs.getInt(1));
			setUsername(rs.getString("username"));
			setPassword(rs.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
