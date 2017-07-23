package org.at.action;
import java.util.List;

import org.at.domain.User;
import org.at.service.ClassesService;
import org.at.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	
	private int user_id;
	private String username;
	private String password;
	
	private ClassesService classesService;
	private UserService userService;
	

	@Override
	public String execute() throws Exception {
		System.out.println(username);
		List users = getUserService().findByName(username);
//		System.out.println("I'm here");
		if (users != null && users.size() == 1) {
			User u = (User) users.get(0); 
			if (u != null && u.getPassword().equals(password)) {
				setUser_id(u.getId());
				System.out.println(u.getId());
				user_id = u.getId();
				setPassword(u.getPassword());
				ActionContext.getContext().getSession().put("user_id", u.getId());
				ActionContext.getContext().getSession().put("username", u.getUsername());
				return SUCCESS;
			}
				
		}
		return ERROR;
	}
	
	public String out () {
		ActionContext.getContext().getSession().put("user_id", null);
		ActionContext.getContext().getSession().put("username", null);
		ActionContext.getContext().getSession().put("password", null);
		return SUCCESS;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
		System.out.println("getuserservice :  " + this.getClass().getName() );
		this.userService = userService;
	}

}