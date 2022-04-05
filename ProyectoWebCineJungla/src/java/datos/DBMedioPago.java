package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.MedioPago;

/**
 * Esta clase guarda todo lo referente al manejo de pagos para boleteria y
 * confiteria.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBMedioPago {

    //Espacios de la clase
    DBConexion cn;

    //Constructor de la clase
    public DBMedioPago() {
        cn = new DBConexion();
    }
    //Cierre del constructor

    /**
     * Funcion que retorna el metodo de pago dado por el numero de dentificacion
     * proporcionado.
     *
     * @param id Define el numero de identificacion del medio de pago.
     * @return El medio de pago.
     * @throws SQLException
     */
    public ResultSet getMedioPagoById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMedioPago, "
                + "Nombre "
                + "FROM mediopago "
                + "WHERE idMedioPago = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene el metodo de pago de acuerdo al nombre.
     *
     * @param nombre define el nombre del metodo de pago.
     * @return El metodo de pago
     * @throws SQLException
     */
    public ResultSet getMedioPagoByNombre(String nombre) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMedioPago, "
                + "Nombre "
                + "FROM mediopago "
                + "WHERE Nombre = " + "\"" + nombre + "\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene los metodos de pago soportados por la empresa.
     *
     * @return Los metodos de pago.
     * @throws SQLException
     */
    public ResultSet getMedioPagos() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMedioPago, "
                + "Nombre "
                + "FROM mediopago "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Metodo que agrega un metodo de pago a la base de datos.
     *
     * @param m
     */
    public void insertarMedioPago(MedioPago m) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into mediopago(Nombre) "
                    + "values(?)");
            pstm.setString(1, m.getNombre());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //Cierre del metodo

    /**
     * Elimina un metodo de pago de la base de datos.
     *
     * @param i
     * @throws SQLException
     */
    public void eliminarMedioPago(int i) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "mediopago where idMedioPago = " + i);
        pstm.executeUpdate();
    }
    //Cierre del metodo

    /**
     * Metodo que modifica un registro de la base de datos.
     *
     * @param m
     * @throws SQLException
     */
    public void modifyCliente(MedioPago m) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("update mediopago "
                + "set  Nombre = ? where idMedioPago = ?");
        pstm.setString(1, m.getNombre());
        pstm.setInt(2, m.getIdMedioPago());
        pstm.executeUpdate();
    }
    //Cierre del metodo

    //Meotodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
