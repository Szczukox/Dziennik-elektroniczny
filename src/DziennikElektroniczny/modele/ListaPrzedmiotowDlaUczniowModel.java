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
public class ListaPrzedmiotowDlaUczniowModel {

    public String[] listaPrzedmiotow(Connection conn, String uczen) {
        String[] przedmioty;

        try {
            Statement przedmiotySt = conn.createStatement();
            ResultSet rsPrzedmioty = przedmiotySt.executeQuery("SELECT COUNT(*) FROM PRZYDZIALY WHERE KLASA = (SELECT KLASA FROM UCZNIOWIE WHERE ID = " + uczen + ")");
            rsPrzedmioty.next();
            przedmioty = new String[rsPrzedmioty.getInt(1) + 1];
            rsPrzedmioty = przedmiotySt.executeQuery("SELECT PRZEDMIOT FROM PRZYDZIALY WHERE KLASA = (SELECT KLASA FROM UCZNIOWIE WHERE ID = " + uczen + ")");
            przedmioty[0] = "---WYBIERZ---";
            int i = 1;
            while (rsPrzedmioty.next()) {
                przedmioty[i++] = (rsPrzedmioty.getString(1));
            }
            rsPrzedmioty.close();
            przedmiotySt.close();
            return przedmioty;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    new String[]{"Wystąpił błąd: " + ex.getMessage()});
        }
        return null;
    }
}
