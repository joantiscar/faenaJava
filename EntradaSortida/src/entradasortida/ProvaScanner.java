/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasortida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author profe
 */
public class ProvaScanner {
    public static void main(String[] args) throws IOException {

        Scanner s = null;
        double sum = 0;
        System.out.format("%f  %1$+010.5f  %2$d %n", Math.PI, 3);
        //System.out.format("%f  %<+020.10f %n", Math.PI);
        try {
            s = new Scanner(new BufferedReader(new FileReader("dades.txt")));
            s.useLocale(Locale.US);
            
            //System.out.println(s.delimiter());

            s.useDelimiter(",");
            while (s.hasNext()) {
                String num=s.next();
                
                
                double d=0.0;
                try{
                    d=Double.parseDouble(num);
                    //System.out.format(Locale.US,"%g %n",d);
                    //System.out.format(Locale.FRANCE,"%g %n",d);
                }catch(java.lang.NumberFormatException e){
                
                    //System.out.println(e.getMessage()+" no és un número correcte!!");
                }
                sum=sum+d;
            }
        } finally {
            s.close();
        }

        //System.out.println(sum);
    }
}
