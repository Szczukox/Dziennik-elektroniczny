/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class JDBC {

    public JDBC() {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "user");
        connectionProps.put("password", "password");
        try {
            conn = DriverManager.getConnection("address", connectionProps);
            System.out.println("Połączono z bazą danych");
            conn.close();
            System.out.println("Odłączono od bazy danych");
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, "Nie udało się połączyć z bazą danych", ex);
            System.exit(-1);
        }
    }

}
