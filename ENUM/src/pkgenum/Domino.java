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
public enum Domino {
    FITXA1 ("BLANC","BLANC"), FITXA2 ("BLANC","BLANC"), FITXA3 ("BLANC","BLANC"), FITXA4 ("BLANC","BLANC"), FITXA5 ("BLANC","BLANC"), FITXA6 ("BLANC","BLANC"),
    FITXA7 ("BLANC","BLANC"), FITXA8 ("BLANC","BLANC"), FITXA9 ("BLANC","BLANC"), FITXA10 ("BLANC","BLANC"), FITXA11 ("BLANC","BLANC"), FITXA12 ("BLANC","BLANC"),
    FITXA13 ("BLANC","BLANC"), FITXA14 ("BLANC","BLANC"), FITXA15 ("BLANC","BLANC"), FITXA16 ("BLANC","BLANC"), FITXA17 ("BLANC","BLANC"), FITXA18 ("BLANC","BLANC"),
    FITXA19 ("BLANC","BLANC"), FITXA20 ("BLANC","BLANC"), FITXA21 ("BLANC","BLANC"), FITXA22 ("BLANC","BLANC"), FITXA23 ("BLANC","BLANC"), FITXA24 ("BLANC","BLANC"),
    FITXA25 ("BLANC","BLANC"), FITXA26 ("BLANC","BLANC"), FITXA27 ("BLANC","BLANC"), FITXA28 ("BLANC","BLANC");
        
        
       private final String part1;
       private final String part2;
        
        Domino(String part1, String part2){
        this.part1 = part1;
        this.part2 = part2; 
    }
        
}
