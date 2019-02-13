/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat2;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author dios
 */
public class Buscar {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);

        System.out.println("Introdueix un text:");
        String text = ent.nextLine();
        System.out.println("Introdueix un altre text a buscar dins del text:");
        String text2 = ent.nextLine();

        Pattern patro = Pattern.compile(text2);
        Matcher text_a_buscar = patro.matcher(text);
        boolean trobat = false;
        System.out.println("Posicions: ");
        while (text_a_buscar.find()) {
            System.out.print(text_a_buscar.start()+1 + ", ");
            trobat = true;
        }
        if (!trobat) {
            System.out.println("No se ha trobat el text " + text2);
        }
    }
}
