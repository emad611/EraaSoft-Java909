package com.hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.STUDENTERAASOFT;
import com.hibernate.model.Teacher;

public class Main {

	public static void main(String[] args) {
		Configuration configuration=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class);
		SessionFactory factory=
				configuration.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		Transaction transaction=session.beginTransaction();
		
		//save=insert
//		Teacher teacher=new Teacher(1, "emad", "20", "tanta");
//		session.save(teacher);
		
		// get
//		Teacher teacher=session.get(Teacher.class, 1);
//		System.out.print(teacher);
//		
		// update
//		Teacher teacher=session.get(Teacher.class, 1);
//		teacher.setName("magdey");
//		session.update(teacher);
		
		//delete
		Teacher teacher=session.get(Teacher.class, 1);
		session.delete(teacher);
		
		transaction.commit();
		
		session.close();
		factory.close();
	}

}
