/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author patry
 */
public class UczniowieDlaNauczycieliTableModel extends AbstractTableModel {

    private final Connection conn;
    private ResultSet dane;
    private ResultSetMetaData metadane;
    private int liczbaKolumn;
    private int liczbaWierszy;
    private PreparedStatement zapytanie;
    private String lekcja;

    public UczniowieDlaNauczycieliTableModel(Connection connection, String klasaIPrzedmiot, String lekcja) {
        conn = connection;
        this.lekcja = lekcja;
        zapytanie = null;
        try {
            if (dane != null) {
                if (!(dane.isClosed())) {
                    dane.close();
                    zapytanie.close();
                }
            }
            String sql = null;
            String[] idKlasy = null;
            String[] idLekcji = null;
            if (klasaIPrzedmiot != "---WYBIERZ---") {
                idKlasy = klasaIPrzedmiot.split(" | ");
            }
            if (lekcja != "---WYBIERZ---") {
                idLekcji = lekcja.split("ID: ");
            }
            if (klasaIPrzedmiot.equals("---WYBIERZ---")) {
                sql = "SELECT IMIE, NAZWISKO, NAZWISKO AS 'SREDNIA OCEN' FROM UCZNIOWIE WHERE ID = 0 ORDER BY NAZWISKO";
            } else if (lekcja.equals("---WYBIERZ---")) {
                sql = "SELECT u.IMIE, u.NAZWISKO, u.ID FROM UCZNIOWIE u WHERE u.KLASA = " + idKlasy[4] + " ORDER BY NAZWISKO";
            } else if (klasaIPrzedmiot != "---WYBIERZ---" && lekcja != "---WYBIERZ---") {
                sql = "SELECT u.IMIE, u.NAZWISKO, o.STATUS, u.ID FROM UCZNIOWIE u, OBECNOSCI o WHERE u.KLASA = " + idKlasy[4] + " AND o.LEKCJA = " + idLekcji[1] + " AND u.ID = o.UCZEN ORDER BY NAZWISKO";
            }
            zapytanie = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            dane = zapytanie.executeQuery();
            metadane = dane.getMetaData();
            liczbaKolumn = metadane.getColumnCount() - 1;
            dane.beforeFirst();
            liczbaWierszy = 0;
            while (this.dane.next()) {
                this.liczbaWierszy++;
            }
            dane.beforeFirst();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public ResultSet getRowSet() {
        return dane;
    }

    public String getIdUcznia(int row) {
        try {
            dane.beforeFirst();
            for (int i = -1; i < row; i++) {
                dane.next();
            }
            String idUcznia = String.valueOf(dane.getInt("ID"));
            return idUcznia;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return liczbaWierszy;
    }

    @Override
    public int getColumnCount() {
        return liczbaKolumn;
    }

    @Override
    public String getColumnName(int kolumna) {
        try {
            return this.metadane.getColumnName(kolumna + 1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
            return e.toString();
        }
    }

    @Override
    public Class getColumnClass(int kolumna) {
        return String.class;
    }

    @Override
    public Object getValueAt(int wiersz, int kolumna) {
        try {
            this.dane.absolute(wiersz + 1);
            Object o = this.dane.getObject(kolumna + 1);
            if (o == null) {
                return null;
            } else {
                return o;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
            return e.toString();
        }
    }

    public void close() {
        try {
            if (dane != null) {
                if (!(dane.isClosed())) {
                    dane.close();
                    zapytanie.close();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    @Override
    public boolean isCellEditable(int wiersz, int kolumna) {
        return kolumna == 2;
    }

    @Override
    public void setValueAt(Object wartosc, int wiersz, int kolumna) {
        if (wartosc != null) {
            if (wartosc.toString().equals("Obecny") || wartosc.toString().equals("Nieobecny") || wartosc.toString().equals("Spozniony")
                    || wartosc.toString().equals("Usprawiedliwiony")) {
                try {
                    String[] idLekcji = lekcja.split("ID: ");
                    String idUcznia = getIdUcznia(wiersz);
                    String sql = "UPDATE OBECNOSCI SET STATUS = '" + wartosc + "' WHERE UCZEN = " + idUcznia + " AND LEKCJA = " + idLekcji[1];
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(UczniowieDlaNauczycieliTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
