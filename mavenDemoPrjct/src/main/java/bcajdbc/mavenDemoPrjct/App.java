package bcajdbc.mavenDemoPrjct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException
    {
    	String dburl ="jdbc:mysql://localhost:3306/studentdb";
    		String username ="root";
    	String pwd ="tan@89553";
        System.out.println( "Hello World!" );
        Class.forName("com.mysql.cj.jdbc.Driver");
        
       Connection con = DriverManager.getConnection(dburl,username,pwd);
       
       String query ="Create Table amity_students(id int,name varchar(50),address varchar(50)";
       Statement st = con.createStatement(); 
       int rows = st.executeUpdate(query);
       System.out.println("Created Amity_student successfully");
       
    }
}
