package org.at.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.at.domain.Classes;
import org.at.service.ClassesService;
import org.at.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClassAction extends ActionSupport{
	private String username;
	private String passowrd;
	private List<Classes> classes;
	//private SessionFactory sessionFactory;
	private Classes clazz;
	
	private ClassesService classesService;
	private UserService userService;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	
	public String lass() throws Exception {
		
//		Session session = getSessionFactory().openSession();
//		//org.hibernate.hql.internal.ast.QuerySyntaxException: classes is not mapped [select c from classes as c]
//		List<Classes> classes = session.createQuery("select c from Classes as c").list();
//		ActionContext.getContext().getSession().put("classes", classes );
//		System.out.println(classes.size());
//		for (int i =0; i<classes.size(); i++) {
//			System.out.print(classes.get(i).getClass());
//			if (i%3 == 0) System.out.println();
//		}
//		setClasses(classes);   //需要设入之后，前端页面，才能通过标签拿到数据
//		
//		classes = getClassesService().list();
//		setClasses(classes);
		classes = classesService.findAll();
		return SUCCESS;
	}
	
	public String add() throws Exception {
//		System.out.println(clazz.getClassname());
//		Session session = getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(clazz);
//		System.out.println(getClasses().size());
//		tx.commit();
//		session.close();
		classesService.add(clazz);
		return SUCCESS;
	}
	
	public String modify() throws Exception {
//		System.out.println(clazz.getClassname());
//		Session session = getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
//		Classes claz = (Classes) session.get(Classes.class, clazz.getId());
//		claz.setClassname(clazz.getClassname());
//		claz.setLocation(clazz.getLocation());
//		session.update(claz);
//		tx.commit();
//		session.close();
		Classes temp = classesService.get(clazz.getId());
		temp.setClassname(clazz.getClassname());
		temp.setLocation(clazz.getLocation());
		classesService.modify(temp);
		return SUCCESS;
	}
	
	
	
	public String delete() throws Exception {
		
		String  ids= ServletActionContext.getRequest().getParameter("id");
		//char idc = ids.charAt(1);
		ids = ids.replaceAll("\\'", "");
		int id = Integer.parseInt(ids);
////		System.out.println("id" +id+"*********");
//		Session session = getSessionFactory().openSession();
//		session.beginTransaction();
//		Classes clazz = (Classes) session.load(Classes.class, id);
//		session.delete(clazz);
//		session.getTransaction().commit();
		classesService.delete(id);
		return SUCCESS;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public List getClasses() {
		return classes;
	}
	public void setClasses(List classes) {
		this.classes = classes;
	}
	public Classes getClazz() {
		return clazz;
	}
	public void setClazz(Classes clazz) {
		this.clazz = clazz;
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
