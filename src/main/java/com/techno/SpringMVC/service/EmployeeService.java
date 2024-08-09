package com.techno.SpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.SpringMVC.POJO.Admin;
import com.techno.SpringMVC.POJO.Employee;
import com.techno.SpringMVC.Repository.EmployeeRepository;

@Service
public class EmployeeService {

@Autowired
EmployeeRepository repository;

	public Employee AddEmployee(String name, String surname, String email,String Designation) {
	Employee employee=repository.addEmployee(name,surname,email,Designation);
	return employee;
	
	}

	public Employee searchEmployee(int id) {  
		Employee employee=repository.searchEmployee(id);
		return employee;
	}

	

	public Employee UpdateEmployee(int id, String name, String surname, String email, String designation) {
		Employee employee=repository.UpdateEmployee(id, name, surname, email, designation);
		return employee;
	}

	 public Employee deleteEmployee(int id) {
	        Employee employee=repository.deleteEmployee(id);
	        return employee;
	    }



	public List <Employee> searchAllEmployees() {
		List<Employee>employees= repository.searchAllEmployees();     
		return employees;                
	}
	public List<Employee> searchAllEmployees1(){
		List<Employee>employees=repository.searchAllEmployees1();
		return employees;        
	}
	public List<Employee>searchEmployees(){
		List<Employee>employees=repository.searchAllEmployees();
		return employees;
	}
	public List<Employee>searchEmployees2(){
		List<Employee>employees=repository.searchEmployees2();
		return employees;
	}

	
	

	

}
          