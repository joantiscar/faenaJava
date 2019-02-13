/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dios
 */
public class PalindromExpReg {

    public static String eliminarCaractersMolestos(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[èé]", "e");
        s = s.replaceAll("[üú]", "u");
        s = s.replaceAll("[íï]", "i");
        s = s.replaceAll("[àá]", "a");
        s = s.replaceAll("[óò]", "o");
        s = s.replaceAll("[,.\\s]", "");
        return s;
    }

    public static void main(String[] args) {
        
        Scanner ent = new Scanner(System.in);
        System.out.println("Disme un text");
        String text = ent.nextLine();
        Pattern patro = Pattern.compile("(.)(.*)\\1");
        Matcher text_a_buscar = patro.matcher(text);
        int posicio = 0;
        while (posicio != -1) {
            text_a_buscar.find();
            System.out.println(text_a_buscar.group());
        }
        
       
//        StringBuilder textResultat = new StringBuilder(eliminarCaractersMolestos(text));
//        if (textResultat.toString().equals(textResultat.reverse().toString())) {
//            System.out.println("El text és un palíndrom!");
//        }else{
//            System.out.println("El text NO és un palíndrom");
//        }

    }
}
