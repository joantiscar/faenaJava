/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.bson.Document;

/**
 *
 * @author dios
 */
public class Model {

    private final MongoClient mongoClient = new MongoClient();
    private MongoDatabase database;
    MongoCollection<Document> collection;
    Document document;

    public String[] getDatabases() {
        MongoIterable<String> databases = mongoClient.listDatabaseNames();
        int cont = 0;
        for (String s : databases) {
            cont++;
        }
        String[] databaseNoms = new String[cont];
        databases = mongoClient.listDatabaseNames();
        cont = 0;
        for (String s : databases) {
            databaseNoms[cont] = s;
            cont++;
        }
        return databaseNoms;
    }

    public void setDatabase(String nom) {
        database = mongoClient.getDatabase(nom);
    }

    public String[] getCollections(String database) {

        MongoDatabase db = mongoClient.getDatabase(database);

        MongoIterable<String> collections = db.listCollectionNames();

        int cont = 0;
        for (String s : collections) {
            cont++;
        }

        String[] collectionsNoms = new String[cont];
        cont = 0;
        for (String s : collections) {
            collectionsNoms[cont] = s;
            cont++;
        }
        return collectionsNoms;

    }

    public void setCollection(String nom) {
        collection = database.getCollection(nom);
    }

    public List<Document> indexDocuments() {

        List<Document> documents = new ArrayList();

        for (Document doc : collection.find()) {
            documents.add(doc);
        }
        return documents;
    }

    public void setDocument(Object id) {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);
        document = collection.find(query).first();
    }

    public String[] getKeys() {

        Set<String> llista = document.keySet();

        List<String> keys = new ArrayList();

        llista.forEach((s) -> {
            keys.add(s);
        });
        int cont = 0;
        for (String s : keys) {
            cont++;
        }

        String[] keysNoms = new String[cont];
        cont = 0;
        for (String s : keys) {
            keysNoms[cont] = s;
            cont++;
        }
        return keysNoms;

    }

    public Object getValueFromKey(Object key) {

        return document.get(key);

    }

    public boolean insertDocument(String dades) {
        try {
            collection.insertOne(Document.parse(dades));
            return true;
        } catch (org.bson.json.JsonParseException e) {
            return false;
        }

    }

    public boolean updateDocument(String dades) {
        try {
            collection.replaceOne(document, Document.parse(dades));
            return true;
        } catch (org.bson.json.JsonParseException e) {
            return false;
        }

    }

    public boolean updateKey(Object key, String valor) {
        try {
            BasicDBObject dades = new BasicDBObject("$set", new BasicDBObject(key.toString(), valor));
            collection.updateOne(document, dades);

            return true;
        } catch (org.bson.json.JsonParseException e) {
            return false;
        }

    }

    public boolean removeKey(String key) {
        try {
            System.out.println(key);
            System.out.println("astio");
            BasicDBObject dades = new BasicDBObject("$unset", new BasicDBObject(key, ""));
            collection.updateOne(document, dades);

            return true;
        } catch (org.bson.json.JsonParseException e) {
            return false;
        }

    }

    public boolean removeDocument() {
        try {
            collection.deleteOne(document);
            return true;
        } catch (org.bson.json.JsonParseException e) {
            return false;
        }

    }
}
