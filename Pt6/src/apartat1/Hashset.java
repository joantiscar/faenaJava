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
public class Hashset {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ent = new Scanner(System.in);
        String opcio = "0";
        Collection<Recepta> receptes = new HashSet<>();
        String siono;
        Ingredient ing;
        System.out.println("Programa d'assignament de ingredients a receptes.");
        do {
            System.out.println("Digues el nom de la Recepta:");
            String nom_Recepta = ent.nextLine();
            Collection<Ingredient> ingredients = new HashSet<>();
            do {
                ing = new Ingredient();
                System.out.println("Introdueix un ingredient de la Recepta:");
                ing.set(ent.nextLine());
                ingredients.add(ing);
                System.out.println("Vols afegir mes ingredients?(si o no)");
                siono = ent.nextLine().toLowerCase();
            } while (siono.equals("si"));
            Recepta recepta = new Recepta();
            recepta.setNom(nom_Recepta);
            System.out.println("L'ultim Ingredient, no acaba de quedar be a esta recepta, aixi que vaig a borrarlo...");
            ingredients.remove(ing);
            System.out.println("Para asegurarme: vaig a mirar que no estigue dins");
            if (ingredients.contains(ing)) {
                System.out.println("Ostia, si encara esta dins!");
            }else{
                System.out.println("Veig que se ha borrat correctament");
            }
            
            recepta.setingredients(ingredients);
            receptes.add(recepta);
            System.out.println("Vols afegir una altra Recepta? (si, no)");
            opcio = ent.nextLine();
        } while ("si".equals(opcio));
        System.out.println("Les receptes, i els seus ingredients son:");
        Iterator iterador = receptes.iterator();
        while (iterador.hasNext()) {
            Recepta Recepta = (Recepta) iterador.next();
            System.out.println("\n" + Recepta.getNom() + ": ");
            Collection<Ingredient> ingredients = Recepta.getIngredients();
            Iterator iterador2 = ingredients.iterator();
            int cont = 1;
            while (iterador2.hasNext()) {
                Ingredient ingredient2 = (Ingredient) iterador2.next();
                System.out.println(cont + ": " + ingredient2.get());
                cont++;
            }
        }

    }
}

class Ingredient {

    private String nom;

    public void set(String n) {
        nom = n;
    }

    public String get() {
        return nom;
    }

}

class Recepta {

    private String nom;
    private Collection<Ingredient> ingredients = new HashSet();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setingredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
