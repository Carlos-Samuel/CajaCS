/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cs.cajacs.interfaces;

import com.cs.cajacs.controllers.UsuariosController;
import com.cs.cajacs.modelos.Usuarios;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kuchi
 */
public class Formulario_Usuarios extends javax.swing.JFrame {

    /**
     * Creates new form Formulario_Usuarios
     *
     *
     */
    UsuariosController controller_usuario = new UsuariosController();
    Usuarios usuario_editar = null;

    public Formulario_Usuarios() {
        initComponents();
        cerrar();
        this.setLocationRelativeTo(null);
    }

    public Formulario_Usuarios(String cedula) {
        initComponents();
        int id = Integer.parseInt(cedula);
        usuario_editar = controller_usuario.getUsuarioById(id);

        System.out.println(usuario_editar);

        jTextCedula.setText(usuario_editar.getCedula());
        jTextNombres.setText(usuario_editar.getNombres());
        jTextApellidos.setText(usuario_editar.getApellidos());
        jTextCorreo.setText(usuario_editar.getCorreo());
        cerrar();
        this.setLocationRelativeTo(null);
//         JOptionPane.showMessageDialog(null, cedula, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextApellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPassword1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jPassword2 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTextNombres.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jTextNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombresActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setText("Cedula:");

        jTextCedula.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jTextCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCedulaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel5.setText("Nombres:");

        jTextApellidos.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jTextApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellidosActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel6.setText("Apellidos:");

        jTextCorreo.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jTextCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCorreoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel7.setText("Correo Electronico:");

        jPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassword1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel8.setText("Contraseña:");

        jPassword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassword2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel9.setText("Confirmar Contraseña:");

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Confirmar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 153, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cancelar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(170, 170, 170))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextNombres)
                            .addComponent(jTextCedula)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPassword1)
                            .addComponent(jPassword2)
                            .addComponent(jTextCorreo)
                            .addComponent(jTextApellidos)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(48, 48, 48))
                    .addComponent(jTextApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombresActionPerformed

    private void jTextCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCedulaActionPerformed

    private void jTextApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellidosActionPerformed

    private void jTextCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCorreoActionPerformed

    private void jPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPassword1ActionPerformed

    private void jPassword2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassword2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPassword2ActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:

        String cedula = jTextCedula.getText();
        String nombres = jTextNombres.getText();
        String apellidos = jTextApellidos.getText();
        String correo = jTextCorreo.getText();
        //Contrasegna

        String contra = jPassword1.getText();
        String contra2 = jPassword2.getText();

        if (cedula.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || contra.isEmpty() || contra2.isEmpty()) {
            // Al menos uno de los campos está vacío
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (contra.equals(contra2) && !(contra.equals(""))) {
                Usuarios usuario = new Usuarios();
                usuario.setCedula(cedula);
                usuario.setNombres(nombres);
                usuario.setCorreo(correo);
                usuario.setApellidos(apellidos);
                usuario.setPassword(contra);
                if (usuario_editar == null) {
                    controller_usuario.createUsuario(usuario);
                    System.out.println("USUARIO CREADO CORRECTAMENTE");
                    JOptionPane.showMessageDialog(null, "Usuario creado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        usuario_editar.setCedula(cedula);
                        usuario_editar.setNombres(nombres);
                        usuario_editar.setCorreo(correo);
                        usuario_editar.setApellidos(apellidos);
                        //usuario_editar.setPassword(contra);

                        controller_usuario.editUsuario(usuario_editar);

                    } catch (Exception ex) {
                        Logger.getLogger(Formulario_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                this.dispose();
                VistaUsuarios usuarios_ventana = new VistaUsuarios();
                usuarios_ventana.setVisible(true);
            } else {
                if ((contra.equals(""))) {
                    JOptionPane.showMessageDialog(null, "la contraseña no puede estar vacia.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    System.out.println("Algo salio mal");
                    JOptionPane.showMessageDialog(null, "La contraseña no coincide.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }


    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:

        this.dispose();
        VistaUsuarios vista = new VistaUsuarios();
        vista.setVisible(true);
    }//GEN-LAST:event_jPanel4MouseClicked
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
            java.util.logging.Logger.getLogger(Formulario_Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPassword1;
    private javax.swing.JPasswordField jPassword2;
    private javax.swing.JTextField jTextApellidos;
    private javax.swing.JTextField jTextCedula;
    private javax.swing.JTextField jTextCorreo;
    private javax.swing.JTextField jTextNombres;
    // End of variables declaration//GEN-END:variables
}
