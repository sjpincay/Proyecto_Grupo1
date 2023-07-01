/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

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
    private ArrayList<Vehiculos> vehiculos;

    /**
     * Constructor de la clase cliente
     * 
     * @param numeroTarjeta
     * @param puntosLicencia
     * @param multas
     * @param vehiulos
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param edad
     * @param correo
     * @param usuario
     * @param password
     * @param perfil 
     */
    public Cliente(String numeroTarjeta, int puntosLicencia, String cedula, String nombres, String apellidos, 
            int edad, String correo, String usuario, String password, TipoPerfil perfil) {
        
        //Debido a que las multas se cargaran por el sistema y son estaticas
        //No se las pedira al crear usuario, existira una funcion que la inicilize
        
        super(cedula, nombres, apellidos, edad, correo, usuario, password, perfil);
        this.numeroTarjeta = numeroTarjeta;
        this.puntosLicencia = puntosLicencia;
        
        vehiculos = init_vehiculos();
        
        
    }
    
    @Override
    public void consultar_multas() {
        int opcion = 0;
        do{
            opcion = Utilidades.solicitarEntrada("Si desea ver sus mutlas con su "
                + "cedula ingrese (1) \n en caso de quere con su placa ingrese (2): ");
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
            }
                
            case 2 -> {
                String placa  = Utilidades.solicitarEntrada("Ingrese su placa: ");
                 
                for(Vehiculo vehiculo: vehiculos){
                    
                    if(!vehiculo.getPlca().equal(placa)) continue;
                    vehiculo.mostrarMultas();
                }
            }
                
        }
        
    }
    
    /**
     * Encagado de inicializar los vehiculos en el constructor
     * los vehiculos se cargaran directamente de la clase sistema
     * y como son estaticas no es necesario un objeto
     */
    private ArrayList<Vehiculo> init_vehiculos(){
        ArrayList<Vehiculos> vehiculos = Sistema.vehiculos; 
        ArrayList<Vehiculo> vehiculosReturn= new ArrayList<>(); 
        //se debe filtrar los vehiculos propios del usuario
        
        for(Vehiculo vehiculo: vehiculos){
            
            if(vehiculo.getOwner().equal(cedula)){
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
            if(!vehiculo.getPlca().equal(placa)) continue;
            vehiculoRevision = vehiculo;
                
        }
        
        if(!vehiculoRevision.getMultas().isEmpty()){
            //Entra si tiene multas
            System.out.println("Lo siento, usted tiene multas pendientes");
            vehiculoRevision.mostrarMutlas();
            return;
        }
        
        //Mostrar los horarios FALTA
    }
    
    private double valorPagar(){
        return 0.0;
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

    public ArrayList<Multas> getMultas() {
        return multas;
    }

    public void setMultas(ArrayList<Multas> multas) {
        this.multas = multas;
    }

    public ArrayList<Vehiculos> getVehiulos() {
        return vehiulos;
    }

    public void setVehiulos(ArrayList<Vehiculos> vehiulos) {
        this.vehiulos = vehiulos;
    }
    
    
  
    
    
}
