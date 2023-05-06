package util;

import java.sql.*;

public class BasicConnection {
    public static void main(String[] args){


    String url =
            "jdbc:mysql://localhost:3306/MyApp?serve rTimezone=America/Bogota";
        String username = "User2";
        String password = "ALKMRT1013";

        String sql = null;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
        sql = "SELECT * FROM MyApp.users_tbl";
        conn =
        DriverManager.getConnection(url, username, password);
        stm = conn.createStatement();
        rs = stm.executeQuery(sql);

        while (rs.next()) {

        System.out.print(rs.getString("user_firstname"));
        System.out.print(" | ");

        System.out.print(rs.getString("user_lastname"));
        System.out.print(" | ");
        System.out.print(rs.getString("user_password"));

        }
        } catch (SQLException e) {
        e.printStackTrace();
        } finally {
        try {
            rs.close();
        stm.close();
        conn.close();
        } catch (SQLException e) {
        throw new RuntimeException(e);
            }
        }// end try-catch
    } // main
} // BasicConnection
