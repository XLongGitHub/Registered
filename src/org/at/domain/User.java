package org.at.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.org.glassfish.gmbal.Description;

@Entity
// @DiscriminatorColumn(name="user_type",
// discriminatorType=DiscriminatorType.STRING)
// @DiscriminatorValue("human")
public class User {
	@Id
	@Column(name ="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;

	@OneToOne(targetEntity=Address.class)
	@JoinColumn(name="address_id",
	referencedColumnName="address_id",unique=true)
	private Address address;
	
	@ManyToMany(targetEntity=Classes.class,fetch=FetchType.EAGER)
	
	@JoinTable(name="user_class",
	joinColumns=@JoinColumn(name="user_id",
	referencedColumnName="user_id"),
	inverseJoinColumns=@JoinColumn(name="class_id",
	referencedColumnName="class_id"))
	
	private Set<Classes> classes = new HashSet<Classes>();
	
	public User() {
		
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.classes = classes;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void init(ResultSet rs) {
		try {
			setId(rs.getInt(1));
			setUsername(rs.getString("username"));
			setPassword(rs.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Classes> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}
}
