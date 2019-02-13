/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasortida;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 *
 * @author profe
 */
public class EscriureObjecte {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ClaseProva o = new ClaseProva();
        Scanner ent = new Scanner(System.in);

        //Demano dades a l'usuari usant l'Scanner
        System.out.println("Introduix un enter:");
        int i = ent.nextInt();
        o.setCampEnter(i);
        o.setCampReal(i * 2);

        File fitxer = new File("datos.dat");
        ObjectOutputStream out = null;
        try {
            if (fitxer.exists()) {
                out = new AppendingObjectOutputStream(new FileOutputStream(fitxer, true));
            } else {
                out = new ObjectOutputStream(new FileOutputStream(fitxer, true));
            }
            out.writeObject(o);
        } catch (IOException ex) {
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                }
            }
        }

        //Lectura del fitxer
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fitxer)));

        try {
            while (true) {
                ClaseProva p = (ClaseProva) in.readObject();
                
                System.out.println(p);
            }
        } catch (EOFException e) {
        } finally {
            if (in != null) {
                in.close();
            }
        }

    }

}

class AppendingObjectOutputStream extends ObjectOutputStream {

    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}
