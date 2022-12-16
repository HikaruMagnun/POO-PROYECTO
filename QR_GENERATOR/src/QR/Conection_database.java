/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QR;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Conection_database {
    final String cadenas = "jdbc:postgresql://db.zjxdboacmeqxvxmjzvzc.supabase.co:5432/postgres?user=postgres&password=AwKjM6LXSEun0HoD";
    Connection conectar = null;
    public Conection_database() {
        try{
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadenas);
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar a la base datos");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Driver Error");
        }
    }
    
    public int Obtener_QRcode_de_Aula(String Cod_Aula) throws SQLException{
        String Query = "SELECT \"QrCode\" from \"Aula\" where \"CodAula\" = '"+Cod_Aula+"';";
        int QR_code;
        try (Statement stmt = conectar.createStatement()) {
            ResultSet rs = stmt.executeQuery(Query);
            rs.next();
            QR_code = rs.getInt(1);
            rs.close();
        }
        return QR_code;
        
        //throw new SQLException(JOptionPane.showMessageDialog(null,"Driver Error"));
    
    }
    
    public void actualizar_qr_code(String Cod_Aula,int qr_code) throws SQLException{
        String Query = "update \"Aula\" set \"QrCode\" = "+ qr_code +" where \"CodAula\" = '"+Cod_Aula+"';";
        try{
            CallableStatement cs = conectar.prepareCall(Query);
            cs.execute();
            cs.close(); 
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al actualizar el qr");
        }
        
        

    }
    
    public ArrayList<String> aulas () throws SQLException{
        List<String> Aulas = new ArrayList<>();
        String Query = "SELECT \"CodAula\" from \"Aula\" ";
        Statement stmt = conectar.createStatement();
        ResultSet rs = stmt.executeQuery(Query);
        while (rs.next()) {
           Aulas.add(rs.getString(1)); 
        }
        rs.close();
        stmt.close();

        return (ArrayList<String>) (Aulas);
        
    }
    
    
    
}
