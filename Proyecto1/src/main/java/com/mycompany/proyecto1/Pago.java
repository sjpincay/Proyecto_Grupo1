/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Clase transaccional que permitirá gestionar los pagos que se hagan, esto será 
 * mediante un operador, el cliente directamente no puede hacerlo
 * 
 * Esta clase representa un pago realizado en el sistema. Tiene atributos que
 * almacenan información relacionada con el pago, como el cliente, la revisión
 * asociada, el valor a pagar, el modo de pago, etc.
 * 
 * El código está documentado internamente con comentarios para una mejor comprensión.
 * 
 * 
 * @author wal26
 */
public class Pago {
    private int codigoPago; // Identificador único para cada pago
    private Cliente cliente; // Objeto Cliente asociado con el pago
    private Revision revision; // Objeto Revision asociado con el pago
    private double valorPagar; // Valor a pagar inicialmente
    private char modoPagar; // Modo de pago (carácter)
    private double valorPagarFinal; // Valor a pagar final después de aplicar descuentos o cargos adicionales
    private Date fechaPago; // Fecha en la que se realizó el pago
    private String razonPago; // Descripción o razón para el pago
    
    private static int codigo = 0; // Variable estática para generar códigos de pago secuenciales

    /**
     * Constructor para un pago asociado con una revisión.
     * 
     * @param cliente El objeto Cliente asociado con el pago
     * @param revision El objeto Revision asociado con el pago
     * @param valorPagar El valor a pagar inicialmente
     * @param modoPagar El modo de pago (carácter)
     * @param valorPagarFinal El valor a pagar final después de aplicar descuentos o cargos adicionales
     * @param fechaPago La fecha en la que se realizó el pago
     * @param razonPago La descripción o razón para el pago
     */
    public Pago(Cliente cliente, Revision revision, double valorPagar, char modoPagar, double valorPagarFinal, Date fechaPago, String razonPago) {
        this.codigoPago = codigo++; // Asignar un nuevo código de pago secuencial
        this.cliente = cliente;
        this.revision = revision;
        this.valorPagar = valorPagar;
        this.modoPagar = modoPagar;
        this.valorPagarFinal = valorPagarFinal;
        this.fechaPago = fechaPago;
        this.razonPago = razonPago;
    }

    /**
     * Constructor para un pago de multa sin una revisión asociada.
     * 
     * @param cliente El objeto Cliente asociado con el pago
     * @param valorPagar El valor a pagar inicialmente
     * @param modoPagar El modo de pago (carácter)
     * @param valorPagarFinal El valor a pagar final después de aplicar descuentos o cargos adicionales
     * @param fechaPago La fecha en la que se realizó el pago
     * @param razonPago La descripción o razón para el pago
     */
    public Pago(Cliente cliente, double valorPagar, char modoPagar, double valorPagarFinal, Date fechaPago, String razonPago) {
        this.codigoPago = codigo++; // Asignar un nuevo código de pago secuencial
        this.cliente = cliente;
        this.valorPagar = valorPagar;
        this.modoPagar = modoPagar;
        this.valorPagarFinal = valorPagarFinal;
        this.fechaPago = fechaPago;
        this.razonPago = razonPago;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Pago.
     * 
     * @return Una cadena que representa el objeto Pago
     */
    @Override
    public String toString() {
        return codigoPago + "," + cliente.cedula + "," + valorPagar + ","
                + modoPagar + "," + valorPagarFinal + "," 
                + new SimpleDateFormat("dd-MM-yyyy").format(fechaPago) + "," +
                razonPago;
    }

    /**
     * Establece el modo de pago.
     * 
     * @param modoPagar El modo de pago a establecer
     */
    public void setModoPagar(char modoPagar) {
        this.modoPagar = modoPagar;
    }

    /**
     * Establece el valor a pagar final.
     * 
     * @param valorPagarFinal El valor a pagar final a establecer
     */
    public void setValorPagarFinal(double valorPagarFinal) {
        this.valorPagarFinal = valorPagarFinal;
    }
    
    /**
     * Agrega el pago al sistema.
     * 
     * Llama al método estático createPago() de la clase Sistema para agregar el pago al sistema.
     */
    public void addPago(){
        Sistema.createPago(this);
    }
}
