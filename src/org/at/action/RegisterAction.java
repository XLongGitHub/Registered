package org.at.action;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.at.util.DB;

/*@WebServlet(name="register",urlPatterns )*/
public class RegisterAction  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("register");
		//if (username.equals("admin") && password.equals("admin")) {
			//resp.sendRedirect("registerSuccess.jsp");
			
//			this.getServletConfig().getServletContext().getRequestDispatcher("registerSuccess.jsp").forward(req, resp);
//			 Path registerSuccess.jsp does not start with a "/" character
		if (isExits(username, password)) {
			this.getServletConfig().getServletContext().getRequestDispatcher("/registerSuccess.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("registerFailure.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	public static boolean isExits(String username, String password) {
		Connection conn = DB.getConn();
		String sql = "select * from user where username = '" + username+"'";
		ResultSet rs = DB.getRs(conn, sql);
		try {
			if (!rs.next()) return false;
			if (rs.getString("username").equals(username) && rs.getString("password").equals(password))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
