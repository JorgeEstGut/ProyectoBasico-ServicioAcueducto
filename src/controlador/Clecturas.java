/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.FileWriter;
import java.io.IOException;
import modelo.Lecturas;


public class Clecturas {
    public void Registrar(Lecturas nueva) throws IOException{
    String ruta ="Lecturas.txt";
        try (FileWriter BaseDeDatos = new FileWriter(ruta,true)) {
            BaseDeDatos.append(nueva.getNroReferencia()+"::"+nueva.getLecturaAnterior()+"::"+nueva.getLecturaActual()+"::"+nueva.getFecha()+"\r\n");
        }
    }
}
