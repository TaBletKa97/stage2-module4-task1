package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class H2ConnectionFactory implements ConnectionFactory {

    @Override
    public Connection createConnection() {
        Connection cn = null;
        try {
            ResourceBundle rb = ResourceBundle.getBundle("h2database");
            Class.forName(rb.getString("jdbc_driver"));
            cn = DriverManager.getConnection(rb.getString("db_url"),
                    rb.getString("user"),
                    rb.getString("password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }
}