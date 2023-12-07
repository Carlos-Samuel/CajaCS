/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cs.cajacs;

import com.cs.cajacs.controllers.UsuariosController;
import com.cs.cajacs.interfaces.*;
import com.cs.cajacs.coneccion.*;
import com.cs.cajacs.modelos.*;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;


/**
 *
 * @author carlossamuelmedinapardo
 */
public class CajaCS {

    public static void main(String[] args) {
        
        ModuloLogin modulo = new ModuloLogin();
        
        modulo.setVisible(true);
        
        /*
 
        UsuariosController controller = new UsuariosController();

        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setCedula("1006873236");
        nuevoUsuario.setNombres("Nombre");
        nuevoUsuario.setApellidos("Apellidos");
        nuevoUsuario.setCorreo("correo@example.com");
        nuevoUsuario.setPassword("contrasena");

        controller.createUsuario(nuevoUsuario);

        System.out.println("Usuario creado con ID: " + nuevoUsuario.getIdUsuarios());

        controller.close();
        
        */
        
        /*
        
            //Para crear un Pago Facturas

        
            PagosFacturasController controller = new PagosFacturasController("MiUnidadPersistencia");

            // Crear un nuevo pago de factura
            Pagos_Facturas nuevoPagoFactura = new Pagos_Facturas();
            // Configura los objetos Facturas, Metodos_de_pago y Usuarios según tus necesidades
            Facturas factura = ;
            Metodos_de_pago metodoDePago = ;
            Usuarios usuario = ;

            nuevoPagoFactura.setFactura(factura);
            nuevoPagoFactura.setMetodoDePago(metodoDePago);
            nuevoPagoFactura.setUsuario(usuario);
            nuevoPagoFactura.setCantidad(5); // Cantidad de pago

            controller.createPagoFactura(nuevoPagoFactura);

            // Realiza otras operaciones según tus necesidades, como obtener pagos de facturas, etc.

            // Cierra el controlador al final de la aplicación
            controller.close();
        
        */
        

    }
}
