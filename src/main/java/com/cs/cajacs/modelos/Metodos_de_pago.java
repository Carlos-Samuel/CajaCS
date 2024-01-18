/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs.cajacs.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 *
 * @author carlossamuelmedinapardo
 */


@Entity
@Table(name = "Metodos_de_pago")
public class Metodos_de_pago {
    @Id
    @Column(name = "idMetodos_de_pago")
    private int idMetodos_de_pago;

    @Column(name = "Descripcion")
    private String Descripcion;

    @Column(name = "Cuenta")
    private String Cuenta;

    @Column(name = "Imagen")
    private String Imagen;
    
    @Column(name = "Activo", nullable = false)
    private Boolean Activo = true;

    public Metodos_de_pago() {}

    // Getters y Setters
    public int getIdMetodos_de_pago() {
        return idMetodos_de_pago;
    }

    public void setIdMetodos_de_pago(int idMetodos_de_pago) {
        this.idMetodos_de_pago = idMetodos_de_pago;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCuenta() {
        return Cuenta;
    }

    public void setCuenta(String Cuenta) {
        this.Cuenta = Cuenta;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }
    
     public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean activo) {
        this.Activo = activo;
    }
}
