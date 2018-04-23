/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import Archivos_Binarios.Archivos_Binarios;
import Archivos_texto.Archivos_Texto;
import Archivos_texto.Estudiante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cespe
 */
public class Archivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       //Archivos_Binarios ab=new Archivos_Binarios();
       //ab.escribir_con_buffer();
       //ab.leer_con_buffer();
       Archivos_Texto archivos_Texto=new Archivos_Texto();
       List<Estudiante> lis=new ArrayList<>();
       lis.add(new Estudiante("5255", "carlos alberto", "cespedes soliz", "75578558"));
       lis.add(new Estudiante("7548", "ronal mauricio", "cespedes soliz", "75348557"));
       lis.add(new Estudiante("4125", "erika", "morales", "70015643"));
        
       archivos_Texto.escribir_Buffer(lis);
       lis=null;
       
       lis=Archivos_Texto.leer_con_scanner();
        for (int i = 0; i < lis.size(); i++) {
            Estudiante get = lis.get(i);
            System.out.println(get);
        }
    }
    
}
