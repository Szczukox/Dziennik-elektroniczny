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
public class ListaPrzydzialowDlaNauczycieliModel {

    public String[] listaPrzydzialow(Connection conn, String nauczyciel) {
        String[] przydzialy;

        try {
            Statement przydzialySt = conn.createStatement();
            ResultSet rsPrzydzialy = przydzialySt.executeQuery("SELECT COUNT(*) FROM PRZYDZIALY WHERE NAUCZYCIEL = " + nauczyciel);
            rsPrzydzialy.next();
            przydzialy = new String[rsPrzydzialy.getInt(1) + 1];
            rsPrzydzialy = przydzialySt.executeQuery("SELECT concat(NAZWA, ' (', ROK_POWSTANIA, ') - ID: ', k.ID) AS 'KLASA', PRZEDMIOT, KLASA AS 'ID_KLASY' FROM PRZYDZIALY p, KLASY k WHERE p.KLASA = k.ID AND NAUCZYCIEL = " + nauczyciel);
            przydzialy[0] = "---WYBIERZ---";
            int i = 1;
            while (rsPrzydzialy.next()) {
                przydzialy[i++] = (rsPrzydzialy.getString("KLASA") + " | " + rsPrzydzialy.getString("PRZEDMIOT"));
            }
            rsPrzydzialy.close();
            przydzialySt.close();
            return przydzialy;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    new String[]{"Wystąpił błąd: " + ex.getMessage()});
        }
        return null;
    }
}
