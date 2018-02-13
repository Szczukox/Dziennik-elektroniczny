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
            String[] klasaPrzedmiot = klasaIPrzedmiot.split("ID: ");
            String[] klasa = klasaPrzedmiot[1].split("[ ]");
            String[] przedmiot = klasaIPrzedmiot.split("[|]");
            String sql = "SELECT ID FROM PRZYDZIALY WHERE KLASA = " + klasa[0] + " AND PRZEDMIOT = '" + przedmiot[1].substring(1) + "'";
            zapytanie = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            dane = zapytanie.executeQuery();
            dane.beforeFirst();
            dane.next();
            przydzial = dane.getInt("ID");
            sql = "SELECT ID, NUMER, TEMAT, DATA, PRZYDZIAL FROM LEKCJE WHERE PRZYDZIAL = " + przydzial;
            zapytanie = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            dane = zapytanie.executeQuery();
            dane.beforeFirst();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public void dodajLekcje(String numer, String temat, Timestamp data) {
        try {
            String sql = "INSERT INTO LEKCJE VALUES (NULL, " + numer + ", '" + temat + "', '" + data + "', " + przydzial + ")";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public void edytujLekcje(String numer, String temat) {
        try {
            String sql = "UPDATE LEKCJE SET TEMAT = '" + temat + "' WHERE NUMER = " + numer + " AND PRZYDZIAL = " + przydzial;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }
}
