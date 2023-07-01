/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 * Es una clase abstracta la cual servira como apoyo para clase Cliente y Operador
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
    
    /**
     * Constructor de la clase Usuario
     * 
     * @param cedula La cedula del usuario
     * @param nombres El nombre del usuario 
     * @param apellidos El Apellido del usuario
     * @param edad La edad del usuario
     * @param correo El correo del Usuario
     * @param usuario El nombre de usuario
     * @param password El password del usuario
     * @param perfil El tipo de perfil
     */

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

    /**
     * Metodo encargado de mostrar el menu del usuario
     */
    public abstract void mostrarMenu();
    
    
    /**
     * Metodo encargado de msotrar las multas de los usuarios
     */
    public abstract void consultar_multas();
    
    
    /**
     * Metodo que permite validar credenciales para el registro
     * 
     * @param usuario usuario del cliente u operador
     * @param password password del usuario
     * @return true si las credenciales son iguales, false caso constrario
     */
    public boolean validarCredenciales(String usuario, String password){
        if(usuario.equals(this.usuario) && password.equals(this.password)){
            return true;
        }
        return false;
    }
    
    /**
     * Obtiene el numero de cedula del usuario
     * 
     * @return El numero de  cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Modifica el atributo cedula del usuario
     * @param cedula El numero de cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Permite obtener el nombre del usuario
     * @return Nombre Usuario
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Modifica el atributo del nombre del usuario
     * @param nombres El nombre de usuario
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Permite obtener el apellido del usuario
     * @return Apellido del usuario
     */
    public String getApellidos() {
        return apellidos;
    }

    
    /**
     * Modifica el atributo del apellido del usuario
     * @param apellidos El apellido del usuario
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    /**
     * Permite obtener la edad del usuario
     * @return Edad del usuario
     */
    public int getEdad() {
        return edad;
    }

    
    /**
     * Modifica el atributo de la edad del usuario
     * @param edad Edad del usuario
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    /**
     * Obtiene el correo del usuario
     * @return Correo del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Permite modificar el atributo del correo del usuario
     * @param correo Correo del usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el nombre de usuario 
     * @return Nombre del archivo
     */
    public String getUsuario() {
        return usuario;
    }

    
    /**
     * Permite modificar el nombre usuario
     * @param usuario nombre de usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Permite obtener el password del usuario
     * @return password del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Modifica el atributo del password
     * @param password passwrod del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtienes el perfil del usuario
     * @return 
     */
    public TipoPerfil getPerfil() {
        return perfil;
    }

    /**
     * Modifica el perfil del usuario 
     * @param perfil perfil del usuario
     */
    public void setPerfil(TipoPerfil perfil) {
        this.perfil = perfil;
    }
    
    
    
}
