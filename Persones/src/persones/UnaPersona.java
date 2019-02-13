/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persones;

/**
 *
 * @author dios
 */
public class UnaPersona {

    Persona persona1 = new Persona();

    int prova() {
        persona1.metodePublic();
        persona1.metodeProtected();
        persona1.metodeSenseres();
        //persona1.metodePrivat();

        return persona1.getAstio();
    }

    public static void main(String[] args) {
        
        
//        System.out.println(prova());
    }
}
