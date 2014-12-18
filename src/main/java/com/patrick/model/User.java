package com.patrick.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	@Column
	private String username;
	@Column
	private String passwd;
	
	public User(){
	}
	
	public User(String username, String passwd) {
		super();
		this.username = username;
		this.passwd = passwd;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "username is " + username + "password is" + passwd;
	}
	

}
