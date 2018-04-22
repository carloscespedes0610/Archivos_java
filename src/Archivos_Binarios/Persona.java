/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos_Binarios;

import java.io.Serializable;

/**
 *
 * @author cespe
 */
public class Persona implements Serializable{
    private int ci;
    private String nombre;
    private int edad;
    
    
    private static final long serialVersionUID=1;

    public Persona() {
    }
    
    

    public Persona(int ci, String nombre, int edad) {
        this.ci = ci;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "ci: "+ci+"; nombre: "+nombre+"; edad: "+edad;
    }
    
    
    
}
