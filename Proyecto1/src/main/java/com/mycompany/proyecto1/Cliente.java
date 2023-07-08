/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

//import Enums.TipoPerfil;
//import static ManejoArchivos.ManejoArchivos.LeerValidando;
//import java.util.ArrayList;
import static ManejoArchivos.ManejoArchivos.LeerValidando;
import Enums.TipoPerfil;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario{
    private String numTarjetaCredito;
    private int puntosLicencia;
    private ArrayList<Vehiculo> listVehiculos;
    ArrayList<String[]> datosClientes = LeerValidando("clientes.txt", true);
    Scanner sc = new Scanner(System.in);
    
    public Cliente(String cedula, String nombres, int edad, String correo, String usuario, String Password, TipoPerfil tipoPerfil) {
        super(cedula, nombres, edad, correo, usuario, Password, tipoPerfil);
        listVehiculos =  initVehiculos();
        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.numTarjetaCredito = dato[1];
                this.puntosLicencia=Integer.parseInt(dato[2]);
            }
        }
    }
    
    private ArrayList<Vehiculo> initVehiculos(){
        ArrayList<Vehiculo> vehiculosTo =  Sistema.listaVehiculoss;
        ArrayList<Vehiculo> vehiculoReturn = new ArrayList<>();
        for(Vehiculo vehiculo: vehiculosTo){
            if(vehiculo.getOwner().equals(super.cedula)){
                vehiculoReturn.add(vehiculo);
            }
        }
        
        return vehiculoReturn;
    }
    
    @Override
    public void consultarMultas() {
        int opcion=0;
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("Desea ver las multas con su numero de cedula (1) + "
                    + "\nO desea ver con su placa(2): ");
            opcion=sc.nextInt();
            sc.nextLine();
        }while(opcion > 2 || opcion < 1);
        
        switch(opcion){
            case 1 -> {
                System.out.println("Ingrese su cédula: ");
                String cedula  = sc.nextLine();
                
                if(!cedula.equals(this.cedula)){
                    System.out.println("Sus datos no coinciden, intentelo nuevamente");
                    return;
                }
                for(Vehiculo vehiculo: listVehiculos){
                    //Si es cedula es en caso general
                    vehiculo.mostrarMultas();
                }
                break;
            }
                
            case 2 -> {
                System.out.println("Ingrese su placa: ");
                String placa  = sc.nextLine();
                 
                for(Vehiculo vehiculo: listVehiculos){
                    
                    if(!vehiculo.getPlaca().equals(placa)) continue;
                    vehiculo.mostrarMultas();
                }
            }
                
        }
        
    }
    
    
    public void agendarRevisionTecnica(){
        System.out.println("Ingrese su placa: ");
        String placa= sc.nextLine();
        Vehiculo vehiculoRevision  = null;
        for(Vehiculo vehiculo: listVehiculos){
            if(!vehiculo.getPlaca().equals(placa)) continue;
            vehiculoRevision = vehiculo;
                
        }
        if(vehiculoRevision == null){
            System.out.println("No se encontro su vehiculo en la base de datos");
            return;
        }
        if(!(vehiculoRevision.getMultas().isEmpty())){
            //Entra si tiene multas
            System.out.println("Lo siento, usted tiene multas pendientes");
            vehiculoRevision.mostrarMultas();
        }
    }
    
    public double valorPagar(String placa){
        double base = 150.0;
        TipoPerfil TipoPerfil = null;
        
        if(TipoPerfil == TipoPerfil.E){
            return base - base*0.2;
        }
        //En esta parte accede los tipo cliente
        
        int puntosPerdido = 0;
        
        //Obtener la cantidad de puntos
        for (Vehiculo vehiculo : listVehiculos) {
            
            if(vehiculo.getPlaca().equals(placa)){
                puntosPerdido = vehiculo.totalPuntosPerdidos();
            }
        }
        
        return base + (puntosPerdido*10);
    }
    public String getNumTarjetaCredito() {
        return numTarjetaCredito;
    }
    /**
     * Metodo set para el numero de tarjeta de credito del cliente
     * @param numTarjetaCredito
     */
    public void setNumTarjetaCredito(String numTarjetaCredito) {
        this.numTarjetaCredito = numTarjetaCredito;
    }
    
    public int getPuntosLicencia() {
        return puntosLicencia;
    }

    public void setPuntosLicencia(int puntosLicencia) {
        this.puntosLicencia = puntosLicencia;
    }   


   
}
