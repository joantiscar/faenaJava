/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 *
 * @author dios
 */
class AppendingObjectOutputStream extends ObjectOutputStream {

    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}

public class EscriuStreamObjectes {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        Persona p = new Persona();
        System.out.println("Disme el teu nom");
        p.setNom(ent.nextLine());
        System.out.println("Disme els teus cognoms");
        p.setCognom(ent.nextLine());
        System.out.println("Disme la teva edat");
        p.setEdat(ent.nextInt());
        System.out.println("Disme el teu pes");
        p.setPes(ent.nextFloat());
        System.out.println("Disme la teva alçada");
        p.setAlçada(ent.nextFloat());
        System.out.println("Disme el teu sexe (m/f)");
        ent.nextLine();
        p.setSexe(ent.nextLine().charAt(0));
        System.out.println("Tens canet de conduir? (s/n)");
        p.setTe_carnet(ent.nextLine().charAt(0));

        ObjectOutputStream out = null;
        try {
            File fitxer = new File("objectes.dat");
            if (fitxer.exists()) {
                out = new AppendingObjectOutputStream(new FileOutputStream(fitxer, true));
               out.writeObject(p);
                
            } else {
                out = new ObjectOutputStream(new FileOutputStream(fitxer, true));
                 out.writeObject(p);
            }
        } catch (IOException ex) {
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                }
            }
        }

    }
}
