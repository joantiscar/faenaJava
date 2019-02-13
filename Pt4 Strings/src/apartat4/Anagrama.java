/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author dios
 */
public class Anagrama {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        System.out.println("Disme la primera cadena");
        String cadena1 = ent.nextLine();
        System.out.println("Disme la segona cadena");
        String cadena2 = ent.nextLine();
        cadena1 = cadena1.toLowerCase();
        cadena2 = cadena2.toLowerCase();
        cadena1 = treureSignesPuntuacio(cadena1);
        cadena2 = treureSignesPuntuacio(cadena2);
        char[] array1 = cadena1.toCharArray();
        char[] array2 = cadena2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        if (Arrays.equals(array1, array2)) {
            System.out.println("Els textos son anagrames l'un de l'altre");
        }else{
            System.out.println("Els textos no son anagrames");
        }
    }
    public static String treureSignesPuntuacio(String cadena){
        StringBuilder cadenabuilder = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (Character.isLetter(caracter)) cadenabuilder.append(caracter);
        }
        return cadenabuilder.toString();
    }
}
