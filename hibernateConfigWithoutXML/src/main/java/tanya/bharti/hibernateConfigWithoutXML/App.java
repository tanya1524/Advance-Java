package tanya.bharti.hibernateConfigWithoutXML;

import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import org.hibernate.query.Query;

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
        
        Properties propertiesSetting = new Properties();
        propertiesSetting.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        propertiesSetting.put(Environment.URL, "jdbc:mysql://localhost:3306/GLOBAL");
        propertiesSetting.put(Environment.USER, "root");
        propertiesSetting.put(Environment.PASS, "tan89553");
        propertiesSetting.put(Environment.SHOW_SQL, true);
        propertiesSetting.put(Environment.HBM2DDL_AUTO, "update");
        //propertiesSetting.put(Environment.RESOURCES_CLASSLOADER, "tanya.bharti.Employee");
        config.addClass(Employee.class);
        
        config.setProperties(propertiesSetting);
        
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        Query query = session.createQuery("from Employee");
        List <Employee> employee = query.list();
        for(Employee e : employee) {
        	System.out.println(e);
        }
        
        tx.commit();
        
        session.close();
        
        factory.close();
    }
}
