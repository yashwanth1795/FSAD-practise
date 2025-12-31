package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCEmployeeDeptDemo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/wtnjava";
        String user = "root";
        String password = "Yash@002"; // keep your actual password here

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database!");

            Statement st = con.createStatement();

            // create tables (safe if they already exist)
            st.executeUpdate("CREATE TABLE IF NOT EXISTS dept1 (dept_id INT PRIMARY KEY, dept_name VARCHAR(50))");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS employee1 ("
                    + "emp_id INT PRIMARY KEY, emp_name VARCHAR(50), salary DOUBLE, dept_id INT, "
                    + "FOREIGN KEY (dept_id) REFERENCES dept1(dept_id))");
            System.out.println("Tables ensured.");

            // INSERT DEPARTMENTS FIRST (important!)
            st.executeUpdate("INSERT IGNORE INTO dept1 VALUES (1, 'HR')");
            st.executeUpdate("INSERT IGNORE INTO dept1 VALUES (2, 'Finance')");
            st.executeUpdate("INSERT IGNORE INTO dept1 VALUES (3, 'IT')");
            System.out.println("Departments inserted.");

            // THEN INSERT EMPLOYEES
            st.executeUpdate("INSERT IGNORE INTO employee1 VALUES (101, 'Alice', 50000, 1)");
            st.executeUpdate("INSERT IGNORE INTO employee1 VALUES (102, 'Bob', 60000, 2)");
            st.executeUpdate("INSERT IGNORE INTO employee1 VALUES (103, 'Charlie', 70000, 3)");
            System.out.println("Employees inserted.");

            con.close();
            System.out.println("Done and Connection Closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
