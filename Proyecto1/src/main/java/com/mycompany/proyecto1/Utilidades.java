/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Es una clase que implementa métodos estáticos de utilidades.
 * @author danie
 */
public class Utilidades {
    /**
     * Es un método que permite obtener la información de un fichero
     * @param nombrearchivo archivo que se desea leer
     * @return una lista con las líneas del fichero
     */
    public static ArrayList<String> LeeFichero(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lineas.add(linea);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;

    }
    /**
     * Es un método que pregunta al usuario y retorna la respuesta en tipo String
     * @param mensaje es lo que se desea imprimir
     * @return el dato ingresado por el usuario
     */
    public static String solicitarEntrada(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        String dato= sc.nextLine();
        return dato;
    }
    /**
     * Es un método que recibe un dato y lo agrega en el archivo .txt
     * @param data información que se desea agregar
     */
    public static void escribirFichero(String data){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("archivo.txt", true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
