/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat3;

/**
 *
 * @author dios
 */
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EscriuStreamDades {

    public static void main(String[] args) throws IOException {
        Scanner ent = new Scanner(System.in);
        System.out.println("Disme el teu nom");
        String nom = ent.nextLine();
        System.out.println("Disme els teus cognoms");
        String cognom = ent.nextLine();
        System.out.println("Disme la teva edat");
        int edat = ent.nextInt();
        System.out.println("Disme el teu pes");
        float pes = ent.nextFloat();
        System.out.println("Disme la teva alçada");
        float alçada = ent.nextFloat();
        System.out.println("Disme el teu sexe (m/f)");
        ent.nextLine();
        char sexe = ent.nextLine().charAt(0);
        System.out.println("Tens canet de conduir? (s/n)");
        char te_carnet = ent.nextLine().charAt(0);

        boolean carnet = false;
        if (te_carnet == 's') {
            carnet = true;
        }
        DataOutputStream out = null;

        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("dades.dat")));

            out.writeUTF(nom);
            out.writeUTF(cognom);
            out.writeInt(edat);
            out.writeFloat(pes);
            out.writeFloat(alçada);
            out.writeChar(sexe);
            out.writeBoolean(carnet);

        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

}
