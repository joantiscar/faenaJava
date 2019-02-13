/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author dios
 */
public class ExcepcionsCheckedTractades {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        FileInputStream f = null;
        try{
            f = new FileInputStream("/home/dios/fitxerExemple.txt");
            f.close();
        }catch(java.io.FileNotFoundException r){
            System.out.println("El fitxer no existeix");
        } 
       
		
        
    }
}
