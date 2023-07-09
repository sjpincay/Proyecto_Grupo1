/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Clase transaccional que permitira gestionar los pagos que se hagan, esto sera 
 * mediante un operador, el cliente directamente no puede hacerlo
 * @author wal26
 */
public class Pago {
    private int codigoPago;
    private Cliente cliente;
    private Revision revision;
    private double valorPagar;
    private char modoPagar;
    private double valorPagarFinal;
    private Date fechaPago;
    private String razonPago;
    
    private static int codigo = 0;

    public Pago(Cliente cliente, Revision revision, double valorPagar, char modoPagar, double valorPagarFinal, Date fechaPago, String razonPago) {
        this.codigoPago = codigo++;
        this.cliente = cliente;
        this.revision = revision;
        this.valorPagar = valorPagar;
        this.modoPagar = modoPagar;
        this.valorPagarFinal = valorPagarFinal;
        this.fechaPago = fechaPago;
        this.razonPago = razonPago;
    }

    
    /**
     * Constructor que no requiere reservacion, ya que unicamente sera para
     * pago de multa
     * 
     * 
     * @param cliente
     * @param valorPagar
     * @param modoPagar
     * @param valorPagarFinal
     * @param fechaPago
     * @param razonPago 
     */
    public Pago(Cliente cliente, double valorPagar, char modoPagar, double valorPagarFinal, Date fechaPago, String razonPago) {
        this.codigoPago = codigo++;
        this.cliente = cliente;
        this.valorPagar = valorPagar;
        this.modoPagar = modoPagar;
        this.valorPagarFinal = valorPagarFinal;
        this.fechaPago = fechaPago;
        this.razonPago = razonPago;
    }

    @Override
    public String toString() {
        return codigoPago + "," + cliente.cedula + "," + valorPagar + ","
                + modoPagar + "," + valorPagarFinal + "," 
                + new SimpleDateFormat("dd-MM-yyyy").format(fechaPago) + "," +
                razonPago;
    }

    public void setModoPagar(char modoPagar) {
        this.modoPagar = modoPagar;
    }

    public void setValorPagarFinal(double valorPagarFinal) {
        this.valorPagarFinal = valorPagarFinal;
    }
    
    public void addPago(){
        Sistema.createPago(this);
    }
    
}
