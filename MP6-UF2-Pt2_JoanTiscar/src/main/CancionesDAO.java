/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
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
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Canciones> list = session.selectList("Canciones.getAll");
            return list;
        } finally {
        session.close();
    }
    }
    
    public Canciones getById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Canciones cancion = (Canciones) session.selectOne("Canciones.getById", id);
            return cancion;
        }
    }
    
     public void update(Canciones cancion) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("Canciones.update", cancion);
            session.commit();
        }
    }
     
     public void insert(Canciones cancion) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("Canciones.insert", cancion);
            session.commit();
        }
    }
     
     public void delete(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("Canciones.deleteById", id);
            session.commit();
        }
    }
}
