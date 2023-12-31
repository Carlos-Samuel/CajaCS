/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.modelos;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author carlossamuelmedinapardo
 */


@Entity
@Table(name = "Pagos_Facturas")
public class Pagos_Facturas implements Serializable{
    
    @EmbeddedId
    private PagosFacturasId id;
    
    @ManyToOne
    @MapsId("facturasId")
    @JoinColumn(name = "Facturas_idFacturas")
    private Facturas factura;

    @ManyToOne
    @MapsId("metodosDePagoId")
    @JoinColumn(name = "Metodos_de_pago_idMetodos_de_pago")
    private Metodos_de_pago metodoDePago;

    @Column(name = "Cantidad")
    private Long Cantidad;

    @ManyToOne
    @JoinColumn(name = "Usuarios_idUsuarios")
    private Usuarios usuario;

    public Pagos_Facturas() {}

    // Getters y Setters
    public Facturas getFactura() {
        return factura;
    }

    public void setFactura(Facturas factura) {
        this.factura = factura;
    }

    public Metodos_de_pago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(Metodos_de_pago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public Long getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Long Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public PagosFacturasId getId() {
        return id;
    }

    public void setId(PagosFacturasId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ", Cantidad=" + Cantidad + ", usuario=" + usuario;
    }
    
    
    
}

