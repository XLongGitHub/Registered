package org.at.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.at.util.DB;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

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

	@Override
	public String execute() throws Exception {
		if (isExits(username, password)) {
			return SUCCESS;
		}
		return ERROR;

	}

	public static boolean isExits(String username, String password) {
		Connection conn = DB.getConn();
		String sql = "select * from user where username = '" + username + "'";
		ResultSet rs = DB.getRs(conn, sql);
		try {
			if (!rs.next())
				return false;
			if (rs.getString("username").equals(username) && rs.getString("password").equals(password))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
