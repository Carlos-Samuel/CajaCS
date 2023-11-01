/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author carlossamuelmedinapardo
 */
public class MySQLDatabase {
    private static MySQLDatabase instance;
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/CajaCS"; 
    private final String user = "cajacs_user";
    private final String password = "cajacs_password"; 

    private MySQLDatabase() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static MySQLDatabase getInstance() {
        if (instance == null) {
            synchronized (MySQLDatabase.class) {
                if (instance == null) {
                    instance = new MySQLDatabase();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
