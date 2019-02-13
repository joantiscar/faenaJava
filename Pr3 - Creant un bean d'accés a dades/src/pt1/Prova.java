/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dios
 */
public class Prova {

    static Connection connection = null;

    public void connectDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/canciones?allowMultiQueries=true";
        String user = "debian-sys-maint";
        String password = "3oVPAN3HgLOQGRfG";
        try {
            connection = DriverManager.getConnection(url, user, password);
            boolean correcte = connection.isValid(50000);
            System.out.println(correcte ? "Connexio correcta" : "Error de connexio");
            
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
            System.out.println("Creant base de dades...");
            crearBaseDeDades();
           
        }
        listCanciones();
    }

    public static void main(String[] args) throws SQLException {

        Prova javaMySQLBasic = new Prova();
        javaMySQLBasic.connectDatabase();
            
       
    }

    private static void crearBaseDeDades() throws SQLException {
         String url = "jdbc:mysql://localhost:3306/";
        String user = "debian-sys-maint";
        String password = "3oVPAN3HgLOQGRfG";
        try {
            connection = DriverManager.getConnection(url, user, password);
            boolean correcte = connection.isValid(50000);
            System.out.println(correcte ? "Connexio correcta" : "Error de connexio");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate("CREATE DATABASE canciones");
            System.out.println("Base de dades creada");
            System.out.println("Començant operacions...");
             
        } catch (SQLException e) {
            System.out.println("Error al crear la base de dades");
            System.out.println("Error: "+e);
        }finally{
            if (statement != null) statement.close();
        }
                    connection = DriverManager.getConnection(url + "canciones", user, password);

         try {
            String[][] camps = {{"id", "integer", "auto_increment primary key"}, 
                {"nom", "varchar(50)"}, {"genere", "ENUM('Rock','Blues','Jazz','Pop','Folk','Altres')"}, {"data", "varchar(20)"}};
            
            crearTaula("canciones", camps);
             
        } catch (SQLException e) {
            System.out.println("Error al crear la base de dades");
            System.out.println("Error: "+e);
        }finally{
            if (statement != null) statement.close();
        }
        
        
        
    }
    
    public static void crearTaula(String nom, String[][] camps) throws SQLException{
        
        crearTaula(nom, camps , "");
    }
    
    public static void crearTaula(String nom, String[][] camps, String extres) throws SQLException{
      StringBuilder query = new StringBuilder();
      query.append("CREATE TABLE ").append(nom).append("(");
        for (String[] camp : camps) {
            query.append(camp[0]).append(' ').append(camp[1]);
            if (camp.length>2){
              if (camp[2].length() > 0) query.append(' ').append(camp[2]);
            
            }
            query.append(',');
            
        }
        query.deleteCharAt(query.length()-1);
        query.append(extres);
        query.append(");");
      
      try {
         Statement statement = connection.createStatement();
      statement.executeUpdate(query.toString());
          System.out.println("Taula " +nom +" creada correctament!");
      } catch (SQLException e) {
            System.out.println("Error al crear la taula! \nError: " + e);
      }
  }
    public static void listCanciones() throws SQLException{
      
      try {
         Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM canciones;");
 
       while (rs.next()) {
               
                System.out.println(rs.getInt("id") + rs.getString("nom") + rs.getString("genere") + rs.getString("data"));
            }
      
         
      } catch (SQLException e) {
            System.out.println("Error al llistar les cançons! \nError: " + e);
      }
  }
}
