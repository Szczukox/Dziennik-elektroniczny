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
public class LogowanieUczen extends Logowanie {

    private String loginUcznia;
    private String hasloUcznia;

    public LogowanieUczen(Connection conn, String login, String haslo) {
        super(conn);
        this.loginUcznia = login.toLowerCase();
        this.hasloUcznia = haslo;
    }

    @Override
    public boolean zaloguj() {
        String czyIstnieje = "SELECT COUNT(*) FROM UCZNIOWIE WHERE ID = " + loginUcznia;
        String sql = "SELECT PESEL FROM UCZNIOWIE WHERE ID = " + loginUcznia;
        try {
            Statement zapytanie = super.getConn().createStatement();
            ResultSet result = zapytanie.executeQuery(czyIstnieje);
            result.next();
            if (result.getInt(1) == 1) {
                result = zapytanie.executeQuery(sql);
                result.next();
                String prawidloweHaslo = result.getString(1);
                if (prawidloweHaslo.equals(hasloUcznia)) {
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(LogowanieUczen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
