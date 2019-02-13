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
public class ExempleDeMultipleInterficie implements ExempleInterficie, UnaAltraInterficie{
    
    @Override
    public void metodePrimer(int primerValor){
        
    }
    
    @Override
    public void metodeSegon(int segonValor, float unAltreValor){
        
    }

    
    @Override
    public void metodeTercer(){
        
    }
    
    @Override
    public void unAltreMetode(){
        
    }
    
    @Override
    public void unAltreAltreMetide(){
        
    }
    
    @Override
    public void metodeAmbDefault(){
        
        System.out.println("Ara aixo fa una altra cosa");
    }
    
}
