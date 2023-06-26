/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author wal26
 */
public abstract class Usuario {
    
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected int edad;
    protected String correo;
    protected String usuario;
    protected String password;
    protected TipoPerfil perfil;

    public Usuario(String cedula, String nombres, String apellidos, int edad, String correo, String usuario, String password, TipoPerfil perfil) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
        this.usuario = usuario;
        this.password = password;
        this.perfil = perfil;
    }

    public abstract void consultar_multas();
    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(TipoPerfil perfil) {
        this.perfil = perfil;
    }
    
    
    
}
