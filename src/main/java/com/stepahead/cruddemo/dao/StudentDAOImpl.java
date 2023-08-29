package com.stepahead.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stepahead.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
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

}
