package com.stepahead.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stepahead.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// define field for entity manager
	EntityManager entityManager;

	// inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// implement save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName",Student.class);
		
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> query = entityManager.createQuery("from Student where lastName=:theData",Student.class);
		query.setParameter("theData", lastName);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent1) {
		entityManager.merge(theStudent1);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		//retrieve the student
		Student theStudent = entityManager.find(Student.class, id);
		
		//delete the student
		if(theStudent != null)
			entityManager.remove(theStudent);
		else
			System.out.println("Student Id Not Present");
	}

	@Override
	@Transactional
	public int deleteAll() {
		int rowDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return rowDeleted;
	}

}
