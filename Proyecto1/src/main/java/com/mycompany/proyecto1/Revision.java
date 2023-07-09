/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.text.SimpleDateFormat;
import java.util.Date;

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
     * 
     * 
     * @param cedula
     * @param placa
     * @param fechaRevision 
     */
    public Revision(String cedula, String placa, Date fechaRevision) {
        this.codigoRevision = codigo++;
        this.cedula = cedula;
        this.placa = placa;
        this.fechaRevision = fechaRevision;
    }
    
    /**
     * 
     * @param codigoRevision
     * @param cedula
     * @param placa
     * @param fechaRevision 
     */
    public Revision(int codigoRevision,String cedula, String placa, Date fechaRevision) {
        this.codigoRevision = codigoRevision;
        this.cedula = cedula;
        this.placa = placa;
        this.fechaRevision = fechaRevision;
    }
    
    public void addRevision(){
        Sistema.createRevision(this);
    }

    public String getCedula() {
        return cedula;
    }

    public String getPlaca() {
        return placa;
    }

    
    @Override
    public String toString() {
        
        return codigoRevision + "," + cedula + "," + placa + ","
                + new SimpleDateFormat("dd-MM-yyy HH:ss").format(fechaRevision);
    }
    
    
}
