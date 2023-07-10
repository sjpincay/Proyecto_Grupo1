/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import Enums.*;

/**
 * Clase abstracta que representa a un Usuario en el sistema.
 * 
 * Esta clase define los atributos y métodos comunes a todos los usuarios, como la cédula,
 * los nombres, el correo, el usuario, la contraseña, la edad y el tipo de perfil.
 * 
 * El código está documentado internamente con comentarios para una mejor comprensión.
 * 
 */
public abstract class Usuario {

    /**
     * 
     */
    protected String cedula, nombres, correo, usuario, contrasena;
    /**
     * 
     */
    protected int edad;
    /**
     * 
     */
    protected TipoPerfil tipoPerfil;

    /**
     * Constructor para la clase Usuario.
     * 
     * @param cedula La cédula del usuario
     * @param nombres Los nombres del usuario
     * @param edad La edad del usuario
     * @param correo El correo del usuario
     * @param usuario El usuario del usuario
     * @param contrasena La contraseña del usuario
     * @param tipoPerfil El tipo de perfil del usuario
     */
    public Usuario(String cedula, String nombres, int edad, String correo, String usuario, String contrasena,
            TipoPerfil tipoPerfil) {

        this.cedula = cedula;
        this.nombres = nombres;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.edad = edad;
        this.tipoPerfil = tipoPerfil;
    }

    /**
     * Método que devuelve el usuario del Usuario.
     * 
     * @return El usuario del Usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método set para el usuario del Usuario.
     * 
     * @param usuario El usuario a establecer
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que devuelve la cédula del Usuario.
     * 
     * @return La cédula del Usuario
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Método set para la cédula del usuario.
     * 
     * @param cedula La cédula a establecer
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Método que devuelve los nombres del Usuario.
     * 
     * @return Los nombres del Usuario
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método set para los nombres del usuario.
     * 
     * @param nombres Los nombres a establecer
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Método que devuelve la edad del Usuario.
     * 
     * @return La edad del Usuario
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Método set para la edad del usuario.
     * 
     * @param edad La edad a establecer
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Método que devuelve el correo del Usuario.
     * 
     * @return El correo del Usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método set para el correo del usuario.
     * 
     * @param correo El correo a establecer
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método que devuelve la contraseña del Usuario.
     * 
     * @return La contraseña del Usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método set para la contraseña del usuario.
     * 
     * @param contrasena La contraseña a establecer
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Método que devuelve el tipo de perfil del Usuario.
     * 
     * @return El tipo de perfil del Usuario
     */
    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    /**
     * Método set para el tipo de perfil del usuario.
     * 
     * @param tipoPerfil El tipo de perfil a establecer
     */
    public void setTipoCategoria(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    /**
     * Método toString que retorna en formato String la descripción del usuario.
     * 
     * @return La descripción del usuario en formato String
     */
    @Override
    public String toString() {
        return nombres;
    }

    /**
     * Método abstracto que se sobreescribe en Cliente y Operador.
     * 
     * Este método se utiliza para consultar las multas del usuario y debe ser implementado
     * en las subclases Cliente y Operador.
     */
    public abstract void consultarMultas();

}

