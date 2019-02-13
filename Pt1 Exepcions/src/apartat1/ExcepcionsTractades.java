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
public class ExcepcionsTractades {
    public static void main(String[] args) {
        
        
         int[] vector = new int[3];
        try{
            System.out.println(vector[4]);
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            System.out.println("Me penso que este vector no es tan gran ");
        }
    }
}
