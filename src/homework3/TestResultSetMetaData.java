package homework3;

import java.sql.SQLException;

public class TestResultSetMetaData {
    public static void main(String[] args)
        throws SQLException,ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded");
    }
}
