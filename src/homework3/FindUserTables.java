package homework3;

import java.sql.SQLException;

public class FindUserTables {
    public static void main(String[] args)
        throws SQLException,ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded");
        
        
    }
}
