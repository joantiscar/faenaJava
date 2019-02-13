/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interficies;

/**
 *
 * @author dios
 */
    interface ExempleInterficie {
        
    static void metodeStatic(){
        System.out.println("Aixo es un metode Static");
    }

    void metodePrimer(int primerValor);

    void metodeSegon(int segonValor, float unAltreValor);

    void metodeTercer();
    
    default void metodeAmbDefault(){
        
        System.out.println("Pos este metode fa algo");
    }

}
