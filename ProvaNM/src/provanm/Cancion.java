package provanm;

import java.util.ArrayList;

        
 
public class Cancion  implements java.io.Serializable {


     private String nom;
     private int duracio;
     private ArrayList<Album> albums;

    public Cancion() {
    }

    public Cancion(String nom, int duracio, ArrayList<Album> albums) {
        this.nom = nom;
        this.duracio = duracio;
        this.albums = albums;
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

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

  

}


