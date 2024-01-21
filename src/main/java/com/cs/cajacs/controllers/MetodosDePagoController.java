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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;

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

    public String getImagenMetodoDePago(int idMedioPago) {
        EntityManager em = emf.createEntityManager();

        try {
            Metodos_de_pago medioPago = em.find(Metodos_de_pago.class, idMedioPago);

            if (medioPago != null) {
                return medioPago.getImagen();
            } else {
                return "No se encontró ninguna imagen para el medio de pago con ID " + idMedioPago;
            }
        } finally {
            em.close();
        }
    }

    public void editMetodoDePago(Metodos_de_pago metodo) throws Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            Metodos_de_pago existingMetodo = em.find(Metodos_de_pago.class, metodo.getIdMetodos_de_pago());
            if (existingMetodo != null) {

                existingMetodo.setDescripcion(metodo.getDescripcion());
                existingMetodo.setCuenta(metodo.getCuenta());
                existingMetodo.setImagen(metodo.getImagen());

                em.merge(existingMetodo);
                em.getTransaction().commit();

                System.out.println("Metodo de pago actualizado exitosamente");
            } else {
                throw new Exception("Metodo de pago no encontrado");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void desactivarMetodoDePago(int id) throws Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            Metodos_de_pago metodo = em.find(Metodos_de_pago.class, id);
            if (metodo != null) {
                metodo.setActivo(false);
                em.merge(metodo);
                em.getTransaction().commit();
            } else {
                throw new Exception("No se ha encontrado el metodo de pago con ID " + id);
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public String guardarImagenMetodoDePago(File inputFile) {
        try {
            // Ruta del directorio actual del proyecto
            String directorioProyecto = System.getProperty("user.dir");

            String nombreImagen = generarNombreUnico();
            String extension = obtenerExtension(inputFile);
            String nombreCompleto = nombreImagen + "." + extension;

            // Crea la ruta de destino dentro del directorio del proyecto
            String rutaDestino = directorioProyecto + File.separator + "ImagenesMedioDePago" + File.separator + nombreImagen + "." + extension;

            // Crea la carpeta de destino si no existe
            File carpetaDestino = new File(directorioProyecto + File.separator + "ImagenesMedioDePago");
            if (!carpetaDestino.exists()) {
                carpetaDestino.mkdirs();
            }

            // Verifica si el archivo de entrada existe
            if (inputFile.exists()) {
                // Copia el archivo a la carpeta de destino
                Path destino = Path.of(rutaDestino);
                Files.copy(inputFile.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Archivo guardado en: " + destino);
                return nombreCompleto;
            } else {
                throw new IOException("El archivo de entrada no existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String obtenerExtension(File file) {
        String nombreArchivo = file.getName();
        int ultimoPunto = nombreArchivo.lastIndexOf(".");
        if (ultimoPunto != -1) {
            return nombreArchivo.substring(ultimoPunto + 1);
        } else {
            return "";
        }
    }

    private String generarNombreUnico() {
        Date fechaHoraActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaHoraFormateada = formatoFecha.format(fechaHoraActual);

        // Genera hash SHA-256 utilizando Apache Commons Codec
        return DigestUtils.sha256Hex(fechaHoraFormateada);
    }

    public String editarImagenMetodoDePago(String nombreArchivoActual, File nuevoArchivo) {
        try {
            // Ruta del directorio actual del proyecto
            String directorioProyecto = System.getProperty("user.dir");

            // Ruta completa del archivo actual
            String rutaArchivoActual = directorioProyecto + File.separator + "ImagenesMedioDePago" + File.separator + nombreArchivoActual;

            // Verifica si el archivo actual existe
            File archivoActual = new File(rutaArchivoActual);
            if (archivoActual.exists()) {
                // Obtiene el nombre y la extensión del nuevo archivo
                String nombreNuevo = generarNombreUnico();
                String extensionNuevo = obtenerExtension(nuevoArchivo);
                String nombreCompletoNuevo = nombreNuevo + "." + extensionNuevo;

                // Ruta completa del nuevo archivo
                String rutaNuevoArchivo = directorioProyecto + File.separator + "ImagenesMedioDePago" + File.separator + nombreCompletoNuevo;

                // Copia el contenido del nuevo archivo al archivo actual
                Files.copy(nuevoArchivo.toPath(), Path.of(rutaNuevoArchivo), StandardCopyOption.REPLACE_EXISTING);

                // Elimina el archivo anterior
                Files.deleteIfExists(archivoActual.toPath());

                System.out.println("Archivo editado. Nuevo nombre: " + nombreCompletoNuevo);
                return nombreCompletoNuevo;
            } else {
                throw new IOException("No es posible editar la imagen porque no existe en la ubicación especificada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
