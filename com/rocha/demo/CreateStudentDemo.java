package com.rocha.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rocha.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object");
			Student tempStudent = new Student("Fer", "Rocha", "fernandaporocha@gmail.com");
			session.beginTransaction();
			session.save(tempStudent);
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			factory.close();
		}
	}

}
