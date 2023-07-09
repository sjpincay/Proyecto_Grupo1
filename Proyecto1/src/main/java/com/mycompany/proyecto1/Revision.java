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
    
    public static int cantidadRevisiones(ArrayList<Revision> revisiones, String cedula){
        int cantidad = 0;
        for(Revision revision: revisiones){
            if(revision.getCedula().equals(cedula)){
                cantidad++;
            }
        }
        
        return cantidad;
    }
    
    /**
     * Metodo estatico que devuelve una revision en base a una placa de un auto 
     * vinculado
     * @param revisiones
     * @param placa
     * @return 
     */
    public static Revision getRevision(ArrayList<Revision> revisiones, String placa){
        Revision revision = null;
        for(Revision rev: revisiones){
            if(rev.getPlaca().equals(placa)){
                revision = rev;
            }
        }
        return revision;
    }
    
    /**
     * Devulve la revison del cliente, siempre y cuando exista solo 1 asociada
     * a este, caso contrario devuelve null
     * @param revisiones
     * @param cliente
     * @return 
     */
    public static Revision getRevision(ArrayList<Revision> revisiones, Cliente cliente){
        if(Revision.cantidadRevisiones(revisiones, cliente.getCedula()) > 1){
            return null;
        }
        
        Revision revision = null;
        for(Revision rev: revisiones){
            if(rev.getCedula().equals(cliente.getCedula())){
                revision = rev;
            }
        }
        return revision;
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
        final Revision other = (Revision) obj;
        if (this.codigoRevision != other.codigoRevision) {
            return false;
        }
        return Objects.equals(this.placa, other.placa);
    }
    
    
    
}
