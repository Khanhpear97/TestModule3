package com.example.testmodule3.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    protected String jdbcURL;
    protected String jdbcUserName;
    protected String jdbcPassword;

    public static Database instance;

    private Database() {
        this.jdbcURL = "jdbc:mysql://localhost:3306/testModule3?useSSL=false";
        this.jdbcUserName = "root";
        this.jdbcPassword = "123456";
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage() + " error");
        }
        return null;
    }
}
