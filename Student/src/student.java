import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class student {

    public static void main(String[] args) {
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/studentdb";
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
                         " course VARCHAR(50), " +
                         " dob DATE, " +
                         " gender VARCHAR(10), " +
                         " cgpa DECIMAL(3,2))";
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
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.print("Enter student course: ");
                        String course = scanner.nextLine();
                        System.out.print("Enter student DOB (yyyy-mm-dd): ");
                        String dobString = scanner.nextLine();
                        LocalDate dob = LocalDate.parse(dobString);
                        System.out.print("Enter student gender (M/F): ");
                        String gender = scanner.nextLine();
                        System.out.print("Enter student CGPA: ");
                        double cgpa = scanner.nextDouble();

                        sql = "INSERT INTO students (name, course, dob, gender, cgpa) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, course);
                        preparedStatement.setDate(3, Date.valueOf(dob));
                        preparedStatement.setString(4, gender);
                        preparedStatement.setDouble(5, cgpa);
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
                            System.out.println("Course: " + resultSet.getString("course"));
                            System.out.println("DOB: " + resultSet.getDate("dob"));
                            System.out.println("Gender: " + resultSet.getString("gender"));
                            System.out.println("CGPA: " + resultSet.getDouble("cgpa"));
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