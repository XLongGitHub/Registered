package org.at.service.impl;

import java.util.List;

import org.at.dao.ClassesDao;
import org.at.dao.UserDao;
import org.at.domain.Classes;
import org.at.service.ClassesService;
import org.hibernate.SessionFactory;

public class ClassesServiceImpl implements ClassesService {
	//private SessionFactory sessionFactory;
	private UserDao userDao;
	private ClassesDao classesDao;
	
	
	
	public List<Classes> findAll() {
		return classesDao.findAll(Classes.class);
	}
	

	@Override
	public Classes get(int class_id) {
		return (Classes) classesDao.get(Classes.class, class_id);
	}


	@Override
	public void add(Classes clazz) {
		classesDao.save(clazz);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		System.out.println("user : " + this.getClass().getName());
	}
	public ClassesDao getClassesDao() {
		return classesDao;
	}
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
		System.out.println("class : " + this.getClass().getName());
	}


	@Override
	public void modify(Classes clazz) {
		classesDao.update(clazz);
	}


	@Override
	public void delete(int id) {
		Classes temp = (Classes) classesDao.get(Classes.class, id);
		classesDao.delete(temp);
	}



}
