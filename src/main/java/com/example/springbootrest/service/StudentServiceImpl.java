package com.example.springbootrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootrest.dao.StudentRepository;
import com.example.springbootrest.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
//	private StudentDAO studentDAO;
//
//	@Autowired
//	public StudentServiceImpl(@Qualifier("studentDAOJpaImpl") StudentDAO studentDAO) {
//		this.studentDAO = studentDAO;
//	}

	private StudentRepository studentRepository;
	
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(Integer studentId) {
		Optional<Student> obj = studentRepository.findById(studentId);
		return obj.orElse(null);
	}

	@Override
	public void save(Student student) {

		studentRepository.save(student);
	}

	@Override
	public void deleteById(Integer studentId) {
		studentRepository.deleteById(studentId);
	}
}
