/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt5.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 *
 * @author dios
 */
public class Pt5Db4o {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ObjectContainer db = null;
        Album album = null;

        try {
            // Obrim o creem el fitxer qbe.yap
            File file = new File("qbe.yap");
            file.delete();
            db = Db4oEmbedded.openFile("qbe.yap");
            // Fiquem 2 pelicules dins de la base de dades
            album = new Album();
            album.setNom("Ride the Lightning");

            Cancion cancion1 = new Cancion("Fight Fire with Fire", 285, album);
            Cancion cancion2 = new Cancion("Ride the Lightning", 397, album);
            Cancion cancion3 = new Cancion("For Whom the Bell Tolls", 310, album);
            Cancion cancion4 = new Cancion("Fade to Black", 417, album);
            Cancion cancion5 = new Cancion("Trapped Under Ice", 244, album);
            Cancion cancion6 = new Cancion("Escape", 264, album);
            Cancion cancion7 = new Cancion("Creeping Death", 396, album);
            Cancion cancion8 = new Cancion("The Call of Ktulu", 534, album);
            Collection<Cancion> canciones = new ArrayList<Cancion>();
            canciones.add(cancion1);
            canciones.add(cancion2);
            canciones.add(cancion3);
            canciones.add(cancion4);
            canciones.add(cancion5);
            canciones.add(cancion6);
            canciones.add(cancion7);
            canciones.add(cancion8);
            album.setCanciones(canciones);

            db.store(album);
            db.store(cancion1);
            db.store(cancion2);
            db.store(cancion3);
            db.store(cancion4);
            db.store(cancion5);
            db.store(cancion6);
            db.store(cancion7);
            db.store(cancion8);

            ObjectSet set;
            
            set = db.queryByExample(cancion2);

            Cancion cancion_a_modificar = null;
            if (set.hasNext()) {
//                System.out.println((Cancion) set.next());
                cancion_a_modificar = (Cancion) set.next();
                System.out.println("Canço abans de modificar: " + cancion_a_modificar.toString());
                cancion_a_modificar.setNom("Algun altre nom");

                db.store(cancion_a_modificar);

                set = db.queryByExample(cancion_a_modificar);

                if (set.hasNext()) {
                    System.out.println("Canço modificada: " + (Cancion) set.next());
                }
            } else {
                System.out.println("Cançó no trobada!");
            }

            System.out.println("\n\nAra borrarem un objecte de la classe Album");

            db.delete(album);

            set = db.queryByExample(album);

            System.out.println("Album borrat. Ara l'intentarem buscar a la base de dades:");

            if (set.hasNext()) {
                System.out.println("L'album no esta borrat!: " + (Album) set.next());
            } else {
                System.out.println("Album no trobat! S'ha esborrat correctament");

                System.out.println("Ara intentarem mirar els registres de la classe Cancion vinculats a este album");

                set = db.queryByExample(new Cancion(album));

                if (set.hasNext()) {

                    while (set.hasNext()) {
                        Cancion cancion_a_mostrar = (Cancion) set.next();
                        System.out.println(cancion_a_mostrar.toString());
                    }
                } else {
                    System.out.println("Els registres no apareixen si els filtrem per l'album. "
                            + "Ara els buscarem tots, i mirarem si encara estan alli dins.");
                    set = db.queryByExample(new Cancion());
                    while (set.hasNext()) {
                        Cancion cancion_a_mostrar = (Cancion) set.next();
                        System.out.println(cancion_a_mostrar.toString());
                    }
                    System.out.println("Podem vere que les cançons encara estan, pero ja no surt l'album.");
                    System.out.println("Les cançons no han desapareguts, pero ja no estan vinculades a cap album");
                    System.out.println("Imagino que el PostgreSQL fa algo paregut al mysql en els \"on delete set null\"");

                }
            }

            album = new Album();
            album.setNom("Ride the Lightning");

            cancion1 = new Cancion("Fight Fire with Fire", 285, album);
            cancion2 = new Cancion("Ride the Lightning", 397, album);
            cancion3 = new Cancion("For Whom the Bell Tolls", 310, album);
            cancion4 = new Cancion("Fade to Black", 417, album);
            cancion5 = new Cancion("Trapped Under Ice", 244, album);
            cancion6 = new Cancion("Escape", 264, album);
            cancion7 = new Cancion("Creeping Death", 396, album);
            cancion8 = new Cancion("The Call of Ktulu", 534, album);
            db.store(cancion1);
            db.store(cancion2);
            db.store(cancion3);
            db.store(cancion4);
            db.store(cancion5);
            db.store(cancion6);
            db.store(cancion7);
            db.store(cancion8);
            db.store(album);

            System.out.println("\n\n\n\nHe guardat 2 cançons noves i un album que les conté.");
            System.out.println("Tambe creare un parell d'albums mes, per asegurarnos de que les querys nomes retornin aquest.");
            //Collection canciones2 = new ArrayList<>(Arrays.asList(cancion1, cancion2));
            Collection canciones2 = new ArrayList<>();
            canciones2.add(cancion1);
            canciones2.add(cancion2);
            album.setCanciones(canciones2);
            db.store(album);
            album = new Album();
            album.setNom("Algun nom");
            album.setCanciones(new ArrayList<>(Arrays.asList(cancion1)));
            db.store(album);
            album = new Album();
            album.setCanciones(new ArrayList<>(Arrays.asList(cancion2)));
            album.setNom("Algun altre nom");
            db.store(album);

//            set = db.queryByExample(new Album(new ArrayList<>(Arrays.asList(cancion1, cancion2))));
            set = db.query(new Predicate<Album>() {
                @Override
                public boolean match(Album a) {

                    return a.getCanciones().containsAll(canciones2);
                }

            });
            System.out.println("\n\n\nAquest es el resultat de fer la búsqueda de l'album, amb un Predicate i un "
                    + "match fet per a que nomes retorni els albums que tenen les dos cançons anteriors");
            if (set.hasNext()) {

                while (set.hasNext()) {
                    Album album_a_mostrar = (Album) set.next();
                    System.out.println(album_a_mostrar.toString());
                }
            }
            System.out.println("\nPodem vere que nomes ens ha tornat l'album que contenia les dos cançons");

            System.out.println("\n\n\nAra buscarem totes les cançons que durin entre 250 i 300 segons");

            Query q = db.query();

            q.constrain(Cancion.class);
            q.descend("duracio").constrain(300).smaller();
            q.descend("duracio").constrain(250).greater();

            set = q.execute();
            System.out.println("\nI aquest es el resultat de la query:");
            if (set.hasNext()) {

                while (set.hasNext()) {
                    Cancion cancion_a_mostrar = (Cancion) set.next();
                    System.out.println(cancion_a_mostrar.toString());
                }
            }


            q = db.query();

            q.constrain(Cancion.class);
            q.descend("duracio").constrain(244).or(q.descend("nom").constrain("Escape"));

            set = q.execute();
            System.out.println("\n\n\nAquest es el resultat de buscar una canço que duri 244 segons o que es digui \"Escape\":");
            if (set.hasNext()) {

                while (set.hasNext()) {
                    Cancion cancion_a_mostrar = (Cancion) set.next();
                    System.out.println(cancion_a_mostrar.toString());
                }
            }

            q = db.query();

            q.constrain(Cancion.class);
            q.descend("nom").constrain("E").startsWith(false).not();

            set = q.execute();
            System.out.println("\n\nAra buscarem cançons que no comencin per E");
            if (set.hasNext()) {

                while (set.hasNext()) {
                    Cancion cancion_a_mostrar = (Cancion) set.next();
                    System.out.println(cancion_a_mostrar.toString());
                }
            }
            q = db.query();

            q.constrain(Cancion.class);
            q.descend("duracio").orderDescending();

            set = q.execute();
            System.out.println("\n\nCançons ordenades per duracio descendentment:");
            if (set.hasNext()) {

                while (set.hasNext()) {
                    Cancion cancion_a_mostrar = (Cancion) set.next();
                    System.out.println(cancion_a_mostrar.toString());
                }
            }

            q = db.query();

            q.constrain(Cancion.class);
            q.descend("duracio").orderAscending();

            set = q.execute();
            System.out.println("\n\nCançons ordenades per duracio ascendentment:");
            if (set.hasNext()) {

                while (set.hasNext()) {
                    Cancion cancion_a_mostrar = (Cancion) set.next();
                    System.out.println(cancion_a_mostrar.toString());
                }
            }

            album = new Album();
            album.setNom("Album sense cançons");
            db.store(album);

            
            Comparator<Album> comparator = new Comparator<Album>() {
                @Override
                public int compare(Album alb1, Album alb2) {
                 
                    if (alb1.getCanciones().size() > alb2.getCanciones().size()) return 1;
                    if (alb1.getCanciones().size() < alb2.getCanciones().size()) return -1;
                    return 0;
                  

                }
               
            };
           
            q = db.query();

            q.constrain(Album.class);
            q.descend("canciones").constrain(null).not();
            q.sortBy(comparator);
         
            set = q.execute();
            
            System.out.println("\n\n\n\n\n\nAlbums ordenats amb un comparator, "
                    + "segons cantitat de cançons, amb un album amb cançons \"null\" a la base de dades");
            
            if (set.hasNext()) {

                while (set.hasNext()) {
                    Album album_a_mostrar = (Album) set.next();
                    System.out.println(album_a_mostrar.toString());
                }
            }
            
            
             set = db.queryByExample(null);
            System.out.println("\n\n\n\nTots els objectes de la BD:");
            while (set.hasNext()) {
                Object objecte = set.next();
                if (Cancion.class.isInstance(objecte)) {
                    System.out.println((Cancion) objecte);
                }
                if (Album.class.isInstance(objecte)) {
                    System.out.println((Album) objecte);
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
