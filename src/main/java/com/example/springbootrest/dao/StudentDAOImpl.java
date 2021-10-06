package com.example.springbootrest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springbootrest.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	private EntityManager entityManager;
	
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Student> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Student> query = session.createQuery("FROM Student", Student.class);
		return query.getResultList();
	}

	@Override
	public Student findById(Integer studentId) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Student.class, studentId);
	}

	@Override
	public void save(Student student) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(student);		
	}

	@Override
	public void deleteById(Integer studentId) {
		Session session = entityManager.unwrap(Session.class);
		Query<?> query = session.createQuery("DELETE FROM Student WHERE id = :stId");
		query.setParameter("stId", studentId);
		query.executeUpdate();
	}
	
}
