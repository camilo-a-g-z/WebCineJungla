package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.CalificacionServicio;

/**
 * Esta clase guarda todo lo referente a las opiniones sobre el servicio
 * brindado por el personal de la empresa.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBCalificacionServicio {

    //campos de la clase
    DBConexion cn;

    //Constructor de la clase
    public DBCalificacionServicio() {
        cn = new DBConexion();
    }

    /**
     * Esta funcion obtiene el registro de la tabla de calificacion del servicio
     * por el id.
     *
     * @param id Parametro que define el numero de identificacion en el
     * registro.
     * @return La calificacion del servicio.
     * @throws SQLException
     */
    public ResultSet getCalificacionServicioById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionServicio, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM calificacionservicio "
                + "WHERE idCalificacionServicio = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion 

    /**
     * Esta funcion obtiene el registro de la tabla de calificacion del servicio
     * por el cliente.
     *
     * @param id Parametro que define el numero de identificacion en el
     * registro.
     * @return La calificacion del servicio.
     * @throws SQLException
     */
    public ResultSet getCalificacionServicioByCliente(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionServicio, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM calificacionservicio "
                + "WHERE Cliente_idCliente = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Esta funcion obtiene el registro de la tabla de calificacion del servicio
     * por el registro de la factura de un cliente.
     *
     * @param id Parametro que define el numero de identificacion en el
     * registro.
     * @return La calificacion del servicio.
     * @throws SQLException
     */
    public ResultSet getCalificacionServicioByFacturaCliente(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionServicio, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM calificacionservicio "
                + "WHERE FacturaCliente_idFacturaCliente = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Metodo que añade una calificacion al servecio general.
     *
     * @param c Parametro de tipo CalificacionServicio que guarda lo referente a
     * las calificaciones del servio general de la empresa.
     */
    public void insertarCalificacionPelicula(CalificacionServicio c) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into "
                    + "calificacionservicio(Calificacion, "
                    + "Cliente_idCliente, "
                    + "FacturaCliente_idFacturaCliente) "
                    + "values(?,?,?)");
            pstm.setDouble(1, c.getCalificacion());
            pstm.setInt(2, c.getCliente_idCliente());
            pstm.setInt(3, c.getFacturaCliente_idFacturaCliente());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //Cierre del Metodo

    /**
     * Metodo que elimina una calificacion del servicio de la empresa.
     *
     * @param i
     * @throws SQLException
     */
    public void eliminarCalificacionServicio(int i) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from calificacionservicio"
                + " where idCalificacionServicio = " + i);
        pstm.executeUpdate();
    }
    //Cierre del Metodo

    /**
     * Metodo que modifica un registro de la base de datos.
     *
     * @param c Parametro de tipo CalificacionServicio que guarda lo referente a
     * las calificaciones del servio general de la empresa.
     * @throws SQLException
     */
    public void modifyCalificacionServicio(CalificacionServicio c) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("update calificacionpelicula "
                + "set  Calificacion = ? , Cliente_idCliente = ? ,"
                + "FacturaCliente_idFacturaCliente = ?  where idCalificacionServicio = ?");
        pstm.setDouble(1, c.getCalificacion());
        pstm.setInt(2, c.getCliente_idCliente());
        pstm.setInt(3, c.getFacturaCliente_idFacturaCliente());
        pstm.setInt(4, c.getIdCalificacionServicio());
        pstm.executeUpdate();
    }
    //Cierre de la funcion

    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
