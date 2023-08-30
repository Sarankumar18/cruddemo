package com.stepahead.cruddemo.dao;

import java.util.List;

import com.stepahead.cruddemo.entity.Student;

public interface StudentDAO {
	//Insert record into the Student table
	void save(Student theStudent);
	
	//Find the record by ID
	Student findById(Integer id);
	
	//List all the record 
	List<Student> findAll();
	
	//Find the record by Last name
	List<Student> findByLastName(String lastName);

}
