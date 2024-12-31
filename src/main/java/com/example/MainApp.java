package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session1 = factory.openSession();
		session1.beginTransaction();
		Employee emp1 = session1.get(Employee.class, 1L);
		System.out.println("Employee Details: " + emp1.getName() + ", " + emp1.getSalary());
		session1.getTransaction().commit();
		session1.close();

		Session session2 = factory.openSession();
		session2.beginTransaction();
		Employee emp2 = session2.get(Employee.class, 1L);
		System.out.println("Employee Details: " + emp2.getName() + ", " + emp2.getSalary());
		session2.getTransaction().commit();
		session2.close();

		factory.close();
	}
}
