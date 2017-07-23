package org.at.service.impl;

import java.util.List;

import org.at.dao.ClassesDao;
import org.at.dao.UserDao;
import org.at.dao.impl.UserDaoHibernate4;
import org.at.domain.Classes;
import org.at.domain.User;
import org.at.service.UserService;
import org.hibernate.SessionFactory;

public class UserServiceImpl implements UserService{
	//private SessionFactory sessionFactory; 发生了模板同名覆盖，前面的有效
	private UserDao userDao;
	private ClassesDao classesDao;
	
	public User get(int id) {
		return (User) userDao.get(User.class, id);
	}
	
	@Override
	public List findByName(String name) {
//		System.out.println("I'm here 2: " + this.getClass().getName() );
		//return new UserDaoHibernate4().findByName(User.class, name);
		return userDao.findByName(User.class, name);
	}
	@Override
	public void save(User u) {
		userDao.save(u);
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public ClassesDao getClassesDao() {
		return classesDao;
	}
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}

	@Override
	public void update(User u) {
		userDao.update(u);
	}

	public void removeClass(User u, Classes clazz) {
		//userDao.delete(clazz);
		
	}

	@Override
	public void delete(User u) {
		userDao.delete(u);
	}

}
