/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos_Binarios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cespe
 */
public class Archivos_Binarios {

    public Archivos_Binarios() {
    }
    
    public void escribir_con_buffer(){
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        File file =new File("ficheroBinarioBuffer.bin");
        
        try {
            fileOutputStream=new FileOutputStream(file);
            bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            byte[] array=new byte[1024];
            
            /*
            el nombre debe ser igual o mayor a 5 de longitud porque esa es
            el limite_cantidad_caracteres_nombre=5, hay que mejorar eso
            ya que si es menor a 5 se deberia rellenar con un caracter especial
            y luego al leer se leeran 5 caracteres, si el nombre era de menor
            longitud, se obtendran con esos caracteres de relleno, pero ahi se
            los puede filtrar
            */
            
            Persona p =new Persona(52, "transsdasdd", 25); // 
            array=p.toBytes();
            bufferedOutputStream.write(array);
            
            p =new Persona(21, "martaffgsd", 85);
            array=p.toBytes();
            bufferedOutputStream.write(array);
            
            
            p =new Persona(9, "joseasdas", 74);
            array=p.toBytes();
            bufferedOutputStream.write(array);
            
            p =new Persona(95, "doraasdas", 15);
            array=p.toBytes();
            bufferedOutputStream.write(array);
            
            bufferedOutputStream.close();
            fileOutputStream.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos_Binarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivos_Binarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void leer_con_buffer(){
        try {
            FileInputStream fileInputStream;
            BufferedInputStream bufferedInputStream;
            File file=new File("ficheroBinarioBuffer.bin");
            
            fileInputStream =new FileInputStream(file);
            bufferedInputStream=new BufferedInputStream(fileInputStream);
            
            byte[] array = new byte[1000];
            
            int limite = 4+50+4;  // del ci + 25 de nombre(2byte *25) + edad
            
            int limite_peq=4+6+4;
            int leidos = bufferedInputStream.read(array); //nombre = 3 *2 =6
            
            Persona p =new Persona();
            
            List<Persona> personas=Persona.cargar_varios(array);
            
            for (int i = 0; i < personas.size(); i++) {
                Persona get = personas.get(i);
                System.out.println(get.toString());
                System.out.println("*****************");
            }
            
            /*
            while(leidos>0){
                
                p.cargar(array);
                
                System.out.println(p.toString());
                System.out.println("********************");
                
                leidos=bufferedInputStream.read(array,leidos+1,leidos*2);
                
            }*/
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos_Binarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivos_Binarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void escribir(){
        try {
            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;
            File file =new File("ficherobinario.bin");
            
            fileOutputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            
            Persona per=new Persona(6311,"carlos", 28);
            objectOutputStream.writeObject(per);
            
            Persona per2=new Persona(6311,"maurio", 28);
            objectOutputStream.writeObject(per2);
            
            Persona per3=new Persona(6311,"luis", 28);
            objectOutputStream.writeObject(per3);
            
            Persona per4=new Persona(6311,"erika", 28);
            objectOutputStream.writeObject(per4);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos_Binarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivos_Binarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void leer(){
        try {
            File file;
            FileInputStream fileInputStream;
            ObjectInputStream objectInputStream;
            
            
            file=new File("ficherobinario.bin");
            fileInputStream=new FileInputStream(file);
            
            objectInputStream=new ObjectInputStream(fileInputStream);
            
            while (true) {
                Object dato = objectInputStream.readObject();

                Persona per = (Persona) dato;
                System.out.println("*******************");
                System.out.println(per);
            }

        } catch (FileNotFoundException ex) {
          //  Logger.getLogger(Archivos_Binarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
         //   Logger.getLogger(Archivos_Binarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
