/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.util.Date;

/**
 *
 * @author wal26
 */
public class Multa {
    private String cedula;
    private String placa;
    private String infraccion;
    private Double valor;
    private Date fechaInfraccion;
    private Date fechaNotificacion;
    private int puntos;

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
        return cedula + " | " + placa + " | " + infraccion + " | " + valor + " | "
                + fechaInfraccion + " | " + fechaNotificacion + " | " + puntos;
    }
    
    
    
    
}
