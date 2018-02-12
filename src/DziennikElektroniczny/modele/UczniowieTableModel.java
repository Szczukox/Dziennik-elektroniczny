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
public class UczniowieTableModel extends AbstractTableModel {

    private final Connection conn;
    private ResultSet dane;
    private ResultSetMetaData metadane;
    private int liczbaKolumn;
    private int liczbaWierszy;
    private PreparedStatement zapytanie;

    public UczniowieTableModel(Connection connection, String klasa) {
        conn = connection;
        zapytanie = null;
        String[] idKlasy = klasa.split("ID: ");
        try {
            if (dane != null) {
                if (!(dane.isClosed())) {
                    dane.close();
                    zapytanie.close();
                }
            }
            String sql = null;
            if (klasa.equals("---WYBIERZ---")) {
                sql = "SELECT u.ID, IMIE, NAZWISKO, PESEL, concat(NAZWA, ' (', ROK_POWSTANIA, ') - ID: ', k.ID) as 'KLASA' FROM UCZNIOWIE u, KLASY k WHERE u.klasa = k.id ORDER BY NAZWISKO";
            } else if (klasa != "---WYBIERZ---") {
                sql = "SELECT u.ID, IMIE, NAZWISKO, PESEL, concat(NAZWA, ' (', ROK_POWSTANIA, ') - ID: ', k.ID) as 'KLASA' FROM UCZNIOWIE u, KLASY k WHERE u.klasa = k.id AND u.klasa = " + idKlasy[1] + " ORDER BY NAZWISKO";
            }
            zapytanie = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            dane = zapytanie.executeQuery();
            metadane = dane.getMetaData();
            liczbaKolumn = metadane.getColumnCount();
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

    public void insertRow(String imie, String nazwisko, String pesel, String klasa) throws SQLException {
        try {
            String sql = "INSERT INTO UCZNIOWIE VALUES (NULL, '" + imie + "', '" + nazwisko + "', '" + pesel + "', " + klasa + ")";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public void editRow(String imie, String nazwisko, String pesel, String klasa, int row) {
        try {
            dane.beforeFirst();
            for (int i = -1; i < row; i++) {
                dane.next();
            }
            String sql = "UPDATE UCZNIOWIE SET IMIE = '" + imie + "', NAZWISKO = '" + nazwisko + "', PESEL = '" + pesel + "', KLASA = " + klasa + " WHERE ID = " + dane.getInt("ID");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public void deleteRow(int row) {
        try {
            dane.beforeFirst();
            for (int i = -1; i < row; i++) {
                dane.next();
            }
            String sql = "DELETE FROM UCZNIOWIE WHERE ID = " + dane.getInt("ID");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public String[] getIDUczniow() {
        try {
            String[] idUczniow = new String[liczbaWierszy];
            dane.beforeFirst();
            int i = 0;
            while (dane.next()) {
                idUczniow[i] = dane.getString("ID");
                i++;
            }
            return idUczniow;
        } catch (SQLException ex) {
            Logger.getLogger(UczniowieTableModel.class.getName()).log(Level.SEVERE, null, ex);
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
        return false;
    }

    @Override
    public void setValueAt(Object value, int wiersz, int kolumna) {
    }
}
