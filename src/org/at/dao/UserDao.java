package org.at.dao;

import java.util.List;

import org.at.common.dao.BaseDao;
import org.at.domain.User;

public  interface UserDao<T>  extends BaseDao<T> {
	public List findByName(Class<T> clazzEntity, String name);
	
}
