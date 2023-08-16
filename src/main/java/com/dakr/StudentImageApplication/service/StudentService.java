package com.dakr.StudentImageApplication.service;


import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dakr.StudentImageApplication.entity.Student;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Service
public interface StudentService {

	public Student saveStudent(MultipartFile std_img,Integer std_id,String std_name,double std_fee);
	
	public void deleteStudent(Integer std_id);
	
	public Student getStudent(Integer std_id) ;
		
	public List<Student> getAllStudent(); 
		
	public Student updateStudent(MultipartFile std_img,Integer std_id,String std_name,double std_fee) throws IOException;
	
	
	//public Student updateStudentImg(MultipartFile std_img,Integer std_id);
	
	//public Student updateData(Integer std_id,String std_name,double std_fee); 
		
	
		
	
	
	
}
