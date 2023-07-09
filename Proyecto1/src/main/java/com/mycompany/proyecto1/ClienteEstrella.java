/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import static ManejoArchivos.ManejoArchivos.LeerValidando;
import Enums.TipoPerfil;
import java.util.ArrayList;

/**
 *
 * @author sjpin
 */
/**
     * Constructor que crea objetos de tipo ClienteEstrella
     * @param cedula
     * @param nombres
     * @param edad
     * @param correo
     * @param usuario
     * @param Password
     * @param tipoPerfil
     */
public class ClienteEstrella extends Cliente{
    ArrayList<String[]> datosClientes = LeerValidando("clientes.txt", true);

    public ClienteEstrella(String cedula, String nombres, int edad, String correo, String usuario, String Password, TipoPerfil tipoPerfil) {
        super(cedula, nombres, edad, correo, usuario, Password, tipoPerfil);
    }

    @Override
    public double valorPagar(String placa) {
        return 150 - 150*0.2;
    }
    
    
    
}
