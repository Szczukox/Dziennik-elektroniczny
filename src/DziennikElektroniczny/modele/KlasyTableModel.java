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
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author patry
 */
public class KlasyTableModel extends AbstractTableModel {

    private final Connection conn;
    private ResultSet dane;
    private ResultSetMetaData metadane;
    private int liczbaKolumn;
    private int liczbaWierszy;
    private PreparedStatement zapytanie;

    public KlasyTableModel(Connection connection) {
        conn = connection;
        zapytanie = null;
        try {
            if (dane != null) {
                if (!(dane.isClosed())) {
                    dane.close();
                    zapytanie.close();
                }
            }
            String sql = null;
            ListaKlasModel listaKlasModel = new ListaKlasModel();
            String[] klasy = listaKlasModel.listaKlas(conn);
            Integer[] liczbaUczniow = new Integer[klasy.length - 1];
            for (int i = 1; i < klasy.length; i++) {
                sql = "SELECT COUNT(*) FROM UCZNIOWIE WHERE KLASA = " + klasy[i];
                zapytanie = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                dane = zapytanie.executeQuery();
                dane.next();
                liczbaUczniow[i - 1] = dane.getInt(1);
            }

            sql = "SELECT ID, NAZWA, ROK_POWSTANIA AS 'ROK POWSTANIA', PROFIL, ID_WYCHOWAWCY AS 'WYCHOWAWCA', LICZBA_UCZNIOW AS 'LICZBA UCZNIÓW' FROM KLASY ORDER BY NAZWA, ROK_POWSTANIA";
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

            for (int i = 0; i < liczbaUczniow.length; i++) {
                dane.next();
                dane.updateInt("LICZBA UCZNIÓW", liczbaUczniow[i]);
                dane.updateRow();
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public ResultSet getRowSet() {
        return dane;
    }

    public void insertRow(String nazwa, String rok_powstania, String profil, String wychowawca) throws SQLException {
        try {
            dane.moveToInsertRow();
            dane.updateString("NAZWA", nazwa);
            dane.updateString("ROK POWSTANIA", rok_powstania);
            dane.updateString("PROFIL", profil);
            dane.updateInt("WYCHOWAWCA", Integer.parseInt(wychowawca));
            dane.insertRow();
            dane.moveToCurrentRow();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public void editRow(String nazwa, String rok_powstania, String profil, String wychowawca, int row) {
        try {
            dane.beforeFirst();
            for (int i = -1; i < row; i++) {
                dane.next();
            }
            dane.updateString("NAZWA", nazwa);
            dane.updateString("ROK POWSTANIA", rok_powstania);
            dane.updateString("PROFIL", profil);
            dane.updateInt("WYCHOWAWCA", Integer.parseInt(wychowawca));
            dane.updateRow();
            dane.moveToCurrentRow();
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
            dane.deleteRow();
            dane.moveToCurrentRow();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
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
        //return Class.forName(metadane.getColumnClassName(kolumna + 1));
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
