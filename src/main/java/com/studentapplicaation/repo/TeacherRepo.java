package com.studentapplicaation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentapplicaation.model.Teacher;
@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
	@Query("SELECT  s FROM Teacher s WHERE s.email = :e")
	public Teacher loginTeacher(@Param("e") String i);
	
	@Query("SELECT  s FROM Teacher s WHERE s.email = :e")
	public Teacher getByEmail(@Param("e") String i);

}
