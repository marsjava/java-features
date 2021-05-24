package com.data;

import java.sql.*;

public class AwsConnection {
    public static Connection con = null;
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String RDS_CONNECION_URL = "jdbc:mysql://db-fullstack.cqvhoyk9f6o6.ap-south-1.rds.amazonaws.com/fullstack";
        String RDS_USERNAME = "root";
        String RDS_PASSWORD = "Admin123";
        con = DriverManager.getConnection(RDS_CONNECION_URL, RDS_USERNAME, RDS_PASSWORD);
        System.out.println("Connected.");

        String query = "select * from employee";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getString("empname"));
        }
        rs.close();
        stmt.close();
        con.close();
    }
}
