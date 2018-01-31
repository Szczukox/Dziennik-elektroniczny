/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.modele;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author patry
 */
public class ListaKlasModel {
    public String[] listaKlas(Connection conn) {
        String[] klasy;
        
        try {
            Statement klasySt = conn.createStatement();
            ResultSet rsKlasy = klasySt.executeQuery("SELECT COUNT(*) FROM KLASY");
            rsKlasy.next();
            klasy = new String[rsKlasy.getInt(1) + 1];
            rsKlasy = klasySt.executeQuery("SELECT ID FROM KLASY");
            klasy[0] = "---WYBIERZ---";
            int i = 1;
            while (rsKlasy.next()) {
                klasy[i++] = (rsKlasy.getString(1));
            }
            rsKlasy.close();
            klasySt.close();
            return klasy;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    new String[] {"Wystąpił błąd: " + ex.getMessage()});
        }  
        return null;
    }
}
