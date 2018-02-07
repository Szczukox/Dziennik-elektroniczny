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
public class LekcjeModel {

    private final Connection conn;
    private ResultSet dane;
    private PreparedStatement zapytanie;
    private int przydzial;

    public LekcjeModel(Connection connection, String klasaIPrzedmiot) {
        conn = connection;
        zapytanie = null;
        try {
            if (dane != null) {
                if (!(dane.isClosed())) {
                    dane.close();
                    zapytanie.close();
                }
            }
            String[] klasaPrzedmiot = klasaIPrzedmiot.split(" | ");
            String sql = "SELECT ID FROM PRZYDZIALY WHERE KLASA = " + klasaPrzedmiot[0] + " AND PRZEDMIOT = '" + klasaPrzedmiot[2] + "'";
            zapytanie = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            dane = zapytanie.executeQuery();
            dane.beforeFirst();
            dane.next();
            przydzial = dane.getInt("ID");
            sql = "SELECT ID, NUMER, TEMAT, DATA, PRZYDZIAL FROM LEKCJE WHERE PRZYDZIAL = (SELECT ID FROM PRZYDZIALY WHERE KLASA = " + klasaPrzedmiot[0]
                    + " AND PRZEDMIOT = '" + klasaPrzedmiot[2] + "')";
            zapytanie = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            dane = zapytanie.executeQuery();
            dane.beforeFirst();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public void dodajLekcje(String numer, String temat, Timestamp data) {
        try {
            dane.moveToInsertRow();
            dane.updateInt("NUMER", Integer.parseInt(numer));
            dane.updateString("TEMAT", temat);
            dane.updateTimestamp("DATA", data);
            dane.updateInt("PRZYDZIAL", przydzial);
            dane.insertRow();
            dane.moveToCurrentRow();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public void edytujLekcje(String numer, String temat, Timestamp data, int row) {
        try {
            dane.beforeFirst();
            for (int i = -1; i < row; i++) {
                dane.next();
            }
            dane.updateInt("NUMER", Integer.parseInt(numer));
            dane.updateString("TEMAT", temat);
            dane.updateTimestamp("DATA", data);
            dane.updateInt("PRZYDZIAL", przydzial);
            dane.updateRow();
            dane.moveToCurrentRow();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }
}
