package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create student object
			System.out.println("Creating new student object....");
			Student tempStudent = new Student("Sachin", "Bagul", "sachin.bagul@ebix.com");
			
			// start transaction
			session.beginTransaction();
			
			// save student object
			System.out.println("saving the student");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
			session.close();
		}

	}

}
