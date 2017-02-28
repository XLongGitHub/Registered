package org.at.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "123456aa");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Statement getStmt(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	public static ResultSet getRs(Connection conn, String sql) {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet getRs(Statement stmt, String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static int insert(Connection conn, String sql) {
		Statement stmt = null;
		int count = 0;
		
		try {
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static int insert(Statement stmt, String sql) {
		int count = 0;
		
		try {
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	
	public static void main(String[] args) {
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sql = "select * from user where username = 'd'";
		try {
			conn = new DB().getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println(rs.next());
//			User user = new User();
//			rs.next();  //返回的rs指向数据起点，此时游标处记录内容为空
//			user.init(rs);
//			System.out.println(user.getUsername() + "  " + user.getPassword() );
			
//			while (rs.next()) {
//				// System.out.println(rs.getString(0));
//				System.out.println(rs.getString("username") + " " + rs.getString("password"));
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
