/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.cs.cajacs.modelos.Permisos;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author carlossamuelmedinapardo
 */


public class PermisosController {
    private EntityManagerFactory emf;

    public PermisosController() {
        this.emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public void createPermiso(Permisos permiso) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(permiso);
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
    
    public List<Permisos> getAllPermisos() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Permisos> query = em.createQuery("SELECT p FROM Permisos p", Permisos.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
