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
import java.util.Scanner;

/**
 *
 * @author sjpin
 */
/**
 * Clase que representa un operador.
 */
public class Operador extends Usuario {
    private int sueldo;

    /**
     * Constructor de la clase Operador.
     *
     * @param cedula      Cédula del operador
     * @param nombres     Nombres del operador
     * @param edad        Edad del operador
     * @param correo      Correo electrónico del operador
     * @param usuario     Usuario del operador
     * @param Password    Contraseña del operador
     * @param tipoPerfil  Tipo de perfil del operador
     */
    public Operador(String cedula, String nombres, int edad, String correo, String usuario, String Password, TipoPerfil tipoPerfil) {
        super(cedula, nombres, edad, correo, usuario, Password, tipoPerfil);
        ArrayList<String[]> datosClientes = LeerValidando("operadores.txt", false);
        for (String[] dato : datosClientes) {
            if (dato[0].equals(cedula)) {
                this.sueldo = Integer.parseInt(dato[1]);
            }
        }
    }

    /**
     * Método para consultar las multas del operador.
     */
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

        int contador = 0;
        // Filtrar lista por meses
        for (Multa multa : multas) {
            if (Integer.parseInt(format.format(multa.getFechaInfraccion())) == Integer.parseInt(mes)) {
                System.out.println(multa);
                contador++;
            }
        }
        if(contador == 0){
            System.out.println("\n\nNo existe multas asociadas al mes actual");
        }
    }

    /**
     * Método que retorna el sueldo del operador.
     *
     * @return Sueldo del operador
     */
    public int getSueldo() {
        return sueldo;
    }

    /**
     * Método set para el sueldo del operador.
     *
     * @param sueldo Sueldo del operador
     */
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Método para consultar los usuarios del sistema.
     *
     * @param listaUsuarios Lista de usuarios del sistema
     */
    public void consultarUsuarios(ArrayList<Usuario> listaUsuarios) {
        for (Usuario user : listaUsuarios) {
            if (user instanceof Operador operador) {
                System.out.println(operador + " | OPERADOR | " + operador.getSueldo());
            } else if (user instanceof ClienteEstrella clienteEstrella) {
                System.out.println(clienteEstrella + " | CLIENTE ESTRELLA |" + user.getCedula());
            } else if (user instanceof Cliente cliente) {
                System.out.println(cliente + " | CLIENTE ESTANDAR |" + user.getCedula());
            }
        }
    }

    /**
     * Método para registrar un pago.
     */
    public void registrarPago() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el numero de cedula del cliente: ");
        String cedulaInput = entrada.nextLine();

        Cliente cliente = null;
        int opcionPagar = 0;
        int opcionMetodo = 0;
        int opcionConfirmar = 0;
        double valorPagar;
        double valorPagarTotal;
        int indexRevision = 0;
        ArrayList<Integer> indexMultas = new ArrayList<>();
        for (Usuario user : Sistema.listaUsuarios) {
            if (user instanceof Cliente cliente1 && user.getTipoPerfil() != TipoPerfil.O) {
                if (!user.getCedula().equals(cedulaInput)) {
                    continue;
                }
                cliente = cliente1;
            }
        }
        if (cliente == null) {
            System.out.println("No se encontro ningun cliente");
            return;
        }
        System.out.println("""
                           ¿Que desea pagar?
                           1. Multas
                           2. Revision
                           """);
        do {
            opcionPagar = entrada.nextInt();
            entrada.nextLine();
        } while (opcionPagar > 2 || opcionPagar <= 0);

        Pago pago;
        String placa = "";
        // Obtener la fecha actual
        Calendar calendar = Calendar.getInstance();
        Date fecha = calendar.getTime();

        if (opcionPagar == 1) {
            // Se encuentra el carro asociado o en el caso de que tenga mas de uno
            // se pide directamente al usuario con el que se trabajará
            Vehiculo vehiCliente = cliente.getListVehiculos().get(0);
            // Comprobar si el usuario posee más de un carro
            if (cliente.getListVehiculos().size() > 1) {
                placa = pedirPlaca();
                vehiCliente = Vehiculo.getVehiculo(Sistema.listaVehiculoss, placa);
            }

            // Verificar si tiene multas
            if (vehiCliente.getMultas().isEmpty()) {
                System.out.println("El cliente no posee multas");
                return;
            }

            valorPagar = vehiCliente.getValor(); // Valor a pagar por multas
            
            System.out.println("Valor a pagar: " + valorPagar);
            pago = new Pago(cliente, valorPagar, 'E', valorPagar, fecha, "Multa");

            // Obtener la lista de índices para luego ser borrados
            for (Multa multa : Sistema.listaMultlas) {
                if (vehiCliente.getMultas().contains(multa)) {
                    indexMultas.add(Sistema.listaMultlas.indexOf(multa));
                  
                }
            }
        } else {
            // Se obtendrá la revisión
            Revision rev = Revision.getRevision(Sistema.revisiones, cliente);
            int cantidad = Revision.cantidadRevisiones(Sistema.revisiones, cliente.getCedula());

            if (cantidad > 1) {
                System.out.println("El cliente posee mas de una revision");
                placa = pedirPlaca();
                rev = Revision.getRevision(Sistema.revisiones, placa);
            }

            // Verificar si existe alguna revisión
            if (rev == null) {
                System.out.println("El cliente no posee revisiones en estos momentos");
                return;
            }

            valorPagar = cliente.valorPagar(rev.getPlaca());
            System.out.println("El valor a pagar es: " + valorPagar);
            pago = new Pago(cliente, rev, valorPagar, 'E', valorPagar, fecha, "Revision");
            indexRevision = Sistema.revisiones.indexOf(rev); // índice para eliminar la revisión
        }
        valorPagarTotal = valorPagar;

        System.out.println("""
                           ¿Qué modo de pago va a usar?
                           1. Efectivo
                           2. Tarjeta de crédito
                           """);
        do {
            opcionMetodo = entrada.nextInt();
            entrada.nextLine();
        } while (opcionMetodo > 2 || opcionMetodo <= 0);

        if (opcionMetodo == 2) {
            valorPagarTotal = valorPagar + valorPagar * 0.1;
            pago.setModoPagar('T');
            pago.setValorPagarFinal(valorPagarTotal);
        }
        System.out.println("El valor final a pagar es: " + valorPagarTotal);
        if (valorPagar == 0) {
            return; // No existen datos a pagar, por lo tanto se retorna
        }

        System.out.println("""
                           ¿Desea proceder con el pago?
                           1. Si
                           2. No
                           """);
        do {
            opcionConfirmar = entrada.nextInt();
            entrada.nextLine();
        } while (opcionConfirmar > 2 || opcionConfirmar <= 0);

        if (opcionConfirmar == 2) {
            System.out.println("La solicitud se ha cancelado");
            return;
        }

        System.out.println("""
                           -----------------------------------------------------
                           Se ha registrado el pago
                           -----------------------------------------------------
                           """);

        pago.addPago(); // Se registra el pago

        if (opcionPagar == 1) {
            // Se borrarán las multas
            // Como son varias multas, se irán borrando una por una de mayor a menor
            // para que no haya conflicto entre sus índices cuando se ajusten
            for (int i = indexMultas.size() - 1; i >= 0; i--) {
                Sistema.removeMulta((int) indexMultas.get(i));
                Sistema.listaMultlas.remove((int) indexMultas.get(i));
                
              
            }
              //Debido a que si se modifica los objetos deben cambiar
                //La multa guardadas en los objetos que se incializaron deben
                //cambiar

                //Se vuelve a inicializar las multas de los vehiculos pero con los 
                //cambios perttinentes
            if(!placa.equals("")){
                    Vehiculo.getVehiculo(Sistema.listaVehiculoss, placa).setMultas(new ArrayList<>());
                }else{
                    cliente.getListVehiculos().get(0).setMultas(new ArrayList<>());
                }
        } else {
            // Se borrarán las revisiones
            Sistema.removeRevisiones(indexRevision);
            Sistema.revisiones.remove(indexRevision);
        }
    }

    /**
     * Método para pedir la placa al usuario.
     *
     * @return Placa ingresada por el usuario
     */
    private String pedirPlaca() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Por favor ingrese su placa: ");
        String placa = entrada.nextLine();

        return placa;
    }
}
