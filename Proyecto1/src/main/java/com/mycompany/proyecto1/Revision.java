/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author wal26
 */
public class Revision {
    private int codigoRevision;
    private String cedula;
    private String placa;
    private Date fechaRevision;
    private static int codigo = 0;

    /**
     * Constructor que crea una nueva instancia de la clase Revision.
     *
     * @param cedula         la cédula del cliente asociado a la revisión
     * @param placa          la placa del vehículo asociado a la revisión
     * @param fechaRevision  la fecha de la revisión
     */
    public Revision(String cedula, String placa, Date fechaRevision) {
        this.codigoRevision = codigo++;
        this.cedula = cedula;
        this.placa = placa;
        this.fechaRevision = fechaRevision;
    }
    
    /**
     * Constructor que crea una nueva instancia de la clase Revision.
     *
     * @param codigoRevision  el código de la revisión
     * @param cedula          la cédula del cliente asociado a la revisión
     * @param placa           la placa del vehículo asociado a la revisión
     * @param fechaRevision   la fecha de la revisión
     */
    public Revision(int codigoRevision, String cedula, String placa, Date fechaRevision) {
        this.codigoRevision = codigoRevision;
        this.cedula = cedula;
        this.placa = placa;
        this.fechaRevision = fechaRevision;
    }

    /**
     * Devuelve la cantidad de revisiones asociadas a una cédula de cliente.
     *
     * @param revisiones  la lista de revisiones
     * @param cedula      la cédula del cliente
     * @return la cantidad de revisiones asociadas a la cédula
     */
    public static int cantidadRevisiones(ArrayList<Revision> revisiones, String cedula) {
        int cantidad = 0;
        for (Revision revision : revisiones) {
            if (revision.getCedula().equals(cedula)) {
                cantidad++;
            }
        }
        return cantidad;
    }
    
    /**
     * Devuelve una revisión asociada a una placa de vehículo.
     *
     * @param revisiones  la lista de revisiones
     * @param placa       la placa del vehículo
     * @return la revisión asociada a la placa de vehículo o null si no se encuentra ninguna
     */
    public static Revision getRevision(ArrayList<Revision> revisiones, String placa) {
        Revision revision = null;
        for (Revision rev : revisiones) {
            if (rev.getPlaca().equals(placa)) {
                revision = rev;
            }
        }
        return revision;
    }

    /**
     * Devuelve la revisión asociada a un cliente. Si hay más de una revisión asociada
     * al cliente, devuelve null.
     *
     * @param revisiones  la lista de revisiones
     * @param cliente     el cliente asociado a la revisión
     * @return la revisión asociada al cliente o null si hay más de una revisión asociada
     */
    public static Revision getRevision(ArrayList<Revision> revisiones, Cliente cliente) {
        if (Revision.cantidadRevisiones(revisiones, cliente.getCedula()) > 1) {
            return null;
        }
        
        Revision revision = null;
        for (Revision rev : revisiones) {
            if (rev.getCedula().equals(cliente.getCedula())) {
                revision = rev;
            }
        }
        return revision;
    }

    /**
     * Agrega la revisión al sistema.
     */
    public void addRevision() {
        Sistema.createRevision(this);
    }

    /**
     * Devuelve la cédula del cliente asociado a la revisión.
     *
     * @return la cédula del cliente
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Devuelve la placa del vehículo asociado a la revisión.
     *
     * @return la placa del vehículo
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Devuelve una representación en forma de cadena de la revisión.
     *
     * @return una cadena que representa la revisión
     */
    @Override
    public String toString() {
        return codigoRevision + "," + cedula + "," + placa + ","
                + new SimpleDateFormat("dd-MM-yyy HH:mm").format(fechaRevision);
    }

    /**
     * Compara la revisión actual con otro objeto para determinar si son iguales.
     *
     * @param obj  el objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Revision other = (Revision) obj;
        return codigoRevision == other.codigoRevision && Objects.equals(placa, other.placa);
    }
}
