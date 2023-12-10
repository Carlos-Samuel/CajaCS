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
@Table(name = "Usuarios_has_Permisos")
public class Usuarios_has_Permisos implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "Usuarios_idUsuarios")
    private Usuarios usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "Permisos_idPermisos")
    private Permisos permiso;

    public Usuarios_has_Permisos() {}

    public Usuarios_has_Permisos(Usuarios usuario, Permisos permiso) {
        this.usuario = usuario;
        this.permiso = permiso;
    }

    // Getters y Setters
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Permisos getPermiso() {
        return permiso;
    }

    public void setPermiso(Permisos permiso) {
        this.permiso = permiso;
    }
}
