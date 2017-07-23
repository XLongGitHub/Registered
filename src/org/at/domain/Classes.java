package org.at.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Classes {
	@Id
	@Column(name = "class_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String classname;
	private String location;
	
//	@ManyToMany(targetEntity=User.class)
//	@JoinTable(name="user_class",
//	joinColumns=@JoinColumn(name="class_id",
//	referencedColumnName="calss_id"),
//	inverseJoinColumns=@JoinColumn(name="user_id",
//	referencedColumnName="user_id"))
//	private Set<User> users = new HashSet<User>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return ""+classname + " : " + location;
	}

	@Override
	public boolean equals(Object obj) {
		Classes clazz = (Classes) obj;
		if (classname.equals(clazz.getClassname()) && location.equals(clazz.getLocation())) return true;
		return false;
	}

//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}
}
