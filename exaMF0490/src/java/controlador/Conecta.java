
package controlador;

//import java.sql.*;
import java.sql.Connection;// Objeto de conexión
import java.sql.DriverManager;// Objeto del controlador o driver JDBC
import javax.swing.JOptionPane;

public class Conecta {

    
     public static Connection getConexion(String usu,String pas, String url) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, usu, pas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
