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


///**
// * Es una clase abstracta la cual servira como apoyo para clase Cliente y Operador
// * @author wal26
// */
//public abstract class Usuario {
//    
//    protected String cedula;
//    protected String nombres;
//    protected int edad;
//    protected String correo;
//    protected String usuario;
//    protected String password;
//    protected TipoPerfil TipoPerfil;
//  
//    
//    /**
//     * Constructor de la clase Usuario
//     * 
//     * @param cedula La cedula del usuario
//     * @param nombres El nombre del usuario 
//     * @param edad La edad del usuario
//     * @param correo El correo del Usuario
//     * @param usuario El nombre de usuario
//     * @param password El password del usuario
//     * @param perfil El tipo de perfil
//     */
//
//    public Usuario(String cedula, String nombres, int edad, String correo, String usuario, String password, TipoPerfil TipoPerfil) {
//        this.cedula = cedula;
//        this.nombres = nombres;
//        this.edad = edad;
//        this.correo = correo;
//        this.usuario = usuario;
//        this.password = password;
//        this.TipoPerfil = TipoPerfil;
//    }
//
//    /**
//     * Metodo encargado de mostrar el menu del usuario
//     */
//    public abstract void mostrarMenu();
//    
//    
//    /**
//     * Metodo encargado de msotrar las multas de los usuarios
//     */
//    public abstract void consultar_multas();
//    
//    
//    /**
//     * Metodo que permite validar credenciales para el registro
//     * 
//     * @param usuario usuario del cliente u operador
//     * @param password password del usuario
//     * @return true si las credenciales son iguales, false caso constrario
//     */
//    public boolean validarCredenciales(String usuario, String password){
//        if(usuario.equals(this.usuario) && password.equals(this.password)){
//            return true;
//        }
//        return false;
//    }
//    
//    /**
//     * Obtiene el numero de cedula del usuario
//     * 
//     * @return El numero de  cedula
//     */
//    public String getCedula() {
//        return cedula;
//    }
//
//    /**
//     * Modifica el atributo cedula del usuario
//     * @param cedula El numero de cedula
//     */
//    public void setCedula(String cedula) {
//        this.cedula = cedula;
//    }
//
//    /**
//     * Permite obtener el nombre del usuario
//     * @return Nombre Usuario
//     */
//    public String getNombres() {
//        return nombres;
//    }
//
//    /**
//     * Modifica el atributo del nombre del usuario
//     * @param nombres El nombre de usuario
//     */
//    public void setNombres(String nombres) {
//        this.nombres = nombres;
//    }
//
//    
//
//    
//    /**
//     * Permite obtener la edad del usuario
//     * @return Edad del usuario
//     */
//    public int getEdad() {
//        return edad;
//    }
//
//    
//    /**
//     * Modifica el atributo de la edad del usuario
//     * @param edad Edad del usuario
//     */
//    public void setEdad(int edad) {
//        this.edad = edad;
//    }
//
//    
//    /**
//     * Obtiene el correo del usuario
//     * @return Correo del usuario
//     */
//    public String getCorreo() {
//        return correo;
//    }
//
//    /**
//     * Permite modificar el atributo del correo del usuario
//     * @param correo Correo del usuario
//     */
//    public void setCorreo(String correo) {
//        this.correo = correo;
//    }
//
//    /**
//     * Obtiene el nombre de usuario 
//     * @return Nombre del archivo
//     */
//    public String getUsuario() {
//        return usuario;
//    }
//
//    
//    /**
//     * Permite modificar el nombre usuario
//     * @param usuario nombre de usuario
//     */
//    public void setUsuario(String usuario) {
//        this.usuario = usuario;
//    }
//
//    /**
//     * Permite obtener el password del usuario
//     * @return password del usuario
//     */
//    public String getPassword() {
//        return password;
//    }
//
//    /**
//     * Modifica el atributo del password
//     * @param password passwrod del usuario
//     */
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    /**
//     * Obtienes el perfil del usuario
//     * @return 
//     */
//    public TipoPerfil getPerfil() {
//        return TipoPerfil;
//    }
//
//    /**
//     * Modifica el perfil del usuario 
//     * @param perfil perfil del usuario
//     */
//    public void setPerfil(TipoPerfil TipoPerfil) {
//        this.TipoPerfil = TipoPerfil;
//    }
//    
//    
//    
//}
