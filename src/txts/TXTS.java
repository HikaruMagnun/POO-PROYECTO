/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package txts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author HP
 */
public class TXTS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileWriter writer;
        try {
            FileWriter fw = new FileWriter("AulaSeg.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("A0307");
            bw.newLine();
            bw.write("5"); 
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
