package tanya.bharti.hibernateFromClause;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.mapping.List;

public class Main {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		String query ="From student";
		List <Student>students =session.createQuery(query);
		
		for(Student s:students) {
			System.out.println("inside for loop");
			System.out.println(s);	
		}
		
		tx.commit();
		session.close();
	}

}
