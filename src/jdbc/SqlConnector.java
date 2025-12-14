package jdbc;
import java.sql.*;
public class SqlConnector {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "myroot";
        String pass = "password";

        try (Connection connection = DriverManager.getConnection(url, user,pass)) {
            System.out.println("connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
