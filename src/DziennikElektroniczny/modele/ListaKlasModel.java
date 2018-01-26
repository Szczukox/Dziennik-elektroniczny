/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.modele;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author patry
 */
public class ListaKlasModel extends AbstractTableModel{
    private final Connection conn;
    private ResultSet dane;
    private ResultSetMetaData metadane;
    private int liczbaKolumn;
    private int liczbaWierszy;
    private PreparedStatement zapytanie;

    public ListaKlasModel(Connection connection) {
        conn = connection;
        zapytanie = null;
        try {
            if (dane != null) {
                if (!(dane.isClosed())) {
                    dane.close();
                    zapytanie.close();
                }
            }
            String sql = "SELECT NAZWA, ROK_POWSTANIA AS 'ROK POWSTANIA', PROFIL, LICZBA_UCZNIOW AS 'LICZBA UCZNIÓW' FROM KLASY";
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
    
    public void insertRow(String nazwa, String rok_powstania, String profil, int liczba_uczniow) throws SQLException {
        try {
            dane.moveToInsertRow();
            dane.updateString("NAZWA", nazwa);
            dane.updateString("ROK POWSTANIA", rok_powstania);
            dane.updateString("PROFIL", profil);
            dane.updateInt("LICZBA UCZNIÓW", liczba_uczniow);
            dane.insertRow();
            dane.moveToCurrentRow();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[] {"Wystąpił błąd: " + e.getMessage()});
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
            JOptionPane.showMessageDialog(null, new String[] {"Wystąpił błąd: " + e.getMessage()});
            return e.toString();
        }
    }
    
    @Override
    public Class getColumnClass(int kolumna) {
        try {
            return Class.forName(metadane.getColumnClassName(kolumna + 1));
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, new String[] {"Wystąpił błąd: " + e.getMessage()});
            return String.class;
        }
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
            JOptionPane.showMessageDialog(null, new String[] {"Wystąpił błąd: " + e.getMessage()});
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
            JOptionPane.showMessageDialog(null, new String[] {"Wystąpił błąd: " + e.getMessage()});
        }
    }
    
    @Override
    public boolean isCellEditable(int wiersz, int kolumna) {
        return false;
    }
    
    @Override
    public void setValueAt(Object value, int wiersz, int kolumna) { }
}
