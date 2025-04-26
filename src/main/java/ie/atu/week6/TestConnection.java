package ie.atu.week6;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdatabase", "root", "Password");
    }
}
