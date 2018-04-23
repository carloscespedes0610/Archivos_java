/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos_Binarios;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cespe
 */
public class Persona{
    private int ci;
    private String nombre;
    private int edad;
    
    static final int limite_cantidad_caracteres_nombre=5;
    
    /* ci=4 + 
       limite_cantidad_caracteres_nombre+2 
        ("+2 porque en esos 2 bytes guarda la longitud de cadena del nombre ") 
       + edad=4
    */
    static final int limite_byte_total_persona=4+(limite_cantidad_caracteres_nombre+2)+4;
    
    
    
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
    
    public byte[] toBytes(){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            // cortamos a una longitud fija
            if(this.nombre!=null && this.nombre.length()>=limite_cantidad_caracteres_nombre){
                this.nombre = this.nombre.substring(0, limite_cantidad_caracteres_nombre); //2
            }
            dos.writeInt(ci);
            dos.writeUTF(nombre);
            dos.writeInt(edad);
            dos.close();
            baos.close();
            
            return baos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void cargar(byte[] array){
        this.ci=this.edad=0;
        this.nombre="";
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(array);
            DataInputStream dis = new DataInputStream(bais);
            this.ci = dis.readInt();
            this.nombre = dis.readUTF();
            this.edad = dis.readInt();
        } catch (IOException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Persona> cargar_varios(byte[] array ){
        List<Persona> personas =new ArrayList<>();
        ByteArrayInputStream bais;
        DataInputStream dis;
        
        //int limite=4+4+4;
        int incrementador=0;
        
        while(incrementador<array.length){
            try {
                bais=new ByteArrayInputStream(array, incrementador, incrementador+limite_byte_total_persona);
                dis=new DataInputStream(bais);
                Persona p=new Persona();
                int ci =dis.readInt();
                String nom=dis.readUTF();
                int edad= dis.readInt();
                /*
                    validamos si es un objeto existente, por ahi es solo datos vacios en el array
                */
                p.setCi(ci);
                p.setNombre(nom);
                p.setEdad(edad);
                
                
                if(ci==0&&nom.equals("")&&edad==0){
                    break;
                }else{
                    personas.add(p);
                }
                
                incrementador=incrementador+limite_byte_total_persona;
            } catch (IOException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        
        if(personas.size()<1){
            return null;
        }
        
        return personas;
    }
}
