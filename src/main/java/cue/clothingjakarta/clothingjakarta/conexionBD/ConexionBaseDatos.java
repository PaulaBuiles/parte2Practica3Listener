package cue.clothingjakarta.clothingjakarta.conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://localhost:3306/clientes-register";
    private static String username = "root";
    private static String password = "0703";
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }

}
