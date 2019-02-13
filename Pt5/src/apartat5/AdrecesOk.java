/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dios
 */
public class AdrecesOk {
     public static void main(String[] args) {
       Scanner ent = new Scanner(System.in);

        System.out.println("Introdueix un text:");
        String text = ent.nextLine();


        Pattern patro = Pattern.compile("[\\w]+[@]{1}[\\w]+[.][a-zA-Z]{2,3}[\\s]");
        Matcher mail_valid = patro.matcher(text);
        boolean trobat = false;
        System.out.println("Adreces trobades: ");
        while (mail_valid.find()) {
            
            System.out.println(mail_valid.group());
            trobat = true;
        }
        if (!trobat) {
            System.out.println("No hi ha cap mail valid");
        }
     }
}
