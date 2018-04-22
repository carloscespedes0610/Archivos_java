/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos_Binarios;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cespe
 */
public class Archivos_Binarios {

    public Archivos_Binarios() {
    }
    
    public void escribir(){
        try {
            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;
            File file =new File("ficherobinario.bin");
            
            fileOutputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            
            Persona per=new Persona(6311,"carlos", 28);
            System.out.println("per: "+per);
            objectOutputStream.writeObject(per);
            
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
            
//            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
            
            Object dato=objectInputStream.readObject();
            
            Persona per=(Persona) dato;
            
            System.out.println(per);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos_Binarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Archivos_Binarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
