/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cs.cajacs.interfaces;

import com.cs.cajacs.controllers.FacturasController;
import com.cs.cajacs.controllers.MetodosDePagoController;
import com.cs.cajacs.controllers.PagosFacturasController;
import com.cs.cajacs.controllers.UsuariosController;
import com.cs.cajacs.modelos.Facturas;
import com.cs.cajacs.modelos.Metodos_de_pago;
import com.cs.cajacs.modelos.Pagos_Facturas;
import com.cs.cajacs.modelos.Usuarios;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author carlossamuelmedinapardo
 */
public class ModuloIngresoDatos extends javax.swing.JFrame {

    /**
     * Creates new form ModuloIngresoDatos
     */
    private int indice;
    private List<JButton> botones;
    private MetodosDePagoController controller = new MetodosDePagoController();
    private FacturasController controller_factura = new FacturasController();
    PagosFacturasController pfcontroller = new PagosFacturasController();
//    PagosFacturasController controller_pago_factura = new PagosFacturasController();

    private UsuariosController controller_usuario = new UsuariosController();
    Facturas factura = null;
    private int id_metodo = 0;
    private int id_factura = 0;
    boolean editar = false;

    public ModuloIngresoDatos() {
        initComponents();
        botones = new ArrayList<JButton>();
        indice = 0;
        cerrar();
//        MetodosDePagoController controller = new MetodosDePagoController();
        List<Metodos_de_pago> prueba = controller.getAllMetodosDePago();
        for (int i = 0; i < prueba.size(); i++) {

            Metodos_de_pago metodo = prueba.get(i);
//            System.out.println(metodo.getIdMetodos_de_pago());
//            System.out.println();
//        
//        
//            System.out.println("hola");
            JButton boton = new JButton(metodo.getDescripcion() + ' ' + indice);
            //CARGA DE IMAGENES
            String directorioProyecto = System.getProperty("user.dir");

            // Crea la ruta de destino dentro del directorio del proyecto
            String ruta_imagen = directorioProyecto + File.separator + "ImagenesMedioDePago" + File.separator + metodo.getImagen();
            ImageIcon icono = new ImageIcon(ruta_imagen);
            // Escala el ícono al tamaño preferido del botón
            int anchoBoton = 100;  // Ajusta el ancho deseado del botón
            int altoBoton = 100;   // Ajusta la altura deseada del botón
            Image imagenEscalada = icono.getImage().getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
            boton.setIcon(new ImageIcon(imagenEscalada));

            // Establece el tamaño preferido del botón
            boton.setPreferredSize(new Dimension(anchoBoton, altoBoton));
            //boton.setIcon(icono);
            //FIN CARGA
            System.out.println(ruta_imagen);
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Cambiar el texto del JTextField al hacer clic en el botón
                    jLabel8.setText(metodo.getDescripcion());
                    id_metodo = metodo.getIdMetodos_de_pago();
                    jText_valor.setText(null);
                    //System.out.println("AQUIII");
                    if (id_metodo != 0 && id_factura != 0) {

                        int total_abonado = pfcontroller.calcularSaldoPendiente(id_factura);
                        //System.out.println(total_abonado);
                        jTextValorPendiente.setText(String.valueOf(total_abonado));

                        int abonado = pfcontroller.obtenerAbonadoMedioPagoFacturaId(id_factura, id_metodo);

                        if (abonado != 0L) {
//                            System.out.println(abonado);
//                            System.out.println("ASSISISISI");
//                            System.out.println(abonado);
                            jText_valor.setText(String.valueOf(abonado));
                            editar = true;
                        } else {
                            editar = false;
                        }
                    }

                }
            });
            Panel.add(boton);
            botones.add(boton);
            indice++;
            Panel.updateUI();
        }
        //controller.close();
    }

    public void cerrar() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            addWindowListener(
                    new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    cambiar();
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cambiar() {
        ModuloDashboard vista = new ModuloDashboard();
        this.dispose();
        vista.setVisible(true);
    }

    public void actualizar_campos() {
        id_factura = 1;
        factura = controller_factura.getFacturaById(id_factura);
        System.out.println(factura);
        System.out.println("SI YA IMPREME");
        //VALORES ABONADOS
        //int valor_abonado = pfcontroller.obtenerAbonadoFacturaId(id_factura);
//
//        System.out.println("Faltante:");
//        int valor_pendiente = pfcontroller.calcularSaldoPendiente(id_factura);
//        String valor_pendiente_cadena = String.valueOf(valor_pendiente);
//        System.out.println();
//        VALORES ABONADOS FIN
//
        System.out.println(factura.getPrefijo());
        jTextPrefijo.setText(factura.getPrefijo());
        jTextNumero.setText(factura.getNumFactura());
        //jTextValorPendiente.setText(valor_pendiente_cadena);

        int valor = factura.getValorFactura();
        jTextValorTotal.setText(String.valueOf(valor));
        int total_abonado = pfcontroller.calcularSaldoPendiente(id_factura);
        jTextValorPendiente.setText(String.valueOf(total_abonado));

    }

    /**
     *
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextPrefijo = new javax.swing.JTextField();
        jTextNumero = new javax.swing.JTextField();
        jTextValorTotal = new javax.swing.JTextField();
        jText_valor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextValorPendiente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 64)); // NOI18N
        jLabel1.setText("Datos Factura");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel2.setText("Pendiente");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel3.setText("Prefijo");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel4.setText("# Factura");

        jTextPrefijo.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jTextPrefijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrefijoActionPerformed(evt);
            }
        });

        jTextNumero.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N

        jTextValorTotal.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N

        jText_valor.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jText_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_valorActionPerformed(evt);
            }
        });

        Panel.setLayout(new java.awt.GridLayout(0, 4));
        jScrollPane1.setViewportView(Panel);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel5.setText("Medio de Pago:");

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registrar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTextValorPendiente.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel7.setText("Valor total");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel8.setText("Seleccionado");

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Guardar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(17, 17, 17))
        );

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Anular");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(17, 17, 17))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Escanear Factura");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel11)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(121, 121, 121)
                        .addComponent(jTextPrefijo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(54, 54, 54)
                        .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(95, 95, 95))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(41, 41, 41)
                                .addComponent(jTextValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(42, 42, 42)
                                .addComponent(jTextValorPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jText_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(jTextPrefijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jTextValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextValorPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jText_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextPrefijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrefijoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrefijoActionPerformed

    private void jText_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_valorActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        int id_usuario = 1;

        String valor = jText_valor.getText();
        if (editar) {
            int numero = 0;
            try {
                numero = Integer.parseInt(valor);
                System.out.println("El número convertido es: " + numero);
            } catch (NumberFormatException e) {
                System.out.println("No se puede convertir a entero. Formato no válido.");
            }
            JOptionPane.showMessageDialog(null, "EDITAR PAGO", "Afirmación", JOptionPane.INFORMATION_MESSAGE);
            int id_factura = factura.getIdFacturas();

            try {

                int total_abonado = pfcontroller.calcularSaldoPendiente(id_factura);
                if (numero > total_abonado) {
                    JOptionPane.showMessageDialog(null, "El valor a abonar es mayor al pendiente", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                pfcontroller.editPagosFacturas(id_factura, id_metodo, numero);
                jText_valor.setText("");
                //JOptionPane.showConfirmDialog(null, "Registrado correctamente", "Confirmación", JOptionPane.YES_NO_OPTION);
                JOptionPane.showMessageDialog(null, "Registrado correctamente", "Afirmación", JOptionPane.INFORMATION_MESSAGE);
                actualizar_campos();
                }
            } catch (Exception ex) {
                Logger.getLogger(ModuloIngresoDatos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            if (!valor.equals("")) {

                System.out.println(id_metodo);
                System.out.println(valor);
                Long numero = null;
                try {
                    numero = Long.parseLong(valor);
                    System.out.println("El número convertido es: " + numero);
                } catch (NumberFormatException e) {
                    System.out.println("No se puede convertir a entero. Formato no válido.");
                }

                // Crear un nuevo pago de factura
                Pagos_Facturas nuevoPagoFactura = new Pagos_Facturas();
                // Configura los objetos Facturas, Metodos_de_pago y Usuarios según tus necesidades

                //buscamos la factura
                System.out.println("METODO DE PAGO ES " + id_metodo);
                Metodos_de_pago metodoDePago = controller.getMetodoDePagoById(id_metodo);
                System.out.println(metodoDePago);
                Usuarios usuario = controller_usuario.getUsuarioById(id_usuario);
                System.out.println(usuario);

                nuevoPagoFactura.setFactura(factura);
                nuevoPagoFactura.setMetodoDePago(metodoDePago);
                nuevoPagoFactura.setUsuario(usuario);
                nuevoPagoFactura.setCantidad(numero); // Cantidad de pago
                System.out.println(numero);
                int total_abonado = pfcontroller.calcularSaldoPendiente(id_factura);
                if (numero > total_abonado) {
                    JOptionPane.showMessageDialog(null, "El valor a abonar es mayor al pendiente", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else {

                    pfcontroller.createPagoFactura(nuevoPagoFactura);
                    System.out.println("AQUI VAMOS BIEN");
                    jText_valor.setText("");
                    //JOptionPane.showConfirmDialog(null, "Registrado correctamente", "Confirmación", JOptionPane.YES_NO_OPTION);
                    JOptionPane.showMessageDialog(null, "Registrado correctamente", "Afirmación", JOptionPane.INFORMATION_MESSAGE);
                    actualizar_campos();
                }
            } else {
                JOptionPane.showMessageDialog(null, "ingrese el monto del metodo de pago.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        dispose();

        ModuloDashboard nuevaVentana = new ModuloDashboard();
        nuevaVentana.setVisible(true);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:

//        ModuloDashboard nuevaVentana = new ModuloDashboard();
//        nuevaVentana.setVisible(true);
        String mensaje = "HOLA";
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        actualizar_campos();

//        System.out.println("hola");
//        JButton boton = new JButton("BOTON" + indice) ;
//        Panel.add(boton);
//        botones.add(boton);
//        indice++;
//        Panel.updateUI();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModuloIngresoDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloIngresoDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloIngresoDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloIngresoDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloIngresoDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextNumero;
    private javax.swing.JTextField jTextPrefijo;
    private javax.swing.JTextField jTextValorPendiente;
    private javax.swing.JTextField jTextValorTotal;
    private javax.swing.JTextField jText_valor;
    // End of variables declaration//GEN-END:variables
}
