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

import java.util.Collection;
import java.sql.SQLException;
import java.io.Serializable;
import java.util.List;
import main.CancionesDAO;


public final class Model implements Serializable {


    private Collection<Canciones> data;
    CancionesDAO dao = new CancionesDAO();
    
    private static final String QUERY_BASED_ON_NAME = "from Canciones a where a._1_Nom like '";
    private static final String QUERY_BASED_ON_GENERE = "from Canciones a where a._2_Genere like '";
    private static final String QUERY_BASED_ON_DATA = "from Canciones a where a._3_Data like '";
    private static final String QUERY_INDEX = "from Canciones";

    public List runQueryBasedOnNom(String filter) {
        return dao.selectAll();
    }

    public List runQueryBasedOnGenere(String filter) {
        return dao.selectAll();
    }
    
    public List runQueryBasedOnData(String filter) {
        return dao.selectAll();
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
//    public void modifyData(Object obj, String nom, Object genere, String dat) throws SQLException {
//  
//    }
//
//    public void removeData(Object obj) throws SQLException {
//    
//    }
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
