/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat2;

import java.util.*;

/**
 *
 * @author dios
 */
public class Treeset {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ordre;
        Scanner ent = new Scanner(System.in);
        System.out.println("Benvingut al programa d'introducció de pel·lícules");
        Collection<Pelicula> pelicules= new TreeSet<>();
        String siono;
        do {
            Pelicula peli = new Pelicula();
            System.out.println("Introdueix una película que haigues vist:");
            peli.set(ent.nextLine());
            pelicules.add(peli);
            System.out.println("Vols afegir mes películes?(si o no)");
            siono = ent.nextLine().toLowerCase();
        } while (siono.equals("si"));
        
        
        System.out.println("Les pelicules que has vist son (ordenades per llargada, les que tenene el titol mes curt primer):");
        Iterator iterador = pelicules.iterator();
        while (iterador.hasNext()) {
            Pelicula peli = (Pelicula) iterador.next();
            System.out.println(peli.get());
        }

    }
}

class Pelicula implements Comparable {

    private String nom;

    public void set(String n) {
        nom = n;
    }

    public String get() {
        return nom;
    }

    @Override
    public int compareTo(Object o) {

        if (this.get().length() == ((Pelicula)o).get().length()) return 0;
        if (this.get().length() < ((Pelicula)o).get().length()) return -1;
        if (this.get().length() > ((Pelicula)o).get().length()) return 1;
        return 0;
    }
}