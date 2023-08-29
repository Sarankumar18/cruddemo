package com.stepahead.cruddemo;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.stepahead.cruddemo.dao.StudentDAO;
import com.stepahead.cruddemo.entity.Student;


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String args[]) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return Runner ->{
			createStudent(studentDAO);
		};
		
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		Student tempStudent = new Student("Alex","Thomsan","alexthomsan@gmail.com");
		
		//save the student object
		studentDAO.save(tempStudent);
		
		//display the id the saved student
		System.out.println("Saved Student. Generated ID: "+ tempStudent.toString());
	}
}
