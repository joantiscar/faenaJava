/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat1;

import java.util.*;

/**
 *
 * @author dios
 */
public class Arraylist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ent = new Scanner(System.in);
        String opcio = "0";
        Collection<Saga> sagues = new ArrayList<>();
        String siono;
        Pelicula peli;
        System.out.println("Programa d'assignament de pelicules a sagues.");
        do {
            System.out.println("Digues el nom de la saga:");
            String nom_saga = ent.nextLine();
            Collection<Pelicula> pelicules = new ArrayList<>();
            do {
                peli = new Pelicula();
                System.out.println("Introdueix una película de la saga:");
                peli.set(ent.nextLine());
                pelicules.add(peli);
                System.out.println("Vols afegir mes películes?(si o no)");
                siono = ent.nextLine().toLowerCase();
            } while (siono.equals("si"));
            Saga saga = new Saga();
            saga.setNom(nom_saga);
            System.out.println("La ultima pelicula, va ser molt dolenta, aixi que vaig a borrarla...");
            pelicules.remove(peli);
            System.out.println("Para asegurarme: vaig a mirar que no estigue dins");
            if (pelicules.contains(peli)) {
                System.out.println("Ostia, si encara esta dins!");
            } else {
                System.out.println("Veig que se ha borrat correctament.");
            }

            saga.setPelicules(pelicules);
            sagues.add(saga);
            System.out.println("Vols afegir una altra saga? (si, no)");
            opcio = ent.nextLine();
        } while ("si".equals(opcio));
        System.out.println("Les sagues, i les seves pelicules son:");
        Iterator iterador = sagues.iterator();
        while (iterador.hasNext()) {
            Saga saga = (Saga) iterador.next();
            System.out.println("\n" + saga.getNom() + ": ");
            Collection<Pelicula> pelis = saga.getPelicules();
            Iterator iterador2 = pelis.iterator();
            int cont = 1;
            while (iterador2.hasNext()) {
                Pelicula peli2 = (Pelicula) iterador2.next();
                System.out.println(cont + ": " + peli2.get());
                cont++;
            }
//            System.out.println("Vols ferli alguna modificació a les pelicules de la saga? (si o no)");
//            opcio = ent.nextLine();
//            if ("si".equals(opcio)) {
//                System.out.println("Vols esborrar alguna pelicula?");
//                opcio = ent.nextLine();
//                if ("si".equals(opcio)) {
//                    System.out.println("Quina? (escriu el numero de pelicula)");
//                    int numeroPelicula = ent.nextInt();
//                    Pelicula peli_a_borrar = null;
//                    Iterator iterador3 = pelis.iterator();
//                    int contador = 1;
//                    while (iterador3.hasNext()) {
//                        if (contador == numeroPelicula) peli_a_borrar = (Pelicula) iterador3.next();
//                        contador++;
//                    }
//                    pelis.remove(peli_a_borrar);
//                    saga.setPelicules(pelis);
//                    System.out.println("Estes son les pelis actuals: ");
//                    
//                }
//            }
        }

    }
}

class Pelicula {

    private String nom;

    public void set(String n) {
        nom = n;
    }

    public String get() {
        return nom;
    }

}

class Saga {

    private String nom;
    private Collection<Pelicula> pelicules = new ArrayList();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Pelicula> getPelicules() {
        return pelicules;
    }

    public void setPelicules(Collection<Pelicula> pelicules) {
        this.pelicules = pelicules;
    }
}
