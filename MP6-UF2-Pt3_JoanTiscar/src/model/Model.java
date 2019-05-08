/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dios
 */
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;
import java.util.Collection;
import java.sql.SQLException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Model implements Serializable {

    ObjectContainer db = null;

    Album currentAlbum = null;

    public Model(String filename) {
        try {
            // Obrim o creem el fitxer qbe.yap
            File file = new File(filename);
            db = Db4oEmbedded.openFile(filename);
        } catch (Exception e) {
            System.out.println("Error!: \n" + e);
        }

    }

    public void closeDatabase() {
        this.db.close();
    }

    public List indexAlbums() {

        ObjectSet result = db.queryByExample(new Album());

        List resultats = new ArrayList();

        for (Object objecte : result) {
            resultats.add(objecte);
        }
        return resultats;

    }

    public void createAlbum(String nom, String artista, String data) {
        Album album = new Album();
        album.setNom(nom);
        album.setArtista(artista);
        album.setData(data);
        System.out.println("CreatingAlbum");

        db.store(album);

    }

    public void editAlbum(Album albumOriginal, String nom, String artista, String data) {

        ObjectSet albumsPossibles = db.queryByExample(albumOriginal);

        Album album = null;
        for (Object objecte : albumsPossibles) {
            album = (Album) objecte;
            break;
        }

        album.setNom(nom);
        album.setArtista(artista);
        album.setData(data);

        db.store(album);

    }

    public void deleteAlbum(Album album) {

        ObjectSet albumsPossibles = db.queryByExample(album);

        Album aBorrar = null;
        for (Object objecte : albumsPossibles) {
            aBorrar = (Album) objecte;
            break;
        }

        db.delete(aBorrar);

    }

    public void createCancion(String nom, int duracio) {

        db.store(new Cancion(nom, duracio, currentAlbum));

    }

    public void editCancion(String nom, int duracio, Cancion cancionOriginal) {
        ObjectSet cancionesPossibles = db.queryByExample(cancionOriginal);

        Cancion cancion = null;
        for (Object objecte : cancionesPossibles) {
            cancion = (Cancion) objecte;
            break;
        }
        cancion.setNom(nom);
        cancion.setDuracio(duracio);

        db.store(cancion);

    }

    public void deleteCancion(Cancion cancionABorrar) {
        cancionABorrar.setAlbum(currentAlbum);
        ObjectSet cancionesPossibles = db.queryByExample(cancionABorrar);

        Cancion cancion = null;
        for (Object objecte : cancionesPossibles) {
            cancion = (Cancion) objecte;
            break;
        }
        db.delete(cancion);

    }

    public List indexCancionesPerAlbum(String nom, String artista, String data) {

        Cancion cancionQuery = new Cancion();

        Album albumQuery = new Album();

        albumQuery.setNom(nom);
        albumQuery.setArtista(artista);
        albumQuery.setData(data);

        ObjectSet albumsPossibles = db.queryByExample(albumQuery);

        Album album = null;
        for (Object objecte : albumsPossibles) {

            album = (Album) objecte;
        }

        cancionQuery.setAlbum(album);

        this.currentAlbum = album;

        ObjectSet result = db.queryByExample(cancionQuery);

        List resultats = new ArrayList();

        for (Object objecte : result) {
            resultats.add(objecte);
        }
        return resultats;

    }

    public List getCancionesFromCurrentAlbum() {

        Cancion cancionQuery = new Cancion();

        cancionQuery.setAlbum(currentAlbum);

        ObjectSet result = db.queryByExample(cancionQuery);

        List resultats = new ArrayList();

        for (Object objecte : result) {
            resultats.add(objecte);
        }
        return resultats;
    }

}
