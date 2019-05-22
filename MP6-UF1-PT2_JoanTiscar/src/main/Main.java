/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import java.io.IOException;
import java.sql.SQLException;
import model.Model;
import vista.Vista;

/**
 *
 * @author dios
 */
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Model m = new Model();
        Vista v = new Vista();
        Controller c = new Controller(m, v);
    }
}
