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
/**
 * Clase que representa a un Cliente Estrella.
 */
public class ClienteEstrella extends Cliente {
    ArrayList<String[]> datosClientes = LeerValidando("clientes.txt", true);

    /**
     * Constructor que crea objetos de tipo ClienteEstrella.
     *
     * @param cedula      Cédula del cliente
     * @param nombres     Nombres del cliente
     * @param edad        Edad del cliente
     * @param correo      Correo electrónico del cliente
     * @param usuario     Usuario del cliente
     * @param Password    Contraseña del cliente
     * @param tipoPerfil  Tipo de perfil del cliente
     */
    public ClienteEstrella(String cedula, String nombres, int edad, String correo, String usuario, String Password, TipoPerfil tipoPerfil) {
        super(cedula, nombres, edad, correo, usuario, Password, tipoPerfil);
    }

    /**
     * Método para calcular el valor a pagar por una revisión técnica.
     *
     * @param placa Placa del vehículo
     * @return Valor a pagar por la revisión técnica (con descuento del 20% para el cliente estrella)
     */
    public double valorPagar(String placa) {
        return 150 - 150 * 0.2;
    }
}/**
 * Clase que representa a un Cliente Estrella.
 */
public class ClienteEstrella extends Cliente {
    ArrayList<String[]> datosClientes = LeerValidando("clientes.txt", true);

    /**
     * Constructor que crea objetos de tipo ClienteEstrella.
     *
     * @param cedula      Cédula del cliente
     * @param nombres     Nombres del cliente
     * @param edad        Edad del cliente
     * @param correo      Correo electrónico del cliente
     * @param usuario     Usuario del cliente
     * @param Password    Contraseña del cliente
     * @param tipoPerfil  Tipo de perfil del cliente
     */
    public ClienteEstrella(String cedula, String nombres, int edad, String correo, String usuario, String Password, TipoPerfil tipoPerfil) {
        super(cedula, nombres, edad, correo, usuario, Password, tipoPerfil);
    }

    /**
     * Método para calcular el valor a pagar por una revisión técnica.
     *
     * @param placa Placa del vehículo
     * @return Valor a pagar por la revisión técnica (con descuento del 20% para el cliente estrella)
     */
    public double valorPagar(String placa) {
        return 150 - 150 * 0.2;
    }
}/**
 * Clase que representa a un Cliente Estrella.
 */
public class ClienteEstrella extends Cliente {
    ArrayList<String[]> datosClientes = LeerValidando("clientes.txt", true);

    /**
     * Constructor que crea objetos de tipo ClienteEstrella.
     *
     * @param cedula      Cédula del cliente
     * @param nombres     Nombres del cliente
     * @param edad        Edad del cliente
     * @param correo      Correo electrónico del cliente
     * @param usuario     Usuario del cliente
     * @param Password    Contraseña del cliente
     * @param tipoPerfil  Tipo de perfil del cliente
     */
    public ClienteEstrella(String cedula, String nombres, int edad, String correo, String usuario, String Password, TipoPerfil tipoPerfil) {
        super(cedula, nombres, edad, correo, usuario, Password, tipoPerfil);
    }

    /**
     * Método para calcular el valor a pagar por una revisión técnica.
     *
     * @param placa Placa del vehículo
     * @return Valor a pagar por la revisión técnica (con descuento del 20% para el cliente estrella)
     */
    public double valorPagar(String placa) {
        return 150 - 150 * 0.2;
    }
}
