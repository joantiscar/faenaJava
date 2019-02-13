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
        
        
        
//enum Carta {
//    REI, CAVALL, SOTA, SET, SIS, CINC, QUATRE, TRES, DOS, AS;
//
//    int valorCarta() {
//        switch (this) {
//
//            case REI:
//                return 4;
//            case CAVALL:
//                return 2;
//            case SOTA:
//                return 3;
//            case TRES:
//                return 10;
//            case AS:
//                return 11;
//
//            default:
//                return 0;
//        }
//    }
//    
//}
//
//enum Pals {
//    ORS, COPES, BASTOS, ESPASES
//}
//
//public class Guinyot {
//
//    public int astio = 3;
//
//    public String obtenirTriunfo() {
//        Random r = new Random();
//        int random = r.nextInt(4);
//        switch (random) {
//            case 0:
//                return "ORS";
//            case 1:
//                return "BASTOS";
//            case 2:
//                return "ESPASES";
//            case 3:
//                return "COPES";
//
//            default:
//                return "astio";
//        }
//
//    }
//
//    public String guanyarMa(Carta carta1, Pals pal1, Carta carta2, Pals pal2) {
//       String triunfo = this.obtenirTriunfo();
//       return guanyarMa(carta1, pal1, carta2, pal2, triunfo);
//        }
//    public String guanyarMa(Carta carta1, Pals pal1, Carta carta2, Pals pal2, Pals triunfo) {
//       String triunfo1 = triunfo.toString();
//       return guanyarMa(carta1, pal1, carta2, pal2, triunfo1);
//        }
//       
//    
//    public String guanyarMa(Carta carta1, Pals pal1, Carta carta2, Pals pal2, String triunfo) {
//        System.out.println("El triunfo es " + triunfo);
//        
//        if ( pal1.toString() == triunfo && pal2.toString() != triunfo ) return "Ha guanyat el jugador 1";
//        if ( pal2.toString() == triunfo && pal1.toString() != triunfo ) return "Ha guanyat el jugador 2";
//        if ( pal1.toString() != pal2.toString()) return "Ha guanyat el jugador 1";
//        if ( carta1.valorCarta()> carta2.valorCarta()) return "Ha guanyat el jugador 1";
//        if ( carta2.valorCarta()> carta1.valorCarta()) return "Ha guanyat el jugador 1";
//        if ( carta1.valorCarta() == carta2.valorCarta()){
//            if (carta1.toString()=="SET") return "Ha guanyat el jugador 1";
//            if (carta2.toString()=="SET") return "Ha guanyat el jugador 2";
//            if (carta1.toString()=="SIS") return "Ha guanyat el jugador 1";
//            if (carta2.toString()=="SIS") return "Ha guanyat el jugador 2";
//            if (carta1.toString()=="CINC") return "Ha guanyat el jugador 1";
//            if (carta2.toString()=="CINC") return "Ha guanyat el jugador 2";
//            if (carta1.toString()=="QUATRE") return "Ha guanyat el jugador 1";
//            if (carta2.toString()=="QUATRE") return "Ha guanyat el jugador 2";
//            if (carta1.toString()=="DOS") return "Ha guanyat el jugador 1";
//            if (carta2.toString()=="DOS") return "Ha guanyat el jugador 2";
//         
//        }
//        return "ALGO HA SORTIT MAL";
//    }
//    
//    public String guanyarMa(Carta carta1, Pals pal1, Carta carta2, Pals pal2, Carta carta3, Pals pal3, Carta carta4, Pals pal4, String triunfo) {
//        System.out.println("El triunfo es " + triunfo);
//        
//        if ( pal1.toString() == triunfo && pal2.toString() != triunfo && pal3.toString() != triunfo && pal4.toString() != triunfo) return "Ha guanyat el jugador 1";
//        if ( pal2.toString() == triunfo && pal1.toString() != triunfo && pal3.toString() != triunfo && pal4.toString() != triunfo ) return "Ha guanyat el jugador 2";
//        if ( pal3.toString() == triunfo && pal1.toString() != triunfo && pal2.toString() != triunfo && pal4.toString() != triunfo ) return "Ha guanyat el jugador 3";
//        if ( pal4.toString() == triunfo && pal1.toString() != triunfo && pal3.toString() != triunfo && pal2.toString() != triunfo ) return "Ha guanyat el jugador 4";
//        if ( pal1.toString() != pal2.toString() && pal1.toString() != pal3.toString() && pal1.toString() != pal4.toString()) return "Ha guanyat el jugador 1";
//        if ( carta1.valorCarta()> carta2.valorCarta() && carta1.valorCarta()> carta3.valorCarta() && carta1.valorCarta()> carta4.valorCarta()) return "Ha guanyat el jugador 1";
//        if ( carta2.valorCarta()> carta1.valorCarta() && carta2.valorCarta()> carta3.valorCarta() && carta2.valorCarta()> carta4.valorCarta()) return "Ha guanyat el jugador 2";        
//        if ( carta3.valorCarta()> carta1.valorCarta() && carta3.valorCarta()> carta2.valorCarta() && carta3.valorCarta()> carta4.valorCarta()) return "Ha guanyat el jugador 3";
//        if ( carta4.valorCarta()> carta1.valorCarta() && carta4.valorCarta()> carta2.valorCarta() && carta4.valorCarta()> carta3.valorCarta()) return "Ha guanyat el jugador 4";
//        if ( carta1.valorCarta() == carta2.valorCarta()){
//            if (carta1.toString()=="SET") return "Ha guanyat el jugador 1";
//            if (carta2.toString()=="SET") return "Ha guanyat el jugador 2";
//            if (carta3.toString()=="SET") return "Ha guanyat el jugador 3";
//            if (carta4.toString()=="SET") return "Ha guanyat el jugador 4";
//            
//            
//            if (carta1.toString()=="SIS") return "Ha guanyat el jugador 1";
//            if (carta2.toString()=="SIS") return "Ha guanyat el jugador 2";
//            if (carta3.toString()=="SIS") return "Ha guanyat el jugador 3";
//            if (carta4.toString()=="SIS") return "Ha guanyat el jugador 4";
//            
//            
//            
//            if (carta1.toString()=="CINC") return "Ha guanyat el jugador 1";
//            if (carta2.toString()=="CINC") return "Ha guanyat el jugador 2";
//            if (carta3.toString()=="CINC") return "Ha guanyat el jugador 3";
//            if (carta4.toString()=="CINC") return "Ha guanyat el jugador 4";
//            
//            
//            
//            if (carta1.toString()=="QUATRE") return "Ha guanyat el jugador 1";
//            if (carta2.toString()=="QUATRE") return "Ha guanyat el jugador 2";
//            if (carta3.toString()=="QUATRE") return "Ha guanyat el jugador 3";
//            if (carta4.toString()=="QUATRE") return "Ha guanyat el jugador 4";
//            
//            
//            if (carta1.toString()=="DOS") return "Ha guanyat el jugador 1";
//            if (carta2.toString()=="DOS") return "Ha guanyat el jugador 2";
//            if (carta3.toString()=="DOS") return "Ha guanyat el jugador 3";
//            if (carta4.toString()=="DOS") return "Ha guanyat el jugador 4";
//         
//        }
//        return "ALGO HA SORTIT MAL";
//
//    }
//
//    public String guanyarMa(Carta carta1, Pals pal1, Carta carta2, Pals pal2, Carta carta3, Pals pal3, Carta carta4, Pals pal4) {
//       String triunfo = this.obtenirTriunfo();
//       return guanyarMa(carta1, pal1, carta2, pal2, carta3, pal3, carta4, pal4, triunfo);
//
//    }
//    public String guanyarMa(Carta carta1, Pals pal1, Carta carta2, Pals pal2, Carta carta3, Pals pal3, Carta carta4, Pals pal4, Pals triunfo){
//        String triunfo1 = triunfo.toString();
//       return guanyarMa(carta1, pal1, carta2, pal2, carta3, pal3, carta4, pal4, triunfo1);
//    }
//}
