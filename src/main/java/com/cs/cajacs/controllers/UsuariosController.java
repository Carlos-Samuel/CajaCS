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
import javax.persistence.NoResultException;
import org.apache.commons.codec.digest.DigestUtils;

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

    public String createUsuario(Usuarios usuario) {
        String mensaje = "";
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Verificar si ya existe un usuario con el mismo correo
            Usuarios usuarioConMismoCorreo = em.createQuery("SELECT u FROM Usuarios u WHERE u.correo = :correo", Usuarios.class)
                    .setParameter("correo", usuario.getCorreo())
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElse(null);

            if (usuarioConMismoCorreo != null) {
                mensaje = "Ya existe un usuario registrado con este correo.";
                em.getTransaction().rollback();
                return mensaje;
            }

            // Verificar si ya existe un usuario con la misma cedula
            Usuarios usuarioConMismaCedula = em.createQuery("SELECT u FROM Usuarios u WHERE u.cedula = :cedula", Usuarios.class)
                    .setParameter("cedula", usuario.getCedula())
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElse(null);

            if (usuarioConMismaCedula != null) {
                mensaje = "Ya existe un usuario registrado con esta cedula.";
                em.getTransaction().rollback();
                return mensaje;
            }

            // Genera hash SHA-256 para la contraseña ingresada
            String claveEncriptada = DigestUtils.sha256Hex(usuario.getPassword());
            usuario.setPassword(claveEncriptada);

            em.persist(usuario);
            mensaje = "Usuario creado correctamente.";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
        return mensaje;
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
                //existingUsuario.setPassword(usuario.getPassword());

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

    public Usuarios login(String correo, String password) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Usuarios> query = em.createQuery(
                    "SELECT u FROM Usuarios u WHERE u.correo = :correo", Usuarios.class);
            query.setParameter("correo", correo);

            try {
                Usuarios usuario = query.getSingleResult();

                String claveEncriptada = DigestUtils.sha256Hex(password);

                if (claveEncriptada.equals(usuario.getPassword())) {
                    return usuario;
                } else {
                    return null; // Contraseña incorrecta
                }
            } catch (NoResultException e) {
                // Usuario no encontrado
                return null;
            }
        } finally {
            em.close();
        }
    }

    public void cambiarContraseña(String correo, String nuevaClave) throws Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            TypedQuery<Usuarios> query = em.createQuery(
                    "SELECT u FROM Usuarios u WHERE u.correo = :correo", Usuarios.class);
            query.setParameter("correo", correo);

            Usuarios usuario = query.getSingleResult();
            
            if (usuario != null) {
                // Genera el hash SHA-256 para la nueva contraseña
                String nuevaClaveEncriptada = DigestUtils.sha256Hex(nuevaClave);
                usuario.setPassword(nuevaClaveEncriptada);
                em.getTransaction().commit();
                System.out.println("Contraseña actualizada correctamente");
            } else {
                throw new Exception("No existe un usuario con el correo ingresado");
            }

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

}
