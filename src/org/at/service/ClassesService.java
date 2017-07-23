package org.at.service;

import java.util.List;

import org.at.domain.Classes;

public interface ClassesService {

	public  Classes get(int class_id);

	public List<Classes> findAll();

	public void add(Classes clazz);

	public void modify(Classes clazz);

	public void delete(int id);

}
