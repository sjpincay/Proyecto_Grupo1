/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import Enums.TipoPerfil;
import static ManejoArchivos.ManejoArchivos.LeerValidando;
import java.util.ArrayList;

/**
 *
 * @author sjpin
 */
public class Operador extends Cliente{
    
        private int sueldo;

    
    public Operador(String cedula, String nombres, int edad, String correo, String usuario, String contrasena, TipoPerfil TipoPerfil) {
        super(cedula, nombres, edad, correo, usuario, contrasena, TipoPerfil);
        ArrayList<String[]> datosClientes = LeerValidando("operadores.txt", true);
        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.sueldo = Integer.valueOf(dato[1]);
            }
        }
    }
    
    public void consultarUsuarios(ArrayList<Usuario> listaUsuarios){
        
    }
    
}
