/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import Enums.*;

public abstract class Usuario {

    protected String cedula,nombres,correo,usuario,contrasena;
    protected int edad;
    protected TipoPerfil tipoPerfil;
    
    public Usuario(String cedula, String nombres,int edad, String correo,String usuario, String contrasena, TipoPerfil tipoPerfil){
        
        this.cedula = cedula;
        this.nombres = nombres;
        this.correo = correo;
        this.usuario=usuario;
        this.contrasena = contrasena;
        this.edad = edad;
        this.tipoPerfil = tipoPerfil;
    }

    /**
     * Metodo que devuelve el user del Usuario
     * @return String
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo set para el user del Usuario
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo que devuelve la cedula del Usuario
     * @return String
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Metodo set para la cedula del usuario
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo que devuelve los nombres del Usuario
     * @return String
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Metodo set para los nombres del usuario
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Metodo que devuelve la edad del Usuario
     * @return int
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Metodo set para la edad del usuario
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Metodo que devuelve el correo del Usuario
     * @return String
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo set para el correo del usuario
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo que devuelve la contrasena del Usuario
     * @return String
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Metodo set para la contrasena del usuario
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Metodo que devuelve el tipo de categoria a la que pertenece el usuario
     * @return tipoCategoria (Enum)
     */
    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    /**
     * Metodo set para el tipo Categoria del usuario
     * @param tipoPerfil
     */
    public void setTipoCategoria(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    /**
     * Metodo toString que retorna en formato String la descripcion del usuario
     * @return String
     */
    @Override
    public String toString() {
        return nombres; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    /**
     * Metodo abstracto que se sobreescribe en Cliente y Operador
     */
    public abstract void consultarMultas();

    
    
}

