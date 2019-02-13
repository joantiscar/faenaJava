/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat4;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author dios
 */
public class LligStreamObjectes {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
         ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new
                    BufferedInputStream(new FileInputStream("objectes.dat")));
            try {
                int cont = 1;
                while (true) {
                    
                   
                    Persona c = (Persona) in.readObject();
                    System.out.println("Persona " +cont +":\n" +c +"\n");
                   cont++;
                }
            } catch (EOFException e) {}
        } finally {
            if(in!=null) in.close();
        }

    }
}
