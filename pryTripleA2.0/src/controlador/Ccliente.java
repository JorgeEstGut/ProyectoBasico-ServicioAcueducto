/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.FileWriter;
import java.io.IOException;
import modelo.Cliente;

public class Ccliente {
    public void Registrar(Cliente nueva) throws IOException{
    String ruta ="Clientes.txt";
        try (FileWriter BaseDeDatos = new FileWriter(ruta,true)) {
            BaseDeDatos.append(nueva.getNroreferencia()+"::"+nueva.getCedula()+"::"+
                    nueva.getNombres()+"::"+nueva.getApellidos()+"::"+nueva.getBarrio()+"::"+
                    nueva.getMunicipio()+"::"+nueva.getSexo()+"::"+nueva.getEstrato()+"\r\n");
        }
    }
}
