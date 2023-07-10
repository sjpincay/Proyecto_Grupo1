/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import static ManejoArchivos.ManejoArchivos.LeerValidando;
import Enums.TipoPerfil;
import ManejoArchivos.ManejoArchivos;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase principal, en esta clase se encontrara el metodo main y es el nucleo del programa
 * Ademas es la unica clase que interaccionara directamente con los ficheros
 * Dispone de metodos estaticos para leer, escribir y borrar datos de los ficheros depenediendo de lo que se hara
 * ninguna otra clase tiene los derechos de proder interactuar con los ficheros
 * se lo realiza de esta forma para tener una estructura mas organizada tratando de simular una base de datos 
 * y servidor que puede obtener estos datos y enviarle a algun programa que los trate para mostrarlo
 * 
 * @author sjpin
 */
public class Sistema {
    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    static ArrayList<Multa> listaMultlas=new ArrayList<>();
    static ArrayList<Vehiculo> listaVehiculoss=new ArrayList<>();
    static ArrayList<Date> horarios = new ArrayList<>();
    static ArrayList<Revision> revisiones = new ArrayList<>();
    static java.util.ArrayList<Vehiculo> listaVehiculos;

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
        // Código para leer el archivo "usuarios.txt" y crear objetos de Usuario
        // basado en los datos leídos. Luego, los objetos se agregan a la lista de Usuarios.
        ArrayList<String[]> datosUsuarios = LeerValidando("usuarios.txt", false);
        for (String[] dato : datosUsuarios) {
            switch (dato[6]) {
                case "S" -> {
                    listaUsuarios.add(new Cliente(dato[0], dato[1], Integer.parseInt(dato[2]), dato[3], dato[4], dato[5], TipoPerfil.valueOf(dato[6])));
                    
                    break;
                }
                case "E" -> {
                    listaUsuarios.add(new ClienteEstrella(dato[0], dato[1], Integer.parseInt(dato[2]), dato[3], dato[4], dato[5], TipoPerfil.valueOf(dato[6])));
                    break;
                }
                case "O" -> {
                    
                    listaUsuarios.add(new Operador(dato[0], dato[1], Integer.parseInt(dato[2]), dato[3], dato[4], dato[5], TipoPerfil.valueOf(dato[6])));
                    
                }
            }
        }

    }
    /**
     * Interactuando con el archivo multas.txt para poder obtener la informacion
     * y ponerla a disposicion al sistema
     */

    public static void cargarMultas() {
        // Código para leer el archivo "multas.txt" y obtener la información.
        // Luego, se crea objetos de la clase Multa basados en los datos leídos
        // y se agregan a la lista de Multas (listaMultlas)
        java.util.ArrayList <String[]> datosMultas = LeerValidando("multas.txt", true);
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
    
    /**
     * Interactuando con el archivo vehiculos.txt para poder obtener la informacion
     * y ponerla a disposicion al sistema
     */

    public static void cargarVehiculos() {
        // Código para leer el archivo "vehiculos.txt" y obtener la información.
        // Luego, se crean objetos de la clase Vehiculo basados en los datos leídos
        // y se agregan a la lista de Vehiculos (listaVehiculoss)
        ArrayList<String[]> vehiculo= LeerValidando("vehiculos.txt",false);
        
        Vehiculo v;
        
        for(String[] dato:vehiculo){
            v = new Vehiculo(dato[0], dato[1], dato[2], dato[3], dato[4], dato[5], dato[6]);
            listaVehiculoss.add(v);

        }
    }
    /**
     * Metodo que permite registrar la revision en el fichero
     * @param revision Revision que se desea guardar
     */
    public static void createRevision(Revision revision) {
        // Código para registrar la revisión en un archivo y guardar la información.
        revisiones.add(revision);
        ManejoArchivos.EscribirArchivo("revisiones.txt", revision.toString());
    }
     /**
     * Metodo que carga los horarios de revisiones y los guarda en la
     * variable estática horarios, la cual es de tipo Date.
     */
    public static void cargarHorarios() {
        // Código para leer el archivo "horarios.txt" y obtener los horarios de revisión.
        // Luego, se almacenan en la variable estática "horarios" como objetos Date.
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
     * 
     * @param pago El pago que se realizo
     */
        public static void createPago(Pago pago) {
        // Código para crear un pago y guardar la información en un archivo.
    }
        
    /**
     * Interactúa con el archivo revisiones.txt para obtener la información
     * y ponerla a disposición del sistema para su posterior uso.
     */
    
    public static void cargarRevisiones(){
        

        // Código para leer el archivo "revisiones.txt" y obtener la información.
        // Luego, se crean objetos de la clase Revision basados en los datos leídos
        // y se agregan a la lista de Revisiones (revisiones)
        ArrayList<String[]> revisionesTotales= ManejoArchivos.LeerValidando("revisiones.txt", false);
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
    
    /**
     * Remueve del fichero el horario que un cliente ha sido seleccionado
     * el indice es el mismo de la lista
     * 
     * @param index indice se desea borrar
     */
    public static void removeHorarario(int index){
        //el arrayList de horarios es paralelo al fichero y al de cliente
        ManejoArchivos.EliminarLinea("horarios.txt", index+1); //la linea empieza en 0
        
    }
    
    /**
     * 
     * @param index indice a borrar
     */
    public static void removeRevisiones(int index){
        //el arrayList de horarios es paralelo al fichero y al de cliente
        ManejoArchivos.EliminarLinea("revisiones.txt", index+1); //la linea empieza en 1
        
    }
    
    /**
     * 
     * @param index indice a borrar
     */
    public static void removeMulta(int index){
        //el arrayList de horarios es paralelo al fichero y al de cliente
        ManejoArchivos.EliminarLinea("multas.txt", index+1); //la linea empieza en 1
        
    }
    
    /**
     * 
     * @param args args
     */
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
                
                //COMPROBANDO SI EL USUARIO ES OPERADOR
                if (usuario instanceof Operador operador) {
                    Sistema.mostrarMenuOperador();
                    int opc2 = 0;
                    while (opc2 != 4) {
                        System.out.println("Ingrese opcion: ");
                        opc2 = sc.nextInt();
                        sc.nextLine();
                        switch (opc2) {
                            case 3 -> {
                                operador.consultarUsuarios(listaUsuarios);
                                Sistema.mostrarMenuOperador();
                                break;
                            }
                            case 2 -> {
                                operador.consultarMultas();
                                Sistema.mostrarMenuOperador();
                                break;
                            }
                            case 1 -> {
                                operador.registrarPago();
                                Sistema.mostrarMenuOperador();
                                break;
                            }
                            default -> System.out.println("Opcion invalida");
                        }
                    }
                }
                
                //COMPROBRANDO SI EL USUARIO ES CLIENTE 
                if (usuario instanceof Cliente) {
                    Cliente cliente = (Cliente) usuario;
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
                
            } else if (!usuario.getUsuario().equals(user) && usuario.getContrasena().equals(password)) {
                System.out.println("Usuario o contraseña incorrectos");
            }
        }
    }

}
