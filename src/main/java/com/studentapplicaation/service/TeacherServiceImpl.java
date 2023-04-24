package com.studentapplicaation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapplicaation.model.LoginTeacher;
import com.studentapplicaation.model.Teacher;
import com.studentapplicaation.repo.TeacherRepo;
@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherRepo repo;
	

	@Override
	public Teacher save(Teacher s) {
		return repo.save(s);
	}

	@Override
	public Teacher update(Teacher t,int tid) {
		Teacher t1=repo.findById(tid).get();
		t1.setDob(t.getDob());
		t1.setEmail(t.getEmail());
		t1.setGender(t.getGender());
		t1.setHeadToStandard(t.getHeadToStandard());
		t1.setImage(t.getImage());
		t1.setMobno(t.getMobno());
		t1.setTname(t.getTname());
		t1.setSalary(t.getSalary());
		t1.setPassword(t.getPassword());
		return repo.save(t1);
	}

	@Override
	public Teacher getOne(int tid) {
		return repo.findById(tid).get();
	}

	@Override
	public List<Teacher> getAll() {
		return repo.findAll();
	}

	@Override
	public void delete(int sid) {
		repo.deleteById(sid);
	}

	@Override
	public Boolean loginTeacher(LoginTeacher i) {
		String id=i.getEmail();
		String password=i.getPassword();
		Teacher s1=repo.loginTeacher(id);
		String s=s1.getPassword();
		if(s.equals(password)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Teacher getOne(String email) {
		Teacher t=repo.getByEmail(email);
		return t;
	}

}
