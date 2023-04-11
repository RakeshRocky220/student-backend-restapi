package com.studentapplicaation.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapplicaation.model.LoginStudent;
import com.studentapplicaation.model.Student;
import com.studentapplicaation.model.Transfer;
import com.studentapplicaation.repo.StudentRepo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo repo;

	
	@Override
	public Student save(Transfer t) {
		Student s=t.getStudent();
		int total=s.getMaths()+s.getChemistry()+s.getPhysics();
		double percentage=total/3;
		s.setPercentage(percentage);
		s.setGrade(getGrade(total));
		s.setTotal(total);
		s.setImage(s.getImage());
		s.setTeacher(t.getTeacher());
		return repo.save(s);
		
		
	}

	@Override
	public Student update(Student s,int sid) {
	Student s1=repo.findById(sid).get();
	s1.setSname(s.getSname());
	s1.setFee(s.getFee());
	s1.setMaths(s.getMaths());
	s1.setChemistry(s.getChemistry());
	s1.setPhysics(s.getPhysics());
	s1.setTotal(s.getChemistry()+s.getMaths()+s.getPhysics());
	s1.setPercentage((s.getChemistry()+s.getMaths()+s.getPhysics())/3);
	s1.setMobno(s.getMobno());
	s1.setGrade(getGrade(s.getChemistry()+s.getMaths()+s.getPhysics()));
	s1.setImage(s.getImage());
	return repo.save(s1);
	}

	@Override
	public Student getOne(int sid) {
		return repo.findById(sid).get();
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void delete(int sid) {
		repo.deleteById(sid);
		
	}
	
	private char getGrade(int total) {
		if(total>80) {
			return 'A';
		}else if(total>50) {
			return 'B';
		}else if(total>30) {
			return 'C';
		}else {
			return 'F';
		}
	}

	@Override
	public List<Student> getByStandard(String i) {
		List<Student> l=getAll();
		
		return l.stream().filter(std->std.getStandard().equals(i)).collect(Collectors.toList());
	}
	
	@Override
	public List<Student> getByPercentage(String s) {
		return repo.OrderedByPercentage().stream().filter(i->i.getStandard().equals(s)).collect(Collectors.toList());
	}

	@Override
	public List<Student> getByMaths(String s) {
		// TODO Auto-generated method stub
		return repo.OrderedByMaths().stream().filter(i->i.getStandard().equals(s)).collect(Collectors.toList());
	}

	@Override
	public List<Student> getByPhysics(String s) {
		// TODO Auto-generated method stub
		return repo.OrderedByPhysics().stream().filter(i->i.getStandard().equals(s)).collect(Collectors.toList());
	}

	@Override
	public List<Student> getByChemistry(String s) {
		// TODO Auto-generated method stub
		return repo.OrderedByChemistry().stream().filter(i->i.getStandard().equals(s)).collect(Collectors.toList());
	}

	@Override
	public Boolean login(LoginStudent i) {
		Integer id=i.getSid();
		String password=i.getPassword();
		Student s1=repo.studetnLogin(id);
		String s=s1.getPassword();
		if(s.equals(password)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Student> getRanks() {
		// TODO Auto-generated method stub
		List<Student> students=getAll();
		Collections.sort(students,(s1,s2)->{
			if(s1.getPercentage()>s2.getPercentage()) {
				return 1;
			}else if(s1.getPercentage()<s2.getPercentage()) {
				return -1;
			}else {
				return 0;
			}
		});
		 List<Student> s1=students.stream().limit(10).collect(Collectors.toList());
		 return s1;
	}

	@Override
	public void sendSms(List<String> s)  {
	
		List<Student> l=getAll();
		List<Integer> i=s.stream().map(str->Integer.parseInt(str)).collect(Collectors.toList());
		for(Student std:l) {
			if(checkNumberInList(i,std.getSid())) {
				continue;
			}else {
				final String str="+91"+String.valueOf(std.getMobno());
				final String a="AC704977aa6f7baa0c803327823917bd32";
				final String b="312adc2e4296577f2fe4ba37559e804a";
				Twilio.init(a,b);
				 Message twilioMessage = Message.creator(new PhoneNumber(str),
			                new PhoneNumber("+14752552860"), "Your Student Mr/Mrs: "+std.getSname()+" Was Absent today please send the student to school regularly").create();
			        System.out.println("SMS sent: " + twilioMessage.getSid());
			}
		}
		
	}
	
	
	
	public static boolean checkNumberInList(List<Integer> numList, int numToCheck) {
	    for (int num : numList) {
	        if (num == numToCheck) {
	            return true;
	        }
	    }
	    return false;
	}

	


}
