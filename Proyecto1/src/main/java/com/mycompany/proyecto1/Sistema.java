/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author sjpin
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Sistema {
    private ArrayList<Multa> multas;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Usuario> usuarios; // Lista de usuarios del sistema
    public Sistema(){
        usuarios= cargarUsuarios(); // inicializamos la lista de usuarios cargando los datos desde el archivo
    }
    private ArrayList<Usuario> cargarUsuarios(){
        ArrayList<String> usuario = Utilidades.LeerFichero("usuarios.txt");
        ArrayList<Usuario> usuarioReturn= new ArrayList();
        for (String linea : usuario) {
            String[] datos = linea.split(",");
            /**
             * s es standard
             * o es igual operador
             * e es igual estrella
             */
            if(datos[6].equals("S")){
                ArrayList<String> cliente = Utilidades.LeerFichero("clientes.txt");
                ArrayList<Cliente> clienteReturn= new ArrayList();
                for (String linea1 : cliente) {
                    String[] datos1 = linea1.split(",");
                    if(datos[0].equals(datos1[0])){
                        String nombre = datos[1].split(" ")[0];
                        String apellido = datos[1].split(" ")[1];
                        Cliente clienteADD = new Cliente(datos1[1], 
                                Integer.parseInt(datos1[2]), 
                                datos1[0], 
                                nombre, 
                                apellido, 
                                Integer.parseInt(datos[2]), 
                                datos[3], 
                                datos[4], 
                                datos[5], 
                                TipoPerfil.ESTANDAR);
                    }
                }
            }
            if(datos[6].equals("E")){
                ArrayList<String> cliente = Utilidades.LeerFichero("clientes.txt");
                ArrayList<Cliente> clienteReturn= new ArrayList();
                for (String linea1 : cliente) {
                    String[] datos1 = linea1.split(",");
                    if(datos[0].equals(datos1[0])){
                        String nombre = datos[1].split(" ")[0];
                        String apellido = datos[1].split(" ")[1];
                        Cliente clienteADD = new Cliente(datos1[1], 
                                Integer.parseInt(datos1[2]), 
                                datos1[0], 
                                nombre, 
                                apellido, 
                                Integer.parseInt(datos[2]), 
                                datos[3], 
                                datos[4], 
                                datos[5], 
                                TipoPerfil.ESTRELLA);
                    }
                }
            }
        }
        return usuarioReturn;
    }
    private void cargarVehiculos(){
        
    }
    private void cargarMultas(){
        
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
