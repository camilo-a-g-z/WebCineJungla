package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.CalificacionPelicula;

/**
 * Esta clase guarda todo lo referente a las peliculas disponibles en el cine.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBCalificacionPelicula {

    //campos de la clase
    DBConexion cn;

    //Constructor de la clase
    public DBCalificacionPelicula() {
        cn = new DBConexion();
    }
    //Cierre del constructor

    /**
     * Funcion que retorna la calificacion de la pelicula con el id
     * proporcionado.
     *
     * @param id Parametro que define el numero de identificacion de la
     * pelicula.
     * @return La calificacion de la pelicula.
     * @throws SQLException
     */
    public ResultSet getCalificacionPeliculaById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionPelicula, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "Pelicula_idPelicula "
                + "FROM calificacionpelicula "
                + "WHERE idCalificacionPelicula = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que retorna la calificacion dada por un cliente a la pelicula
     * solicitada por su id.
     *
     * @param id Parametro que define el numero de identificacion de la 
     * pelicula.
     * @return La calificacion de la pelicula.
     * @throws SQLException
     */
    public ResultSet getCalificacionPeliculaByCliente(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionPelicula, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "Pelicula_idPelicula "
                + "FROM calificacionpelicula "
                + "WHERE Cliente_idCliente = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que retorna la calificacion de la pelicula solicitada, almacenada 
     * en la base de datos. 
     * 
     * @param id Parametro que define el numero de identificacion de la
     * pelicula.
     * @return La calificacion de la pelicula.
     * @throws SQLException 
     */
    public ResultSet getCalificacionPeliculaByPelicula(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionPelicula, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "Pelicula_idPelicula "
                + "FROM calificacionpelicula "
                + "WHERE Pelicula_idPelicula = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que añade la calificacion a la pelicula.
     * 
     * @param c Parametro de tipo CalificacionPelicula que guarda lo referente 
     * a las calficaciones de las peliculas.
     */
    public void insertarCalificacionPelicula(CalificacionPelicula c) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into "
                    + "calificacionpelicula(Calificacion, "
                    + "Cliente_idCliente, "
                    + "Pelicula_idPelicula) "
                    + "values(?,?,?)");
            pstm.setDouble(1, c.getCalificacion());
            pstm.setInt(2, c.getCliente_idCliente());
            pstm.setInt(3, c.getPelicula_idPelicula());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //Cierre del metodo

    /**
     * Metodo que elimina la calificacion solicitada de la base de datos. 
     * 
     * @param i
     * @throws SQLException 
     */
    public void eliminarCalificacionPelicula(int i) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from calificacionpelicula"
                + " where idCalificacionPelicula = " + i);
        pstm.executeUpdate();
    }
    //Cierre del metodo

    /**
     * Metodo que modifica la calificacion de la pelicula proporcionada.
     * 
     * @param c Parametro que define un objeto de tipo CalificacionPelicula que 
     * contiene datos referentes a la calificacion de las peliculas.
     * @throws SQLException 
     */
    public void modifyCalificacionPelicula(CalificacionPelicula c) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("update calificacionpelicula "
                + "set  Calificacion = ? , Cliente_idCliente = ? ,"
                + "Pelicula_idPelicula = ?  where idCalificacionPelicula = ?");
        pstm.setDouble(1, c.getCalificacion());
        pstm.setInt(2, c.getCliente_idCliente());
        pstm.setInt(3, c.getPelicula_idPelicula());
        pstm.setInt(4, c.getIdCalificacionPelicula());
        pstm.executeUpdate();
    }
    //Cierre del metodo

    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
