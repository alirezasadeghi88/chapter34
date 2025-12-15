package homework3;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class TestCallableStatement {
    public static void main(String[] args)throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/javabook2","postgres","postgres");


    }
}
