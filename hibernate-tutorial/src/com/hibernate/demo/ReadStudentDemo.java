package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Sanket", "Alone", "sanket.alone@ghari.com");
			
			// start transaction
			session.beginTransaction();
			
			// save student object
			System.out.println("saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find out the student's id
			System.out.println("Saved student Generated id: " + tempStudent.getId());
			
			//get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id
			System.out.println("Getting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete: " + myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nDone!!");
			
		} finally {
			factory.close();
			session.close();
		}

	}

}
