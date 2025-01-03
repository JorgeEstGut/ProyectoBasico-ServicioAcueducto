/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jega_
 */
public class Cliente {
    private int Nroreferencia;
    private long Cedula;
    private String Nombres;
    private String Apellidos;
    private String Municipio;
    private String Barrio;
    private String Sexo;
    private int Estrato;

    public Cliente(int Nroreferencia, long Cedula, String Nombres, String Apellidos, String Municipio, String Barrio, String Sexo, int Estrato) {
        this.Nroreferencia = Nroreferencia;
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Municipio = Municipio;
        this.Barrio = Barrio;
        this.Sexo = Sexo;
        this.Estrato = Estrato;
    }

    public int getNroreferencia() {
        return Nroreferencia;
    }

    public void setNroreferencia(int Nroreferencia) {
        this.Nroreferencia = Nroreferencia;
    }

    public long getCedula() {
        return Cedula;
    }

    public void setCedula(long Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public String getBarrio() {
        return Barrio;
    }

    public void setBarrio(String Barrio) {
        this.Barrio = Barrio;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public int getEstrato() {
        return Estrato;
    }

    public void setEstrato(int Estrato) {
        this.Estrato = Estrato;
    }
    
    
    
}
