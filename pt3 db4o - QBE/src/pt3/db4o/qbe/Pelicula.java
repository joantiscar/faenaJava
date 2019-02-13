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
public class Pelicula {
    
    private String nom;
    private String data;
    private int recaudacio;
    private int cost;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getRecaudacio() {
        return recaudacio;
    }

    public void setRecaudacio(int recaudacio) {
        this.recaudacio = recaudacio;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "nom=" + nom + ", data=" + data + ", recaudacio=" + recaudacio + ", cost=" + cost + '}';
    }

    public Pelicula() {
    }

    public Pelicula(String nom) {
        this.nom = nom;
    }

    public Pelicula(String nom, int recaudacio, int cost) {
        this.nom = nom;
        this.recaudacio = recaudacio;
        this.cost = cost;
    }

    public Pelicula(String nom, String data, int recaudacio, int cost) {
        this.nom = nom;
        this.data = data;
        this.recaudacio = recaudacio;
        this.cost = cost;
    }
   
    
}
