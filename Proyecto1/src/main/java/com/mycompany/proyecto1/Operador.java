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
public class Operador extends Cliente {

    private int sueldo;

    /**
     * Constructor que crea objetos de tipo Operador
     *
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
        for (Multa multa : multas) {
            if (Integer.parseInt(format.format(multa.getFechaInfraccion())) == Integer.parseInt(mes)) {
                System.out.println(multa);
            }
        }

    }

    /**
     * Metodo que retorna en formato int el sueldo del operador
     *
     * @return int
     */
    public int getSueldo() {
        return sueldo;
    }

    /**
     * Metodo set para el sueldo del operador
     *
     * @param sueldo
     */
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

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

    public void registrarPago() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese su numero de cedula: ");
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
        String placa;
        //Obtener la fecha actual
        Calendar calendar = Calendar.getInstance();

        Date fecha = calendar.getTime();

        if (opcionPagar == 1) {

            //Se encuentra el carro asociado o en el caso de que tenga mas de un
            //auto se pide directamente al usuario con el que se trabajara
            Vehiculo vehiCliente = cliente.getListVehiculos().get(0);
            //comprabamos si el usuario posee mas de un carro;
            if (cliente.getListVehiculos().size() > 1) {
                placa = pedirPlaca();
                vehiCliente = Vehiculo.getVehiculo(Sistema.listaVehiculoss, placa);
            }

            //verifica si tiene multas
            if (vehiCliente.getMultas().isEmpty()) {
                System.out.println("Ud no posee multas");
                return;
            }

            valorPagar = vehiCliente.getValor(); //Valor a pagar por multas

            System.out.println("Valor a pagar: " + valorPagar);
            pago = new Pago(cliente, valorPagar, 'E', valorPagar, fecha, "Multa");
            
            //Obteniendo la lista del indices para luego ser borrado
            for(Multa multa: Sistema.listaMultlas){
                if(vehiCliente.getMultas().contains(multa)){
                    indexMultas.add(Sistema.listaMultlas.indexOf(multa));
                }
            }
            
        } else {

            //Se obtendra la revision
            Revision rev = Revision.getRevision(Sistema.revisiones, cliente);
            int cantidad = Revision.cantidadRevisiones(Sistema.revisiones, cliente.getCedula());

            if (cantidad > 1) {
                System.out.println("Ud posse mas  de una revision");
                placa = pedirPlaca();
                rev = Revision.getRevision(Sistema.revisiones, placa);

            }

            //Verificar si existe alguna revision
            if (rev == null) {
                System.out.println("Ud no posee una revision en estos momentos");
                return;
            }

            valorPagar = cliente.valorPagar(rev.getPlaca());
            System.out.println("El valor a pagar es: " + valorPagar);
            pago = new Pago(cliente, rev, valorPagar, 'E', valorPagar, fecha, "Revision");
            indexRevision = Sistema.revisiones.indexOf(rev); //indice para eliminar la revision
            
        }
        valorPagarTotal = valorPagar;

        System.out.println("""
                           ¿Que Modo de pago va a usar?
                           1. Efectivo
                           2. Tarjeta de credito
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
            return; //No existe datos a pagar, por lo tanto se retorna
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

       
        pago.addPago(); //Se Resgitra el pago
        
        if(opcionPagar == 1){
            //Se borraran las mulas
            //Como son varias multa se ira borrando una por una de mayor a menor
            //para que no haya conflicto entre sus indices cuando se ajusten
            System.out.println(indexMultas.size());
            for(int i=indexMultas.size()-1; i>=0; i--){
                Sistema.removeMulta((int)indexMultas.get(i));
                Sistema.listaMultlas.remove((int)indexMultas.get(i));
            }
        }else{
            //Se borraran las revisiones
            Sistema.removeRevisiones(indexRevision);
            Sistema.revisiones.remove(indexRevision);
            
        }

    }

    private String pedirPlaca() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Porfavor ingrese su placa: ");
        String placa = entrada.nextLine();

        return placa;
    }

}
