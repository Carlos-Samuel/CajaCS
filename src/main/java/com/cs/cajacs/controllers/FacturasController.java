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
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Query;

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

    public void anularFactura(int id) throws Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            Facturas factura = em.find(Facturas.class, id);
            if (factura != null) {
                factura.setEstado(false);
                em.merge(factura);
                em.getTransaction().commit();
            } else {
                throw new Exception("No se ha encontrado la factura con ID " + id);
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

    //Espera dos fechas o dos null si no quiere el informe en un rango especifico
    public List<Object[]> getInforme1(Date fechaInicio, Date fechaFin) {
        EntityManager em = emf.createEntityManager();

        try {
            if ((fechaInicio == null && fechaFin != null) || (fechaInicio != null && fechaFin == null)) {
                // Si solo se proporciona una de las dos fechas
                return null;
            }

            String consulta = "SELECT CASE WHEN GROUPING(mp.Descripcion) = 1 THEN 'Total' ELSE mp.Descripcion END AS MetodoDePago, "
                    + "SUM(pf.Cantidad) AS CantidadTotal "
                    + "FROM Metodos_de_pago mp "
                    + "JOIN Pagos_Facturas pf ON mp.idMetodos_de_pago = pf.Metodos_de_pago_idMetodos_de_pago "
                    + "JOIN Facturas f ON pf.Facturas_idFacturas = f.idFacturas ";

            if (fechaInicio != null && fechaFin != null) {
                consulta += "WHERE f.fechaRegistrada BETWEEN :fechaInicio AND :fechaFin ";
            }

            consulta += "GROUP BY mp.Descripcion WITH ROLLUP ";
            Query query = em.createNativeQuery(consulta);

            if (fechaInicio != null && fechaFin != null) {
                query.setParameter("fechaInicio", fechaInicio);
                query.setParameter("fechaFin", fechaFin);
            }

            return query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    //Siempre espera ambas fechas fechas y el medio de pago
    public List<Object[]> getInforme2(String medioPago, Date fechaInicio, Date fechaFin) {
        EntityManager em = emf.createEntityManager();

        try {
            if ((fechaInicio == null || fechaFin == null))  {
                //Si no proporciona alguna fecha
                return null;
            }
            
            String consulta = "SELECT f.fechaRegistrada, f.Prefijo, f.NumFactura, f.ValorFactura, "
                    + "pf.Cantidad FROM Metodos_de_pago mp JOIN Pagos_Facturas pf "
                    + "ON mp.idMetodos_de_pago = pf.Metodos_de_pago_idMetodos_de_pago JOIN Facturas f "
                    + "ON pf.Facturas_idFacturas = f.idFacturas WHERE mp.Descripcion = :medioPago "
                    + "AND f.fechaRegistrada BETWEEN :fechaInicio AND :fechaFin ";

            Query query = em.createNativeQuery(consulta);
            query.setParameter("medioPago", medioPago);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);

            List<Object[]> resultado = query.getResultList();

            if (resultado.isEmpty()) {
                System.out.println("No se encontró información para el medio de pago: " + medioPago);
            }

            return resultado;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

}
