package com.studentapplicaation.service;

import java.util.List;

import com.studentapplicaation.model.LoginStudent;
import com.studentapplicaation.model.Student;
import com.studentapplicaation.model.Transfer;

public interface StudentService {
	
	public Student save(Transfer s);

	public Student update(Student s,int sid);

	public Student getOne(int sid);

	public List<Student> getAll();
	
	public List<Student> getByStandard(String i);
	
	public void delete(int sid);
	public List<Student> getByPercentage( String s);
	public List<Student> getByMaths(String s);
	public List<Student> getByPhysics(String s);
	public List<Student> getByChemistry(String s);
	public Boolean login(LoginStudent i);
	public List<Student> getRanks();
	void sendSms(List<String> s);


}
