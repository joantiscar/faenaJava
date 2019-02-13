/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat1;

/**
 *
 * @author dios
 */
public class NumReals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         if(args.length !=0){
          
            for (int i = 0; i < args.length; i++) {
                boolean incorrecte = true;
                if(args[i].matches("[+-]*\\d+")) incorrecte = false;
                if(args[i].matches("[+-]?[\\d]+[\\.]?[\\d]+")) incorrecte = false;
                if (incorrecte == true) {
                    System.out.println(args[i] +" No es un nombre real valid! Ha de ser format nomes de numeros, i si te part decimal, separats amb un punt.");
                }else{
                System.out.println(args[i] +" és un nombre real correcte");
                }
                
            }
        }else{
            System.out.println("No has passat cap parametre!");
        }
    }
    
}
