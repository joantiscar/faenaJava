/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proves;

import java.util.Arrays;

/**
 *
 * @author dios
 */
public class PROVES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        String text1 = "La llamada de la jungla";
        String text2 = "la";
        System.out.println(Arrays.toString(buscaAparicions(text1, text2)));

    }
    
    public static int[] buscaAparicions(String text1, String text2){
        
        
        
        
        int contador = 0;
        int posicio = 0;
        while(posicio > -1){
            posicio = text1.indexOf(text2, posicio+1);
            if (posicio > -1) contador++;
        }
        
       int[] resultat = new int[contador]; 
        
       posicio = 0;
       while(posicio > -1){
           
           posicio = text1.indexOf(text2, posicio+1);
           if (posicio > -1){
                contador--;
               resultat[contador] = posicio;

           }
            
        }
       
        return resultat;
    }
    
}
