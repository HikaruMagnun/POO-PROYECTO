package QR;


import com.google.zxing.WriterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author HP
 */
public class QR_MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws WriterException, IOException, InterruptedException, SQLException {
        File file = new File("AulaSeg.txt");

        if (!file.exists()) {
            try {
                FileWriter wr = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(wr);
                writer.write("A0307");
                writer.newLine();
                writer.write("5"); 
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         QR_VIEW QR = new QR_VIEW();
         QR.setVisible(true);
         QR.setLocationRelativeTo(null);
         QR.GENERADOR();
       
         
    }
    
}
