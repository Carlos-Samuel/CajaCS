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
public class Pagos_Facturas implements Serializable {

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
    private Long cantidad;

    @ManyToOne
    @JoinColumn(name = "Usuarios_idUsuarios")
    private Usuarios usuario;

    public Pagos_Facturas() {
    }

    public Pagos_Facturas(PagosFacturasId id, Facturas factura, Metodos_de_pago metodoDePago, Long cantidad, Usuarios usuario) {
        this.id = id;
        this.factura = factura;
        this.metodoDePago = metodoDePago;
        this.cantidad = cantidad;
        this.usuario = usuario;
    }

    public PagosFacturasId getId() {
        return id;
    }

    public void setId(PagosFacturasId id) {
        this.id = id;
    }

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
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    

    @Override
    public String toString() {
        return "Pagos_Facturas{" +
               "id=" + id +
               ", facturaId=" + (factura != null ? factura.getIdFacturas() : "null") +
               ", metodoDePagoId=" + (metodoDePago != null ? metodoDePago.getIdMetodos_de_pago() : "null") +
               ", cantidad=" + cantidad +
               ", usuarioId=" + (usuario != null ? usuario.getIdUsuarios() : "null") +
               '}';
    }

}


