/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.controllers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import com.cs.cajacs.modelos.Usuarios;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 *
 * @author carlossamuelmedinapardo
 */


public class UsuariosController {
    private EntityManagerFactory emf;

    public UsuariosController() {
        this.emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public List<Usuarios> getAllUsuarios() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Usuarios> query = em.createQuery("SELECT u FROM Usuarios u", Usuarios.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuarios getUsuarioById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }
    
    public void createUsuario(Usuarios usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try {
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
    public void editUsuario(Usuarios usuario) throws Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            Usuarios existingUsuario = em.find(Usuarios.class, usuario.getIdUsuarios());
            if (existingUsuario != null) {

                existingUsuario.setCedula(usuario.getCedula()); 
                existingUsuario.setNombres(usuario.getNombres()); 
                existingUsuario.setApellidos(usuario.getApellidos()); 
                existingUsuario.setCorreo(usuario.getCorreo()); 
                existingUsuario.setPassword(usuario.getPassword()); 

                em.merge(existingUsuario); 
                em.getTransaction().commit();
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
    public void deleteUsuario(int id) throws Exception {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    
    try {
        Usuarios usuario = em.find(Usuarios.class, id);
        if (usuario != null) {
            em.remove(usuario);
            em.getTransaction().commit();
        } else {
            throw new Exception("Usuario no encontrado");
        }
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
