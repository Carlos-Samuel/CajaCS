/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cs.cajacs;

import com.cs.cajacs.interfaces.*;
import com.cs.cajacs.coneccion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author carlossamuelmedinapardo
 */
public class CajaCS {

    public static void main(String[] args) {
        ModuloLogin modulo = new ModuloLogin();
        
        modulo.setVisible(true);

        try {
            MySQLDatabase database = MySQLDatabase.getInstance();
            Connection connection = database.getConnection();

            String query = "SELECT * FROM Usuarios";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("idUsuarios"); 
                String userName = resultSet.getString("Nombres"); 

                System.out.println("ID: " + userId + ", Nombre: " + userName);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
