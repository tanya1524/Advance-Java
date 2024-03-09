import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class student {

	    public static void main(String[] args) {
	        Connection connection = null;
	        Scanner scanner = new Scanner(System.in);
	        String url = "jdbc:mysql://localhost:3306/GLOBAL";
	        String username = "root";
	        String password = "tan89553";

	        try {
	            // Register the driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish a connection
	            connection = DriverManager.getConnection(url, username, password);
	            System.out.println("Connected to the database successfully!");

	            // Create a table
	            String sql = "CREATE TABLE IF NOT EXISTS students " +
	                         "(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
	                         " name VARCHAR(50), " +
	                         " age INTEGER, " +
	                         " gender VARCHAR(10), " +
	                         " address VARCHAR(100), " +
	                         " gpa DECIMAL(3,2))";
	            Statement statement = connection.createStatement();
	            statement.execute(sql);

	            while (true) {
	                System.out.println("\n1. Insert data");
	                System.out.println("2. Fetch data");
	                System.out.println("3. Exit");
	                System.out.print("Enter your choice: ");
	                int choice = scanner.nextInt();

	                switch (choice) {
	                    case 1:
	                        // Insert data
	                        System.out.print("Enter student name: ");
	                        String name = scanner.next();
	                        System.out.print("Enter student age: ");
	                        int age = scanner.nextInt();
	                        System.out.print("Enter student gender (M/F): ");
	                        String gender = scanner.next();
	                        System.out.print("Enter student address: ");
	                        scanner.nextLine();
	                        String address = scanner.nextLine();
	                        System.out.print("Enter student GPA: ");
	                        double gpa = scanner.nextDouble();

	                        sql = "INSERT INTO students (name, age, gender, address, gpa) VALUES (?, ?, ?, ?, ?)";
	                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	                        preparedStatement.setString(1, name);
	                        preparedStatement.setInt(2, age);
	                        preparedStatement.setString(3, gender);
	                        preparedStatement.setString(4, address);
	                        preparedStatement.setDouble(5, gpa);
	                        preparedStatement.executeUpdate();
	                        System.out.println("Data inserted successfully!");
	                        break;

	                    case 2:
	                        // Fetch data
	                        sql = "SELECT * FROM students";
	                        statement = connection.createStatement();
	                        ResultSet resultSet = statement.executeQuery(sql);

	                        System.out.println("\nStudent Details:");
	                        System.out.println("-----------------");
	                        while (resultSet.next()) {
	                            System.out.println("ID: " + resultSet.getInt("id"));
	                            System.out.println("Name: " + resultSet.getString("name"));
	                            System.out.println("Age: " + resultSet.getInt("age"));
	                            System.out.println("Gender: " + resultSet.getString("gender"));
	                            System.out.println("Address: " + resultSet.getString("address"));
	                            System.out.println("GPA: " + resultSet.getDouble("gpa"));
	                            System.out.println("-----------------");
	                        }
	                        break;

	                    case 3:
	                        // Exit
	                        System.out.println("Exiting the program...");
	                        System.exit(0);
	                        break;

	                    default:
	                        System.out.println("Invalid choice, please try again...");
	                        break;
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Error occurred: " + e.getMessage());
	        } finally {
	            try {
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (SQLException e) {
	                System.out.println("Error occurred while closing the connection: " + e.getMessage());
	            }
	        }
	    }
	}


