package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
					tempStudent.setId(1);
					Student tempStudent1 = new Student("Satyawan", "Phadtare", "satyawan.phadtare@ebix.com");
					Student tempStudent2 = new Student("Piyush", "Sawalkar", "Piyush.Sawalkar@ebix.com");
					Student tempStudent3 = new Student("Vibhor", "Hadke", "vibhor.Hadke@ebix.com");
					
					// start transaction
					session.beginTransaction();
					
					// save student object
					System.out.println("saving the student");
					session.save(tempStudent);
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					session.getTransaction().commit();
				} catch (Exception e) {
					System.out.println("Transaction Rollback");
					e.printStackTrace();
					session.getTransaction().rollback();
					
				} finally {
					factory.close();
					session.close();
				}

	}

}
