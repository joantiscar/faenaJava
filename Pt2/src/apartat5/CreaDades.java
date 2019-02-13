/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat5;

/**
 *
 * @author dios
 */
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class CreaDades {

    public static void main(String[] args) throws IOException {

        DataOutputStream out = null;

        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("aleatori.dat")));

//            for (int i = 0; i < 10; i++) {
//                out.writeInt(i);
//            }
            out.writeLong(0);
            out.writeLong(1);
            out.writeLong(2);
            out.writeLong(3);
            out.writeLong(4);
            out.writeLong(5);
            out.writeLong(6);
            out.writeLong(7);

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
