/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import static ManejoArchivos.ManejoArchivos.LeerValidando;
import Enums.TipoPerfil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

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

    @Override
    public void consultarMultas() {
        
        System.out.println("""
                           ---------------------------------------------------------------
                                                Consultar Multas
                           ---------------------------------------------------------------
                           """);
        
        SimpleDateFormat format = new SimpleDateFormat("MM");
        Calendar calendar = Calendar.getInstance();

        Date fecha = calendar.getTime();
        String mes = format.format(fecha);
        
        System.out.println("Mes actual: " + mes);
        
        ArrayList<Multa> multas = Sistema.listaMultlas;
        
        //Filtras lista por meses
        for(Multa multa: multas){
            if(Integer.parseInt(format.format(multa.getFechaInfraccion())) == Integer.parseInt(mes)){
                System.out.println(multa);
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
        for(Usuario usuario: listaUsuarios){
            if(usuario instanceof Operador){
                Operador operador = (Operador) usuario;
                System.out.println(operador + " | OPERADOR | " + operador.getSueldo());
            }else if(usuario instanceof ClienteEstrella){
                ClienteEstrella clienteEstrella = (ClienteEstrella) usuario;
                System.out.println(clienteEstrella + " | CLIENTE ESTRELLA |" + usuario.getCedula());
            }else if(usuario instanceof Cliente){
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente + " | CLIENTE ESTANDAR |" + usuario.getCedula());
            }
            
        }
    }     

    
    public void registrarPago(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese su numero de cedula: ");
        String cedulaInput = entrada.nextLine();
        
        
        Cliente cliente = null;
        int opcionPagar = 0;
        int opcionMetodo = 0;
        int opcionConfirmar = 0;
        double valorPagar = 0.0;
        double valorPagarTotal = 0.0;
        
        
        for(Usuario user: Sistema.listaUsuarios){
            
            if(user instanceof Cliente cliente1 && user.getTipoPerfil() != TipoPerfil.O){
                if(!user.getCedula().equals(cedulaInput)) continue;
                cliente = cliente1;
            }else{
                System.out.println("Solo puede registrar pagos los cliente");
            }
        }
        
        System.out.println("""
                           ¿Que desea pagar?
                           1. Multas
                           2. Revision
                           """);
        do {            
            opcionPagar = entrada.nextInt();
            entrada.nextLine();
        } while (opcionPagar > 2 || opcionPagar <= 0);
        
        
        
        
        System.out.println("""
                           ¿Que Modo de pago va a usar?
                           1. Efectivo
                           2. Tarjeta de credito
                           """);
        do {            
            opcionMetodo = entrada.nextInt();
            entrada.nextLine();
        } while (opcionMetodo > 2 || opcionMetodo <= 0);
        
        if(opcionMetodo == 2){
            valorPagarTotal = valorPagar + valorPagar*0.1;
        }
        
        System.out.println("""
                           ¿Desea proceder con el pago?
                           1. Si
                           2. No
                           """);
        do {            
            opcionConfirmar = entrada.nextInt();
            entrada.nextLine();
        } while (opcionConfirmar > 2 || opcionConfirmar <= 0);
        
        if(opcionConfirmar == 2){
            System.out.println("La solicitud se ha cancelado");
            return;
        }
        
        Pago pago = null;
        if(opcionPagar == 1){
            valorPagar = resumenMultas(cliente);
            valorPagarTotal = valorPagar;
            pago = new Pago(cliente, valorPagar, (opcionMetodo == 1) ? 'E':'T', valorPagarTotal, new Date(), "Multa");
        }else{
            valorPagarTotal = valorPagar;
            
            //Detectar si tiene mas de una revision
            Revision rev = null;
            int cantidad = 0;
            String placa = "";
            for(Revision revision: Sistema.revisiones){
                if(revision.getCedula().equals(cliente.getCedula())){
                    rev = revision;
                    cantidad++;
                }
            }
            if (cantidad > 0){
                System.out.println("Ud tiene mas de una revision");
                System.out.println("Porfavor ingrese su placa: ");
                placa = entrada.nextLine(); 
            }
            valorPagar = cliente.valorPagar(placa);
            System.out.println("El valor a pagar de la revision es " + valorPagar);
            
        
            
            pago = new Pago(cliente, rev, valorPagar, (opcionMetodo == 1) ? 'E':'T', valorPagarTotal, new Date(), "Revision");
        }
        
        if(valorPagar == 0) return; //No existe datos a pagar, por lo tanto se retorna
        
        System.out.println("""
                           -----------------------------------------------------
                           Se ha registrado el pago
                           -----------------------------------------------------
                           """);
        System.out.println(pago);
        
    }
    
    private double resumenMultas(Cliente cliente){
        Vehiculo vehiculo = cliente.getListVehiculos().get(0);
        Scanner entrada = new Scanner(System.in);
        if(cliente.getListVehiculos().size() > 1){
            System.out.println("Ud dispone de mas de un auto");
            System.out.println("Porfavor ingrese la placa del auto que desea pagar");
            String placa = entrada.nextLine();
            for(Vehiculo vehi: cliente.getListVehiculos()){
                if(vehi.getPlaca().equals(placa)){
                    vehiculo = vehi;
                }
            }
        }
        
        entrada.close();
        System.out.println("\nUd tiene la siguientes multas\n");
        return vehiculo.mostrarMultas();
    }
    
   
    
    
}