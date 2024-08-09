package com.techno.SpringMVC.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.techno.SpringMVC.POJO.Admin;
@Repository
public class AdminRepository {
	
		private static EntityManagerFactory factory;
		private static EntityManager manager;
		private static EntityTransaction transaction;
		private static String JPQL;
		private static Query query;
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
		public Admin addadmin(String username, String password) {
			openConnection();
			transaction.begin();
			Admin admin=new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			manager.persist(admin);
			transaction.commit();
			closeConnection();
			return admin;
		}
		
		public Admin login(String username, String password) {
			openConnection();
			transaction.begin();
			JPQL="from Admin "+"where username='"+username+"'and password='"+password+"'";
			query=manager.createQuery(JPQL);
			@SuppressWarnings("unchecked")
			List<Admin> admin=query. getResultList();
			for(Admin admin1:admin) {
				transaction.commit();
			closeConnection();                                                            
			return admin1;                                         
		}
			return null;
		
		}
}
