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

import com.studentapplicaation.model.LoginStudent;
import com.studentapplicaation.model.Student;
import com.studentapplicaation.model.Trans;
import com.studentapplicaation.model.Transfer;
import com.studentapplicaation.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {
	
	@Autowired 
	private StudentService service;
	


	@PostMapping("/saveStudent")
	public Student save(@RequestBody Transfer s) {
		return service.save(s);
	}
	

@PutMapping("/update/{sid}")
	public Student update(@RequestBody Student p,@PathVariable Integer sid){
		Student s=service.update(p,sid);
		return s;
	}

	@DeleteMapping("/delete/{sid}")
	public void delete(@PathVariable Integer sid) {
		 service.delete(sid);
	}
	
	@GetMapping("/get/{sid}")
	public Student getOne(@PathVariable Integer sid) {
		return service.getOne(sid);
	}
	@GetMapping("/getAll")
	public List<Student> getAll() {
		List<Student> p=service.getAll();
		return p;
	}
	
	@GetMapping("/getbystand/{standard}")
	public List<Student> getByStand( @PathVariable String standard){
		return service.getByStandard(standard);
	}
	@GetMapping("/getbymaths/{standard}")
	public List<Student> getByMaths( @PathVariable String standard) {
		List<Student> p=service.getByMaths(standard);
		return p;
	}
	@GetMapping("/getbyphysics/{standard}")
	public List<Student> getByPhysics( @PathVariable String standard) {
		List<Student> p=service.getByPhysics(standard);
		return p;
	}
	@GetMapping("/getbychemistry/{standard}")
	public List<Student> getByChemistry( @PathVariable String standard) {
		List<Student> p=service.getByChemistry(standard);
		return p;
	}
	@GetMapping("/getbypercentage/{standard}")
	public List<Student> getByPercentage( @PathVariable String standard) {
		List<Student> p=service.getByPercentage(standard);
		return p;
	}
	
	@PostMapping("/loginstudent")
	public Boolean login(@RequestBody LoginStudent l) {
		
		return service.login(l);
	}
	@PostMapping("/send-sms")
	  public void sendSmsToAllStudents(@RequestBody Trans t) {
	List<String> arr=t.getList();
	service.sendSms(arr);
	}
	

}
