/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt5.db4o;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author dios
 */
public class Album {
    
    private String nom;
    private Collection <Cancion> canciones;

    public Album(String nom, Collection<Cancion> canciones) {
        this.nom = nom;
        this.canciones = canciones;
    }

    public Album(Collection<Cancion> canciones) {
        
        this.canciones = canciones;
    }
    
    public Album(String nom) {
        this.nom = nom;
    }

    public Album() {
    }

    @Override
    public String toString() {
        return "Album{" + "nom=" + nom + ", canciones=" + canciones + '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection <Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(Collection <Cancion> canciones) {
        this.canciones = canciones;
    }
    public int duracioTotal(){
        int total = 0;
       
       Iterator iterator = this.canciones.iterator();
        
       while(iterator.hasNext()){
           total += ((Cancion) iterator.next()).getDuracio();
       }
       
        return total;
    }
    
}
