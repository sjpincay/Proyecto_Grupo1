/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.util.ArrayList;

/**
 *
 * 
 * 
 * @author wal26
 */
public class Vehiculo {
    
    private String owner;
    private String placa;
    private String marca;
    private String modelo;
    private String year;
    private String chasis;
    private String color;
    
    private ArrayList<Multa> multas;

    public Vehiculo(String owner, String placa, String marca, String modelo, String year, String chasis, String color) {
        this.owner = owner;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.chasis = chasis;
        this.color = color;
        
        multas = init_multas();
    }
    
    
    private ArrayList<Multa> init_multas(){
        ArrayList<Multa> multas = Sistema.multas;
        ArrayList<Multa> multaReturn = new ArrayList<>();
        
        //Filtrar las multas
        for (Multa multa : multas) {
            if(multa.getPlaca().equals(placa)){
                multaReturn.add(multa);
            }
        }
        return multaReturn;
    }
    
    public void mostrarMultas(){
        double valor = 0.0;
        
        System.out.println("------------------------------------------------");
        System.out.println("               DETALLE DE MULTAS                ");
        System.out.println("------------------------------------------------");
        System.out.println("CEDULA | MATRICULA | INFRACCION | VALOR A PAGAR |"
                + " FECHA DE INFRACCION | FECHA DE NOTIFICACION | PUNTOS");
        for (Multa multa : this.multas) {
            System.out.println(multas);
            valor += multa.getValor();
        }
        
        if(valor > 0){
            System.out.println("Para pagar puede acercarse a la agencia mas cercana");
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public void setMultas(ArrayList<Multa> multas) {
        this.multas = multas;
    }
    
    
    
}
