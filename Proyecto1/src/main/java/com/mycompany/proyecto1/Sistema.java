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
import java.util.ArrayList;
import static ManejoArchivos.ManejoArchivos.LeerValidando;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Sistema {
    public static ArrayList<Multa> multas = new ArrayList<>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public static ArrayList<Usuario> usuarios = new ArrayList<>(); // Lista de usuarios del sistema
    public Sistema(){
        cargarMultas();
        cargarVehiculos();
        cargarUsuarios(); // inicializamos la lista de usuarios cargando los datos desde el archivo
        
        
        
    }
    private void cargarUsuarios() {
        
        ArrayList<String[]> usuario= LeerValidando("C:\\Users\\wal26\\OneDrive\\Documentos\\Universidad\\poo\\proyecto\\Proyecto_Grupo1\\Proyecto1\\src\\main\\java\\com\\mycompany\\proyecto1\\usuarios.txt",true);
        Usuario u;
        
        for(String[] dato:usuario){
            switch(dato[6]){
                case "S":
                    u=new Cliente(dato[0],dato[1],Integer.valueOf(dato[2]),dato[3],dato[4],dato[5],TipoPerfil.valueOf(dato[6]));
                    usuarios.add(u);
                    break;
                case "E":
                    
                    u=new Cliente(dato[0],dato[1],Integer.valueOf(dato[2]),dato[3],dato[4],dato[5],TipoPerfil.valueOf(dato[6]));
                    usuarios.add(u);
                    break; 
                    
                case "O":
                    /*
                    u=new Operador(dato[0],dato[1],Integer.valueOf(dato[2]),dato[3],dato[4],dato[5],TipoPerfil.valueOf(dato[6]));
                    usuarios.add(u);
                    break;    
*/
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
        ArrayList<String[]> vehiculo= LeerValidando("C:\\Users\\wal26\\OneDrive\\Documentos\\Universidad\\poo\\proyecto\\Proyecto_Grupo1\\Proyecto1\\src\\main\\java\\com\\mycompany\\proyecto1\\vehiculos.txt",true);
        Vehiculo u;
        
        for(String[] dato:vehiculo){
            u = new Vehiculo(dato[0], dato[1], dato[2], dato[3], dato[4], dato[5], dato[6]);
            vehiculos.add(u);

        }
    }
    private void cargarMultas(){
        ArrayList<String[]> multa= LeerValidando("C:\\Users\\wal26\\OneDrive\\Documentos\\Universidad\\poo\\proyecto\\Proyecto_Grupo1\\Proyecto1\\src\\main\\java\\com\\mycompany\\proyecto1\\multas.txt",true);
        Multa u;
        DateFormat format = new SimpleDateFormat("dd-mm-YYYY");
        Date fecha1 = null;
        Date fecha2 = null;
        for(String[] dato:multa){
            
            try {
                fecha1 = format.parse(dato[4]);
                fecha2 = format.parse(dato[5]);
            } catch (ParseException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            ;
            
            u = new Multa(dato[0], dato[1], dato[2], Double.parseDouble(dato[3]),fecha1, fecha2, Integer.parseInt(dato[6]));
            multas.add(u);

        }
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
        }
        
        
        
        usuarioActual.mostrarMenu();
            //todavia falta hacer correciones y agregar mas codigo att sjpincay
    
}
}
