/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt5.db4o;

/**
 *
 * @author dios
 */
public class Cancion {
    
    private String nom;
    private int duracio;
    private Album album;

    public Cancion(String nom, int duracio, Album album) {
        this.nom = nom;
        this.duracio = duracio;
        this.album = album;
    }

    public Cancion(String nom, Album album) {
        this.nom = nom;
        this.album = album;
    }
    
     public Cancion(Album album) {
        this.album = album;
    }
     public Cancion() {
    }

    @Override
    public String toString() {
        return "Cancion{" + "nom=" + nom + ", duracio=" + duracio + '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuracio() {
        return duracio;
    }

    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    
    
}
