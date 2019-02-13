/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat3;

import java.io.FileInputStream; 
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;

/**
 *
 * @author dios
 */
public class LligStreamDades {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DataInputStream in = null;

        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("dades.dat")));
            while (true) {
                System.out.println("Nom: " + in.readUTF());
                System.out.println("Cognom: " + in.readUTF());
                System.out.println("Edat: " + in.readInt());
                System.out.println("Pes: " + in.readFloat());
                System.out.println("Alçada: " + in.readFloat());
                System.out.println("Sexe: " + in.readChar());
                System.out.println("Te carnet: " + in.readBoolean());
            }
        } catch (EOFException e) {
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

}
