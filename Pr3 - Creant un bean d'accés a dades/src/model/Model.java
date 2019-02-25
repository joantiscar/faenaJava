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
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.beans.*;
import java.io.Serializable;

public final class Model implements Serializable {

    static Connection connection = null;

    private Collection<Cancion> data;

    private PropertyChangeSupport propertySupport;

    private static String database;

    public static final String PROP_DATABASE = "database";

    /**
     * Get the value of database
     *
     * @return the value of database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * Set the value of database
     *
     * @param database new value of database
     * @throws java.beans.PropertyVetoException
     */
    public void setDatabase(String database) throws PropertyVetoException {
        String oldDatabase = this.database;
        System.out.println(oldDatabase + database);
        vetoableChangeSupport.fireVetoableChange(PROP_DATABASE, oldDatabase, database);
        this.database = database;
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private transient final VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);

    /**
     * Add VetoableChangeListener.
     *
     * @param listener
     */
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.addVetoableChangeListener(listener);
    }

    /**
     * Remove VetoableChangeListener.
     *
     * @param listener
     */
    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.removeVetoableChangeListener(listener);
    }

    private static String dbuser;

    public static final String PROP_DBUSER = "dbuser";

    /**
     * Get the value of dbuser
     *
     * @return the value of dbuser
     */
    public String getDbuser() {
        return dbuser;
    }

    /**
     * Set the value of dbuser
     *
     * @param dbuser new value of dbuser
     * @throws java.beans.PropertyVetoException
     */
    public void setDbuser(String dbuser) throws PropertyVetoException {
        String oldDbuser = this.dbuser;
        vetoableChangeSupport.fireVetoableChange(PROP_DBUSER, oldDbuser, dbuser);
        this.dbuser = dbuser;
    }

    private static String dbpassword;

    public static final String PROP_DBPASSWORD = "dbpassword";

    /**
     * Get the value of dbpassword
     *
     * @return the value of dbpassword
     */
    public String getDbpassword() {
        return dbpassword;
    }

    /**
     * Set the value of dbpassword
     *
     * @param dbpassword new value of dbpassword
     * @throws java.beans.PropertyVetoException
     */
    public void setDbpassword(String dbpassword) throws PropertyVetoException {
        String oldDbpassword = this.dbpassword;
        vetoableChangeSupport.fireVetoableChange(PROP_DBPASSWORD, oldDbpassword, dbpassword);
        this.dbpassword = dbpassword;
    }

    public Model() throws SQLException, ClassNotFoundException, PropertyVetoException {
        propertySupport = new PropertyChangeSupport(this);
    }

    public Model(String databaseName) throws ClassNotFoundException, SQLException, PropertyVetoException {
        propertySupport = new PropertyChangeSupport(this);

        prepareDatabase(databaseName);
        loadData();
    }

    public void loadData() throws SQLException {

        data = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM canciones;");

            while (rs.next()) {
                Cancion cancion = new Cancion(rs.getString("nom"), Cancion.Genere.valueOf(rs.getString("genere")), rs.getString("data"));
                data.add(cancion);
            }

        } catch (SQLException e) {
            System.out.println("Error al llistar les cançons! \nError: " + e);
        }
    }

    public void prepareDatabase(String nom) throws SQLException, PropertyVetoException {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.setDatabase(prop.getProperty("database"));
            this.setDbuser(prop.getProperty("dbuser"));
            this.setDbpassword(prop.getProperty("dbpassword"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String url = prop.getProperty("database") + nom + "?allowMultiQueries=true";
        String user = prop.getProperty("dbuser");
        String password = prop.getProperty("dbpassword");
        try {
            connection = DriverManager.getConnection(url, user, password);
            boolean correcte = connection.isValid(50000);
            System.out.println(correcte ? "Connexio correcta" : "Error de connexio");

        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
            System.out.println("Creant base de dades...");
            crearBaseDeDades(nom);

        }
    }

    public void addData(String nom, Object cat, String dat) throws SQLException {
        Cancion b = new Cancion(nom, (Cancion.Genere) cat, dat);

        Statement statement = connection.createStatement();
        PreparedStatement create = null;
        try {
            String query = ("INSERT INTO canciones(nom, genere, data) VALUES ('" + nom + "','" + cat.toString() + "','" + dat + "');");

            connection.setAutoCommit(false);

            create = connection.prepareStatement(query);

            create.execute();

            connection.commit();

            connection.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println("Error al crear la cançó");
            System.out.println("Error: " + e);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (create != null) {
                create.close();
            }
        }

        data.add(b);

    }

    public void modifyData(Object obj, String nom, Object genere, String dat) throws SQLException {
        Cancion b = (Cancion) obj;
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate("UPDATE canciones SET nom ='" + nom + "' WHERE nom ='" + b.get_1_Nom() + "';");
            statement.executeUpdate("UPDATE canciones SET genere ='" + genere + "' WHERE nom ='" + nom + "';");
            statement.executeUpdate("UPDATE canciones SET data ='" + dat + "' WHERE nom ='" + nom + "';");
            b.set_1_Nom(nom);
            b.set_2_Genere((Cancion.Genere) genere);
            b.set_3_Data(dat);
        } catch (SQLException e) {
            System.out.println("Error al editar la cançó");
            System.out.println("Error: " + e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void removeData(Object obj) throws SQLException {
        Cancion b = (Cancion) obj;
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate("DELETE FROM canciones WHERE nom ='" + b.get_1_Nom() + "';");
            System.out.println("Cançó esborrada correctament");
            data.remove(b);
        } catch (SQLException e) {
            System.out.println("Error al borrar la cançó");
            System.out.println("Error: " + e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public Collection<Cancion> getData() {
        return data;
    }

    private void crearBaseDeDades(String databaseName) throws SQLException {

        String url = this.getDatabase();
        String user = this.getDbuser();
        String password = this.getDbpassword();
        try {
            connection = DriverManager.getConnection(url, user, password);
            boolean correcte = connection.isValid(50000);
            System.out.println(correcte ? "Connexio correcta" : "Error de connexio");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate("CREATE DATABASE " + databaseName);
            System.out.println("Base de dades creada");
            System.out.println("Començant operacions...");

        } catch (SQLException e) {
            System.out.println("Error al crear la base de dades");
            System.out.println("Error: " + e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        connection = DriverManager.getConnection(url + databaseName, user, password);

        try {
            String[][] camps = {
                {"nom", "varchar(50) primary key"}, {"genere", "ENUM('Rock','Blues','Jazz','Pop','Folk','Altres')"},
                {"data", "varchar(20)"}};

            crearTaula("canciones", camps);

        } catch (SQLException e) {
            System.out.println("Error al crear la base de dades");
            System.out.println("Error: " + e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

    }

    public static void crearTaula(String nom, String[][] camps) throws SQLException {

        crearTaula(nom, camps, "");
    }

    public static void crearTaula(String nom, String[][] camps, String extres) throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE ").append(nom).append("(");
        for (String[] camp : camps) {
            query.append(camp[0]).append(' ').append(camp[1]);
            if (camp.length > 2) {
                if (camp[2].length() > 0) {
                    query.append(' ').append(camp[2]);
                }

            }
            query.append(',');

        }
        query.deleteCharAt(query.length() - 1);
        query.append(extres);
        query.append(");");

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query.toString());
            System.out.println("Taula " + nom + " creada correctament!");
        } catch (SQLException e) {
            System.out.println("Error al crear la taula! \nError: " + e);
        }
    }

    public static void listCanciones() throws SQLException {

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
