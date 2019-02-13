/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat3;

import java.util.Scanner;

/**
 *
 * @author dios
 */
public class Inicials {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        System.out.println("Disme un text, i et dire les inicials de cada paraula");
        String text = ent.nextLine();
        String[] paraules = text.split("[\\s,.]+");
        for (String paraula : paraules) {
            System.out.print(paraula.charAt(0) + ", ");
        }
    }
}
