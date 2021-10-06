package com.example.springbootrest.service;

import java.util.List;

import com.example.springbootrest.entity.Student;

public interface StudentService {
	public List<Student> findAll();
	public Student findById(Integer studentId);
	public void save(Student student);
	public void deleteById(Integer studentId);
}
