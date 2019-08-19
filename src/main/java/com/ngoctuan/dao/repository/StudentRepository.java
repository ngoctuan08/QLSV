package com.ngoctuan.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngoctuan.dao.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	Student findById(int id);
}
