/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.util.ArrayList;

/**
 *
 * @author wal26
 */
public class Cliente extends Usuario{

    private String numeroTarjeta;
    private int puntosLicencia;
    private ArrayList<Multas> multas;
    private ArrayList<Vehiculos> vehiulos;

    public Cliente(String numeroTarjeta, int puntosLicencia, ArrayList<Multas> multas,
            ArrayList<Vehiculos> vehiulos, String cedula, String nombres, String apellidos, 
            int edad, String correo, String usuario, String password, TipoPerfil perfil) {
        
        
        super(cedula, nombres, apellidos, edad, correo, usuario, password, perfil);
        this.numeroTarjeta = numeroTarjeta;
        this.puntosLicencia = puntosLicencia;
        this.multas = multas;
        this.vehiulos = vehiulos;
        
        
    }
    
    @Override
    public void consultar_multas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void agendarRevision(){
        
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
