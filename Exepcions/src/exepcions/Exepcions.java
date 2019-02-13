/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exepcions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dios
 */
public class Exepcions {

    public void llançarExepcions() throws FileNotFoundException, IOException {
//        String path="/";
        try (BufferedReader b = new BufferedReader(new InputStreamReader(System.in))){
            int i = -1;
            while(i<0){
                try{  
                    i = Integer.parseInt(b.readLine());
                    if(i<0) throw new java.lang.NumberFormatException();
                }catch(java.lang.NumberFormatException e){
                    System.out.println("Introdueix un numero enter correcte");
                    i = -1;
                }
                }
        }
        
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Exepcions e=new Exepcions();
//        
        e.llançarExepcions();

//        throw new FileNotFoundException();
    }

}
