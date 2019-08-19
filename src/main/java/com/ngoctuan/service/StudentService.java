package com.ngoctuan.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ngoctuan.dao.model.Student;

public interface StudentService {
	List<Student> findAllStudent();
	
	Student findById(int id);
	
	boolean createStudent(Student student);
	
	boolean updateStudent(Student student);
	
	boolean deleteStudent(int id);
	
	Page<Student> findAllStudentPage(Pageable pageable);
	
}
