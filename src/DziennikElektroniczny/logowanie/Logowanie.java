/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.logowanie;

import java.sql.*;

/**
 *
 * @author patry
 */
public abstract class Logowanie {

    private Connection conn;

    public Logowanie(Connection conn) {
        this.conn = conn;
    }

    public abstract boolean zaloguj();

    public Connection getConn() {
        return conn;
    }
}
