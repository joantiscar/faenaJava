package provanm;

import java.util.ArrayList;
import java.util.Collection;





public class Album  implements java.io.Serializable {


     private String nom;
     private String artista;
     private String data;
    private ArrayList <Cancion> canciones;

    public Album(String nom, String artista, String data, ArrayList<Cancion> canciones) {
        this.nom = nom;
        this.artista = artista;
        this.data = data;
        this.canciones = canciones;
    }

    public Album() {

    }

    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Collection <Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList <Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Album{" + "nom=" + nom + ", artista=" + artista + ", data=" + data + '}';
    }
    
    

}


