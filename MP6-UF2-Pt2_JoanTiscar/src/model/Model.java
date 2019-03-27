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

import main.CancionesDAO;
import java.util.Collection;
import java.sql.SQLException;
import java.io.Serializable;
import java.util.List;


public final class Model implements Serializable {


    private Collection<Canciones> data;
    CancionesDAO dao = new CancionesDAO();
    
    private static final String QUERY_BASED_ON_NAME = "from Canciones a where a._1_Nom like '";
    private static final String QUERY_BASED_ON_GENERE = "from Canciones a where a._2_Genere like '";
    private static final String QUERY_BASED_ON_DATA = "from Canciones a where a._3_Data like '";
    private static final String QUERY_INDEX = "from Canciones";

    public List runQueryBasedOnNom(String filter) {
        return dao.getByName("%" + filter + "%");
    }

    public List runQueryBasedOnGenere(String filter) {
        return dao.getByGenere("%" + filter + "%");
    }
    
    public List runQueryBasedOnData(String filter) {
        return dao.getByData("%" + filter + "%");
    }
    
//
    public List getData() throws SQLException {
        return dao.selectAll();
    }
//
//    public void addData(String nom, Object cat, String dat) throws SQLException {
//        
//
//    }
//
    public void runDeleteQuery(String name) throws SQLException {
    dao.delete(name);
    }
    
    public void runInsertQuery(String name, String genere, String data) throws SQLException {
        Canciones cancion = new Canciones();
        cancion.set_1_Nom(name);
        cancion.set_2_Genere(genere);
        cancion.set_3_Data(data);
        dao.insert(cancion);
    }
    
    public void runModifyQuery(String originalName, String name, String genere, String data) throws SQLException {
        Canciones cancion = new Canciones();
        cancion.set_1_Nom(name);
        cancion.set_2_Genere(genere);
        cancion.set_3_Data(data);
        dao.update(originalName, cancion);
    }
//
//    public Collection<Canciones> getData() {
//        return data;
//    }
//
//  
//
//    public static void listCanciones() throws SQLException {
//
//      
//    }
    
   
    
}
