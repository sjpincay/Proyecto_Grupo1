/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author sjpin
 */
import java.util.ArrayList;
public class Sistema {
    private ArrayList<Usuario> usuarios; // Lista de usuarios del sistema
    public Sistema(){
        usuarios= DatosUsuarios.cargarUsuarios(); // inicializamos la lista de usuarios cargando los datos desde el archivo     
    } 
    public void iniciar(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("BIENVENIDO AL SISTEMA");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        boolean loginExitoso= false;
        Usuario usuarioActual= null;
        
        while(!loginExitoso){
            String usuario= Utilidades.solicitarEntrada("USUARIO \n");
            String contraseña= Utilidades.solicitarEntrada("CONTRASEÑA \n");
            
            //validamos el usuario y contraseña ingresados
            for (Usuario usuarioRegistrado: usuarios){
                if (usuarioRegistrado.validarCredenciales(usuario, contraseña)){
                    loginExitoso=true;
                    usuarioActual=usuarioRegistrado;
                    break; 
                }
            }
            usuarioActual.mostrarMenu();
            //todavia falta hacer correciones y agregar mas codigo att sjpincay
    }
}
}
