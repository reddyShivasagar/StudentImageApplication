package com.dakr.StudentImageApplication.controller;

import java.io.IOException;
import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dakr.StudentImageApplication.entity.Student;
import com.dakr.StudentImageApplication.service.StudentServiceImpl;

@RestController

public class StudentController {

	@Autowired
	private StudentServiceImpl service;
	
	
	@PostMapping("/Save")
	public String Save(@RequestParam MultipartFile std_img,@RequestParam Integer std_id,@RequestParam String std_name,@RequestParam double std_fee ) {
		 
		String msg=null;
		
		Student student=service.saveStudent(std_img, std_id, std_name, std_fee);
		 
		if(student!=null) {
			msg="Data saved";
		}
		else {
			msg="Data not saved";
		}
		return msg;
		
	
	
		
	}
	
	@DeleteMapping("/Delete/{std_id}")
	public void delete(@PathVariable Integer std_id) {
		service.deleteStudent(std_id);
				
		
	}
	
	@GetMapping("/Get/{std_id}")
	public Student get(@PathVariable Integer std_id) {
		return service.getStudent(std_id);
		
	}
	
	@GetMapping("/Get")
	public List<Student> getAll() {
		return service.getAllStudent();
		
	}
	
	
	@PutMapping("/Update/{std_id}")
	public Student update(@RequestParam MultipartFile std_img,@PathVariable Integer std_id,@RequestParam String std_name,@RequestParam double std_fee) throws IOException {
		return service.updateStudent(std_img, std_id, std_name, std_fee);
		
	}
	
	
	//Update only Image
//	@PutMapping("/UpdateImg/{std_id}")
//	public Student updateImg(@RequestParam("std_img") MultipartFile std_img,@PathVariable Integer std_id) {
//		return service.updateStudentImg(std_img, std_id);
//		
//	}
//	
	//Update data
//	@PutMapping("/UpdateData/{std_id}/{std_name}/{std_fee}")
//	public Student UpdateData(@PathVariable Integer std_id,@PathVariable String std_name,@PathVariable double std_fee) {
//		return service.updateData(std_id, std_name, std_fee);
//		
//	}
//	
	
	
	
	
}
