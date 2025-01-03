/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.FileWriter;
import java.io.IOException;
import modelo.Tarifas;

public class Ctarifas {
    public void Registrar(Tarifas nueva, String a) throws IOException{
    String ruta ="baseDatos/tarifas/"+a+".txt";
        try (FileWriter BaseDeDatos = new FileWriter(ruta)) {
            BaseDeDatos.write(nueva.getEst1()+"::"+nueva.getVal1()+"\n"+nueva.getEst2()+"::"+nueva.getVal2()+"\n"+nueva.getEst3()+"::"+nueva.getVal3()+"\n"+nueva.getEst4()+"::"+nueva.getVal4()+"\n"+nueva.getEst5()+"::"+nueva.getVal5()+"\n"+nueva.getEst6()+"::"+nueva.getVal6());
        }
    }
}
