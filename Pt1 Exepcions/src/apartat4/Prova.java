/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat4;

import static java.lang.System.err;

/**
 *
 * @author dios
 */
public class Prova implements AutoCloseable {



    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Igual ha petat una mica");
    }
}

class prova {

    public static void performTryWithResource() throws Exception {
        try ( Prova prova = new Prova()) {
            prova.close();
        }
    }

    public static void main(String[] args) {
        try {
            performTryWithResource();
        } catch (Exception ex) {
            Throwable[] suppressed = ex.getSuppressed();
            for (int i = 0; i < suppressed.length; i++) {
                System.out.println(suppressed[i].getMessage());

            }

        }
    }
}
