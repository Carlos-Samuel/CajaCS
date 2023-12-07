/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import com.cs.cajacs.modelos.Metodos_de_pago;

/**
 *
 * @author carlossamuelmedinapardo
 */

public class MetodosDePagoController {
    private EntityManagerFactory emf;

    public MetodosDePagoController() {
        this.emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public void createMetodoDePago(Metodos_de_pago metodoDePago) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(metodoDePago);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Metodos_de_pago> getAllMetodosDePago() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("SELECT m FROM Metodos_de_pago m", Metodos_de_pago.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Metodos_de_pago getMetodoDePagoById(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Metodos_de_pago.class, id);
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}

