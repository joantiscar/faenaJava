/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat2;

import java.util.Arrays;

/**
 *
 * @author dios
 */
public class ProvaMetodeSetAll {

    static int provaGenerador(int valor, int multiplicador) {

        return valor * multiplicador - 23;
    }

    public static void main(String[] args) {

        int[] array1 = new int[5];
        array1[0] = 4;
        array1[2] = 1;
        array1[4] = 2341;
        System.out.println("Array original: \n" +Arrays.toString(array1));
        Arrays.setAll(array1, (index) -> 2 + index);
        System.out.println("Array anterior amb el setAll per a transformar els valors de cada casella, en la posicio de la casella + 2:\n" +Arrays.toString(array1));
        Arrays.setAll(array1, (index) -> 2 * index);
       System.out.println("Array anterior amb el setAll per a transformar els valors de cada casella, en la posicio de la casella * 2:\n" +Arrays.toString(array1));
        Arrays.setAll(array1, (index) -> provaGenerador(array1[index], 5));
        System.out.println("Array anterior amb el valor de les caselles, sent el seu valor anterior, multiplicat per 5, i restantli 23:\n" +Arrays.toString(array1));
        Arrays.setAll(array1, (index) -> 5);
        System.out.println("Array anterior, amb tots els valors convertits en el numero 5:\n" +Arrays.toString(array1));
    }
}
