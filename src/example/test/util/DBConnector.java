package example.test.util;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Created by jaliya on 7/10/17.
 */
public class DBConnector {

    static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/inventory";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    Connection con = null;

    public Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}
