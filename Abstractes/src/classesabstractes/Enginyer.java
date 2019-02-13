/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesabstractes;

/**
 *
 * @author dios
 */
public class Enginyer extends Treballador {

    String projecteAssignat;

 

    @Override
    public void definirDades() {

        this.codi = 1;
        this.nom = "Emilio Jose";
        this.cognom = "Martí Gómez";
        this.dataNaixement = "11/1/95";
        this.projecteAssignat = "Creacio de nova maquina";

    }

    public void obtindreCoses() {
        System.out.println(this.codi);
        System.out.println(this.nom);
        System.out.println(this.cognom);
        System.out.println(this.dataNaixement);
        System.out.println(this.projecteAssignat);

    }

}
