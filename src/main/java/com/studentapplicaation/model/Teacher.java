package com.studentapplicaation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Teacher {
	@Id
	private int tid;
	private String password;
	private String gender;
	public Teacher() {
		super();
	}
	public Teacher(int tid, String tname,String gender, String password,long mobno, String dob, String headToStandard, String email, String image,
			double salary, List<Student> students) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.password=password;
		this.mobno = mobno;
		this.gender=gender;
		this.dob = dob;
		this.headToStandard = headToStandard;
		this.email = email;
		this.image = image;
		this.salary = salary;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public long getMobno() {
		return mobno;
	}
	public void setMobno(long mobno) {
		this.mobno = mobno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getHeadToStandard() {
		return headToStandard;
	}
	public void setHeadToStandard(String headToStandard) {
		this.headToStandard = headToStandard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	private String tname;
	private long mobno;
	private String dob;
	private String headToStandard;
	private String email;
	@Lob
	private String image;
	private double salary;
}
