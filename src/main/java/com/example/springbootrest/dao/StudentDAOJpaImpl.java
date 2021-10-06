package com.example.springbootrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springbootrest.entity.Student;

@Repository
public class StudentDAOJpaImpl implements StudentDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> q = 
				entityManager.createQuery("FROM Student", Student.class);
		
		return q.getResultList();
	}

	@Override
	public Student findById(Integer studentId) {
		return entityManager.find(Student.class, studentId);
	}

	@Override
	public void save(Student student) {
		Student saved = entityManager.merge(student);
		student.setId(saved.getId());
	}

	@Override
	public void deleteById(Integer studentId) {
		Query q = entityManager.createQuery("DELETE FROM Student WHERE id=:studentId");
		q.setParameter("studentId", studentId);
		q.executeUpdate();	
	}
}
