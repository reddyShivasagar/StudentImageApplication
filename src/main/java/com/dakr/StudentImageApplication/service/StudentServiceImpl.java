 package com.dakr.StudentImageApplication.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dakr.StudentImageApplication.entity.Student;
import com.dakr.StudentImageApplication.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repository;

	@Override
	public Student saveStudent(MultipartFile std_img, Integer std_id, String std_name, double std_fee) {
		 Student student=new Student();
		
		try {
			student.setStd_img(Base64.getEncoder().encodeToString(std_img.getBytes()));
		}
		catch(IOException e){
			e.printStackTrace();
			
		}
		student.setStd_id(std_id);
		student.setStd_name(std_name);
		student.setStd_fee(std_fee);
		
		return repository.save(student);
	}

	@Override
	public void deleteStudent(Integer std_id) {

		repository.deleteById(std_id);
		
	}

	@Override
	public Student getStudent(Integer std_id) {

		Student student=repository.findById(std_id).get();
		
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list=repository.findAll();
		return list;
	}

//	@Override
//	public Student updateStudentImg(MultipartFile std_img,Integer std_id) {
//
//		Student student2=repository.findById(std_id).get();
//		
//		student2.setStd_id(std_id);
////		student2.setStd_name(student2.getStd_name());
////		student2.setStd_fee(student2.getStd_fee());
//		try {
//			student2.setStd_img(Base64.getEncoder().encodeToString(std_img.getBytes()));
//		}
//		catch(IOException e){
//			e.printStackTrace();
//			
//		}
//		return repository.save(student2);
//	}
//
//	@Override
//	public Student updateData(Integer std_id,String std_name,double std_fee) {
//		Student student1=repository.findById(std_id).get();
//		
//		student1.setStd_id(std_id);
//		student1.setStd_name(std_name);
//		student1.setStd_fee(std_fee);
//	
//		return repository.save(student1);
//	}

	@Override
	public Student updateStudent(MultipartFile std_img, Integer std_id, String std_name, double std_fee) throws IOException {

		Student student=repository.findById(std_id).get();
		
		student.setStd_id(std_id);
		student.setStd_name(std_name);
		student.setStd_fee(std_fee);
		
		student.setStd_img(Base64.getEncoder().encodeToString(std_img.getBytes()));
		
		return repository.save(student);
	}


	

}
