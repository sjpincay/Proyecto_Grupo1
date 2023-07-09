/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import static ManejoArchivos.ManejoArchivos.LeerValidando;
import Enums.TipoPerfil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sjpin
 */
public class Operador extends Cliente{
    private int sueldo;
    
    /**
     * Constructor que crea objetos de tipo Operador
     * @param cedula
     * @param nombres
     * @param edad
     * @param correo
     * @param usuario
     * @param contrasena
     * @param tipoPerfil
     */
    public Operador(String cedula, String nombres, int edad, String correo, String usuario, String contrasena, TipoPerfil tipoPerfil) {
        super(cedula, nombres, edad, correo, usuario, contrasena, tipoPerfil);
        ArrayList<String[]> datosClientes = LeerValidando("operadores.txt", true);
        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.sueldo = Integer.valueOf(dato[1]);
            }
        }
    }

    @Override
    public void consultarMultas() {
        
        System.out.println("""
                           ---------------------------------------------------------------
                                                Consultar Multas
                           ---------------------------------------------------------------
                           """);
        
        SimpleDateFormat format = new SimpleDateFormat("MM");
        Calendar calendar = Calendar.getInstance();

        Date fecha = calendar.getTime();
        String mes = format.format(fecha);
        
        System.out.println("Mes actual: " + mes);
        
        ArrayList<Multa> multas = Sistema.listaMultlas;
        
        //Filtras lista por meses
        for(Multa multa: multas){
            if(Integer.parseInt(format.format(multa.getFechaInfraccion())) == Integer.parseInt(mes)){
                System.out.println(multa);
            }
        }
        
         
    }
    
    
    
    /**
     * Metodo que retorna en formato int el sueldo del operador
     * @return int
     */
    public int getSueldo() {
        return sueldo;
    }

    /**
     * Metodo set para el sueldo del operador
     * @param sueldo
     */
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
    
    public void consultarUsuarios(ArrayList<Usuario> listaUsuarios){
        for(Usuario usuario: listaUsuarios){
            if(usuario instanceof Operador){
                Operador operador = (Operador) usuario;
                System.out.println(operador + " | OPERADOR | " + operador.getSueldo());
            }else if(usuario instanceof ClienteEstrella){
                ClienteEstrella clienteEstrella = (ClienteEstrella) usuario;
                System.out.println(clienteEstrella + " | CLIENTE ESTRELLA |" + usuario.getCedula());
            }else if(usuario instanceof Cliente){
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente + " | CLIENTE ESTANDAR |" + usuario.getCedula());
            }
            
        }
    }     

    void consultarReservas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}