/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.cs.cajacs.modelos.Usuarios_has_Permisos;

/**
 *
 * @author carlossamuelmedinapardo
 */
public class UsuariosHasPermisosController {
    private EntityManagerFactory emf;

    public UsuariosHasPermisosController(String persistenceUnitName) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void createUsuarioPermiso(Usuarios_has_Permisos usuarioPermiso) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(usuarioPermiso);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // Otras operaciones según tus necesidades

    public void close() {
        emf.close();
    }
}
