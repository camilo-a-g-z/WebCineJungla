package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.AccionRol;

/**
 * Esta clase guarda todo lo referente a las acciones que tienen disponibles los
 * roles de la empresa.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBAccionRol {

    //campos de la Clase
    DBConexion cn;

    //Constructor de la Clase
    public DBAccionRol() {
        cn = new DBConexion();
    }
    //cierre del constructor

    /**
     * Funcion que devuelve el rol del personal con la identificacion dada.
     *
     * @param id El parametro id define la identificacion que se proporciona
     * para entregar su rol.
     * @return El rol de la identificacion proporcionada.
     */
    public ResultSet getAccionRolById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idAccionRol, "
                + "Nombre, "
                + "Rol_idRol "
                + "FROM accionrol "
                + "WHERE idAccionRol = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que devuelve el rol del personal con el nombre dado.
     *
     * @param nombre El parametro nombre define el nombre del personal que se
     * proporciona para entregar su rol.
     * @return El ronl con el nombre proporcionado.
     * @throws SQLException
     */
    public ResultSet getAccionRolByNombre(String nombre) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idAccionRol, "
                + "Nombre, "
                + "Rol_idRol "
                + "FROM accionrol "
                + "WHERE Nombre = " + "\"" + nombre + "\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que devuelve las acciones disponibles para el personal.
     *
     * @return Las acciones disponibles del personal.
     * @throws SQLException
     */
    public ResultSet getAccionRoles() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idAccionRol, "
                + "Nombre, "
                + "Rol_idRol "
                + "FROM accionrol "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Metodo que dispone una nueva accion a un rol especificado.
     *
     * @param a El parametro a es un objeto de tipo AccionRol que guarda las
     * acciones disponibles en los roles de la empresa.
     */
    public void insertarAccionRol(AccionRol a) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into accionrol(Nombre, "
                    + "Rol_idRol) "
                    + "values(?,?)");
            pstm.setString(1, a.getNombre());
            pstm.setInt(2, a.getRol_idRol());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //Cierre del metodo

    /**
     * Metodo que releva de una accion a un rol especificado.
     *
     * @param i
     * @throws SQLException
     */
    public void eliminarAccionRol(int i) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from accionrol"
                + " where idAccionRol = " + i);
        pstm.executeUpdate();
    }
    //Cierre del metodo

    /**
     * Este metodo modifica un registro de la base de datos de la tabla cliente.
     *
     * @param a objeto de tipo AccionRol que guarda las acciones disponibles en
     * los roles de la empresa.
     * @throws SQLException
     */
    public void modifyCliente(AccionRol a) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("update accionrol "
                + "set  Nombre = ? , Rol_idRol = ?  where idAccionRol = ?");
        pstm.setString(1, a.getNombre());
        pstm.setInt(2, a.getRol_idRol());
        pstm.setInt(3, a.getIdAccionRol());
        pstm.executeUpdate();
    }
    //Cierre del metodo

    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
