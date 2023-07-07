/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import Enums.TipoPerfil;
import static ManejoArchivos.ManejoArchivos.LeerValidando;
import java.util.ArrayList;

/**
 * Es una clase cliente que asocia al usuario (cliente) con el sistema
 * permitiendo tener acceso ya sea a multas u otras cosas
 * 
 * @author wal26
 */

public class Cliente extends Usuario{

    private String numeroTarjeta;
    private int puntosLicencia;
    private ArrayList<Vehiculo> vehiculos;

    /**
     * Constructor de la clase cliente
     * 
     * @param numeroTarjeta
     * @param puntosLicencia
     * @param multas
     * @param vehiculos
     * @param cedula
     * @param nombres
   
     * @param edad
     * @param correo
     * @param usuario
     * @param password
     * @param perfil 
     */
    public Cliente( String cedula, String nombres, int edad, String correo, String usuario, String password, TipoPerfil perfil) {
        super(cedula, nombres, edad, correo, usuario, password, perfil);
        ArrayList<String[]> datosClientes = LeerValidando("operadores.txt", true);
        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.numeroTarjeta = String.valueOf(dato[1]);
                this.puntosLicencia=Integer.valueOf(dato[2]);
            }
        }
        vehiculos = init_vehiculos();
        
        
    }
    
    @Override
    public void consultar_multas() {
        int opcion = 0;
        do{
            
            opcion = Utilidades.solicitarEntradaInt("Si desea ver sus mutlas con su"+ "cedula ingrese (1) \n en caso de quere con su placa ingrese (2): ");
        
        }while(opcion > 2 || opcion < 1);
        
        switch(opcion){
            case 1 -> {
                String cedula  = Utilidades.solicitarEntrada("Ingrese su cedula: ");
                
                if(!cedula.equals(this.cedula)){
                    System.out.println("Sus datos no coinciden, intentelo nuevamente");
                    return;
                }
                for(Vehiculo vehiculo: vehiculos){
                    //Si es cedula es en caso general
                    vehiculo.mostrarMultas();
                }
                break;
            }
                
            case 2 -> {
                String placa  = Utilidades.solicitarEntrada("Ingrese su placa: ");
                 
                for(Vehiculo vehiculo: vehiculos){
                    
                    if(!vehiculo.getPlaca().equals(placa)) continue;
                    vehiculo.mostrarMultas();
                }
            }
                
        }
        
        mostrarMenu();
        
    }
    
    
    @Override
    public void mostrarMenu(){
        int opcion = Utilidades.solicitarEntradaInt("\n1. Consultar multas \n2. Agendar Revision tecnica\n3. Salir\n");
        
        switch (opcion) {
            case 1:
                consultar_multas();
                break;
            case 2:
                agendarRevision();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("La opcion es incorrecta");
                mostrarMenu();
                break;
        }
        
    }
    
    /**
     * Encagado de inicializar los vehiculos en el constructor
     * los vehiculos se cargaran directamente de la clase sistema
     * y como son estaticas no es necesario un objeto
     */
    private ArrayList<Vehiculo> init_vehiculos(){
        ArrayList<Vehiculo> vehi = Sistema.vehiculos; 
        ArrayList<Vehiculo> vehiculosReturn= new ArrayList<>(); 
        //se debe filtrar los vehiculos propios del usuario
        
        
        for(Vehiculo vehiculo: vehi){
            
            if(vehiculo.getOwner().equals(cedula)){
                //El cliente actual es dueno del vehiculo
                vehiculosReturn.add(vehiculo);
            }
        }
        
     
        return vehiculosReturn;
    }
    

    
    public void agendarRevision(){
        String placa = Utilidades.solicitarEntrada("Ingrese su placa: ");
        Vehiculo vehiculoRevision  = null;
        for(Vehiculo vehiculo: vehiculos){
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
            return;
        }
        
        //Mostrar los horarios FALTA
    }
    
    /**
     * En cargado de obtener el precio que se debera pagara en la revision 
     * @return el precio a pagar
     */
    private double valorPagar(String placa){
        double base = 150.0;
        
        if(TipoPerfil == TipoPerfil.E){
            return base - base*0.2;
        }
        
        //En esta parte accede los tipo cliente
        
        int puntosPerdido = 0;
        
        //Obtener la cantidad de puntos
        for (Vehiculo vehiculo : vehiculos) {
            
            if(vehiculo.getPlaca().equals(placa)){
                puntosPerdido = vehiculo.totalPuntosPerdidos();
            }
        }
        
        return base + (puntosPerdido*10);
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getPuntosLicencia() {
        return puntosLicencia;
    }

    public void setPuntosLicencia(int puntosLicencia) {
        this.puntosLicencia = puntosLicencia;
    }

  

    public ArrayList<Vehiculo> getVehiulos() {
        return vehiculos;
    }

    public void setVehiulos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    
  
    public void comprarTickets(){
        
    }
    
    public void consultarReservas(){
        
    }

    void consultarMultas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void agendarRevisionTecnica() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
