/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos_texto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cespe
 */
public class Archivos_Texto {
    static final String direccion_archivo="archivo_texto.txt";

    public Archivos_Texto() {
    }
    
    public static List<Estudiante> leer_con_scanner(){
        File file=new File(direccion_archivo);
        List<Estudiante> estudiantes =new ArrayList<>();
        try {
            Scanner scanner =new Scanner(file);
            while(scanner.hasNextLine()){
                String linea= scanner.nextLine();
                Scanner delimitar=new Scanner(linea);
                delimitar.useDelimiter("\\s*,\\s*");
                Estudiante e = new Estudiante();
                e.setCedula(delimitar.next());
                e.setNombres(delimitar.next());
                e.setApellidos(delimitar.next());
                e.setTelefono(delimitar.next());
                estudiantes.add(e);
            }
            scanner.close();
            return estudiantes;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos_Texto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    
    public void escribir_Buffer(List<Estudiante> estudiantes){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter;
        File file =new File(direccion_archivo);
        
        try {
            fileWriter=new FileWriter(file);
            bufferedWriter=new BufferedWriter(fileWriter);
            
            for (int i = 0; i < estudiantes.size(); i++) {
                Estudiante get = estudiantes.get(i);
                bufferedWriter.write(get.concatenar_para_escritura());
            }
            
            bufferedWriter.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Archivos_Texto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fileWriter != null) {
                try {//cierra el flujo principal
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
