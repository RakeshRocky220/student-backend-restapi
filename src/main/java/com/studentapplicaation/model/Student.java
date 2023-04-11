package com.studentapplicaation.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Student {
@Id
private int sid;
private String password;
private String sname;
private String gender;
private String standard;
private String dob;
private long mobno;
private double fee;
private int maths;
private int physics;
private int chemistry;
private int total;
private char grade;
private double percentage;
public Student() {
	super();
}
public Student(int sid, String password, String sname,String gender, String standard, String dob, long mobno, double fee, int maths,
		int physics, int chemistry, int total, char grade, double percentage, String image, Teacher teacher) {
	super();
	this.sid = sid;
	this.password = password;
	this.sname = sname;
	this.gender=gender;
	this.standard = standard;
	this.dob = dob;
	this.mobno = mobno;
	this.fee = fee;
	this.maths = maths;
	this.physics = physics;
	this.chemistry = chemistry;
	this.total = total;
	this.grade = grade;
	this.percentage = percentage;
	this.image = image;
	this.teacher = teacher;
}
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
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getStandard() {
	return standard;
}
public void setStandard(String standard) {
	this.standard = standard;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public long getMobno() {
	return mobno;
}
public void setMobno(long mobno) {
	this.mobno = mobno;
}
public double getFee() {
	return fee;
}
public void setFee(double fee) {
	this.fee = fee;
}
public int getMaths() {
	return maths;
}
public void setMaths(int maths) {
	this.maths = maths;
}
public int getPhysics() {
	return physics;
}
public void setPhysics(int physics) {
	this.physics = physics;
}
public int getChemistry() {
	return chemistry;
}
public void setChemistry(int chemistry) {
	this.chemistry = chemistry;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public char getGrade() {
	return grade;
}
public void setGrade(char grade) {
	this.grade = grade;
}
public double getPercentage() {
	return percentage;
}
public void setPercentage(double percentage) {
	this.percentage = percentage;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Teacher getTeacher() {
	return teacher;
}
public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
@Lob
private String image;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "tid")
private Teacher teacher;

}
