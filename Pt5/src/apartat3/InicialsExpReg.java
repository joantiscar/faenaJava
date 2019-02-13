/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dios
 */
public class InicialsExpReg {
    public static void main(String[] args) {
         Scanner ent = new Scanner(System.in);
        System.out.println("Disme un text, i et dire les inicials de cada paraula");
        String text = ent.nextLine();
        Pattern patro = Pattern.compile("\\b.{1}");
        Matcher text_a_buscar = patro.matcher(text);
        System.out.println("Inicials: ");
        while (text_a_buscar.find()) {
            System.out.print(text_a_buscar.group() + ", ");
            text_a_buscar.find();
        }
 
        }
    }
