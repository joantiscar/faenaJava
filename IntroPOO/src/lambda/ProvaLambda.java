/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

/**
 *
 * @author dios
 */
public class ProvaLambda {

    // interficie funcional 
    interface Funcional {

        //Únic mètode abstracte
        String concatena(String a, String b);

    }

    public static void provaLambda(String a, String b, Funcional f) {
        System.out.println(f.concatena(a, b));
    }

    public static void main(String[] args) {

        // Exemple de classe anònima
        provaLambda("Em dic ", "Emilio José",
                new Funcional() {

            public String concatena(String a, String b) {
                return a + b;
            }
        }
        );

        // Exemple de expressió Lambda
        provaLambda("Em dic ", "Emilio José",
                (String a, String b) -> a + b
        );

        // Exemple de expressió Lambda
        provaLambda("Em dic ", "Emilio José",
                (String a, String b) -> {
                    String c = a + b;
                    return c;
                }
        );

    }   

}
