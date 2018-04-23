/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos_texto;

/**
 *
 * @author cespe
 */
public class Estudiante {
    private String cedula;
	private String nombres;
	private String apellidos;
	private String telefono;

    public Estudiante() {
    }

    public Estudiante(String cedula, String nombres, String apellidos, String telefono) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }
    
    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
        
    public String concatenar_para_escritura(){
        return cedula+","+nombres+","+apellidos+","+telefono+"\n";
    }

    @Override
    public String toString() {
        return "cedula: "+cedula+"; nombres:"+nombres+" "+apellidos+"; telefono: "+telefono;
    }
    
    
    
}
