package ie.atu.week6;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class SelectExample {
    public static void main(String[] args) throws SQLException {


        String selectsql = "SELECT s.firstName, s.lastName, s.age, s.email" +
                "FROM Student s" +
                "JOIN course c ON s.id = c.StudentId";

        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdatabase", "root", "Password");){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectsql);

            while(rs.next()){
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                System.out.println(firstName + " " + lastName + " " + age + " " + email);
            }

        }
        catch(SQLException e){
            System.out.println(e);
        }

    }
}
