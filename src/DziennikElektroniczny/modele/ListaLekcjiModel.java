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
public class ListaLekcjiModel {

    public String[] listaLekcji(Connection conn, String klasaIPrzedmiot) {
        String[] lekcje;
        
        String[] klasaPrzedmiot = klasaIPrzedmiot.split(" | ");
        try {
            Statement lekcjeSt = conn.createStatement();
            ResultSet rsLekcje = lekcjeSt.executeQuery("SELECT COUNT(*) FROM LEKCJE WHERE PRZYDZIAL = (SELECT ID FROM PRZYDZIALY WHERE (KLASA = " + klasaPrzedmiot[0] + " AND PRZEDMIOT = '" + klasaPrzedmiot[2] + "')) ORDER BY NUMER");
            rsLekcje.next();
            lekcje = new String[rsLekcje.getInt(1) + 1];
            rsLekcje = lekcjeSt.executeQuery("SELECT ID FROM LEKCJE WHERE PRZYDZIAL = (SELECT ID FROM PRZYDZIALY WHERE (KLASA = " + klasaPrzedmiot[0] + " AND PRZEDMIOT = '" + klasaPrzedmiot[2] + "')) ORDER BY NUMER");
            lekcje[0] = "---WYBIERZ---";
            int i = 1;
            while (rsLekcje.next()) {
                lekcje[i++] = (rsLekcje.getString(1));
            }
            rsLekcje.close();
            lekcjeSt.close();
            return lekcje;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    new String[]{"Wystąpił błąd: " + ex.getMessage()});
        }
        return null;
    }
}
