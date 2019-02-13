/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt3.db4o.qbe;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/**
 *
 * @author dios
 */
public class Pt3Db4oQBE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ObjectContainer db = null;
        Pelicula peli = null;
        Album album = null;
        Videojoc joc = null;

        try {
            // Obrim o creem el fitxer qbe.yap
            db = Db4oEmbedded.openFile("qbe.yap");
            // Fiquem 2 pelicules dins de la base de dades
            db.store(new Pelicula("El señor de los anillos", "29 de juliol de 1954", 99887766, 834848));
            db.store(new Pelicula("Piratas del caribe", "14 d’agost de 2003", 55554444, 11234));
            
    
            // Fiquem dos albums dins de la base de dades.
            db.store(new Album("Gaia", "Mago de oz", new String[]{"Obertura MDXX", "Gaia", "La conquista",
                "Alma", "La costa del silencio", "El árbol de la noche triste", "La rosa de los vientos",
                "La leyenda de la Llorona", "Van a rodar cabezas", "El atrapasueños", "Si te vas", "La venganza de Gaia"}, 72));
            db.store(new Album("Dawn of Victory", "Rhapsody of fire", new String[]{"Lux Triumphans", "Dawn of Victory",
                 "Triumph for my Magic Steel", "The Village of Dwarves", "Dargor, Shadowlord of the Black Mountai",
                 "The Bloody Rage of the Titans", "Holy Thunderforce", "Trolls in the Dark", "The Last Winged Unicorn",
                "The Mighty Ride of the Firelord"}, 53));

            // Fem una queryByExample amb un exemple de "null". Aixo fara que ens retorne tots els objectes de la base de dades
            
            ObjectSet set = db.queryByExample(null);
            System.out.println("Tots els objectes de la BD:");
            while (set.hasNext()) {
                // Un cop ja els tinguessim, si son instancies de la classe "Pelicula", els farem un cast a pelicula, i els mostrarem per pantalla amb el seu metode toString
                Object objecte = set.next();
                if (Pelicula.class.isInstance(objecte)) {
                    System.out.println((Pelicula) objecte);
                }
                // Aqui el mateix pero per a albums
                if (Album.class.isInstance(objecte)) {
                    System.out.println((Album) objecte);
                }

            }
            // Busquem i mostrem totes les películes, passant com a exemple per a la query la classe Pelicula
            set = db.queryByExample(Pelicula.class);
            System.out.println("\n\n\n--------------------------------------\n\n\nTotes les pel·lícules de la BD:");
            while (set.hasNext()) {
                peli = (Pelicula) set.next();

                if (peli != null) {
                    System.out.println(peli.toString());

                }

            }
            // Igual pero para albums
            set = db.queryByExample(Album.class);
            System.out.println("\n\n\n--------------------------------------\n\n\nTots els albums de la BD:");
            while (set.hasNext()) {
                album = (Album) set.next();

                if (album != null) {
                    System.out.println(album.toString());

                }

            }
            
            // Aqui busquem les pelicules anomenades "El señor de los anillos".
            // Para fer aixo, donem d'exemple un objecte Pelicula amb un nom "El señor de los anillos"
            set = db.queryByExample(new Pelicula("El señor de los anillos"));
            System.out.println("\n\n\n--------------------------------------\n\n\nTots les peliqules que es diuen \"El señor de los anillos\" de la BD:");
            while (set.hasNext()) {
                peli = (Pelicula) set.next();

                if (peli != null) {
                    System.out.println(peli.toString());

                }

            }

             
            // Creem un nou joc, i el fiquem a la base de dades.
            // El primer joc, tindra un valor a "Durada" diferent del per defecte.
            // El segon utilitzara el valor per defecte
            joc = new Videojoc();
            joc.setDurada(234);
            joc.setNom("Pacman");
            db.store(joc);
            joc = new Videojoc();
            joc.setNom("Tetris");
            db.store(joc);
            
            joc = new Videojoc();
            joc.setDurada(0); // Fiquem que la durada de l'objecte d'exemple sigui 0 per a que no filtre.
            set = db.queryByExample(joc);
            System.out.println("\n\n\n--------------------------------------\n\n\nVideojocs de la base de dades:");
            while (set.hasNext()) {
                // Busquem tots els jocs i els mostrem
                joc = (Videojoc) set.next();

                if (joc != null) {
                    System.out.println(joc.toString());

                }

            }

            
            
            db.close();

        } catch (Exception e) {
            System.out.println("Error!: \n" + e);
        } finally {
            if (db != null) {
                db.close();
            }

        }
    }

}
