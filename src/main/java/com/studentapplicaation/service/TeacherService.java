package com.studentapplicaation.service;

import java.util.List;

import com.studentapplicaation.model.LoginTeacher;
import com.studentapplicaation.model.Teacher;



public interface TeacherService {
	public Teacher save(Teacher s);

	public Teacher update(Teacher t,int tid);

	public Teacher getOne(int tid);
	public Teacher getOne(String email);

	public List<Teacher> getAll();
	
	public void delete(int tid);
	
	public Boolean loginTeacher(LoginTeacher i);
}
