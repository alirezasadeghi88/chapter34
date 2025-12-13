package homework;

import java.sql.*;

public class FindUserTables {
    public static void main(String[] args)
        throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        System.out.println("Driver Loaded");

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javabook",
                "postgres","postgres");
        System.out.println("Database connected");

        DatabaseMetaData dbMetaData = connection.getMetaData();

        ResultSet rsTables = dbMetaData.getTables(null,null,null,
                new String[] {"TABLE"});
        System.out.println("User tables: ");
        while (rsTables.next())
            System.out.println(rsTables.getString("TABLE_NAME") + " ");

        connection.close();
    }
}
