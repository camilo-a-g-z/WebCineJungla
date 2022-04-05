package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Multiplex;

/**
 * Esta clase guarda todo lo referente a los datos de los multiplex de la
 * empresa.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBMultiplex {

    //Espacios de la clase
    DBConexion cn;

    //Constructor de la clase
    public DBMultiplex() {
        cn = new DBConexion();
    }
    //Cierre del constructor

    /**
     * Funcion que obtiene el ultimo numero de identificacion del registro.
     *
     * @return El numero de identificacion.
     */
    public String getLastId() {
        try {
            PreparedStatement pstm_2 = cn.getConexion().prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet res = pstm_2.executeQuery();
            res.next();
            return res.getString("LAST_INSERT_ID()");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene datos de un multiplex por su numero de identificacion
     * registrado.
     *
     * @param id Define el numero de identificacion de el multiplex.
     * @return Los datos de el multiplex
     * @throws SQLException
     */
    public ResultSet getMultiplexById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMultimplex, "
                + "Nombre, "
                + "Direccion "
                + "FROM multiplex "
                + "WHERE idMultiplex = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene los datos del multiplex por su nombre.
     *
     * @param nombre Define el nombre dado al multiplex.
     * @return Los datos del multiplex.
     * @throws SQLException
     */
    public ResultSet getMultiplexByNombre(String nombre) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMultimplex, "
                + "Nombre, "
                + "Direccion "
                + "FROM multiplex "
                + "WHERE Nombre = " + "\"" + nombre + "\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene los multiplex propiedad de la empresa.
     *
     * @return Los datos de los multiplex.
     * @throws SQLException
     */
    public ResultSet getMultiplexs() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMultiplex, "
                + "Nombre, "
                + "Direccion "
                + "FROM multiplex "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Metodo que agrega un multiplex a la base de datos
     *
     * @param m
     */
    public void insertarMultiplex(Multiplex m) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into multiplex(Nombre ,"
                    + " Direccion) "
                    + "values(?,?)");
            pstm.setString(1, m.getNombre());
            pstm.setString(2, m.getDireccion());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //Cierre del metodo

    /**
     * Funcion que elimina un multiplex de la base de datos de la empresa.
     *
     * @param i
     * @throws SQLException
     */
    public void eliminarMultiplex(int i) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "multiplex where idMultiplex = " + i);
        pstm.executeUpdate();
    }
    //Cierre del metodo

    /**
     * Funcion que modifica un registro de la base de datos.
     *
     * @param m
     * @throws SQLException
     */
    public void modifyMultiplex(Multiplex m) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("update multiplex "
                + "set  Nombre = ? , Direccion = ? where idMultiplex = ?");
        pstm.setString(1, m.getNombre());
        pstm.setString(2, m.getDireccion());
        pstm.setInt(3, m.getIdMultiplex());
        pstm.executeUpdate();
    }
    //Cierre del metodo

    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
