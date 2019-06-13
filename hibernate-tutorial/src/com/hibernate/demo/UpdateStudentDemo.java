package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studId = 28;
			
			//get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			// retrieve student based on the id
			System.out.println("Getting student with id: " + studId);
			
			Student myStudent = session.get(Student.class, studId);
			
			System.out.println("Updating Student");
			
			myStudent.setFirstName("Sattu");
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nDone!!");
			
		} finally {
			factory.close();
			session.close();
		}

	}

}
