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
                String[] idKlasy = klasy[i].split("ID: ");
                sql = "SELECT COUNT(*) FROM UCZNIOWIE WHERE KLASA = " + idKlasy[1];
                zapytanie = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                dane = zapytanie.executeQuery();
                dane.next();
                liczbaUczniow[i - 1] = dane.getInt(1);
            }

            sql = "SELECT k.ID, NAZWA, ROK_POWSTANIA AS 'ROK POWSTANIA', PROFIL, concat(IMIE, ' ', NAZWISKO, ' - ID: ', n.ID) AS 'WYCHOWAWCA',"
                    + "LICZBA_UCZNIOW AS 'LICZBA UCZNIÓW', ID_WYCHOWAWCY FROM KLASY k, NAUCZYCIELE n WHERE k.ID_WYCHOWAWCY = n.ID ORDER BY NAZWA, ROK_POWSTANIA";
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

            for (int i = 0; i < liczbaUczniow.length; i++) {
                dane.next();
                String sqlLiczbaUczniow = "UPDATE KLASY SET LICZBA_UCZNIOW = " + liczbaUczniow[i] + " WHERE ID = " + dane.getInt("ID");
                PreparedStatement ps = conn.prepareStatement(sqlLiczbaUczniow);
                ps.executeUpdate();
                ps.close();
            }
            dane = zapytanie.executeQuery();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: " + e.getMessage()});
        }
    }

    public ResultSet getRowSet() {
        return dane;
    }

    public void insertRow(String nazwa, String rok_powstania, String profil, String wychowawca) throws SQLException {
        try {
            String sql = "INSERT INTO KLASY VALUES (NULL, '" + nazwa + "', '" + rok_powstania + "', '" + profil + "', 0, " + wychowawca + ")";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            if (e.getMessage().contains("id_wychowawcy")) {
                JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: Podany nauczyciel jest już wychowawcą innej klasy!"});
            } else {
                JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: Klasa o podanej nazwie i roku powstania już istnieje!"});
            }
        }
    }

    public void editRow(String nazwa, String rok_powstania, String profil, String wychowawca, int row) {
        try {
            dane.beforeFirst();
            for (int i = -1; i < row; i++) {
                dane.next();
            }
            String sql = "UPDATE KLASY SET NAZWA = '" + nazwa + "', ROK_POWSTANIA = '" + rok_powstania + "', PROFIL = '" + profil + "',"
                    + "ID_WYCHOWAWCY = " + wychowawca + " WHERE ID = " + dane.getInt("ID");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            if (e.getMessage().contains("id_wychowawcy")) {
                JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: Podany nauczyciel jest już wychowawcą innej klasy!"});
            } else {
                JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: Klasa o podanej nazwie i roku powstania już istnieje!"});
            }
        }
    }

    public void deleteRow(int row) {
        try {
            dane.beforeFirst();
            for (int i = -1; i < row; i++) {
                dane.next();
            }
            String sql = "DELETE FROM KLASY WHERE ID = " + dane.getInt("ID");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            dane = zapytanie.executeQuery();
        } catch (SQLException e) {
            if (e.getMessage().contains("id_wychowawcy")) {
                JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: Podany nauczyciel jest już wychowawcą innej klasy!"});
            } else {
                JOptionPane.showMessageDialog(null, new String[]{"Wystąpił błąd: Klasa o podanej nazwie i roku powstania już istnieje!"});
            }
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
