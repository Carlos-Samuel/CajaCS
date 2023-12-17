/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import com.cs.cajacs.modelos.Pagos_Facturas;

import com.cs.cajacs.modelos.Pagos_Facturas;

/**
 *
 * @author carlossamuelmedinapardo
 */


public class PagosFacturasController {
    private EntityManagerFactory emf;

    public PagosFacturasController() {
        this.emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public void createPagoFactura(Pagos_Facturas pagoFactura) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(pagoFactura);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    //Esto no esta funcionando
    public List<Pagos_Facturas> obtenerPagosPorFacturaId(Integer facturaId) {
        EntityManager em = emf.createEntityManager();
        List<Pagos_Facturas> resultados = null;
        try {
            TypedQuery<Pagos_Facturas> query = em.createQuery(
                    "SELECT pf FROM Pagos_Facturas pf WHERE pf.factura.id = :facturaId", Pagos_Facturas.class);
            query.setParameter("facturaId", facturaId);
            resultados = query.getResultList();
        } finally {
            em.close();
        }
        return resultados;
    }

    public Integer obtenerAbonadoFacturaId(Integer facturaId) {
        EntityManager em = emf.createEntityManager();
        Long sumaTotal = 0L;
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT SUM(pf.Cantidad) FROM Pagos_Facturas pf WHERE pf.factura.id = :facturaId", Long.class);
            query.setParameter("facturaId", facturaId);

            sumaTotal = query.getSingleResult();

            if (sumaTotal == null) {
                sumaTotal = 0L;
            }
        } finally {
            em.close();
        }
        return sumaTotal.intValue();
    }
    
    public Integer calcularSaldoPendiente(Integer facturaId) {
    EntityManager em = emf.createEntityManager();
    Integer valorFactura = 0;
    Integer valorAbonado = 0;
    Integer saldoPendiente = 0;

    try {
        TypedQuery<Integer> queryValorFactura = em.createQuery(
                "SELECT f.ValorFactura FROM Facturas f WHERE f.id = :idFacturas", Integer.class);
        queryValorFactura.setParameter("idFacturas", facturaId);
        valorFactura = queryValorFactura.getSingleResult();

        if (valorFactura == null) {
            valorFactura = 0;
        }

        valorAbonado = obtenerAbonadoFacturaId(facturaId);

        saldoPendiente = valorFactura - valorAbonado;

    } finally {
        em.close();
    }
    return saldoPendiente;
}

    
    public void close() {
        emf.close();
    }
}
