package com.stepahead.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.stepahead.cruddemo.dao.StudentDAO;
import com.stepahead.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {
	int id;
	public static void main(String args[]) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return Runner -> {
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
			queryForStudents(studentDAO);
		};

	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> myStudents = studentDAO.findAll();
		
		for(Student tempStudent: myStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student myStudent = studentDAO.findById(5);
		
		if(myStudent != null) {
			System.out.println("First Name: " + myStudent.getFirstName());
			System.out.println("Last Name: " + myStudent.getLastName());
			System.out.println("Email ID: " + myStudent.getEmail());
		}
		else {
			System.out.println("Record Not Found");
		}
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("John", "Doe", "johndoe@gmail.com");
		Student tempStudent2 = new Student("Jane", "Smith", "janesmith@gmail.com");
		Student tempStudent3 = new Student("Michael", "Johnson", "michaeljohnson@gmail.com");
		Student tempStudent4 = new Student("Emily", "Williams", "emilywilliams@gmail.com");
		Student tempStudent5 = new Student("Daniel", "Brown", "danielbrown@gmail.com");
		Student tempStudent6 = new Student("Olivia", "Davis", "oliviadavis@gmail.com");
		
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		studentDAO.save(tempStudent5);
		studentDAO.save(tempStudent6);
		
		System.out.println("Record Inserted..");

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		Student tempStudent = new Student("Alex", "Thomsan", "alexthomsan@gmail.com");

		// save the student object
		studentDAO.save(tempStudent);

		// display the id the saved student
		System.out.println("Saved Student. Generated ID: " + tempStudent.toString());
	}
}
