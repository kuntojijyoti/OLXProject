package com.zensar.olx.user.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OlxUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String username;
	private String password;
	private String roles;
	private String firstname;
	private String lastname;
	private String email;
	private String phoneNumber;
	private Active status;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Active getStatus() {
		return status;
	}
	public void setStatus(Active status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OlxUser [userId=" + userId + ", username=" + username + ", password=" + password + ", roles=" + roles
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", status=" + status + "]";
	}
	








}
