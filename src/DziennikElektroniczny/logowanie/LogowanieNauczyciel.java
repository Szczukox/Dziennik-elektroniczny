/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.logowanie;

import DziennikElektroniczny.logowanie.Logowanie;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patry
 */
public class LogowanieNauczyciel extends Logowanie{

    private String loginNauczyciela;
    private String hasloNauczyciela;

    public LogowanieNauczyciel(Connection conn, String login, String haslo) {
        super(conn);
        this.loginNauczyciela = login.toLowerCase();
        this.hasloNauczyciela = haslo;
    }

    @Override
    public boolean zaloguj() {
        String czyIstnieje = "SELECT COUNT(*) FROM NAUCZYCIELE WHERE ID = " + loginNauczyciela;
        String sql = "SELECT PESEL FROM NAUCZYCIELE WHERE ID = " + loginNauczyciela;
        try {
            Statement zapytanie = super.getConn().createStatement();
            ResultSet result = zapytanie.executeQuery(czyIstnieje);
            result.next();
            if (result.getInt(1) == 1) {
                result = zapytanie.executeQuery(sql);
                result.next();
                String prawidloweHaslo = result.getString(1);
                if (prawidloweHaslo.equals(hasloNauczyciela)) {
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogowanieUczen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
