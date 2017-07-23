package org.at.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.at.dao.impl.UserDaoHibernate4;
import org.at.domain.Classes;
import org.at.domain.User;
import org.at.service.ClassesService;
import org.at.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.messaging.simp.user.UserSessionRegistry;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyClassAction extends ActionSupport{
	
	private ClassesService classesService;
	private UserService userService;
	private List<Classes> classes;// = new ArrayList<>(); 分配局部空间
	private SessionFactory sessionFactory;
	private int num;
	
	public String choose() {
		String ids = ServletActionContext.getRequest().getParameter("id");
		ids = ids.replaceAll("\\'", "");
		int class_id = Integer.parseInt(ids);

		int user_id = (int) ActionContext.getContext().getSession().get("user_id");
		System.out.println("******************************"+user_id+"**********");		
		User u = userService.get(user_id);
		Classes clazz = classesService.get(class_id);
		u.getClasses().add(clazz);
		//userService.save(u);
		userService.update(u);
		//u.getClasses().add(classesService.get(class_id));
		
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		Classes clazz = (Classes) session.load(Classes.class, class_id);
//		User user = (User) session.load(User.class, user_id);
//		user.getClasses().add(clazz);
//		tx.commit();
//		session.close();
		return SUCCESS;
	}
	
	public String list() {
		int user_id = (int) ActionContext.getContext().getSession().get("user_id");
		User u = userService.get(user_id); //此时主键改变，由于delete操作，因此在该操作后续更新主键
	//	System.out.println();
		
		System.out.println(u.getId()+ " :" + u.getUsername()) ;
		Set classess = u.getClasses();
		System.out.println("iniit " + (classess == null));
		classes = new ArrayList<>();  //使得每次数据包含上一次的数据
//		Session session = sessionFactory.openSession();
//		int user_id = (int) ActionContext.getContext().getSession().get("user_id");
//		
//		Transaction tx = session.beginTransaction();
//		User u = (User) session.load(User.class, user_id);
//		Set classess = u.getClasses();
		if (classess != null) {
			//System.out.println(classes.size());
			System.out.println(" size");
			System.out.println(classess.getClass().getSimpleName() + " size");
			for (Iterator item = classess.iterator(); item.hasNext();)
			{
				Classes it = (Classes) item.next();
				classes.add(it);
			}	
		}
//		for (Iterator item = classess.iterator(); item.hasNext();)
//		{
//			Classes it = (Classes) item.next();
//			classes.add(it);
////			classes.add((Classes) item) cast error
//		}
	
			
		//classes = session.createQuery("select c from Classes where c.class_id in ( select user_id from u form User as u where u.user_id = " +user_id +") ").list(); 
//		List classesl =  session.createSQLQuery(" select * from classes where class_id  in ("
//				+ "select class_id from user_class where user_id = " + user_id+ " )").list();
//		System.out.println(classesl);
//		for (int i = 0 ; i<classesl.size(); i+=3) {
//			Classes c = new Classes();
//			c.setId((int) classesl.get(i));  //转型错误
//			c.setClassname((String) classesl.get(i+1));
//			c.setLocation((String) classesl.get(i+2));
//			classes.add(c);
//		}
		
//		1
//		List  class_ids = session.createSQLQuery("select class_id from user_class where user_id ="+ user_id).list();
//		for (int i = 0; i < class_ids.size(); i++) {
//			System.out.println(class_ids.get(i));

			
//Messages:	
//could not resolve property: class_id of: org.at.domain.Classes
//could not resolve property: class_id of: org.at.domain.Classes [select c from org.at.domain.Classes as c where c.class_id = 

//		2
//			List<Classes> temp = session.createQuery("select c from Classes as c where c.id = "+ class_ids.get(i)).list();
//			
//			for (Iterator item = temp.iterator(); item.hasNext();) {
//				Classes c = (Classes) item.next();
//				if (!classes.contains(c));
//				classes.add(c);
//			}
		
			
			/*Iterator<Classes> item = temp.iterator();
				if (item.hasNext()) {
					System.out.println(((Classes) item).getClassname());  //cast error
					item.next();
				}*/
//			for (int j = 0; j < temp.size(); j++) {
//				if (temp.get(j) != null)
//					classes.add((Classes) temp.get(j));
//			}
//		}
//		classes = session.createQuery("select c from ") 
//		Set set = new HashSet();
	
		return SUCCESS;
		}
	
	public String delete() {
		int user_id = (int) ActionContext.getContext().getSession().get("user_id");
		String class_ids = ServletActionContext.getRequest().getParameter("id");
		class_ids = class_ids.replaceAll("\\'", "");
		int class_id = Integer.parseInt(class_ids);
		
//		User u = userService.get(user_id);
//		Classes clazz = classesService.get(class_id);
//		Set<Classes> clazzes = u.getClasses();
//		Set<Classes> new_clazzes = new HashSet<Classes>();
//		for (Iterator<Classes> item = clazzes.iterator(); item.hasNext(); ) {
//			Classes temp = item.next();
//			System.out.println("******************************"+user_id+"**********");
//			if (!temp.equals(clazz))
//				//System.out.println("******************************"+user_id+"**********");
//				new_clazzes.add(temp);
//		}
//		User new_user = new User(u.getId(), u.getUsername(), u.getPassword());
//		userService.delete(u);
//		System.out.println("******************************"+user_id+"**********");
//		//clazzes.remove(clazz);
//		//new_user.setClasses(new_clazzes);
//		System.out.println("******************************"+user_id+"**********"+new_user.getClass().getName()+" id: "+new_user.getId());
//		userService.save(new_user);
//		System.out.println("******************************"+user_id+"**********");
//		user_id = ((User)userService.findByName(new_user.getUsername()).get(0)).getId();
//		System.out.println("******************************"+user_id+"**********");
//		ActionContext.getContext().getSession().put("user_id", user_id);
//		new_user = ((User)userService.findByName(new_user.getUsername()).get(0));
//		for (Iterator<Classes> item = new_clazzes.iterator(); item.hasNext(); ) {
//			 Classes cla = (Classes) item.next();
//			 System.out.println(cla.getClassname()+"*************");
//			 new_user.getClasses().add(cla);
//		}
//		userService.update(new_user);	

	
//		//u.getClasses().remove(clazz);
//		System.out.println("remove********************************"
//				+ "\n*****************");
//		userService.removeClass(u, clazz);
//		//userService.update(u);
//				
//		u.getClasses().add(clazz);
//		userService.update(u);
		Session session = sessionFactory.openSession();
		System.out.println(num+"num*********************");
		System.out.println("ddddddddddd"+(sessionFactory == null));
//		UserDaoHibernate4<User> udao = new UserDaoHibernate4<>();
//		sessionFactory = udao.getSessionFactory();
		//Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//session.saveOrUpdate("delect from user_class where user_id = "+user_id+" and class_id = " + class_id);
		//session.createSQLQuery("delect from user_class where user_id = "+user_id+" and class_id = " + class_id);
		Classes c = (Classes) session.load(Classes.class, class_id);
		User u = (User) session.load(User.class, user_id); 
		u.getClasses().remove(c);
		tx.commit();
		session.close();
		return SUCCESS;
	}
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	public List getClasses() {
		return classes;
	}
	public void setClasses(List classes) {
		this.classes = classes;
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

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
