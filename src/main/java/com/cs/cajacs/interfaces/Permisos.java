/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cs.cajacs.interfaces;

import com.cs.cajacs.controllers.PermisosController;
import com.cs.cajacs.controllers.UsuariosHasPagosFacturasController;
import com.cs.cajacs.controllers.UsuariosHasPermisosController;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 *
 * @author kuchi
 */
public class Permisos extends javax.swing.JFrame {

    /**
     * Creates new form Permisos
     */
    PermisosController pcontroller = new PermisosController();
    UsuariosHasPermisosController pscontroler = new UsuariosHasPermisosController();

    public Permisos(String id) {
        initComponents();
        List<com.cs.cajacs.modelos.Permisos> listado_permisos = pcontroller.getAllPermisos();
        Font font = new Font("Hecvetica Neue", Font.PLAIN, 24); // Define el tipo de fuente y el tamaño deseado
        int id_entera = Integer.parseInt(id);
        for (int i = 0; i < listado_permisos.size(); i++) {

            System.out.println();
            JCheckBox check = new JCheckBox();
            check.setText(listado_permisos.get(i).getDescripcion());
            check.setFont(font);

            boolean tiene_permiso = pscontroler.verificarPermisoDeUsuario(id_entera, listado_permisos.get(i).getIdPermisos());

            check.setSelected(tiene_permiso);

            Panel.add(check);
            Panel.updateUI();
        }
        this.setLocationRelativeTo(null);
        cerrar();

    }

    public Permisos() {
        initComponents();
        List<com.cs.cajacs.modelos.Permisos> listado_permisos = pcontroller.getAllPermisos();
        Font font = new Font("Hecvetica Neue", Font.PLAIN, 24); // Define el tipo de fuente y el tamaño deseado
        for (int i = 0; i < listado_permisos.size(); i++) {

            System.out.println();
            JCheckBox check = new JCheckBox();
            check.setText(listado_permisos.get(i).getDescripcion());
            check.setFont(font);

            Panel.add(check);
            Panel.updateUI();
        }
        this.setLocationRelativeTo(null);
        cerrar();
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
        VistaUsuarios vista = new VistaUsuarios();
        this.dispose();
        vista.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(Panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Permisos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
