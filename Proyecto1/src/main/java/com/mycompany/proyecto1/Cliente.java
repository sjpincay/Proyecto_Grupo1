/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import Enums.TipoPerfil;
import static ManejoArchivos.ManejoArchivos.LeerValidando;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase Cliente que representa a un cliente en el sistema.
 * 
 * Esta clase hereda de la clase Usuario y agrega funcionalidades específicas para un cliente,
 * como el número de tarjeta de crédito, los puntos de licencia, la lista de vehículos y la
 * capacidad de consultar multas y agendar revisiones técnicas.
 * 
 * El código está documentado internamente con comentarios para una mejor comprensión.
 * 
 */
public class Cliente extends Usuario {
    private String numTarjetaCredito; // Número de tarjeta de crédito del cliente
    private int puntosLicencia; // Puntos de licencia del cliente
    private final ArrayList<Vehiculo> listVehiculos = initVehiculos(); // Lista de vehículos del cliente
    private final ArrayList<Date> horarios = Sistema.horarios; // Lista de horarios disponibles para revisiones técnicas
    private final ArrayList<String[]> datosClientes = LeerValidando("clientes.txt", true); // Datos de los clientes almacenados en un archivo
    private final Scanner sc = new Scanner(System.in);

    /**
     * Constructor de la clase Cliente.
     *
     * @param cedula     Cédula del cliente
     * @param nombres    Nombres del cliente
     * @param edad       Edad del cliente
     * @param correo     Correo electrónico del cliente
     * @param usuario    Usuario del cliente
     * @param Password   Contraseña del cliente
     * @param tipoPerfil Tipo de perfil del cliente
     */
    public Cliente(String cedula, String nombres, int edad, String correo, String usuario, String Password,
            TipoPerfil tipoPerfil) {
        super(cedula, nombres, edad, correo, usuario, Password, tipoPerfil);

        // Recuperar datos del cliente desde un archivo (clientes.txt) y asignarlos a las variables correspondientes
        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.numTarjetaCredito = dato[1];
                this.puntosLicencia = Integer.parseInt(dato[2]);
            }
        }
    }

    /**
     * Método privado que inicializa la lista de vehículos del cliente.
     *
     * @return ArrayList de vehículos pertenecientes al cliente.
     */
    private ArrayList<Vehiculo> initVehiculos() {
        ArrayList<Vehiculo> vehiculosTo = Sistema.listaVehiculoss; // Obtener la lista de vehículos del sistema
        ArrayList<Vehiculo> vehiculoReturn = new ArrayList<>();

        for (Vehiculo vehiculo : vehiculosTo) {
            if (vehiculo.getOwner().equals(super.cedula)) {
                vehiculoReturn.add(vehiculo);
            }
        }
        return vehiculoReturn;
    }

    /**
     * Método para consultar las multas del cliente.
     */
    @Override
    public void consultarMultas() {
        int opcion = 0;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("Desea ver las multas con su número de cédula (1) ");
            System.out.println("o desea ver con su placa (2): ");
            opcion = entrada.nextInt();
            entrada.nextLine();
        } while (opcion > 2 || opcion < 1);

        switch (opcion) {
            case 1 -> {
                System.out.println("Ingrese su cédula: ");
                String cedulaInput = entrada.nextLine();

                if (!cedulaInput.equals(this.cedula)) {
                    System.out.println("Sus datos no coinciden, intente nuevamente");
                    return;
                }

                for (Vehiculo vehiculo : listVehiculos) {
                    // Si se selecciona la opción de cédula, se muestra las multas de todos los vehículos del cliente
                    vehiculo.mostrarMultas();
                }
                break;
            }

            case 2 -> {
                System.out.println("Ingrese su placa: ");
                String placa = entrada.nextLine();

                for (Vehiculo vehiculo : listVehiculos) {
                    // Si se selecciona la opción de placa, se muestra las multas del vehículo con la placa ingresada
                    if (vehiculo.getPlaca().equals(placa)) {
                        vehiculo.mostrarMultas();
                        break;
                    }
                }
            }
        }
    }

    /**
     * Método para agendar una revisión técnica.
     */
    public void agendarRevisionTecnica() {
        System.out.println("Ingrese su placa: ");
        String placa = sc.nextLine();
        Vehiculo vehiculoRevision = null;

        for (Vehiculo vehiculo : listVehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculoRevision = vehiculo;
                break;
            }
        }

        if (vehiculoRevision == null) {
            System.out.println("No se encontró su vehículo en la base de datos");
            return;
        }

        if (!vehiculoRevision.getMultas().isEmpty()) {
            // Entra si tiene multas
            System.out.println("Lo siento, usted tiene multas pendientes");
            vehiculoRevision.mostrarMultas();
            return;
        }
        
        //Verficar que no consta con revisiones existentes relacionados a la misma
        //placa
        if(Revision.getRevision(Sistema.revisiones, placa) != null){
            //Si hay una revison con esa placa
            System.out.println("Lo siento, Ud ya tiene una revision para este vehiculo");
            return;
        }

        System.out.println("Ud. no tiene multas ni revisones asocidas para este vehiculo, por elija el horario que mas desee");
        int contador = 1;
        int opcionHorario = 0;

        for (Date horario : horarios) {
            System.out.println(contador + ". "+ horario);
            contador++;
        }

        do {
            System.out.println("Elija el horario para la revisión: ");
            opcionHorario = sc.nextInt();
            sc.nextLine(); // Limpiando el buffer
        } while (opcionHorario > horarios.size() || opcionHorario <= 0);

        // Obtenemos la fecha seleccionada
        Date fecha = horarios.get(opcionHorario - 1);

        System.out.println(this + "Se ha registrado su cita para "
                + new SimpleDateFormat("dd-MM-yyyy").format(fecha) + " a las "
                + new SimpleDateFormat("HH::ss").format(fecha));

        System.out.println("Valor a pagar: " + valorPagar(placa));

        Revision revision = new Revision(super.cedula, placa, fecha);

        revision.addRevision(); // Añadir revisión a la base de datos
        horarios.remove(opcionHorario - 1); // Se quita un horario disponible
        Sistema.removeHorarario(opcionHorario - 1);
        System.out.println("\nPuede pagar hasta 24 horas antes de la cita");
        System.out.println("De lo contrario, la cita se cancelará");
    }

    /**
     * Método que calcula el valor a pagar por una revisión técnica.
     *
     * @param placa Placa del vehículo
     * @return Valor a pagar por la revisión técnica
     */
    public double valorPagar(String placa) {
        double base = 150.0;
        int puntosPerdidos = 0;

        // Obtener la cantidad de puntos perdidos
        for (Vehiculo vehiculo : listVehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                puntosPerdidos = vehiculo.totalPuntosPerdidos();
                break;
            }
        }

        return base + (puntosPerdidos * 10);
    }
    
    /**
     *  Obtiene el numero de la tarjeta de credito del usuario
     * @return String numero de tarjeta  de credito
     */

    // Getters y Setters

    public String getNumTarjetaCredito() {
        return numTarjetaCredito;
    }

    /**
     * Método set para el número de tarjeta de crédito del cliente.
     *
     * @param numTarjetaCredito Número de tarjeta de crédito del cliente
     */
    public void setNumTarjetaCredito(String numTarjetaCredito) {
        this.numTarjetaCredito = numTarjetaCredito;
    }

    /**
     * Obtiene la cantidad de puntos de licencia
     * @return puntosLicencia
     */
    public int getPuntosLicencia() {
        return puntosLicencia;
    }

    /**
     * Modifica el atributo de los puntos de licencia
     * @param puntosLicencia puntosLicencia
     */
    public void setPuntosLicencia(int puntosLicencia) {
        this.puntosLicencia = puntosLicencia;
    }

    /**
     * Obtiene todos los vehivulos asociados al usuario
     * @return la lista de Vehiculos
     */
    public ArrayList<Vehiculo> getListVehiculos() {
        return listVehiculos;
    }
}
