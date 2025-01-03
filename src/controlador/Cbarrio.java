/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.FileWriter;
import java.io.IOException;
import modelo.Barrio;

/**
 *
 * @author jega_
 */
public class Cbarrio {
    public void Registrar(Barrio nueva, String a) throws IOException{
        String ruta = "baseDatos/lugares/barrios/" + a +".txt";
        try (FileWriter BaseDeDatos = new FileWriter(ruta, true)) {
            BaseDeDatos.append(nueva.getBarrio()+"\r\n");
        }
    }
}
