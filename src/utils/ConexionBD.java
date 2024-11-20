
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
    public static Connection getConnectionBD() {
        String bd = "UniversidadDB";
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "toor";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection cn = null;
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url+bd, user, password);
            System.out.println("Conexión exitosa");
        }catch(ClassNotFoundException |SQLException ex) {
            System.out.println(ex);
            System.out.println("No se conectó a bd");
        }
        return cn;
    }
}
