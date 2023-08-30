package com.stepahead.cruddemo.dao;

import java.util.List;

import com.stepahead.cruddemo.entity.Student;

public interface StudentDAO {
	//Insert record into the Student table
	void save(Student theStudent);
	
	//Find the record by ID
	Student findById(Integer id);
	
	//Find the record by last name
	List<Student> findAll();

}
