package com.techno.SpringMVC.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.techno.SpringMVC.POJO.Employee;


@Repository
public class EmployeeRepository {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static javax.persistence.Query query;
	private static String JPQL ;
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("emp1");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
	}
	private static void closeConnection() {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {	
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.getRollbackOnly();
		}
	}
	
	public Employee addEmployee(String name, String surname, String email, String designation) {
		openConnection();
		transaction.begin();
		Employee employee=new Employee();
		employee.setName(name);
		employee.setSurname(surname);
		employee.setEmail(email);
		employee.setDesignation(designation);
		manager.persist(employee);
		transaction.commit();
		closeConnection();                     
		return employee;
	}
	
	 public Employee searchEmployee(int id) {
	        openConnection();
	        transaction.begin();
	        Employee employee = manager.find(Employee.class, id);
	        transaction.commit();
	        closeConnection();
	        return employee;             
	    }
	  public Employee UpdateEmployee(int id, String name, String surname, String email, String designation) {
	        openConnection();
	        transaction.begin();
	        Employee employee = manager.find(Employee.class, id);
	        if (employee != null) {
	            employee.setName(name);
	            employee.setSurname(surname);
	            employee.setEmail(email);
	            employee.setDesignation(designation);  
	            manager.persist(employee);
	            transaction.commit();
	        }
	        closeConnection();         
	        return employee;
	        
	    }
	public Employee deleteEmployee(int id) {
		openConnection();
		transaction.begin();
		Employee employee=manager.find(Employee.class, id);
		if(employee!=null) {
			manager.remove(employee);
			transaction.commit();
			closeConnection();
			return employee;
			
		}
		closeConnection();
		return employee;
		
	}
	public List<Employee> searchAllEmployees() {
		openConnection();
		transaction.begin();
		JPQL="from Employee";
		query=manager.createQuery(JPQL);
		@SuppressWarnings("unchecked")
		List<Employee> employees=query.getResultList();
		transaction.commit();
		closeConnection();
		return employees;
		
	
	}
	public List<Employee> searchAllEmployees1(){
		openConnection();
		transaction.begin();
		JPQL="from Employee";
		query=manager.createQuery(JPQL);
		@SuppressWarnings("unchecked")
		List<Employee> employees=query.getResultList();
		transaction.commit();
		closeConnection();
		return employees;                       
		
	}
	public List<Employee> searchEmployees(){
		openConnection();
		transaction.begin();
		JPQL="from Employee";
		query=manager.createQuery(JPQL);
		@SuppressWarnings("unchecked")
		List<Employee> employees=query.getResultList();
		transaction.commit();
		closeConnection();
		return employees;
		
	}
	public List<Employee> searchEmployees2(){
		openConnection();
		transaction.begin();
		JPQL="from Employee";
		query=manager.createQuery(JPQL);
		List<Employee>employees=query.getResultList();
		transaction.begin();
		closeConnection();
		return employees;
		
	}
	
	
	}
	 
	    
	
	
	
	
	
              


