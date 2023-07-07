/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import static ManejoArchivos.ManejoArchivos.LeerValidando;
import Enums.TipoPerfil;
import java.util.ArrayList;

/**
 *
 * @author sjpin
 */
public class Operador extends Cliente{
    private int sueldo;
    
    /**
     * Constructor que crea objetos de tipo Operador
     * @param cedula
     * @param nombres
     * @param edad
     * @param correo
     * @param usuario
     * @param contrasena
     * @param tipoPerfil
     */
    public Operador(String cedula, String nombres, int edad, String correo, String usuario, String contrasena, TipoPerfil tipoPerfil) {
        super(cedula, nombres, edad, correo, usuario, contrasena, tipoPerfil);
        ArrayList<String[]> datosClientes = LeerValidando("operadores.txt", true);
        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.sueldo = Integer.valueOf(dato[1]);
            }
        }
    }
    
    /**
     * Metodo que retorna en formato int el sueldo del operador
     * @return int
     */
    public int getSueldo() {
        return sueldo;
    }

    /**
     * Metodo set para el sueldo del operador
     * @param sueldo
     */
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    
    public void consultarUsuarios(ArrayList<Usuario> listaUsuarios){
        
    }     

    void consultarReservas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}