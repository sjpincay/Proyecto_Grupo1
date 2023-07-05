/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author sjpin
 */
import Enums.TipoPerfil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import static ManejoArchivos.ManejoArchivos.LeerValidando;
public class Sistema {
    private ArrayList<Multa> multas;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Usuario> usuarios; // Lista de usuarios del sistema
    public Sistema(){
        usuarios= cargarUsuarios(); // inicializamos la lista de usuarios cargando los datos desde el archivo
    }
    private ArrayList<Usuario> cargarUsuarios() {
        
        ArrayList<String[]> usuario= LeerValidando("usuarios.txt",true);
        Usuario u;
        
        for(String[] dato:usuario){
            switch(dato[6]){
                case "S":
                    u=new Cliente(dato[0],dato[1],Integer.valueOf(dato[2]),dato[3],dato[4],dato[5],TipoPerfil.valueOf(dato[6]));
                    usuarios.add(u);
                    break;
                case "E":
                    u=new ClienteVip(dato[0],dato[1],Integer.valueOf(dato[2]),dato[3],dato[4],dato[5],TipoPerfil.valueOf(dato[6]));
                    usuarios.add(u);
                    break; 
                case "O":
                    u=new Operador(dato[0],dato[1],Integer.valueOf(dato[2]),dato[3],dato[4],dato[5],TipoPerfil.valueOf(dato[6]));
                    usuarios.add(u);
                    break;    
            }
        }
//    ArrayList<String> usuarios = Utilidades.LeerFichero("usuarios.txt");
//    ArrayList<Usuario> usuarioReturn = new ArrayList<>();
//
//    for (String linea : usuarios) {
//        String[] datos = linea.split(",");
//        Usuario usuario;
        
        
        
        
//        if (datos[6].equals("S")) {
//            ArrayList<String> clientes = Utilidades.LeerFichero("clientes.txt");
//
//            for (String linea1 : clientes) {
//                String[] datos1 = linea1.split(",");
//                if (datos[0].equals(datos1[0])) {
//                    String nombre = datos[1].split(" ")[0];
//                    String apellido = datos[1].split(" ")[1];
//
//                    Cliente cliente = new Cliente(
//                            datos1[1],
//                            Integer.parseInt(datos1[2]),
//                            datos1[0],
//                            nombre,
//                            apellido,
//                            Integer.parseInt(datos[2]),
//                            datos[3],
//                            datos[4],
//                            datos[5],
//                            TipoPerfil.ESTANDAR
//                    );
//
//                    usuario = cliente;
//                    break;
//                }
//            }
//        } else if (datos[6].equals("E")) {
//            ArrayList<String> clientes = Utilidades.LeerFichero("clientes.txt");
//
//            for (String linea1 : clientes) {
//                String[] datos1 = linea1.split(",");
//                if (datos[0].equals(datos1[0])) {
//                    String nombre = datos[1].split(" ")[0];
//                    String apellido = datos[1].split(" ")[1];
//
//                    Cliente cliente = new Cliente(
//                            datos1[1],
//                            Integer.parseInt(datos1[2]),
//                            datos1[0],
//                            nombre,
//                            apellido,
//                            Integer.parseInt(datos[2]),
//                            datos[3],
//                            datos[4],
//                            datos[5],
//                            TipoPerfil.ESTRELLA
//                    );
//
//                    usuario = cliente;
//                    break;
//                }
//            }
//        } else {
//            // Aquí puedes agregar otro tipo de usuario si es necesario
//            usuario = new Usuario(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5],datos[6] ) {};
//        }
//
//        usuarioReturn.add(usuario);
//    }
//
//    return usuarioReturn;
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
