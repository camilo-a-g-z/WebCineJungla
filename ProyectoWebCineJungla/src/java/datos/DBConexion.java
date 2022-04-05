package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase guarda todo lo referente al manejo de datos para el acceso a la
 * cuenta de un cliente.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBConexion {

    //Espacios de la clase
    static String bd = "mydb";
    static String login = "root";
    static String password = "u_admin";
    static String url = "jdbc:mysql://localhost:3306/" + bd;
    static String mensaje = "";

    Connection conexion = null;

    // Constructor de la clase
    public DBConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, login, password);
            if (conexion != null) {
                System.out.println("Conexión a base de datos " + bd + " OK");
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        } catch (ClassNotFoundException e) {
            mensaje = e.getMessage();
        }
    }
    //Cierre del cconstructor

    /**
     * Metodo para retornar mensajes de control.
     *
     * @return Mensajes de control.
     */
    public static String getMensaje() {
        return mensaje;
    }
    //Cierre del metodo

    /**
     * Metodo para setear mensajes de control.
     *
     * @param mensaje Define el mensaje que se va a redefinir.
     */
    public static void setMensaje(String mensaje) {
        DBConexion.mensaje = mensaje;
    }
    //Cierre de la funcion.

    /**
     * metodo que retorna la conexion a la base de datos.
     *
     * @return El estado de conexion.
     */
    public Connection getConexion() {
        return conexion;
    }
    //Cierre del metodo

    /**
     * Metodo que desconecta la base de datos.
     */
    public void desconectar() {
        conexion = null;
    }
    //Cierre del metodo
}
