/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import com.cs.cajacs.modelos.Facturas;

/**
 *
 * @author carlossamuelmedinapardo
 */


public class FacturasController {
    private EntityManagerFactory emf;

    public FacturasController() {
        this.emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public void createFactura(Facturas factura) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(factura);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Facturas> getAllFacturas() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("SELECT f FROM Facturas f", Facturas.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Facturas getFacturaById(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Facturas.class, id);
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}
