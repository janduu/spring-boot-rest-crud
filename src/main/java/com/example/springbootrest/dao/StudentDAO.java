package com.example.springbootrest.dao;

import java.util.List;

import com.example.springbootrest.entity.Student;

public interface StudentDAO {
	public List<Student> findAll();
	public Student findById(Integer studentId);
	public void save(Student student);
	public void deleteById(Integer studentId);
}
