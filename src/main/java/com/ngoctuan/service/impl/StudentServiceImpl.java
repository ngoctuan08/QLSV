package com.ngoctuan.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ngoctuan.dao.model.Student;
import com.ngoctuan.dao.repository.StudentRepository;
import com.ngoctuan.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Override
	public List<Student> findAllStudent() {
		List<Student> students = null;
		try {
			students = studentRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return students;
	}

	@Override
	public Student findById(int id) {
		Student student = null;
		try {
			student = studentRepository.findById(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return student;
	}

	@Override
	public boolean createStudent(Student student) {
		try {
			studentRepository.save(student);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	
	@Override
	public boolean updateStudent(Student student) {
		try {
			studentRepository.save(student);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		try {
			studentRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	public Page<Student> findAllStudentPage(Pageable pageable) {
		Page<Student> students = null;
		try {
			students = studentRepository.findAll(pageable);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return students;
	}

}
