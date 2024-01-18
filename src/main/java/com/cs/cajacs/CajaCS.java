/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cs.cajacs;

import com.cs.cajacs.controllers.*;
import com.cs.cajacs.interfaces.*;
import com.cs.cajacs.coneccion.*;
import com.cs.cajacs.modelos.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlossamuelmedinapardo
 */
public class CajaCS {

    public static void main(String[] args) {

//        ModuloLogin modulo = new ModuloLogin();
//        modulo.setVisible(true);
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
            
         
        //Anular facturas
        try {
            fcontroller.anularFactura(1);
        } catch (Exception ex) {
            Logger.getLogger(CajaCS.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
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
        /*

            
            System.out.println(pfcontroller.obtenerAbonadoFacturaId(1));
            System.out.println("INICIO Pagos");
            
          //  List<Pagos_Facturas> lista_Pagos_Facturas = pfcontroller.obtenerPagosPorFacturaId(1);

//            for (Pagos_Facturas pago_factura : lista_Pagos_Facturas) {
//                System.out.println("ID de Factura: " + pago_factura.getFactura().getNumFactura());
//                System.out.println("Metodo de pago: " + pago_factura.getMetodoDePago().getDescripcion());
//                System.out.println("Monto: " + pago_factura.getCantidad());
//            }
//            
//            System.out.println("FIN Pagos");
//
//           
//            
//            System.out.println("Abonado:");
//            
//            System.out.println(pfcontroller.obtenerAbonadoFacturaId(1));
//        
//            System.out.println("Faltante:");
//            
//            System.out.println(pfcontroller.calcularSaldoPendiente(1));   

           



         */
 /*
        //*************METODOS CINDY*****************
        //INFORME 1 RECIBIENDO FECHAS 
        //Formato Date ->  Año, mes (va de 0 a 11), día
        Date fechaInicio = new Date(2022 - 1900, 7, 01); //Equivale a 2022-08-01
        Date fechaFin = new Date(2022 - 1900, 7, 13); //Equivale a 2022-08-13
        List<Object[]> informe1RecibeFechas = fcontroller.getInforme1(fechaInicio, fechaFin);

        System.out.println("\nINFORME 1 - Con fechas");
        if (informe1RecibeFechas != null) {
            for (Object[] resultado : informe1RecibeFechas) {
                String descripcion = (String) resultado[0];
                BigDecimal cantidadTotal = (BigDecimal) resultado[1];

                System.out.println(descripcion + " : " + cantidadTotal);
            }
        } else {
            System.out.println("Por favor ingrese ambas fechas.");
        }

        //INFORME 1 SIN RECIBIR FECHAS 
        List<Object[]> informe1NoRecibeFechas = fcontroller.getInforme1(null, null);

        System.out.println("\nINFORME 1 - Sin fechas");
        if (informe1NoRecibeFechas != null) {
            for (Object[] resultado : informe1NoRecibeFechas) {
                String descripcion = (String) resultado[0];
                BigDecimal cantidadTotal = (BigDecimal) resultado[1];

                System.out.println(descripcion + " : " + cantidadTotal);
            }
        } else {
            System.out.println("Por favor ingrese ambas fechas.");
        }
         
        //INFORME 2        
        System.out.println("\nINFORME 2");
        List<Object[]> informe2 = fcontroller.getInforme2("Nequi",fechaInicio,fechaFin);
        if (informe2 != null) {
            for (Object[] resultado : informe2) {
                Date fechaFactura = (Date) resultado[0];
                String prefijo = (String) resultado[1];
                String numFactura = (String) resultado[2];
                String valorFactura = (String) resultado[3];
                Integer cantidadMedioPago = (Integer) resultado[4];

                System.out.println("**************************");
                System.out.println("Fecha : " + fechaFactura);
                System.out.println("Prefijo: " + prefijo);
                System.out.println("Numero : " + numFactura);
                System.out.println("Valor factura: " + valorFactura);
                System.out.println("Total medio de pago : " + cantidadMedioPago);

            }
        }else {
            System.out.println("Por favor ingrese el rango de fechas para hacer la busqueda.");
        }
        
        //OBTENER IMAGEN MEDIO DE PAGO
        String imagen = mcontroller.getImagenMetodoDePago(1);
        System.out.println("\nIMAGEN MEDIO DE PAGO SELECCIONADO : " + imagen);
         
        //EDITAR MEDIO DE PAGO
        Metodos_de_pago metodo = mcontroller.getMetodoDePagoById(1);
        metodo.setCuenta("00000");

        try {
            mcontroller.editMetodoDePago(metodo);
        } catch (Exception ex) {
            Logger.getLogger(CajaCS.class.getName()).log(Level.SEVERE, null, ex);
        };
         
        //DESACTIVAR MEDIO DE PAGO
        try {
            mcontroller.desactivarMetodoDePago(1);
        } catch (Exception ex) {
            Logger.getLogger(CajaCS.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        //CARGAR IMAGEN MEDIO DE PAGO
        File inputFile = new File("D:\\Desktop\\nequi.png");
        String Imagen = mcontroller.guardarImagenMetodoDePago(inputFile);


        //El metodo anterior devuelve el nombre de la imagen y lo debo enviar
        //en el create del metodo de pago para que lo guarde en la DB
        if (Imagen != null) {
            Metodos_de_pago nuevoMetodo2 = new Metodos_de_pago();
            nuevoMetodo2.setDescripcion("Prueba");
            nuevoMetodo2.setImagen(Imagen);
            mcontroller.createMetodoDePago(nuevoMetodo2);
        }else{
            System.out.println("Se debe cargar una imagen para registrar el metodo de pago");
        }
         */
    }
}
