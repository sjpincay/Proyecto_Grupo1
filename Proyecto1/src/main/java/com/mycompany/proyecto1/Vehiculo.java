/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;
import java.util.ArrayList;
/**
 *
 * @author sjpin
 */
/**
 * Clase que representa un Vehículo en el sistema.
 * 
 * Esta clase define los atributos y métodos relacionados con un vehículo, como el propietario,
 * la placa, la marca, el modelo, el año, el chasis, el color y las multas asociadas.
 * 
 * El código está documentado internamente con comentarios para una mejor comprensión.
 * 
 */
public class Vehiculo {
    private String owner; // Propietario del vehículo
    private String placa; // Placa del vehículo
    private String marca; // Marca del vehículo
    private String modelo; // Modelo del vehículo
    private String year; // Año del vehículo
    private String chasis; // Chasis del vehículo
    private String color; // Color del vehículo
    private ArrayList<Multa> multas; // Lista de multas asociadas al vehículo

    /**
     * Constructor para la clase Vehiculo.
     * 
     * @param owner El propietario del vehículo
     * @param placa La placa del vehículo
     * @param marca La marca del vehículo
     * @param modelo El modelo del vehículo
     * @param year El año del vehículo
     * @param chasis El chasis del vehículo
     * @param color El color del vehículo
     */
    public Vehiculo(String owner, String placa, String marca, String modelo, String year, String chasis, String color) {
        this.owner = owner;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.chasis = chasis;
        this.color = color;

        multas = initMultas(); // Inicializar la lista de multas asociadas al vehículo
    }
    
    /**
     * Método que inicializa la lista de multas del vehículo.
     * 
     * @return La lista de multas asociadas al vehículo
     */
    public ArrayList<Multa> initMultas(){
        ArrayList<Multa> mult = Sistema.listaMultlas; // Obtener la lista de multas del sistema
        ArrayList<Multa> multaReturn = new ArrayList<>();
        
        // Filtrar las multas por placa
        for (Multa multa : mult) {
            if (multa.getPlaca().equals(placa)) {
                multaReturn.add(multa);
            }
        }
        return multaReturn;
    }

    /**
     * Método estático que obtiene un objeto Vehiculo según su placa.
     * 
     * @param vehiculos La lista de vehículos
     * @param placa La placa del vehículo a buscar
     * @return El objeto Vehiculo correspondiente a la placa o null si no se encuentra
     */
    public static Vehiculo getVehiculo(ArrayList<Vehiculo> vehiculos, String placa){
        for(Vehiculo vehi: vehiculos){
            if(vehi.getPlaca().equals(placa)){
                return vehi;
            }
        }
        
        return null;
    }
    
    /**
     * Método que muestra las multas del vehículo y retorna el valor total a pagar.
     * 
     * @return El valor total a pagar por las multas del vehículo
     */
    public double mostrarMultas() {
        System.out.println("------------------------------------------------");
        System.out.println("               DETALLE DE MULTAS                ");
        System.out.println("------------------------------------------------");
        System.out.println("CEDULA | MATRICULA | INFRACCION | VALOR A PAGAR | FECHA DE INFRACCION | FECHA DE NOTIFICACION | PUNTOS");

        for (Multa multa : multas) {
            System.out.println(multa.getCedula() + " | " + multa.getPlaca() + " | " + multa.getInfraccion() + " | " +
                    multa.getValor() + " | " + multa.getFechaInfraccion() + " | " + multa.getFechaNotificacion() + " | " +
                    multa.getPuntos());
        }

        double valorTotal = getValor();
        if (valorTotal > 0) {
            System.out.println("\n\nTOTAL A PAGAR: " + valorTotal);
            System.out.println("\nPara pagar puede acercarse a la agencia más cercana.");
        }
        return valorTotal;
    }
    
    /**
     * Método que calcula el valor total a pagar por las multas del vehículo.
     * 
     * @return El valor total a pagar por las multas del vehículo
     */
    public double getValor(){
        double valorTotal = 0.0;
        for (Multa multa : multas) {
            valorTotal += multa.getValor();
        }
        return valorTotal;
    }
    
    /**
     * Método que calcula la suma de los puntos perdidos por las multas del vehículo.
     * 
     * @return La suma de los puntos perdidos por las multas del vehículo
     */
    public int totalPuntosPerdidos() {
        int puntosTotales = 0;

        for (Multa multa : multas) {
            puntosTotales += multa.getPuntos();
        }

        return puntosTotales;
    }

    // Getters y Setters

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
