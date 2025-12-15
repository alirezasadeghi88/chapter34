package homework3;

import java.sql.*;


public class TestCallableStatement {
    public static void main(String[] args)throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/javabook2","postgres","postgres");

        CallableStatement callableStatement = connection.prepareCall
                ("{? = call studentFound(?, ?)}");

        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter student's first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter student's last name: ");
        String lastName = input.nextLine();

        callableStatement.setString(2, firstName);
        callableStatement.setString(3, lastName);
        callableStatement.registerOutParameter(1, Types.INTEGER);
        callableStatement.execute();


    }
}
