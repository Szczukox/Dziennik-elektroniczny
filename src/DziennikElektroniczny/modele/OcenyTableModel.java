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
public class OcenyTableModel extends AbstractTableModel {

    private final Connection conn;
    private ResultSet dane;
    private ResultSetMetaData metadane;
    private int liczbaKolumn;
    private int liczbaWierszy;
    private PreparedStatement zapytanie;

    public OcenyTableModel(Connection connection, String uczen, String przedmiot, String dlaKogo) {
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
            if (dlaKogo.equals("uczen")) {
                sql = "SELECT STOPIEN, TYP, WAGA, LEKCJA FROM OCENY WHERE (UCZEN = " + uczen + " AND LEKCJA IN (SELECT ID FROM LEKCJE WHERE PRZYDZIAL IN (SELECT ID FROM PRZYDZIALY WHERE PRZEDMIOT = '" + przedmiot + "')))";
            } else if (dlaKogo.equals("nauczyciel")) {
                sql = "SELECT STOPIEN, TYP, WAGA, LEKCJA, UCZEN, ID FROM OCENY WHERE (UCZEN = " + uczen + " AND LEKCJA IN (SELECT ID FROM LEKCJE WHERE PRZYDZIAL IN (SELECT ID FROM PRZYDZIALY WHERE PRZEDMIOT = '" + przedmiot + "')))";
            }
            zapytanie = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            dane = zapytanie.executeQuery();
            metadane = dane.getMetaData();
            if (dlaKogo.equals("uczen")) {
                liczbaKolumn = metadane.getColumnCount();
            } else if (dlaKogo.equals("nauczyciel")) {
                liczbaKolumn = metadane.getColumnCount() - 2;
            }
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

    public void wstawOcene(String stopien, String typ, String waga, String lekcja, String uczen) throws SQLException {
        try {
            dane.moveToInsertRow();
            dane.updateString("STOPIEN", stopien);
            dane.updateString("TYP", typ);
            dane.updateInt("WAGA", Integer.parseInt(waga));
            dane.updateInt("LEKCJA", Integer.parseInt(lekcja));
            dane.updateInt("UCZEN", Integer.parseInt(uczen));
            dane.insertRow();
            dane.moveToCurrentRow();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public void poprawOcene(String stopien, String typ, String waga, int row) {
        try {
            dane.beforeFirst();
            for (int i = -1; i < row; i++) {
                dane.next();
            }
            dane.updateString("STOPIEN", stopien);
            dane.updateString("TYP", typ);
            dane.updateInt("WAGA", Integer.parseInt(waga));
            dane.updateRow();
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
