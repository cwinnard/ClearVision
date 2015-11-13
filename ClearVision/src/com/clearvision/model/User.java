package com.clearvision.model;

public class User {
	public String firstName;
	public String lastName;
	public String email;
	public String pass;
	public Boolean valid;
	public int userID;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public User() {
	}

	public User(String firstName, String lastName, String email, String pass, int userID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pass = pass;
		this.userID = userID;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

}
