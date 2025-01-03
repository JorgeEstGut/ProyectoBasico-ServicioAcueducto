/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.FileWriter;
import java.io.IOException;
import modelo.Facturas;

public class Cfacturas {
    public void Registrar(Facturas nueva) throws IOException{
    String ruta ="baseDatos/facturas/Facturas.txt";
        try (FileWriter BaseDeDatos = new FileWriter(ruta,true)) {
            BaseDeDatos.append(nueva.getNroPoliza()+"::"+nueva.getFecha()+"::"+nueva.getValor()+"\r\n");
        }
    }
}
