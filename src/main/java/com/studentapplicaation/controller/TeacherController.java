package com.studentapplicaation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentapplicaation.model.LoginTeacher;
import com.studentapplicaation.model.Teacher;
import com.studentapplicaation.service.TeacherService;

@RestController
@CrossOrigin
public class TeacherController {
@Autowired
private TeacherService service;

	@PostMapping("/saveTeacher")
	public Teacher saveTeacher(@RequestBody Teacher t) {
		return service.save(t);
	}

@PutMapping("/updateTeacher/{tid}")
	public Teacher update(@RequestBody Teacher p,@PathVariable Integer tid){
	Teacher s=service.update(p,tid);
		return s;
	}

	@DeleteMapping("/deleteTeacher/{tid}")
	public void delete(@PathVariable Integer tid) {
		 service.delete(tid);
	}
	
	@GetMapping("/getTeacher/{tid}")
	public Teacher getOne(@PathVariable Integer tid) {
		return service.getOne(tid);
	}
	@GetMapping("/getTeacherBy/{email}")
	public Teacher getOneByEmail(@PathVariable String email) {
		return service.getOne(email);
	}
	@GetMapping("/getAllTeachers")
	public List<Teacher> getAll() {
		List<Teacher> p=service.getAll();
		return p;
	}
	@PostMapping("/loginTeacher")
	public Boolean login(@RequestBody LoginTeacher l) {
		
		return service.loginTeacher(l);
	}
	
}
