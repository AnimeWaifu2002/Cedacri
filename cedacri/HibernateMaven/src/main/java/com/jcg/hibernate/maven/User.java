package com.jcg.hibernate.maven;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(name = "id_user")
	private int iduser;

	@Column(name = "name_user")
	private String username;

	@Column(name = "email_user")
	private String email_user;
	
	@Column(name = "password_user")
	private String password_user;

	
	public int getUserid() {
		return iduser;
	}

	public void setUserid(int iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password_user;
	}

	public void setPassword(String password_user) {
		this.password_user = password_user;
	}
	
	public String getEmail() {
		return email_user;
	}
	
	public void setEmail(String email_user) {
		this.email_user = email_user;
	}
	
}