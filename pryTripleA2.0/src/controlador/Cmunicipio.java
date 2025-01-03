/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.FileWriter;
import java.io.IOException;
import modelo.Municipio;

/**
 *
 * @author usuario_RCUL82
 */
public class Cmunicipio {
    public void Registrar(Municipio nueva) throws IOException{
    String ruta ="baseDatos/lugares/municipios/Municipios.txt";
        try (FileWriter BaseDeDatos = new FileWriter(ruta,true)) {
            BaseDeDatos.append(nueva.getMunici()+"\r\n");
        }
    }
}
