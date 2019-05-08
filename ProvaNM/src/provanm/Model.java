/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provanm;

/**
 *
 * @author dios
 */
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Model implements Serializable {

    ObjectContainer db = null;

    Album currentAlbum = null;

    public static void main(String[] args) {
        Model m = new Model("astio.yap");
    }
    
    public Model(String filename) {
        try {
            // Obrim o creem el fitxer qbe.yap
            File file = new File(filename);
            file.delete();
            db = Db4oEmbedded.openFile(filename);
        } catch (Exception e) {
            System.out.println("Error!: \n" + e);
        }

        Cancion cancion1 = new Cancion();
        Cancion cancion2 = new Cancion();
        Cancion cancion3 = new Cancion();
        Cancion cancion4 = new Cancion();
        Cancion cancion5 = new Cancion();
        Album album1 = new Album();
        Album album2 = new Album();
        Album album3 = new Album();
        Album album4 = new Album();
        Album album5 = new Album();
        ArrayList albums = new ArrayList();
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        albums.add(album4);
        albums.add(album5);
        cancion1.setAlbums(albums);
        ArrayList canciones = new ArrayList();
        canciones.add(cancion1);
        canciones.add(cancion2);
        canciones.add(cancion3);
        canciones.add(cancion4);
        canciones.add(cancion5);
        album1.setCanciones(canciones);
        
        db.store(album1);
        db.store(album2);
        db.store(album3);
        db.store(album4);
        db.store(album5);
        db.store(cancion1);
        db.store(cancion2);
        db.store(cancion3);
        db.store(cancion4);
        db.store(cancion5);
        
        ObjectSet result = db.queryByExample(new Object());
        
        for(Object objecte : result){
            
            if (objecte.getClass() == Album.class){
                System.out.println(((Album)objecte).getCanciones());
            }
            if (objecte.getClass() == Cancion.class){
                System.out.println(((Cancion)objecte).getAlbums());
            }
        }
        
        
        db.close();
        
        
    }

    public void closeDatabase() {
        db.close();
    }


}
