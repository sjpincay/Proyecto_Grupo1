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
     * Obtiene el numero de cedula del responsable de la multa
     * @return String numero de cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Modifica el numero de cedula del responsable de la multa
     * @param cedula La cedula 
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * La placa del vehiculo que se multo
     * @return la placla 
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Modifica el numero de placa del vehiculo infractor
     * @param placa El numero de placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Obtiene el motivo de la infraccion
     * @return la infraccion
     */
    public String getInfraccion() {
        return infraccion;
    }

    /**
     * Modifica el motivo de la infraccion
     * @param infraccion la infraccion
     */
    public void setInfraccion(String infraccion) {
        this.infraccion = infraccion;
    }

    
    /**
     * Obtiene el valor que se debe pagar de la multa
     * @return el valor a pagar
     */
    public Double getValor() {
        return valor;
    }

    
    /**
     * Establece el valor a pagar de la multa
     * @param valor El valor a pagar
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    
    /**
     * Se obtiene la fecha de la infraccion
     * @return la fecha de infraccion
     */
    public Date getFechaInfraccion() {
        return fechaInfraccion;
    }

    
    /**
     * Modifica la fecha de la infraccion
     * @param fechaInfraccion la fecha de infraccion
     */
    public void setFechaInfraccion(Date fechaInfraccion) {
        this.fechaInfraccion = fechaInfraccion;
    }

    /**
     * Obtiene la fecha cuando se notifico la multa
     * @return la fecha de notificacion
     */
    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }


    /**
     * modifica la fecha cuando se notifico
     * @param fechaNotificacion la fecha donde se notifico
     */
    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    /**
     * Obtiene la cantidad de puntos que se bajaran por la multa
     * @return la cantidad de puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Modifica el numero de puntos que se bajara al infractor
     * @param puntos cantidad de puntos
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Metodo para mostrar las multas
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
     * Metodo para verficiar si dos multas son iguales
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
