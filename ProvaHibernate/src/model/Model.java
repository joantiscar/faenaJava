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
import hibernate.entity.Canciones;
import hibernate.util.HibernateUtil;
import java.util.Collection;
import java.sql.SQLException;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public final class Model implements Serializable {


    private Collection<Canciones> data;

    
    private static final String QUERY_BASED_ON_NAME = "from Canciones a where a._1_Nom like '";
    private static final String QUERY_BASED_ON_GENERE = "from Canciones a where a._2_Genere like '";
    private static final String QUERY_BASED_ON_DATA = "from Canciones a where a._3_Data like '";
    private static final String QUERY_INDEX = "from Canciones";

    public List runQueryBasedOnNom(String filter) {
        return executeHQLQuery(QUERY_BASED_ON_NAME + filter + "%'");
    }

    public List runQueryBasedOnGenere(String filter) {
        return executeHQLQuery(QUERY_BASED_ON_GENERE + filter + "%'");
    }
    
    public List runQueryBasedOnData(String filter) {
        return executeHQLQuery(QUERY_BASED_ON_DATA + filter + "%'");
    }
    
     private List executeHQLQuery(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            he.printStackTrace();
            return null;
        }

    }
//
    public List getData() throws SQLException {
        return executeHQLQuery(QUERY_INDEX);
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
