package com.jcg.hibernate.maven;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppMain {

	static User userObj;
	static Session sessionObj ;

	@SuppressWarnings("deprecation")
	public static void createSession() {
        SessionFactory sessionFactory = null;
        sessionFactory = new Configuration().configure().buildSessionFactory();
        sessionObj= sessionFactory.openSession();
        sessionObj.beginTransaction();
    }

	public static void main(String[] args) {
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			createSession();
				userObj = new User();
				userObj.setUserid(1);
				userObj.setUsername("Stefan");
				userObj.setPassword("2002");
				userObj.setEmail("stefanboblic@gmail.com");
				sessionObj.save(userObj);
				sessionObj.getTransaction().commit();
				sessionObj.beginTransaction();
				userObj = new User();
				userObj.setUserid(2);
				userObj.setUsername("Mod");
				userObj.setPassword("1");
				userObj.setEmail("whatever@gmail");
				sessionObj.save(userObj);
				sessionObj.getTransaction().commit();
				sessionObj.beginTransaction();
				userObj = new User();
				userObj.setUserid(3);
				userObj.setUsername("Admin");
				userObj.setPassword("1111");
				userObj.setEmail("whatever@gmail.com");
				sessionObj.save(userObj);
				sessionObj.getTransaction().commit();
				sessionObj.beginTransaction();
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");
			List<User> result = sessionObj.createQuery("from "+ "User").list();
			for(User i : result) {
	             System.out.println("UserID: "+ i.getUserid());
	             System.out.println("Username: "+ i.getUsername());
	             System.out.println("Email: "+ i.getEmail());
	             System.out.println("Password: "+ i.getPassword());
	             System.out.println("=============================================");
	         }
		} catch(Exception sqlException) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			sqlException.printStackTrace();
		} 
				
				sessionObj.close();
	}
}