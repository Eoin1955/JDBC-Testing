package ie.atu.week6;

import java.sql.*;

public class InsertExample {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdatabase", "root", "Password");

        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Students (firstName, lastName, age, email) values(?,?,?,?)"); //first_name last_name email age
            stmt.setString(1, "Eoin");
            stmt.setString(2, "Ager");
            stmt.setInt(3, 20);
            stmt.setString(4, "G00431577@atu.ie");
            stmt.executeUpdate();

            stmt = con.prepareStatement("INSERT INTO course (StudentId, course, duration)values(?,?,?)");
            stmt.setInt(1, getLastInsertId(con));
            stmt.setString(2, "Software Engineering");
            stmt.setString(3, "4 years");
        }
        catch (SQLException ex){
            System.out.println("insert failed");
            ex.printStackTrace();
        }
        con.close();
    }


    private static int getLastInsertId(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
        rs.next();
        int id = rs.getInt(1);
        rs.close();
        stmt.close();
        return id;
    }
}