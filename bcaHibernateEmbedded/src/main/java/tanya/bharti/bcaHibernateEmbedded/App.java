package tanya.bharti.bcaHibernateEmbedded;



/**
 * Hello world!
 *x 
 */
public class App 
{
    public static void main( String[] args )
    {
    	configuration config = new Configuration ();
    	config.configure(); 
    	
    	SessionFactory factory = config.buildsessionFactory();
    	Session session =factory.openSession();
    	
    	Transcation tx =
    	
    	
    	
    	
        
    }
}
