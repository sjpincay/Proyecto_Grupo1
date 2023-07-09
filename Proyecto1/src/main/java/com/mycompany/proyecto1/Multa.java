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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(String infraccion) {
        this.infraccion = infraccion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getFechaInfraccion() {
        return fechaInfraccion;
    }

    public void setFechaInfraccion(Date fechaInfraccion) {
        this.fechaInfraccion = fechaInfraccion;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return cedula + " | " + placa + " | " + infraccion + " | " + valor + " | "
                + format.format(fechaInfraccion) + " | " + format.format(fechaNotificacion) + " | " + puntos;
    }

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
