/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.controllers;

import com.cs.cajacs.modelos.Permisos;
import com.cs.cajacs.modelos.Usuarios;
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

    public UsuariosHasPermisosController() {
        this.emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public String createPermisoUsuario(int idUsuario, int idPermiso) {
        String mensaje = "";

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            // Verifica si el usuario y el permiso existen
            Usuarios usuario = em.find(Usuarios.class, idUsuario);
            Permisos permiso = em.find(Permisos.class, idPermiso);

            if (usuario == null || permiso == null) {
                mensaje = "Verifique la existencia del usuario y del permiso a asignar.";
                em.getTransaction().rollback();
            } else {
                em.createNativeQuery("INSERT INTO usuarios_has_permisos (Usuarios_idUsuarios, Permisos_idPermisos) VALUES (?, ?)")
                        .setParameter(1, idUsuario)
                        .setParameter(2, idPermiso)
                        .executeUpdate();

                mensaje = "El permiso fue asignado correctamente.";
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }

        return mensaje;
    }

    public void close() {
        emf.close();
    }

    public boolean verificarPermisoDeUsuario(int idUsuario, int idPermiso) {
        EntityManager em = emf.createEntityManager();
        try {
            Long count = em.createQuery(
                    "SELECT COUNT(uhp) FROM Usuarios_has_Permisos uhp "
                    + "WHERE uhp.usuario.idUsuarios = :idUsuario AND uhp.permiso.idPermisos = :idPermiso", Long.class)
                    .setParameter("idUsuario", idUsuario)
                    .setParameter("idPermiso", idPermiso)
                    .getSingleResult();

            return count > 0;

        } finally {
            em.close();
        }
    }

    public String deleteUsuarioPermiso(int idUsuario, int idPermiso) {
        String mensaje = "";

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.createNativeQuery("DELETE FROM Usuarios_has_Permisos WHERE Usuarios_idUsuarios = ? AND Permisos_idPermisos = ?")
                    .setParameter(1, idUsuario)
                    .setParameter(2, idPermiso)
                    .executeUpdate();

            mensaje = "El permiso fue removido correctamente.";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }

        return mensaje;
    }

}
