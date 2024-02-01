import java.sql.DriverManager;

public class insert

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://local host: 3306/STUDENT","root,"Students");
        		
        		Statement st = con.createStatement();
        		
        		String query ="Insert into students values (566,'VARUN','B.tech',90,'2002-01-15','male');
        				int rowAffected =st.executeUpdate(query);
                System.out.println(rowAffected + "row Inserted Successfully!!!");
        con.close() ;
	}

}



