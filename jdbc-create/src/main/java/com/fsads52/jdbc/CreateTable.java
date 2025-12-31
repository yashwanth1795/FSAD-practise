package com.fsads52.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {

    	String url = "jdbc:mysql://localhost:3306/studentdb";
 
        String user = "root";         
        String pass = "Yash@002";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();

            String sql = "CREATE TABLE students ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(50), "
                    + "age INT"
                    + ")";

            stmt.executeUpdate(sql);

            System.out.println("Table created successfully!!!");
            con.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
