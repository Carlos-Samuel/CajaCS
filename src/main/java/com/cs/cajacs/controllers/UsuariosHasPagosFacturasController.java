/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.cs.cajacs.modelos.Usuarios_has_Pagos_Facturas;

/**
 *
 * @author carlossamuelmedinapardo
 */

public class UsuariosHasPagosFacturasController {
    private EntityManagerFactory emf;

    public UsuariosHasPagosFacturasController() {
        this.emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public void createUsuarioPagoFactura(Usuarios_has_Pagos_Facturas usuarioPagoFactura) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(usuarioPagoFactura);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}
