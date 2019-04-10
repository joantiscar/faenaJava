package model;

        
 
public class Cancion  implements java.io.Serializable {


     private String nom;
     private int duracio;
     private Album album;

    public Cancion(String nom, int duracio, Album album) {
        this.nom = nom;
        this.duracio = duracio;
        this.album = album;
    }

    public Cancion() {
    }

    

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
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




}


