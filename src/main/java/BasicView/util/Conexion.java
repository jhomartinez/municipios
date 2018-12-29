/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicView.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JHON
 */
public class Conexion {

    public Connection conexion;

    public Conexion() throws SQLException, ClassNotFoundException {
        conexion = null;
    }

    public Connection conectar() throws ClassNotFoundException, SQLException {
    //ARREGLAR LA CONEXION
        //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@172.16.2.11:1521:calidaddb", "BISA", "YgcncxrPwuoB");
            //conexion.setSchema("CALIDAD");
            if (conexion == null) {
                return conexion;
            } else {
                return conexion;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión de la base de datos");
        }
        return null;
    }
}
