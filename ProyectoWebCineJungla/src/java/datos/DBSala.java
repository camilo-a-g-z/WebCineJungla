package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Sala;

/**
 * Esta clase guarda todo lo referente a la informacion de las salas de los
 * multiplex.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBSala {

    //Espacios de la clase
    DBConexion cn;

    //Constructor de la clase
    public DBSala() {
        cn = new DBConexion();
    }
    //Cierre de la clase

    /**
     * Funcion que obtiene el ultimo numero de identificacion del registro.
     *
     * @return El ultimo numero de identificacion.
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
     * Obtiene Datos de una sala con el numero de identificacion.
     *
     * @param id Define el numero de identificacion de la sala.
     * @return Datos de la sala.
     * @throws SQLException
     */
    public ResultSet getSalaById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSala, "
                + "Numero, "
                + "Multiplex_idMultiplex "
                + "FROM sala "
                + "WHERE idSala = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Obtiene datos de una sala por el numero de la sala de un multiplex.
     *
     * @param numero Define el numero de la sala dentro de un multiplex.
     * @return Datos de la sala.
     * @throws SQLException
     */
    public ResultSet getSalaByNumero(int numero) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSala, "
                + "Numero, "
                + "Multiplex_idMultiplex "
                + "FROM sala "
                + "WHERE Numero = " + numero);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Obtiene datos de una sala por el multiplex en el que se alojan.
     *
     * @param id Define el numero de identificacion del multiplex.
     * @return Datos de la sala.
     * @throws SQLException
     */
    public ResultSet getSalaByidMultiplex(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSala, "
                + "Numero, "
                + "Multiplex_idMultiplex "
                + "FROM sala "
                + "WHERE Multiplex_idMultiplex = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene los datos de las salas.
     *
     * @return los datos de las salas.
     * @throws SQLException
     */
    public ResultSet getSalas() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSala, "
                + "Numero, "
                + "Multiplex_idMultiplex "
                + "FROM sala "
                + "ORDER BY Numero ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Agrega una sala a la base de datos.
     *
     * @param s
     */
    public void insertarSala(Sala s) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into sala(Numero ,"
                    + " Multiplex_idMultiplex) "
                    + "values(?,?)");
            pstm.setString(1, s.getNumero());
            pstm.setInt(2, s.getMultiplex_idMultiplex());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //Cierre del metodo

    /**
     * Elimina una sala de la base de datos.
     *
     * @param i
     * @throws SQLException
     */
    public void eliminarSala(int i) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "sala where idSala = " + i);
        pstm.executeUpdate();
    }
    //Cierre del metodo

    /**
     * Modifica un registro de la base de datos.
     *
     * @param s
     * @throws SQLException
     */
    public void modifySala(Sala s) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("update sala "
                + "set  Numero = ? , Multiplex_idMultiplex = ? where idSala = ?");
        pstm.setString(1, s.getNumero());
        pstm.setInt(2, s.getMultiplex_idMultiplex());
        pstm.setInt(3, s.getIdSala());
        pstm.executeUpdate();
    }
    //Cierre de del metodo

    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
