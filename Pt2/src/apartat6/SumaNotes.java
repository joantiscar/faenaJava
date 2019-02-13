/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat6;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author dios
 */
public class SumaNotes {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        DataInputStream in = null;
        int alumnes = 0;
        int aprovats = 0;
        int alumnes10 = 0;
        int alumnes0 = 0;
        int notesTotal = 0;
        Scanner ent = null;
        try {
            ent = new Scanner(new BufferedReader(new FileReader("notes.txt")));
            ent.useDelimiter("\\s-[\\s]*");
            while (ent.hasNext()) {
                String valor = ent.next().trim();
                int notaActual = 0;
                 try{
                     notaActual= Integer.parseInt(valor);
                     alumnes++;
                 if (notaActual>=5)aprovats++;
                 if(notaActual == 10) alumnes10++;
                 if(notaActual == 0) alumnes0++;
                 notesTotal = notesTotal+notaActual;
                } catch (java.lang.NumberFormatException e){
                     
                     System.out.println("Nota incorrecta " + valor + "!!!!");
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
            System.out.println("Total d'alumnes: " +alumnes);
            System.out.println("Percentatge d'aprovats: " +((aprovats*100)/alumnes));
            System.out.println("Percentatge de suspesos: " +(100-(aprovats*100)/alumnes));
            System.out.println("Total de deus: " +alumnes10);
            System.out.println("Total de zeros: " +alumnes0);
            System.out.println("Nota mitja: " +(float)notesTotal/alumnes);
        }
    }
}
