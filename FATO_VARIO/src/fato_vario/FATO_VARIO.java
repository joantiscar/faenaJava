/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fato_vario;

import java.util.Random;

/**
 *
 * @author dios
 */
public class FATO_VARIO {

 public int astio = 3;

    public String obtenirTriunfo() {
        Random r = new Random();
        int random = r.nextInt(3);
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

//    public void guanyarMa(Carta carta1, Carta carta2) {
//
//    }
//
//    public void guanyarMa(Carta carta1, Carta carta2, Carta carta3, Carta carta4) {
//
//    }
}