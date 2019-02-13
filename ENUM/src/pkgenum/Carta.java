/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgenum;

/**
 *
 * @author dios
 */
public enum Carta {
    ASORS (11, "ORS"), ASESPASES (11, "ESPASES"), ASCOPES (11, "COPES"), ASBASTOS (11, "BASTOS"),
    DOSORS (1, "ORS"), DOSESPASES (1, "ESPASES"), DOSCOPES (1, "COPES"), DOSBASTOS (1, "BASTOS"),
    TRESORS (2, "ORS"), TRESESPASES (10, "ESPASES"), TRESCOPES (10, "COPES"), TRESBASTOS (10, "BASTOS"),
    QUATREORS (3, "ORS"), QUATREESPASES (3, "ESPASES"), QUATRECOPES (3, "COPES"), QUATREBASTOS (3, "BASTOS"),
    CINCORS (4, "ORS"), CINCESPASES (4, "ESPASES"), CINCCOPES (4, "COPES"), CINCBASTOS (4, "BASTOS"),
    SISORS (5, "ORS"), SISESPASES (60, "ESPASES"), SISCOPES (60, "COPES"), SISBASTOS (60, "BASTOS"),
    SETORS(6, "ORS"), SETESPASES (6, "ESPASES"), SETCOPES (6, "COPES"), SETBASTOS (6, "BASTOS"),
    SOTAORS (7, "ORS"), SOTAESPASES (7, "ESPASES"), SOTACOPES (7, "COPES"), SOTABASTOS (7, "BASTOS"),
    CAVALLORS (8, "ORS"), CAVALLESPASES (8, "ESPASES"), CAVALLCOPES (8, "COPES"), CAVALLBASTOS (8, "BASTOS"),
    REIORS (9, "ORS"), REIESPASES (9, "ESPASES"), REICOPES (9, "COPES"), REIBASTOS (9, "BASTOS");
    
    private final int valor_carta;
    private final String pal_carta;
    
    Carta(int valor, String pal){
        this.valor_carta = valor;
        this.pal_carta = pal; 
    }
    public int valorCarta(){
        return this.valor_carta;
    }
    public String dirValorCarta(){
        String resultat = "" + this.valor_carta/100;
        return resultat;
    }
    public String palCarta(){
        return this.pal_carta;
    }
    public int puntuacioCarta(){
        switch (this.valor_carta) {
            case 11:
                return 11;
                case 10:
                return 10;
                case 9:
                return 4;
                case 8:
                return 3;
                case 7:
                return 2;
                default:
                    return 0;
        }
        
    }
    
}
