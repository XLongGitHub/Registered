package org.at.dao.impl;

import java.util.List;

import org.at.common.dao.impl.BaseDaoHibernate4;
import org.at.dao.UserDao;
import org.at.domain.User;

public class UserDaoHibernate4<T> extends BaseDaoHibernate4<T> implements UserDao<T>{
	
	public List findByName(Class<T> clazzEntity, String name) {
//		System.out.println("I'm here 3:  0  " + this.getClass().getName() );
		return find("select en from "+ clazzEntity.getSimpleName() + " en where en.username = ?0", name);
		//return find("select en from "+ clazzEntity.getSimpleName() + " en where en.username = '" + name + "'");
	}
}
