/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat7;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author dios
 */
public class LoPantanoEsDeLaSenia {

    public static void main(String[] args) {
        double valor = 0;
        char format;
        Scanner ent = new Scanner(System.in);
        System.out.println("Vols fer servir el format americà (u) o el format europeu (e)?");
        format = ent.nextLine().charAt(0);
        if (format == 'u') ent.useLocale(Locale.US);
        if (format == 'e') ent.useLocale(Locale.FRANCE);
        do {
            try{
            System.out.println("\nDisme un numero");
            valor = ent.nextDouble();
            if (format == 'u') System.out.format(Locale.US,"%+025.05f", valor);
            if (format == 'e') System.out.format(Locale.FRANCE,"%+025.05f", valor);
            }catch(Exception e){
                System.out.println("Has introduit algo mal");
                ent.next();
            }
            
        } while (valor != 0);
        System.out.println("Adeu");
    }

}
