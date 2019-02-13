/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author dios
 */
public class Proves {
    
    public static void main(String[] args) {

        
        System.out.println("Proves en ArrayList: ");
        MultiCapsa<String> mc1 = new MultiCapsa<>(new ArrayList<>());

        mc1.afegir("Primer");
        mc1.afegir("Segon");
        System.out.println((mc1.esBuida() ? "buida" : "no buida"));
        System.out.println(mc1.obtenir());
        mc1.eliminar();
        System.out.println(mc1.obtenir());

        mc1.eliminar();
        System.out.println((mc1.buidar() ? "buidada" : "no buidada"));
        System.out.println((mc1.esBuida() ? "buida" : "no buida"));
        System.out.println("\n");
        System.out.println("Proves en HashSet:");
        MultiCapsa<String> mc2 = new MultiCapsa<>(new HashSet<>());

        mc2.afegir("Primer");
        mc2.afegir("Segon");
        System.out.println((mc2.esBuida() ? "buida" : "no buida"));
        System.out.println(mc2.obtenir());
        mc2.eliminar();
        System.out.println(mc2.obtenir());

        mc2.eliminar();
        System.out.println((mc2.buidar() ? "buidada" : "no buidada"));
        System.out.println((mc2.esBuida() ? "buida" : "no buida"));
        System.out.println("\n");
        
        System.out.println("Proves en TreeSet:");

        MultiCapsa<String> mc3 = new MultiCapsa<>(new TreeSet<>());

        mc3.afegir("Primer");
        mc3.afegir("Segon");
        System.out.println((mc3.esBuida() ? "buida" : "no buida"));
        System.out.println(mc3.obtenir());
        mc3.eliminar();
        System.out.println(mc3.obtenir());

        mc3.eliminar();
        System.out.println((mc3.buidar() ? "buidada" : "no buidada"));
        System.out.println((mc3.esBuida() ? "buida" : "no buida"));
        System.out.println("\n");

        System.out.println("Proves en Bicicletes: ");
        
        MultiCapsa<Bicycle> mc4 = new MultiCapsa<>(new ArrayList<>());
        mc4.afegir(new Bicycle(112,2,3));
        mc4.afegir(new Bicycle(22313,2134,34));
        mc4.afegir(new Bicycle(312,231,35));
        mc4.afegir(new Bicycle(41,234,32));
        mc4.afegir(new Bicycle(5,234,233));
        mc4.afegir(new Bicycle(6123,623,323));
        Collection ordenadets = mc4.<Bicycle>ordenat();
        
        Iterator iterador = ordenadets.iterator();
        System.out.println("Bicicletes ordenades per 'cadence':");
          while(iterador.hasNext()){
              System.out.println(iterador.next().toString());
        }
          System.out.println("\n");
           System.out.println("Proves en Strings: ");
         MultiCapsa<String> mc5 = new MultiCapsa<>(new ArrayList<>());
        mc5.afegir("Astio");
        mc5.afegir("Emilio Jose");
        mc5.afegir("Martí Gómez");
        mc5.afegir("Lo pantano es de La Sénia");
        mc5.afegir("Avui he menjat patates");
        mc5.afegir("Fato");
        Collection ordenadets2 = mc5.<String>ordenat();
        
        Iterator iterador2 = ordenadets2.iterator();
        System.out.println("Strings ordenats: ");
          while(iterador2.hasNext()){
              System.out.println(iterador2.next().toString());
        }
        
    }
}
