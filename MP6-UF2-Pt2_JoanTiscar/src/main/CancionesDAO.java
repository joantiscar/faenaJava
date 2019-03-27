/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import model.Canciones;
import model.Canciones;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author dios
 */
public class CancionesDAO {
    
    private SqlSessionFactory sqlSessionFactory;
    
    public CancionesDAO() {
            sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }
    
    @SuppressWarnings("unchecked")
    public List<Canciones> selectAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Canciones> list = session.selectList("Canciones.getAll");
            return list;
        }
    }
    
    public List getByName(String name) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Canciones> canciones = session.selectList("Canciones.getByName", name);
            System.out.println(canciones);
            return canciones;
        }
    }
    
    public List getByGenere(String genere) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Canciones> canciones = session.selectList("Canciones.getByGenere", genere);
            System.out.println(canciones);
            return canciones;
        }
    }
    
    public List getByData(String data) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Canciones> canciones = session.selectList("Canciones.getByData", data);
            System.out.println(canciones);
            return canciones;
        }
    }
    
     public void update(String cancionOriginal, Canciones canciones) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Cancion cancion = new Cancion();
            cancion.set_1_Nom(canciones.get_1_Nom());
            cancion.set_2_Genere(canciones.get_2_Genere());
            cancion.set_3_Data(canciones.get_3_Data());
            cancion.setNomOriginal(cancionOriginal);
            session.update("Canciones.update", (Object) cancion);
            session.commit();
        }
    }
     
     public void insert(Canciones cancion) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("Canciones.insert", cancion);
            System.out.println("astio");
            session.commit();
        }
    }
     
     public void delete(String name) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("Canciones.deleteByName", name);
            session.commit();
        }
    }
}
class Cancion extends Canciones{
    private String nomOriginal;

    public String getNomOriginal() {
        return nomOriginal;
    }

    public void setNomOriginal(String nomOriginal) {
        this.nomOriginal = nomOriginal;
    }
    
    
}
