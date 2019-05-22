/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dios
 */
public class Model {

    ArrayList dades = new ArrayList();

    public Model() {
        try {
            this.llegirDades();
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarDades() throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try ( FileWriter fitxer = new FileWriter("astio.json")) {
            gson.toJson(dades, fitxer);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void llegirDades() throws IOException {
        this.dades = new ArrayList();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try ( FileReader fitxer = new FileReader("astio.json")) {
            JsonReader reader = new JsonReader(fitxer);
            reader.beginArray();
            while (reader.hasNext()) {
                dades.add(gson.fromJson(reader, Album.class));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList getDades() {
        return this.dades;
    }

    public void afegirAlbum(String nom, String artista, String data) {

        this.dades.add(new Album(nom, artista, data));
    }

    public void editarAlbum(Album album, String nom, String artista, String data) {

        album.setNom(nom);
        album.setArtista(artista);
        album.setData(data);
    }

    public void removeAlbum(Album album) {
        this.dades.remove(album);
    }
}
