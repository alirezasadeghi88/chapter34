package homework;

import java.sql.*;

public class SimpleJdbc {
    public static void main(String[] args)  {
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded");

            // Connect to a database
            Connection connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/javabook", "postgres", "postgres");
            System.out.println("Database connected");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a statement
            ResultSet resultSet = statement.executeQuery
                    ("select * from course");

            // Iterate through the result and print the student names
            while (resultSet.next())
                System.out.println(resultSet.getString(1) + "\t" +
                        resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + resultSet.getString(4));

            // Close the connection
            connection.close();
        } catch (Exception e) {
            System.out.println("error...");
        }
    }
}
