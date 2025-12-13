package homework;

import java.sql.*;

public class TestResultSetMetaData {
    public static void main(String[] args)
        throws SQLException,ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javabook",
                "postgres","postgres");
        System.out.println("Database connected");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from Course");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
            System.out.printf("%-12s\t",resultSetMetaData.getColumnName(i));
        System.out.println();

        while (resultSet.next()) {
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
                System.out.printf("%-12s\t",resultSet.getObject(i));
            System.out.println();
        }

        connection.close();




    }
}
