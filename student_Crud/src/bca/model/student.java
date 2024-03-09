package bca.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

	public class student {
		
		public student() {
			super();	
		}
		
		public void addstudent(Connection con,Scanner sc) throws SQLException {
		Statement st = con.createStatement();

		System.out.println("Enter Student Id:");
		int id =sc.nextInt();
		
		System.out.println("Enter Student Name: ");
		String name = sc.next();
		
		System.out.println("Enter Student Age: ");
		int age = sc.nextInt();
		
		System.out.println("Enter Student Marks: ");
		double marks = sc.nextDouble();
		
		System.out.println("Enter Student Gender: ");
		String gender = sc.next();
		
		
		
		String query = String.format("Insert Into students values(%d, '%s', %d, %f,'%s')", id, name, age, marks, gender);
		
		int rows = st.executeUpdate(query);
		System.out.println(rows +"record inserted !!");
	 
		}
		
		public void displaystudent(Connection con) throws SQLException {
			
	     Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from students");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ "\t"+rs.getString(2)+ "\t"+ rs.getInt(3)+"\t"+rs.getDouble(4)+"\t"+rs.getString(5));
			}
		}

		public void updatestudentName(Connection con, Scanner sc) throws SQLException {
		
		Statement st = con.createStatement();
		System.out.println("Enter Student ID: ");
		int id = sc.nextInt();
		System.out.println("Enter Student New Name: ");
		String name = sc.next();
		
		String query = String.format("update students set name='%s' where id = %d", name, id);
		int rowsAffected = st.executeUpdate(query);
		System.out.println(rowsAffected+" recored updated!!!");

	   }
		
	     public void deletestudent(Connection con, Scanner sc) throws SQLException {
		 Statement st = con.createStatement();
		 System.out.println("Enter Student ID: ");
		 int id = sc.nextInt();
		
		int rowAffected = st.executeUpdate("delete from students where id = "+id);
		System.out.println(rowAffected + " recored deleted!!!");

	  }
	     }

