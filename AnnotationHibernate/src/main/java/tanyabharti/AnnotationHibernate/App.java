package tanyabharti.AnnotationHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration config = new Configuration();
        config.configure();
        
        SessionFactory factory = config.buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        Employee em = session.get(Employee.class, 908);
        
        System.out.println(em);
        
        tx.commit();
        session.close();
    }
}
