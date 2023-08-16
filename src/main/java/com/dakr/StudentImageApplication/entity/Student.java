package com.dakr.StudentImageApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="StudentTable")
public class Student {
	
	@Id
	@Column(name="StudentId")
	private Integer std_id;
	private String std_name;
	private double std_fee;
	
	@Lob
	@Column(length = 9999999)
	private String std_img;

}
