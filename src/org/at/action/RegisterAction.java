package org.at.action;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (username.equals("admin") && password.equals("admin")) {
			//resp.sendRedirect("registerSuccess.jsp");
			
//			this.getServletConfig().getServletContext().getRequestDispatcher("registerSuccess.jsp").forward(req, resp);
//			 Path registerSuccess.jsp does not start with a "/" character
			this.getServletConfig().getServletContext().getRequestDispatcher("/registerSuccess.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("registerFailure.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
