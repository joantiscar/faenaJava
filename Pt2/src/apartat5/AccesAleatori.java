/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat5;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author dios
 */
public class AccesAleatori {

    public static void main(String[] args) throws FileNotFoundException, IOException {
    
       Scanner ent = new Scanner(System.in);
        System.out.println("Disme la posició que vols consultar");
        int posicio = ent.nextInt() * 8;
     
        try ( RandomAccessFile fitxer = new RandomAccessFile("aleatori.dat", "rw")) {
  
            fitxer.seek(0);
            fitxer.seek(posicio);
            long resultat = fitxer.readLong();
            
 
            System.out.println("El long a la posicio " + posicio /8 +" és: " + resultat);
        } catch (Exception e) {
       
            System.out.println("Aquesta posició es incorrecta");
        }

    }
}
