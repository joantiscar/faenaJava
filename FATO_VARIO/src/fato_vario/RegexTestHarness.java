/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fato_vario;

/**
 *
 * @author dios
 */
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class RegexTestHarness {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.println("Introduix una expressió regular (buida per acabar): ");
            String regex = console.nextLine();
            if (regex.isEmpty()) break;
            
            Pattern pattern=null;
            try{
                pattern  = Pattern.compile(regex);
            }catch(PatternSyntaxException e){            
                System.out.println("Error a l'expressió regular: "+e.getDescription()+"\nTorna-ho a provar.");
                continue;
            }
            
            while (true) {
                System.out.println("Introduix el text on buscar (buit per canviar d'expressió regular): ");
                String text = console.nextLine();
                if (text.isEmpty()) {
                    break;
                }
                Matcher matcher
                        = pattern.matcher(text);
                boolean found = false;
                while (matcher.find()) {
                    System.out.format("He trobat el text"
                            + " \"%s\" que comença a "
                            + "l'índex %d i finalitza a l'índex %d.%n",
                            matcher.group(),
                            matcher.start(),
                            matcher.end());
                    found = true;
                }
                if (!found) System.out.format("No s'han trobat coincidències.%n");                
            }
        }
    }
}