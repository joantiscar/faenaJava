/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author dios
 */
public class Linies {

    public static void main(String[] args) throws IOException {

        BufferedReader inputStream1 = null;
        BufferedReader inputStream2 = null;
        PrintWriter outputStream = null;

        try {
            inputStream1 = new BufferedReader(new FileReader("origen1.txt"));
            inputStream2 = new BufferedReader(new FileReader("origen2.txt"));
            outputStream = new PrintWriter(new FileWriter("fusio.txt"));

            String a;

            while ((a = inputStream1.readLine()) != null) {
                outputStream.println(a);
                a = inputStream2.readLine();
                if (a != null) {
                    outputStream.println(a);
                }

            }
            while ((a = inputStream2.readLine()) != null) {
                outputStream.println(a);

            }
        } finally {
            if (inputStream1 != null && inputStream2 != null) {
                inputStream1.close();
                inputStream2.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }

    }
}
