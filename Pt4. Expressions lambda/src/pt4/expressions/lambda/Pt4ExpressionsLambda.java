/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt4.expressions.lambda;

/**
 *
 * @author dios
 */
public class Pt4ExpressionsLambda {

    // Primer creem una interficie funcional, que te dins un únic métode abstracte
    interface interficieFuncional {

        int Conta(String a, char b);

    }

    public static void provaConta(String a, char b, interficieFuncional f) {
        System.out.println("El caracter " + b + " apareix al text " + f.Conta(a, b) + " vegades");
    }

    public static void main(String[] args) {

        String text = "Emilio José Martí Gómez";
        char caracter = 'm';

        // Aquesta classe anònima busca el caracter m dins del String text
        provaConta(text, caracter,
                new interficieFuncional() {

            public int Conta(String a, char b) {
                int contador = 0;
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) == b) {
                        contador++;
                    }
                }
                return contador;
            }
        }
        );
        // Aquesta expressió Lambda fa el mateix que la classe anònima anterior
        provaConta(text, caracter,
                (String a, char b) -> {
                    int contador = 0;
                    for (int i = 0; i < a.length(); i++) {
                        if (a.charAt(i) == b) {
                            contador++;
                        }
                    }
                    return contador;
                });

        // Aquesta expressió Lambda fa el mateix que la anterior, pero amb la diferencia, de que aquesta no distingeix entre majúscules i minúscules
        provaConta(text, caracter,
                (String a, char b) -> {
                    int contador = 0;
                    String c = a.toLowerCase();
                    for (int i = 0; i < c.length(); i++) {
                        if (c.charAt(i) == b) {
                            contador++;
                        }
                    }
                    return contador;
                });
    }
}
