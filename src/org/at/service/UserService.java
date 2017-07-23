package org.at.service;


import java.util.List;

import org.at.domain.Classes;
import org.at.domain.User;

public interface UserService {
	public User get(int id);
	public List findByName(String name);
	//public List findById(int id);
	public void save(User u);
	//public void modify(User u);
	public void update(User u);
	public void removeClass(User u, Classes clazz);
	public void delete(User u);
}
