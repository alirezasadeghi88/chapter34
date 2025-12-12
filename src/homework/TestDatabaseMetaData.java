package homework;

import java.sql.*;


public class TestDatabaseMetaData {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getMetaData();
        System.out.println("database URL: " + dbMetaData.getURL());
        System.out.println("database username: " +
                dbMetaData.getUserName());
        System.out.println("database product name: " +
                dbMetaData.getDatabaseProductName());
        System.out.println("database product version: " +
                dbMetaData.getDatabaseProductVersion());
        System.out.println("JDBC driver name: " +
                dbMetaData.getDriverName());
        System.out.println("JDBC driver version: " +
                dbMetaData.getDriverVersion());
        System.out.println("JDBC driver major version: " +
                );

    }
}
