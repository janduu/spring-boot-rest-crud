package com.example.springbootrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootrest.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
