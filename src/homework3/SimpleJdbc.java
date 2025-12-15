package homework3;

import java.sql.*;

public class SimpleJdbc {
    public static void main(String[] args)
        throws SQLException,ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/javabook2","postgres","postgres");
        System.out.println("Database connected");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery
                ("select firstName, mi, lastName from Student where lastName "
                     + " = 'Smith'");

        while (resultSet.next())
            System.out.println(resultSet.getString(1) + "\t" +
                    resultSet.getString(2) + "\t" + resultSet.getString(3));

        connection.close();
    }
}
