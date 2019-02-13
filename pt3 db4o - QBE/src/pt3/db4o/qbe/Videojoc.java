/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt3.db4o.qbe;

/**
 *
 * @author dios
 */
public class Videojoc {
    
    private String nom;
    private int durada = 24;

    public Videojoc() {
    }

    
    
    @Override
    public String toString() {
        return "Videojoc{" + "nom=" + nom + ", durada=" + durada + '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }
    
    
}
