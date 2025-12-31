package com.klu;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		//load configuration and create the session factory
		SessionFactory factory=new Configuration()
				.configure().buildSessionFactory();
		//open session
		Session session =factory.openSession();
		//being transaction
		Transaction tx=session.beginTransaction();
		//create the table /object
		Student s = new Student();   // ✅ correct
		s.setId(1);
		s.setName("Ravi");
		s.setMarks(90);
		session.save(s);

		//save the data
		session.save(s);
		//commit
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Student data inserted succesfully");
		
	}

}
