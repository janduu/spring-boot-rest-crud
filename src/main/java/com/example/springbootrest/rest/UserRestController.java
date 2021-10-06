package com.example.springbootrest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrest.entity.Student;
import com.example.springbootrest.service.StudentService;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	
	private StudentService studentService;
	
	
	@Autowired
	public UserRestController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.findAll();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable Integer studentId) {
		Student student = studentService.findById(studentId);
		if (student == null) {
			throw new RuntimeException("Student with id[" + studentId + "] is not found!");
		}
		return student;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		student.setId(null);
		studentService.save(student);
		return student;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		if (student.getId() == null || student.getId() == 0) {
			throw new RuntimeException("Student's id[currentVal=" + student.getId() + "] must be specified in order to update");
		} else if (studentService.findById(student.getId()) == null) {
			throw new RuntimeException("Student with id[" + student.getId() + "] is not found!");
		}
		studentService.save(student);
		return student;
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable Integer studentId) {
		if (studentService.findById(studentId) == null) {
			throw new RuntimeException("Student with id[" + studentId + "] is not found!");
		}
		studentService.deleteById(studentId);
		return "Student with id[" + studentId + "] successfully removed!";
	}
}
