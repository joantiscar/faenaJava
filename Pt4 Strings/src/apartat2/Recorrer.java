/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat2;

import java.util.Scanner;

/**
 *
 * @author dios
 */
public class Recorrer {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        int anteriorPosicio = 0;
        
        System.out.println("Introdueix un text:");
        String text = ent.nextLine();
        System.out.println("Introdueix un caracter a buscar dins del text:");
        char caracter = ent.nextLine().charAt(0);
        System.out.println("Vols distingir entre majuscules i minuscules? (Si/No)");
        char majuscules = ent.nextLine().charAt(0);
        System.out.println("En quin ordre busco (1. esquerra a dreta, 2. dreta a esquerra)?:");
        int direccio = ent.nextInt();
        if(majuscules == 'n' || majuscules == 'N') text = text.toLowerCase();
        if (direccio == 2) {
            anteriorPosicio = text.length();
             if (text.lastIndexOf(caracter) == -1){
                 System.out.println("El carcater \"" +caracter +"\" no esta al text");
             }else{
                 System.out.print("El carcater \"" +caracter +"\" es troba a les posicions: ");
             }
            do {
                anteriorPosicio = text.lastIndexOf(caracter, anteriorPosicio);
               
                if (anteriorPosicio == -1) break;
                System.out.print(anteriorPosicio + ", ");
                anteriorPosicio--;
                
            } while (true);
            
        }
        if (direccio == 1) {
            if (text.indexOf(caracter) == -1) {
                System.out.println("El carcater \"" +caracter +"\" no esta al text");
            }else{
                System.out.print("El carcater \"" +caracter +"\" es troba a les posicions: ");
            }
            do {
                anteriorPosicio = text.indexOf(caracter, anteriorPosicio);
               
                if (anteriorPosicio == -1) break;
                System.out.print(anteriorPosicio +", ");
                anteriorPosicio++;
                
            } while (true);
        }
        
        
    }
}
