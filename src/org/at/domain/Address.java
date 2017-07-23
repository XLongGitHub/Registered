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
public class Address {
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String detail;
	private String country;
	
	/*@ManyToMany(targetEntity=User.class)
	@JoinTable(name="user_address",
	joinColumns=@JoinColumn(name="address_id",
	referencedColumnName="address_id"),
	inverseJoinColumns=@JoinColumn(name="user_id",
	referencedColumnName="user_id"))
	private Set<User> users = new HashSet<User>();*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
