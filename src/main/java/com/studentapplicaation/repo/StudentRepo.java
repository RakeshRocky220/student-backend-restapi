package com.studentapplicaation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentapplicaation.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

@Query("SELECT s FROM Student s ORDER BY s.percentage DESC")
	List<Student> OrderedByPercentage();
	
	@Query("SELECT s FROM Student s ORDER BY s.maths DESC")
	List<Student> OrderedByMaths();
	
	@Query("SELECT s FROM Student s ORDER BY s.physics DESC")
	List<Student> OrderedByPhysics();
	
	@Query("SELECT s FROM Student s ORDER BY s.chemistry DESC")
	List<Student> OrderedByChemistry();
	
	@Query("SELECT  s FROM Student s WHERE s.id = :e")
	public Student studetnLogin(@Param("e") int i);
}
