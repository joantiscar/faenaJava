/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgenum;

import java.util.Random;

/**
 *
 * @author dios
 */
public class exemples {

    public static String obtindreTriunfo() {
        Random r = new Random();
        int random = r.nextInt(4);
        switch (random) {
            case 0:
                return "ORS";
            case 1:
                return "BASTOS";
            case 2:
                return "ESPASES";
            case 3:
                return "COPES";

            default:
                return "astio";
        }
    }
    
    
       public static String guanyarMa(Carta carta1, Carta carta2) {
       String triunfo = obtindreTriunfo();
       return guanyarMa(carta1, carta2, triunfo);
       }
       
    
    public static String guanyarMa(Carta carta1, Carta carta2, String triunfo) {
        if (carta1 == carta2) return "Astio les dos cartes son la mateixa";
        System.out.println("El triunfo es " + triunfo);
        
        if ( carta1.palCarta() == triunfo && carta2.palCarta() != triunfo ) return "Ha guanyat el jugador 1";
        if ( carta2.palCarta() == triunfo && carta1.palCarta() != triunfo ) return "Ha guanyat el jugador 2";
        if ( carta1.palCarta() != carta2.palCarta()) return "Ha guanyat el jugador 1";
        if ( carta1.valorCarta()> carta2.valorCarta()) return "Ha guanyat el jugador 1";
        if ( carta2.valorCarta()> carta1.valorCarta()) return "Ha guanyat el jugador 1";

        return "ALGO HA SORTIT MAL";
    }
    
    public static String guanyarMa(Carta carta1, Carta carta2, Carta carta3, Carta carta4, String triunfo) {
        
        if (carta1 == carta2 || carta1 == carta3 || carta1 == carta4 || carta2 == carta3 || carta2 == carta4 || carta3 == carta4) return "Astio, me has repetit una carta"; 
        
        
        System.out.println("El triunfo es " + triunfo);
        boolean carta1_participa = true;
        boolean carta2_participa = true;
        boolean carta3_participa = true;
        boolean carta4_participa = true;
        
        if ( carta1.palCarta() != triunfo && (carta2.palCarta() == triunfo || carta3.palCarta() == triunfo || carta4.palCarta() == triunfo)) carta1_participa = false;
        if ( carta1.palCarta() != carta2.palCarta() && carta2.palCarta() != triunfo) carta2_participa = false;
        if ( carta1.palCarta() != carta3.palCarta() && carta3.palCarta() != triunfo) carta3_participa = false;
        if ( carta1.palCarta() != carta4.palCarta() && carta4.palCarta() != triunfo) carta4_participa = false;
        if ( !(carta2_participa == false || (carta2.valorCarta() < carta1.valorCarta() && carta1_participa == true) || (carta2.valorCarta() < carta3.valorCarta() && carta3_participa == true) || (carta2.valorCarta() < carta4.valorCarta() && carta4_participa == true))) return "Ha guanyat el jugador 2";        
        if ( !(carta3_participa == false || (carta3.valorCarta() < carta1.valorCarta() && carta1_participa == true) || (carta3.valorCarta() < carta2.valorCarta() && carta2_participa == true) || (carta3.valorCarta() < carta4.valorCarta() && carta4_participa == true))) return "Ha guanyat el jugador 3";
        if ( !(carta4_participa == false || (carta4.valorCarta() < carta1.valorCarta() && carta1_participa == true) || (carta4.valorCarta() < carta2.valorCarta() && carta2_participa == true) || (carta4.valorCarta() < carta3.valorCarta() && carta3_participa == true))) return "Ha guanyat el jugador 4";
        
        
//        if ( carta1.palCarta() == triunfo && carta2.palCarta() != triunfo && carta3.palCarta() != triunfo && carta4.palCarta() != triunfo ) return "Ha guanyat el jugador 1";
//        if ( carta2.palCarta() == triunfo && carta1.palCarta() != triunfo && carta3.palCarta() != triunfo && carta4.palCarta() != triunfo ) return "Ha guanyat el jugador 2";
//        if ( carta3.palCarta() == triunfo && carta1.palCarta() != triunfo && carta2.palCarta() != triunfo && carta4.palCarta() != triunfo ) return "Ha guanyat el jugador 3";
//        if ( carta4.palCarta() == triunfo && carta1.palCarta() != triunfo && carta2.palCarta() != triunfo && carta3.palCarta() != triunfo ) return "Ha guanyat el jugador 4";
//        if ( carta1.palCarta() != carta2.palCarta() && carta1.palCarta() != carta3.palCarta() && carta1.palCarta() != carta4.palCarta()) return "Ha guanyat el jugador 1";
//        if ( (carta1.valorCarta()> carta2.valorCarta() && carta1.palCarta() == carta2.palCarta()) || (carta1.valorCarta()> carta3.valorCarta() && carta1.palCarta() == carta3.palCarta()) || (carta1.valorCarta()> carta4.valorCarta() && carta1.palCarta() == carta4.palCarta())) return "Ha guanyat el jugador 1";
//        if ( (carta2.valorCarta()> carta1.valorCarta() && carta2.palCarta() == carta1.palCarta()) || (carta2.valorCarta()> carta3.valorCarta() && carta2.palCarta() == carta3.palCarta()) || (carta2.valorCarta()> carta4.valorCarta() && carta2.palCarta() == carta4.palCarta())) return "Ha guanyat el jugador 2";        
//        if ( (carta3.valorCarta()> carta1.valorCarta() && carta3.palCarta() == carta1.palCarta()) || (carta3.valorCarta()> carta2.valorCarta() && carta3.palCarta() == carta2.palCarta()) || (carta3.valorCarta()> carta4.valorCarta() && carta3.palCarta() == carta4.palCarta())) return "Ha guanyat el jugador 3";
//        if ( (carta4.valorCarta()> carta1.valorCarta() && carta4.palCarta() == carta1.palCarta()) || (carta4.valorCarta()> carta2.valorCarta() && carta4.palCarta() == carta2.palCarta()) || (carta4.valorCarta()> carta3.valorCarta() && carta4.palCarta() == carta3.palCarta())) return "Ha guanyat el jugador 4";
        return "Ha guanyat el jugador 1";

    }

    public static String guanyarMa(Carta carta1, Carta carta2, Carta carta3, Carta carta4) {
       String triunfo = obtindreTriunfo();
       return guanyarMa(carta1, carta2, carta3, carta4, triunfo);

    }


    public static void main(String[] args) {
//        Guinyot g = new Guinyot();
//        System.out.println(Carta.CAVALL.valorCarta());
//        System.out.println(g.obtenirTriunfo());
//        System.out.println(g.guanyarMa(Carta.DOS, Pals.BASTOS, Carta.SET, Pals.COPES));
        System.out.println(Carta.QUATREBASTOS.puntuacioCarta());
        System.out.println(guanyarMa(Carta.ASCOPES, Carta.QUATRECOPES, Carta.TRESCOPES, Carta.TRESBASTOS, "COPES"));
    }
}
