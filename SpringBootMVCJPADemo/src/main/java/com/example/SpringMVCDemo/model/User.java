package com.example.SpringMVCDemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	public User(int uid, String uname) {
		
		this.uid = uid;
		this.uname = uname;
	}
	public User() {
		
	}
	
	
	@Id
	private int uid;
	private String uname;
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + "]";
	}
	
	

}
