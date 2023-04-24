package com.studentapplicaation.model;

public class LoginStudent {
private int sid;
private String password;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public LoginStudent(int sid, String password) {
	super();
	this.sid = sid;
	this.password = password;
}
public LoginStudent() {
	super();
}

}
