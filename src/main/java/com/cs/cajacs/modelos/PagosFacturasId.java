/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Embeddable;

/**
 *
 * @author carlossamuelmedinapardo
 */
@Embeddable
public class PagosFacturasId implements Serializable {
    private Long facturasId; 
    private Long metodosDePagoId;

    public PagosFacturasId(Long facturasId, Long metodosDePagoId) {
        this.facturasId = facturasId;
        this.metodosDePagoId = metodosDePagoId;
    }
    
    public PagosFacturasId() {
    }

    public Long getFacturasId() {
        return facturasId;
    }

    public void setFacturasId(Long facturasId) {
        this.facturasId = facturasId;
    }

    public Long getMetodosDePagoId() {
        return metodosDePagoId;
    }

    public void setMetodosDePagoId(Long metodosDePagoId) {
        this.metodosDePagoId = metodosDePagoId;
    }

}