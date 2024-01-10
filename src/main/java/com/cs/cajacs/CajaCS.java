/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cs.cajacs;

import com.cs.cajacs.controllers.*;
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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author carlossamuelmedinapardo
 */
public class CajaCS {

    public static void main(String[] args) {
        
        //ModuloLogin modulo = new ModuloLogin();
        
        //modulo.setVisible(true);
        
        
        
        //Esto es crear usuarios
        
        /*
 
        UsuariosController controller = new UsuariosController();

        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setCedula("1006873236");
        nuevoUsuario.setNombres("Nombre");
        nuevoUsuario.setApellidos("Apellidos");
        nuevoUsuario.setCorreo("correo@example.com");
        nuevoUsuario.setPassword("contrasena");

        controller.createUsuario(nuevoUsuario);
        controller.createUsuario(nuevoUsuario);
        controller.createUsuario(nuevoUsuario);
        controller.createUsuario(nuevoUsuario);
        controller.createUsuario(nuevoUsuario);
        

        controller.close();
        
        */
        
        
            PagosFacturasController pfcontroller = new PagosFacturasController();
            FacturasController fcontroller = new FacturasController();
            UsuariosController ucontroller = new UsuariosController();
            MetodosDePagoController mcontroller = new MetodosDePagoController();
            
            
            // Para editar o borrar usuarios
            
            /*

            List<Usuarios> listaUsuarios = ucontroller.getAllUsuarios();
            
            System.out.println("INICIO");

            for (Usuarios usuarios : listaUsuarios) {
                System.out.println(usuarios.toString());
            }
            
            System.out.println("FIN");            

            Usuarios usuario = ucontroller.getUsuarioById(1);
            
            usuario.setNombres("Puto");
            
            try {
                ucontroller.editUsuario(usuario);
                ucontroller.deleteUsuario(5);
            } catch (Exception ex) {
                Logger.getLogger(CajaCS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            listaUsuarios = ucontroller.getAllUsuarios();
            
            System.out.println("INICIO");

            for (Usuarios usuarios : listaUsuarios) {
                System.out.println(usuarios.toString());
            }
            
            System.out.println("FIN");  
            
            */
            
            /*
            
            //Para crear un Pago Facturas
            
            //Crear una factura
            
            Facturas nuevaFactura = new Facturas();
            nuevaFactura.setPrefijo("Prefijo");
            nuevaFactura.setNumFactura("1231245");
            nuevaFactura.setValorFactura(10000);
            
            fcontroller.createFactura(nuevaFactura);
            
            
            */
            
            /*
            
            //Crear un metodo de pago
            
            Metodos_de_pago nuevoMetodo = new Metodos_de_pago();
            
            nuevoMetodo.setDescripcion("Tarjeta");
            
            mcontroller.createMetodoDePago(nuevoMetodo);

            
            */
            
            /*
            
            
            
            List<Facturas> listaFacturas = fcontroller.getAllFacturas();
            
            
            System.out.println("INICIO");

            for (Facturas factura : listaFacturas) {
                System.out.println("ID de Factura: " + factura.getIdFacturas());
                System.out.println("Monto de Factura: " + factura.getValorFactura());
            }
            
            System.out.println("FIN");
            
            */
            
            /*
           
            Pagos_Facturas nuevoPagoFactura = new Pagos_Facturas();
            
            Facturas factura = fcontroller.getFacturaById(1);
            
            Usuarios usuario = ucontroller.getUsuarioById(1);
                        
            Metodos_de_pago metodo = mcontroller.getMetodoDePagoById(2);
                        
            nuevoPagoFactura.setFactura(factura);
            nuevoPagoFactura.setMetodoDePago(metodo);
            nuevoPagoFactura.setUsuario(usuario);
            nuevoPagoFactura.setCantidad(3000L);
            PagosFacturasId idPF = new PagosFacturasId(factura.getIdFacturas(), metodo.getIdMetodos_de_pago());
            nuevoPagoFactura.setId(idPF);
            
            System.out.println("Antes de iniciar datos");
            System.out.println(factura.getIdFacturas());
            System.out.println(metodo.getIdMetodos_de_pago());
            System.out.println(usuario.getIdUsuarios());
           
            System.out.println("Antes de iniciar el proceso");
            
            try{
                pfcontroller.createPagoFactura(nuevoPagoFactura);
            } catch (Exception e) {
                System.out.println("Se ha producido un error: " + e.getMessage());
            }
            
            System.out.println("Despues del proceso");
            
            */
            
            
          
            //Obtener la cantidad pagadas por medio de pago por factura
            
            /*
            
            int cantidad = pfcontroller.obtenerAbonadoMedioPagoFacturaId(1, 1);
            
            System.out.println("Factura 1 pago en efectivo "+ cantidad);
            
            int cantidad2 = pfcontroller.obtenerAbonadoMedioPagoFacturaId(1, 2);
            
            System.out.println("Factura 1 pago en tarjeta " + cantidad2);
            
            */
            
            //Anular facturas
            
            // fcontroller.anularFactura(1);
            
            //Editar pago en facturas
            
            /*
            
            List<Pagos_Facturas> listaPagosFacturas = pfcontroller.getAllPagosFacturas();
            
            System.out.println("INICIO");

            for (Pagos_Facturas pagosFacturas : listaPagosFacturas) {
                System.out.println(pagosFacturas.toString());
            }
            
            System.out.println("FIN");            

            
            
            try {
                pfcontroller.editPagosFacturas(1, 1, 8888);
            } catch (Exception ex) {
                Logger.getLogger(CajaCS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            listaPagosFacturas = pfcontroller.getAllPagosFacturas();
            
            System.out.println("INICIO");

            for (Pagos_Facturas pagosFacturas : listaPagosFacturas) {
                System.out.println(pagosFacturas.toString());
            }
            
            System.out.println("FIN");            
            
            */
                                 
            
            //Esto no esta funcionando
            
            
            
            
            System.out.println("INICIO Pagos");
            
          //  List<Pagos_Facturas> lista_Pagos_Facturas = pfcontroller.obtenerPagosPorFacturaId(1);

//            for (Pagos_Facturas pago_factura : lista_Pagos_Facturas) {
//                System.out.println("ID de Factura: " + pago_factura.getFactura().getNumFactura());
//                System.out.println("Metodo de pago: " + pago_factura.getMetodoDePago().getDescripcion());
//                System.out.println("Monto: " + pago_factura.getCantidad());
//            }
//            
            System.out.println("FIN Pagos");

           
            
            System.out.println("Abonado:");
            
            System.out.println(pfcontroller.obtenerAbonadoFacturaId(1));
        
            System.out.println("Faltante:");
            
            System.out.println(pfcontroller.calcularSaldoPendiente(1));   

           

    }
}
