package homework3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FindUserTables {
    public static void main(String[] args)
        throws SQLException,ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/javabook2","postgres","postgres");
        System.out.println("Database connected");

        DatabaseMetaData databaseMetaData = connection.getMetaData();


    }
}
