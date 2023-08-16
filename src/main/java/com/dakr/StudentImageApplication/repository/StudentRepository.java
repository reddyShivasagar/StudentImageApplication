package com.dakr.StudentImageApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.StudentImageApplication.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
