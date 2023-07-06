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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sistema {
    public static ArrayList<Multa> multas = new ArrayList<>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public static ArrayList<Usuario> usuarios = new ArrayList<>(); // Lista de usuarios del sistema
    
    public static void cargarUsuarios() {
        
        ArrayList<String[]> usuario= LeerValidando("usuarios.txt",true);
        Usuario u;  
        for(String[] dato:usuario){
            switch(dato[6]){
                case "S":
                    u=new Cliente(dato[0],dato[1],Integer.valueOf(dato[2]),dato[3],dato[4],dato[5],TipoPerfil.valueOf(dato[6]));
                    usuarios.add(u);
                    break;
                case "E":
                    
                    u=new ClienteEstrella(dato[0],dato[1],Integer.parseInt(dato[2]),dato[3],dato[4],dato[5],TipoPerfil.valueOf(dato[6]));
                    usuarios.add(u);
                    break; 
                    
                case "O":
                    
                    u=new Operador(dato[0],dato[1],Integer.parseInt(dato[2]),dato[3],dato[4],dato[5],TipoPerfil.valueOf(dato[6]));
                    usuarios.add(u);
                    break;    
            }
        }

    }
    
    public static void mostrarMenuOperador(){
        System.out.println("1. Consultar usuarios\n2. Consultar reservas\n3. Salir");
    }

    /**
     * Metodo que imprime el menu del Cliente
     */
    public static void mostrarMenuCliente(){
        System.out.println("1. Consultar Multas\n2. Agendar Revisión técnica");
    }
    
//    
//    public static void  cargarVehiculos(){
//        ArrayList<String[]> vehiculo= LeerValidando("vehiculos.txt",true);
//        Vehiculo u;
//        
//        for(String[] dato:vehiculo){
//            u = new Vehiculo(dato[0], dato[1], dato[2], dato[3], dato[4], dato[5], dato[6]);
//            vehiculos.add(u);
//
//        }
//    }
//    public static void  cargarMultas(){
//        ArrayList<String[]> multa= LeerValidando("multas.txt",true);
//        Multa u;
//        DateFormat format = new SimpleDateFormat("dd-mm-YYYY");
//        Date fecha1 = null;
//        Date fecha2 = null;
//        for(String[] dato:multa){
//            
//            try {
//                fecha1 = format.parse(dato[4]);
//                fecha2 = format.parse(dato[5]);
//            } catch (ParseException ex) {
//                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            ;
//            
//            u = new Multa(dato[0], dato[1], dato[2], Double.parseDouble(dato[3]),fecha1, fecha2, Integer.parseInt(dato[6]));
//            multas.add(u);
//
//        }
//    }
    public void iniciar(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("BIENVENIDO AL SISTEMA");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        Scanner sc=new Scanner(System.in);
        System.out.print("USUARIO: ");
        String user=sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String password=sc.nextLine();
        
        //CARGANDO LISTAS
        Sistema.cargarUsuarios();
//        Sistema.cargarMultas();
//        Sistema.cargarVehiculos();
            
        //VALIDANDO INFORMACION
        for(Usuario usuario:usuarios){
            if(usuario.getUsuario().equals(user) && usuario.getPassword().equals(password)){
                System.out.println("INGRESO EXITOSO");
                //COMPROBRANDO SI EL USUARIO ES CLIENTE 
                if(usuario instanceof Cliente cliente){
                    //COMPRANDO SI EL CLIENTE ES CLIENTE ESTRELLA
                    if(cliente instanceof ClienteEstrella clienteEstrella){
                        Sistema.mostrarMenuCliente();
                        int opc=0;
                        while(opc!=3){
                            System.out.println("Ingrese opcion: ");
                            opc=sc.nextInt();
                            sc.nextLine();
                            switch(opc){
                                case 1:
                                    clienteEstrella.consultarMultas();
                                    Sistema.mostrarMenuCliente();
                                    break;
                                case 2:
                                    clienteEstrella.consultarReservas();
                                    Sistema.mostrarMenuCliente();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                                    break;
                            }
                        }
                    }else{
                        Sistema.mostrarMenuCliente();
                        int opc=0;
                        while(opc!=3){
                            System.out.println("Ingrese opcion: ");
                            opc=sc.nextInt();
                            sc.nextLine();
                            switch(opc){
                                case 1:
                                    cliente.comprarTickets();
                                    Sistema.mostrarMenuCliente();
                                    break;
                                case 2:
                                    cliente.consultarReservas();
                                    Sistema.mostrarMenuCliente();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                                    break;
                            }
                        }
                    }    
                }
                //COMPROBANDO SI EL USUARIO ES OPERADOR
                if(usuario instanceof Operador operador){
                    Sistema.mostrarMenuOperador();
                    int opc2=0;
                    while(opc2!=3){
                        System.out.println("Ingrese opcion: ");
                        opc2=sc.nextInt();
                        sc.nextLine();
                        switch(opc2){
                            case 1:
                                operador.consultarUsuarios(usuarios);
                                Sistema.mostrarMenuOperador();
                                break;
                            case 2:
                                operador.consultarReservas();
                                Sistema.mostrarMenuOperador();
                                break;
                            case 3:
                                break;    
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }
                    }
                }
            }else if(!usuario.getUsuario().equals(user) && usuario.getPassword().equals(password)){
                System.out.println("Usuario o contraseña incorrectos");
            }    
        }
   } 
}


