/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt3.db4o.qbe;

import java.util.Arrays;

/**
 *
 * @author dios
 */
public class Album {
    
    private String nom;
    private String autor;
    private String[] pistes;
    private int duracio;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String[] getPistes() {
        return pistes;
    }

    public void setPistes(String[] pistes) {
        this.pistes = pistes;
    }

    public int getDuracio() {
        return duracio;
    }

    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }

    public Album() {
    }

    public Album(String nom) {
        this.nom = nom;
    }

    public Album(String nom, String autor) {
        this.nom = nom;
        this.autor = autor;
    }

    public Album(String nom, String autor, String[] pistes, int duracio) {
        this.nom = nom;
        this.autor = autor;
        this.pistes = pistes;
        this.duracio = duracio;
    }

    @Override
    public String toString() {
        return "Album{" + "nom=" + nom + ", autor=" + autor + ", pistes=" + Arrays.toString(pistes) + ", duracio=" + duracio + '}';
    }
    
}
