package org.at.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.at.util.DB;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private String username;
	private String password;
	private String password2;

	public static boolean isExits(String username, String password) {
		Connection conn = DB.getConn();
		String sql = "select * from user where username = '" + username + "'";
		System.out.println(username);
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

	public static boolean register(String username, String password) {
		Connection conn = DB.getConn();
		String sql = "insert into user value( null, '" + username + "','" + password + "')";
		int result = DB.insert(conn, sql);

		return result == 1;

	}

	@Override
	public String execute() throws Exception {

		if (!isExits(username, password)) {
			if (register(username, password)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} else {
			return ERROR;
		}
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
