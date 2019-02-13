/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat6;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dios
 */
public class TresParaules {

    public static String eliminarCaractersMolestos(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[èé]", "e");
        s = s.replaceAll("[üú]", "u");
        s = s.replaceAll("[íï]", "i");
        s = s.replaceAll("[àá]", "a");
        s = s.replaceAll("[óò]", "o");
        s = s.replaceAll("[.]", "");
        return s;
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        System.out.println("Disme un text");
        String text = ent.nextLine();
        
        StringBuilder textResultat = new StringBuilder(eliminarCaractersMolestos(text));
        
        
        Pattern patro = Pattern.compile("[\\w]+");
        Matcher text_a_buscar = patro.matcher(textResultat);
       
        StringBuilder textAComparar = new StringBuilder();
        
        int count = 0;
        while (text_a_buscar.find()) {
            if (count < 3) {

                textAComparar.insert(0, (text_a_buscar.group() + " "));
                count++;
            }
        }
        
        int longitut = textAComparar.length();
        
        StringBuilder finalText = new StringBuilder();
        
        for (int i = 0; i < longitut; i++) {
            finalText.append(textResultat.charAt(textResultat.length() - i - 1));
        }
    
        if (finalText.toString().trim().equals(textAComparar.reverse().toString().trim())) {
            System.out.println("El text compleix el patró!");
        } else {
            System.out.println("El text NO compleix el patró");
        }

    }
}
