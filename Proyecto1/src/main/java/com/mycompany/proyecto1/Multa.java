/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author wal26
 */
/**
 * Clase que representa una multa.
 */
public class Multa {
    private String cedula;
    private String placa;
    private String infraccion;
    private Double valor;
    private Date fechaInfraccion;
    private Date fechaNotificacion;
    private int puntos;

    /**
     * Constructor de la clase Multa.
     *
     * @param cedula            Cédula del infractor
     * @param placa             Placa del vehículo infractor
     * @param infraccion        Descripción de la infracción
     * @param valor             Valor de la multa
     * @param fechaInfraccion   Fecha de la infracción
     * @param fechaNotificacion Fecha de notificación de la multa
     * @param puntos            Puntos asociados a la infracción
     */
    public Multa(String cedula, String placa, String infraccion, Double valor, Date fechaInfraccion, Date fechaNotificacion, int puntos) {
        this.cedula = cedula;
        this.placa = placa;
        this.infraccion = infraccion;
        this.valor = valor;
        this.fechaInfraccion = fechaInfraccion;
        this.fechaNotificacion = fechaNotificacion;
        this.puntos = puntos;
    }

    /**
     * 
     * @return String numero de cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * 
     * @param cedula La cedula 
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * 
     * @return la placla 
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * 
     * @param placa El numero de placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * 
     * @return la infraccion
     */
    public String getInfraccion() {
        return infraccion;
    }

    /**
     * 
     * @param infraccion la infraccion
     */
    public void setInfraccion(String infraccion) {
        this.infraccion = infraccion;
    }

    
    /**
     * 
     * @return el valor a pagar
     */
    public Double getValor() {
        return valor;
    }

    
    /**
     * 
     * @param valor El valor a pagar
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    
    /**
     * 
     * @return la fecha de infraccion
     */
    public Date getFechaInfraccion() {
        return fechaInfraccion;
    }

    
    /**
     * 
     * @param fechaInfraccion la fecha de infraccion
     */
    public void setFechaInfraccion(Date fechaInfraccion) {
        this.fechaInfraccion = fechaInfraccion;
    }

    /**
     * 
     * @return la fecha de notificacion
     */
    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }


    /**
     * 
     * @param fechaNotificacion la fecha donde se notifico
     */
    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    /**
     * 
     * @return la cantidad de puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * 
     * @param puntos cantidad de puntos
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * 
     * @return String formato a imprimir
     */
    @Override
    public String toString() {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return cedula + " | " + placa + " | " + infraccion + " | " + valor + " | "
                + format.format(fechaInfraccion) + " | " + format.format(fechaNotificacion) + " | " + puntos;
    }

    
    /**
     * 
     * @param obj objeto a varificar
     * @return si son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Multa other = (Multa) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.infraccion, other.infraccion)) {
            return false;
        }
        return Objects.equals(this.fechaInfraccion, other.fechaInfraccion);
    }
}
