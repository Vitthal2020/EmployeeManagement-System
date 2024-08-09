package com.techno.SpringMVC.EmployeeRepository;


import javax.persistence.EntityManager;



import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.techno.SpringMVC.POJO.Employee;


public class EmployeeRepository {

    private static EntityManagerFactory factory;
    private static EntityManager manager;
    private static EntityTransaction transaction;

    static {
        factory = Persistence.createEntityManagerFactory("emp");
    }

    private static void openConnection() {
        manager = factory.createEntityManager();
        transaction = manager.getTransaction();
    }

    private static void closeConnection() {
        if (manager != null) {
            manager.close();
        }
        if (factory != null) {
            factory.close();
        }
    }

    public void addEmployee(String name, String email) {
        openConnection();
        try {
            transaction.begin();
            Employee employee = new Employee();
            employee.setName(name);
            employee.setEmail(email);
            manager.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
