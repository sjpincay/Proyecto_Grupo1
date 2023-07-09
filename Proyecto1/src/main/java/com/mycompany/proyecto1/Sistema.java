/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;
/**
 *
 * @author sjpin
 */
import static ManejoArchivos.ManejoArchivos.LeerValidando;
import Enums.TipoPerfil;
import ManejoArchivos.ManejoArchivos;
import static java.lang.String.format;
import java.text.DateFormat;
import static java.text.MessageFormat.format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Sistema {
    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    static ArrayList<Multa> listaMultlas=new ArrayList<>();
    static ArrayList<Vehiculo> listaVehiculoss=new ArrayList<>();
    static ArrayList<Date> horarios = new ArrayList<>();
    static ArrayList<Revision> revisiones = new ArrayList<>();

    /**
     * Metodo que imprime el menu del Operador
     */
    public static void mostrarMenuOperador() {
        System.out.println("1. Registar pagos\n2. Consultar multas clientes\n3. Consultar usuarios");
    }

    /**
     * Metodo que imprime el menu del Cliente
     */
    public static void mostrarMenuCliente() {
        System.out.println("1. Consultar Multas\n2. Agendar Revisión técnica");
    }

    /**
     * Metodo que lee el archivo Usuarios y crea los objetos de los mismos para
     * agregarlos a la lista de Usuarios
     */
    public static void cargarUsuarios() {
        ArrayList<String[]> datosUsuarios = LeerValidando("usuarios.txt", true);
        Usuario u;
        for (String[] dato : datosUsuarios) {
            switch (dato[6]) {
                case "S" -> {
                    u = new Cliente(dato[0], dato[1], Integer.parseInt(dato[2]), dato[3], dato[4], dato[5], TipoPerfil.valueOf(dato[6]));
                    listaUsuarios.add(u);
                    break;
                }
                case "E" -> {
                    u = new ClienteEstrella(dato[0], dato[1], Integer.parseInt(dato[2]), dato[3], dato[4], dato[5], TipoPerfil.valueOf(dato[6]));
                    listaUsuarios.add(u);
                    break;
                }
                case "O" -> {
                    u = new Operador(dato[0], dato[1], Integer.parseInt(dato[2]), dato[3], dato[4], dato[5], TipoPerfil.valueOf(dato[6]));
                    listaUsuarios.add(u);
                }
            }
        }

    }
    
    
    public static void cargarMultas(){
        ArrayList <String[]> datosMultas = LeerValidando("multas.txt", true);
        Multa m;
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1=null;
        Date fecha2=null;
        for(String[] dato:datosMultas){
            
            try {
                fecha1 = format.parse(dato[4]);
                fecha2 = format.parse(dato[5]);
               
            } catch (ParseException ex){
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            m= new Multa(dato[0],dato[1],dato[2],Double.valueOf(dato[3]), fecha1,fecha2,Integer.parseInt(dato[6]));
            listaMultlas.add(m);
        }
    }
    
    
    public static void cargarVehiculos(){
        ArrayList<String[]> vehiculo= LeerValidando("vehiculos.txt",true);
        
        Vehiculo v;
        
        for(String[] dato:vehiculo){
            v = new Vehiculo(dato[0], dato[1], dato[2], dato[3], dato[4], dato[5], dato[6]);
            listaVehiculoss.add(v);

        }
    }
    
    public static void createRevision(Revision revision){
        revisiones.add(revision);
        ManejoArchivos.EscribirArchivo("revisiones.txt", revision.toString());
    }
    
    /**
     * Metodo que carga los horarios de revisiones y lo guarda en la 
     * variable estatica horarios, dicha variable es de tipo Date
     */
    public static void cargarHorarios(){
        ArrayList<String> horars= ManejoArchivos.LeerArchivo("horarios.txt");
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        
        for(String horario: horars){
            try {
                horarios.add(format.parse(horario));
            } catch (ParseException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /**
     * Carga las revisiones que se han creado
     */
    
    public static void cargarRevisiones(){
        ArrayList<String[]> revisionesTotales= ManejoArchivos.LeerValidando("revisiones.txt", true);
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date fecha = null;
        for(String[] revision: revisionesTotales){
            try {
                fecha = format.parse(revision[3]);
            } catch (ParseException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
           revisiones.add(new Revision(Integer.parseInt(revision[0]), revision[1], revision[2], fecha));
        }
    }

    public static void removeHorarario(Date horario){
        //el arrayList de horarios es paralelo al fichero
        
    }
    public static void main(String[] args) {
        //INICIO DE SESION
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("BIENVENIDO AL SISTEMA");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        Scanner sc = new Scanner(System.in);
        System.out.print("USUARIO: ");
        String user = sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String password = sc.nextLine();

        //CARGANDO LISTAS
        Sistema.cargarMultas();
        Sistema.cargarVehiculos();
        Sistema.cargarUsuarios();
        Sistema.cargarHorarios();
        Sistema.cargarRevisiones();

        //VALIDANDO INFORMACION
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsuario().equals(user) && usuario.getContrasena().equals(password)) {
                System.out.println("INGRESO EXITOSO");
                //COMPROBRANDO SI EL USUARIO ES CLIENTE 
                if (usuario instanceof Cliente cliente) {
                    //COMPRANDO SI EL CLIENTE ES CLIENTE ESTRELLA
                    if (cliente instanceof ClienteEstrella clienteEstrella) {
                        Sistema.mostrarMenuCliente();
                        int opc = 0;
                        while (opc != 3) {
                            System.out.println("Ingrese opcion: ");
                            opc = sc.nextInt();
                            sc.nextLine();
                            switch (opc) {
                                case 1 -> {
                                    clienteEstrella.consultarMultas();
                                    Sistema.mostrarMenuCliente();
                                }
                                case 2 -> {
                                    clienteEstrella.agendarRevisionTecnica();
                                    Sistema.mostrarMenuCliente();
                                }
                                case 3 -> {
                                }
                                default -> System.out.println("Opcion invalida");
                            }
                        }
                    } else {
                        Sistema.mostrarMenuCliente();
                        int opc = 0;
                        while (opc != 3) {
                            System.out.println("Ingrese opcion: ");
                            opc = sc.nextInt();
                            sc.nextLine();
                            switch (opc) {
                                case 1 -> {
                                    cliente.consultarMultas();
                                    Sistema.mostrarMenuCliente();
                                }
                                case 2 -> {
                                    cliente.agendarRevisionTecnica();
                                    Sistema.mostrarMenuCliente();
                                }
                                case 3 -> {
                                }
                                default -> System.out.println("Opcion invalida");
                            }
                        }
                    }
                }
                //COMPROBANDO SI EL USUARIO ES OPERADOR
                if (usuario instanceof Operador operador) {
                    Sistema.mostrarMenuOperador();
                    int opc2 = 0;
                    while (opc2 != 3) {
                        System.out.println("Ingrese opcion: ");
                        opc2 = sc.nextInt();
                        sc.nextLine();
                        switch (opc2) {
                            case 1 -> {
                                operador.consultarUsuarios(listaUsuarios);
                                Sistema.mostrarMenuOperador();
                            }
                            case 2 -> {
                                operador.consultarReservas();
                                Sistema.mostrarMenuOperador();
                            }
                            case 3 -> {
                            }
                            default -> System.out.println("Opcion invalida");
                        }
                    }
                }
            } else if (!usuario.getUsuario().equals(user) && usuario.getContrasena().equals(password)) {
                System.out.println("Usuario o contraseña incorrectos");
            }
        }
    }

    void iniciar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
