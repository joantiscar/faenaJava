/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat1;

import java.io.FileInputStream;

/**
 *
 * @author dios
 */
public class ExcepcionsNoTractades {
    public static void main(String[] args) {
        
        FileInputStream f = null;
        f = new FileInputStream("/home/dios/fitxerExemple.txt"); 
       
	f.close(); 	
        
        
        
         int[] vector = new int[3];
        System.out.println(vector[4]);
    }
}
