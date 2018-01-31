/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.modele;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author patry
 */
public class ListaNauczycieliModel {

    public String[] listaNauczycieli(Connection conn) {
        String[] nauczyciele;

        try {
            Statement nauczycieleSt = conn.createStatement();
            ResultSet rsNauczyciele = nauczycieleSt.executeQuery("SELECT COUNT(*) FROM NAUCZYCIELE");
            rsNauczyciele.next();
            nauczyciele = new String[rsNauczyciele.getInt(1) + 1];
            rsNauczyciele = nauczycieleSt.executeQuery("SELECT ID FROM NAUCZYCIELE");
            nauczyciele[0] = "---WYBIERZ---";
            int i = 1;
            while (rsNauczyciele.next()) {
                nauczyciele[i++] = String.valueOf(rsNauczyciele.getInt(1));
            }
            rsNauczyciele.close();
            nauczycieleSt.close();
            return nauczyciele;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    new String[]{"Wystąpił błąd: " + ex.getMessage()});
        }
        return null;
    }
}
