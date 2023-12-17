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


/**
 *
 * @author carlossamuelmedinapardo
 */
public class CajaCS {

    public static void main(String[] args) {
        
        //ModuloLogin modulo = new ModuloLogin();
        
        //modulo.setVisible(true);
        
        /*
        
        //Estos son los ejemplos, no borrar
 
        UsuariosController controller = new UsuariosController();

        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setCedula("1006873236");
        nuevoUsuario.setNombres("Nombre");
        nuevoUsuario.setApellidos("Apellidos");
        nuevoUsuario.setCorreo("correo@example.com");
        nuevoUsuario.setPassword("contrasena");

        controller.createUsuario(nuevoUsuario);

        controller.close();
        
        */
        

        
        
            //Para crear un Pago Facturas

        
            PagosFacturasController pfcontroller = new PagosFacturasController();
            FacturasController fcontroller = new FacturasController();
            UsuariosController ucontroller = new UsuariosController();
            MetodosDePagoController mcontroller = new MetodosDePagoController();
            
            

            /*
            
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
            
            nuevoMetodo.setDescripcion("Efectivo");
            
            mcontroller.createMetodoDePago(nuevoMetodo);

            */
            

            Pagos_Facturas nuevoPagoFactura = new Pagos_Facturas();
            
            List<Facturas> listaFacturas = fcontroller.getAllFacturas();
            
            /*
            
            System.out.println("INICIO");

            for (Facturas factura : listaFacturas) {
                System.out.println("ID de Factura: " + factura.getIdFacturas());
                System.out.println("Monto de Factura: " + factura.getValorFactura());
            }
            
            System.out.println("FIN");
            
            */
            
            Facturas factura = fcontroller.getFacturaById(1);
            
            Usuarios usuario = ucontroller.getUsuarioById(1);
                        
            Metodos_de_pago metodo = mcontroller.getMetodoDePagoById(1);
                        
            /*
 
            nuevoPagoFactura.setFactura(factura);
            nuevoPagoFactura.setMetodoDePago(metodo);
            nuevoPagoFactura.setUsuario(usuario);
            nuevoPagoFactura.setCantidad(1500L);

            pfcontroller.createPagoFactura(nuevoPagoFactura);
            
            */

            
            //Esto no esta funcionando
            
            
            /*
            
            System.out.println("INICIO Pagos");
            
            List<Pagos_Facturas> lista_Pagos_Facturas = pfcontroller.obtenerPagosPorFacturaId(1);

            for (Pagos_Facturas pago_factura : lista_Pagos_Facturas) {
                System.out.println("ID de Factura: " + pago_factura.getFactura().getNumFactura());
                System.out.println("Metodo de pago: " + pago_factura.getMetodoDePago().getDescripcion());
                System.out.println("Monto: " + pago_factura.getCantidad());
            }
            
            System.out.println("FIN Pagos");

            */
            
            System.out.println("Abonado:");
            
            System.out.println(pfcontroller.obtenerAbonadoFacturaId(1));
        
            System.out.println("Faltante:");
            
            System.out.println(pfcontroller.calcularSaldoPendiente(1));      

    }
}
