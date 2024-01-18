/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.modelos;

import java.util.Objects;
import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author carlossamuelmedinapardo
 */
@Embeddable
public class PagosFacturasId implements Serializable {
    private int facturasId; 
    private int metodosDePagoId;

    public PagosFacturasId(int facturasId, int metodosDePagoId) {
        this.facturasId = facturasId;
        this.metodosDePagoId = metodosDePagoId;
    }
    
    public PagosFacturasId() {
    }

    public int getFacturasId() {
        return facturasId;
    }

    public void setFacturasId(int facturasId) {
        this.facturasId = facturasId;
    }

    public int getMetodosDePagoId() {
        return metodosDePagoId;
    }

    public void setMetodosDePagoId(int metodosDePagoId) {
        this.metodosDePagoId = metodosDePagoId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.facturasId);
        hash = 59 * hash + Objects.hashCode(this.metodosDePagoId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PagosFacturasId other = (PagosFacturasId) obj;
        if (!Objects.equals(this.metodosDePagoId, other.metodosDePagoId)) {
            return false;
        }
        
        if (!Objects.equals(this.facturasId, other.facturasId)) {
            return false;
        }
        return true;
    }
    
}