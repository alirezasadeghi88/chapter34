package homework3;

import java.sql.*;

public class FindUserTables {
    public static void main(String[] args)
        throws SQLException,ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/javabook2","postgres","postgres");
        System.out.println("Database connected");

        DatabaseMetaData databaseMetaData = connection.getMetaData();

        ResultSet rsTables = databaseMetaData.getTables(null,null,null,
                new String[] {"TABLE"});
        System.out.print("User tables: ");
        while (rsTables.next())
            System.out.print(rsTables.getString("TABLE_NAME") + " ");

        connection.close();
    }
}
