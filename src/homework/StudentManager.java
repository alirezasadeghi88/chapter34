package homework;

import java.io.*;
import java.sql.*;
import java.util.*;


public class StudentManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            Properties props = new Properties();
            props.load(new FileInputStream("E:\\projects\\chapter34\\src\\homework\\confing.properties"));

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Database connected!");

            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Stu (" +
                            "ssn VARCHAR(9) PRIMARY KEY, " +
                            "firstname VARCHAR(50), " +
                            "mi CHAR(1), " +
                            "lastname VARCHAR(50), " +
                            "birthdate DATE, " +
                            "street VARCHAR(100), " +
                            "phone VARCHAR(15), " +
                            "zipcode VARCHAR(10), " +
                            "deptid VARCHAR(10))"
            );

            String sql = "INSERT INTO Stu(ssn, firstname, mi," +
                    " lastname, birthdate, street, phone, zipcode, deptid)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            System.out.print("How many students do you want to insert? ");
            int count = Integer.parseInt(input.nextLine());
            for (int i = 0; i < count; i++) {
                System.out.println("\n--- Student " + (i + 1) + "----");

                System.out.print("Enter SSN: ");
                String ssn = input.nextLine();

                System.out.print("Enter First Name: ");
                String firstname = input.nextLine();

                System.out.print("Enter Middle Initial: ");
                String mi = input.nextLine();

                System.out.print("Enter Last Name: ");
                String lastname = input.nextLine();

                System.out.print("Enter Birth Date (YYYY-MM-DD): ");
                String birthdate = input.nextLine();

                System.out.print("Enter Street: ");
                String street = input.nextLine();

                System.out.print("Enter Phone: ");
                String phone = input.nextLine();

                System.out.print("Enter Zip Code: ");
                String zipcode = input.nextLine();

                System.out.print("Enter DeptID: ");
                String deptid = input.nextLine();

                preparedStatement.setString(1,ssn);
                preparedStatement.setString(2,firstname);
                preparedStatement.setString(3,mi);
                preparedStatement.setString(4,lastname);
                preparedStatement.setDate(5,java.sql.Date.valueOf(birthdate));
                preparedStatement.setString(6,street);
                preparedStatement.setString(7,phone);
                preparedStatement.setString(8,zipcode);
                preparedStatement.setString(9,deptid);

                preparedStatement.addBatch();
            }

            int[] rows = preparedStatement.executeBatch();
            System.out.println(rows.length + "row(s) inserted");

            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            input.close();
        }
    }
}
