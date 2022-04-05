package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Cliente;

/**
 * Esta clase guarda todo lo referente a los datos de los clientes.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBCliente {

    //Campos de la clase
    DBConexion cn;

    //Constructor de la clase
    public DBCliente() {
        cn = new DBConexion();
    }
    //Cierre del constructor

    /**
     * Funcion que obtiene el cliente con la identificacion dada.
     *
     * @param id El parametro id define la identificacion que se proporciona.
     * @return Los datos del cliente.
     * @throws SQLException
     */
    public ResultSet getClienteById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCliente, "
                + "Nombre, "
                + "PuntosJungla, "
                + "Correo, "
                + "MedioPago_idMedioPago, "
                + "HashPsw "
                + "FROM cliente "
                + "WHERE idCliente = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene el cliente con el correo electronico proporcionado.
     *
     * @param correo El parametro define la identificacion que se proporciona.
     * @return Los datos del cliente.
     * @throws SQLException
     */
    public ResultSet getClienteByCorreo(String correo) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCliente, "
                + "Nombre, "
                + "PuntosJungla, "
                + "Correo, "
                + "MedioPago_idMedioPago "
                + "FROM cliente "
                + "WHERE Correo = ?");
        pstm.setString(1, correo);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene el acceso del cliente con el correo proporcionado.
     *
     * @param correo El parametro define la identificacion que se proporciona.
     * @return El acceso del cliente.
     * @throws SQLException
     */
    public ResultSet getClienteLogin(String correo) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCliente, "
                + "HashPsw, "
                + "Nombre "
                + "FROM cliente "
                + "WHERE Correo = ?");
        pstm.setString(1, correo);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene datos del cliente con el nombre que se proporciona.
     *
     * @param nombre El parametro define el nombre del cliente solicitado.
     * @return
     * @throws SQLException
     */
    public ResultSet getClienteByNombre(String nombre) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCliente, "
                + "Nombre, "
                + "PuntosJungla, "
                + "Correo, "
                + "MedioPago_idMedioPago "
                + "FROM cliente "
                + "WHERE Nombre = " + "\"" + nombre + "\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene datos del cliente.
     *
     * @return Los datos del cliente.
     * @throws SQLException
     */
    public ResultSet getClientes() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCliente, "
                + "Nombre, "
                + "PuntosJungla, "
                + "Correo, "
                + "MedioPago_idMedioPago "
                + "FROM cliente "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Metodo que agrega un nuevo cluente a la base de datos.
     *
     * @param c
     */
    public void insertarCliente(Cliente c) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into cliente(Nombre, "
                    + "PuntosJungla, "
                    + "Correo, "
                    + "HashPsw, "
                    + "MedioPago_idMedioPago) "
                    + "values(?,?,?,?,?)");
            pstm.setString(1, c.getNombre());
            pstm.setDouble(2, c.getPuntosJungla());
            pstm.setString(3, c.getCorreo());
            pstm.setString(4, c.getHashPsw());
            pstm.setInt(5, c.getMedioPago_idMedioPago());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //Cierre del metodo

    /**
     * Metodo que elimina la cuenta de un cliente.
     *
     * @param i
     * @throws SQLException
     */
    public void eliminarCliente(int i) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from cliente where idCliente = " + i);
        pstm.executeUpdate();
    }
    //Cierre del metodo

    /**
     * Metodo que modifica un registro de la base de datos.
     *
     * @param c Parametro de tipo cliente que guarda lo referente a datos de los
     * clientes.
     * @throws SQLException
     */
    public void modifyCliente(Cliente c) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("update cliente "
                + "set  Nombre = ? , PuntosJungla = ? ,"
                + "Correo = ? , HashPsw = ? , MedioPago_idMedioPago = ?  where idCliente = ?");
        pstm.setString(1, c.getNombre());
        pstm.setDouble(2, c.getPuntosJungla());
        pstm.setString(3, c.getCorreo());
        pstm.setString(4, c.getHashPsw());
        pstm.setInt(5, c.getMedioPago_idMedioPago());
        pstm.setInt(6, c.getIdCliente());
        pstm.executeUpdate();
    }
    //Cierre del metodo

    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo get
}
