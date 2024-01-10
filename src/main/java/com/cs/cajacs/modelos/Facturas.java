/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 *
 * @author carlossamuelmedinapardo
 */


@Entity
@Table(name = "Facturas")
public class Facturas {
    @Id
    @Column(name = "idFacturas")
    private int idFacturas;

    @Column(name = "Prefijo")
    private String Prefijo;

    @Column(name = "NumFactura")
    private String NumFactura;

    @Column(name = "ValorFactura")
    private Integer ValorFactura;

    @Column(name = "Terminado")
    private Boolean Terminado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaRegistrada")
    private Date fechaRegistrada;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaTerminada")
    private Date fechaTerminada;
    
    @Column(name = "estado", nullable = false)
    private Boolean estado = true;


    public Facturas() {}

    // Getters y Setters
    public int getIdFacturas() {
        return idFacturas;
    }

    public void setIdFacturas(int idFacturas) {
        this.idFacturas = idFacturas;
    }

    public void setFacturasId(int idFacturas) {
        this.idFacturas = idFacturas;
    }
    public String getPrefijo() {
        return Prefijo;
    }

    public void setPrefijo(String Prefijo) {
        this.Prefijo = Prefijo;
    }

    public String getNumFactura() {
        return NumFactura;
    }

    public void setNumFactura(String NumFactura) {
        this.NumFactura = NumFactura;
    }

    public Integer getValorFactura() {
        return ValorFactura;
    }

    public void setValorFactura(Integer ValorFactura) {
        this.ValorFactura = ValorFactura;
    }

    public Boolean getTerminado() {
        return Terminado;
    }

    public void setTerminado(Boolean Terminado) {
        this.Terminado = Terminado;
    }

    public Date getFechaRegistrada() {
        return fechaRegistrada;
    }

    public void setFechaRegistrada(Date fechaRegistrada) {
        this.fechaRegistrada = fechaRegistrada;
    }

    public Date getFechaTerminada() {
        return fechaTerminada;
    }

    public void setFechaTerminada(Date fechaTerminada) {
        this.fechaTerminada = fechaTerminada;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    
    
}

