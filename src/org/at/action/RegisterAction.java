package org.at.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.at.domain.User;
import org.at.service.ClassesService;
import org.at.service.UserService;
import org.at.util.DB;
import org.at.util.SF;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	//private SessionFactory sessionFactory;
	
	private String username;
	private String password;
	private String password2;
	
	private ClassesService classesService;
	private UserService userService;
	
	public  boolean isExits(String username, String password) {
//		SessionFactory sf = SF.getSf();
//		Session session = sf.openSession();
//		List users = session.createSQLQuery("select username,password from user where username='"+username+"'").list();
		//User u = userService.
		List u = userService.findByName(username);
		//System.out.println(u.size());
		if (u.size() > 0 ) {
			//System.out.println(u.getPassword().);
			return true;
		}
		return false;
	}
	
	public  boolean register(String username, String password) {
//		SessionFactory sf = SF.getSf();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		User user = new User();
//		user.setPassword(password);
//		user.setUsername(username);
//		session.save(user);
//		tx.commit();
//		session.close();
		User u = new User(username, password);
		userService.save(u);
		return true;
	}

	@Override
	public String execute() throws Exception {
		
//		Session session = sessionFactory.openSession();
//		List users = session.createSQLQuery("select username,password from user where username='"+username+"'").list();
//		if (users.isEmpty()) {
//			Transaction tx = session.beginTransaction();
//			User user = new User();
//			user.setPassword(password);
//			user.setUsername(username);
//			session.save(user);
//			tx.commit();
//			session.close();
//			
//			return SUCCESS;
//		}
		
		List user = userService.findByName(username);
		if (user.size() == 0) {
			userService.save(new User(username, password));
			return SUCCESS;
		}
		return ERROR;
		
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

	public ClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
