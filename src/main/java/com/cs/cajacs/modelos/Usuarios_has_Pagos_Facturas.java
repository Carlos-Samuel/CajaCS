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

/**
 *
 * @author carlossamuelmedinapardo
 */


@Entity
@Table(name = "Usuarios_has_Pagos_Facturas")
public class Usuarios_has_Pagos_Facturas implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "Usuarios_idUsuarios")
    private Usuarios usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "Pagos_Facturas_Facturas_idFacturas")
    private Facturas factura;

    @Id
    @ManyToOne
    @JoinColumn(name = "Pagos_Facturas_Metodos_de_pago_idMetodos_de_pago")
    private Metodos_de_pago metodoDePago;

    public Usuarios_has_Pagos_Facturas() {}

    // Getters y Setters
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
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
}

