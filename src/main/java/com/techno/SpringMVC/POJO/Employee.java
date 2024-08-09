package com.techno.SpringMVC.POJO;

import javax.persistence.Entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String surname;
	private String email;
	private String Designation;
	
	
	
	
	
	

}
