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
public class PrzydzialyTableModel extends AbstractTableModel {

    private final Connection conn;
    private ResultSet dane;
    private ResultSetMetaData metadane;
    private int liczbaKolumn;
    private int liczbaWierszy;
    private PreparedStatement zapytanie;

    public PrzydzialyTableModel(Connection connection, String klasa, String przedmiot, String nauczyciel) {
        conn = connection;
        zapytanie = null;
        String[] idKlasy = klasa.split("ID: ");
        String[] idNauczyciela = nauczyciel.split("ID: ");
        try {
            if (dane != null) {
                if (!(dane.isClosed())) {
                    dane.close();
                    zapytanie.close();
                }
            }
            String sql = null;
            if (klasa.equals("---WYBIERZ---") && przedmiot.equals("---WYBIERZ---") && nauczyciel.equals("---WYBIERZ---")) {
                sql = "SELECT p.ID, concat(NAZWA, ' (', ROK_POWSTANIA, ') - ID: ', k.ID) AS 'KLASA', PRZEDMIOT, concat(IMIE, ' ', NAZWISKO, ' - ID: ', n.ID) as 'NAUCZYCIEL', KLASA AS 'ID_KLASY', NAUCZYCIEL AS 'ID_NAUCZYCIELA' FROM PRZYDZIALY p, KLASY k, NAUCZYCIELE n WHERE KLASA = k.ID AND NAUCZYCIEL = n.ID ORDER BY KLASA";
            } else if (klasa != "---WYBIERZ---" && przedmiot.equals("---WYBIERZ---") && nauczyciel.equals("---WYBIERZ---")) {
                sql = "SELECT p.ID, concat(NAZWA, ' (', ROK_POWSTANIA, ') - ID: ', k.ID) AS 'KLASA', PRZEDMIOT, concat(IMIE, ' ', NAZWISKO, ' - ID: ', n.ID) as 'NAUCZYCIEL', KLASA AS 'ID_KLASY', NAUCZYCIEL AS 'ID_NAUCZYCIELA' FROM PRZYDZIALY p, KLASY k, NAUCZYCIELE n WHERE KLASA = k.ID AND NAUCZYCIEL = n.ID AND KLASA = " + idKlasy[1] + " ORDER BY KLASA";
            } else if (klasa.equals("---WYBIERZ---") && przedmiot != "---WYBIERZ---" && nauczyciel.equals("---WYBIERZ---")) {
                sql = "SELECT p.ID, concat(NAZWA, ' (', ROK_POWSTANIA, ') - ID: ', k.ID) AS 'KLASA', PRZEDMIOT, concat(IMIE, ' ', NAZWISKO, ' - ID: ', n.ID) as 'NAUCZYCIEL', KLASA AS 'ID_KLASY', NAUCZYCIEL AS 'ID_NAUCZYCIELA' FROM PRZYDZIALY p, KLASY k, NAUCZYCIELE n WHERE KLASA = k.ID AND NAUCZYCIEL = n.ID AND PRZEDMIOT = '" + przedmiot + "' ORDER BY KLASA";
            } else if (klasa.equals("---WYBIERZ---") && przedmiot.equals("---WYBIERZ---") && nauczyciel != "---WYBIERZ---") {
                sql = "SELECT p.ID, concat(NAZWA, ' (', ROK_POWSTANIA, ') - ID: ', k.ID) AS 'KLASA', PRZEDMIOT, concat(IMIE, ' ', NAZWISKO, ' - ID: ', n.ID) as 'NAUCZYCIEL', KLASA AS 'ID_KLASY', NAUCZYCIEL AS 'ID_NAUCZYCIELA' FROM PRZYDZIALY p, KLASY k, NAUCZYCIELE n WHERE KLASA = k.ID AND NAUCZYCIEL = n.ID AND NAUCZYCIEL = " + idNauczyciela[1] + " ORDER BY KLASA";
            } else if (klasa != "---WYBIERZ---" && przedmiot != "---WYBIERZ---" && nauczyciel.equals("---WYBIERZ---")) {
                sql = "SELECT p.ID, concat(NAZWA, ' (', ROK_POWSTANIA, ') - ID: ', k.ID) AS 'KLASA', PRZEDMIOT, concat(IMIE, ' ', NAZWISKO, ' - ID: ', n.ID) as 'NAUCZYCIEL', KLASA AS 'ID_KLASY', NAUCZYCIEL AS 'ID_NAUCZYCIELA' FROM PRZYDZIALY p, KLASY k, NAUCZYCIELE n WHERE KLASA = k.ID AND NAUCZYCIEL = n.ID AND (KLASA = " + idKlasy[1] + ") AND (PRZEDMIOT = '" + przedmiot + "') ORDER BY KLASA";
            } else if (klasa != "---WYBIERZ---" && przedmiot.equals("---WYBIERZ---") && nauczyciel != "---WYBIERZ---") {
                sql = "SELECT p.ID, concat(NAZWA, ' (', ROK_POWSTANIA, ') - ID: ', k.ID) AS 'KLASA', PRZEDMIOT, concat(IMIE, ' ', NAZWISKO, ' - ID: ', n.ID) as 'NAUCZYCIEL', KLASA AS 'ID_KLASY', NAUCZYCIEL AS 'ID_NAUCZYCIELA' FROM PRZYDZIALY p, KLASY k, NAUCZYCIELE n WHERE KLASA = k.ID AND NAUCZYCIEL = n.ID AND (KLASA = " + idKlasy[1] + ") AND (NAUCZYCIEL = " + idNauczyciela[1] + ") ORDER BY KLASA";
            } else if (klasa.equals("---WYBIERZ---") && przedmiot != "---WYBIERZ---" && nauczyciel != "---WYBIERZ---") {
                sql = "SELECT p.ID, concat(NAZWA, ' (', ROK_POWSTANIA, ') - ID: ', k.ID) AS 'KLASA', PRZEDMIOT, concat(IMIE, ' ', NAZWISKO, ' - ID: ', n.ID) as 'NAUCZYCIEL', KLASA AS 'ID_KLASY', NAUCZYCIEL AS 'ID_NAUCZYCIELA' FROM PRZYDZIALY p, KLASY k, NAUCZYCIELE n WHERE KLASA = k.ID AND NAUCZYCIEL = n.ID AND (PRZEDMIOT = '" + przedmiot + "') AND (NAUCZYCIEL = " + idNauczyciela[1] + ") ORDER BY KLASA";
            } else if (klasa != "---WYBIERZ---" && przedmiot != "---WYBIERZ---" && nauczyciel != "---WYBIERZ---") {
                sql = "SELECT p.ID, concat(NAZWA, ' (', ROK_POWSTANIA, ') - ID: ', k.ID) AS 'KLASA', PRZEDMIOT, concat(IMIE, ' ', NAZWISKO, ' - ID: ', n.ID) as 'NAUCZYCIEL', KLASA AS 'ID_KLASY', NAUCZYCIEL AS 'ID_NAUCZYCIELA' FROM PRZYDZIALY p, KLASY k, NAUCZYCIELE n WHERE KLASA = k.ID AND NAUCZYCIEL = n.ID AND (KLASA = " + idKlasy[1] + ") AND (PRZEDMIOT = '" + przedmiot + "') AND (NAUCZYCIEL = " + idNauczyciela[1] + ") ORDER BY KLASA";
            }
            zapytanie = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            dane = zapytanie.executeQuery();
            metadane = dane.getMetaData();
            liczbaKolumn = metadane.getColumnCount() - 2;
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

    public void insertRow(String klasa, String przedmiot, String nauczyciel) throws SQLException {
        try {
            String sql = "INSERT INTO PRZYDZIALY VALUES (NULL, " + klasa + ", '" + przedmiot + "', " + nauczyciel + ")";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public void editRow(String klasa, String przedmiot, String nauczyciel, int row) {
        try {
            dane.beforeFirst();
            for (int i = -1; i < row; i++) {
                dane.next();
            }
            String sql = "UPDATE PRZYDZIALY SET KLASA = " + klasa + ", PRZEDMIOT = '" + przedmiot + "', NAUCZYCIEL = " + nauczyciel + " WHERE ID = " + dane.getInt("ID");
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
            String sql = "DELETE FROM PRZYDZIALY WHERE ID = " + dane.getInt("ID");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            dane = zapytanie.executeQuery();
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
