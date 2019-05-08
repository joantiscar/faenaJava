/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import model.Model;
import org.bson.Document;

/**
 *
 * @author dios
 */
public class Main {


    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
            Model model = new Model();
            model.setDatabase("consultes");
            model.setCollection("users");
            List<Document> documents = model.indexDocuments();
            
            for (Document doc : documents) {
                System.out.println(doc);
            }
            
    }

    
}
