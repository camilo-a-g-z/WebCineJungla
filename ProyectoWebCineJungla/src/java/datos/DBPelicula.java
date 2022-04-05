package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Pelicula;

/**
 * Esta clase guarda todo lo referente los datos de las peliculas proyectadas.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBPelicula {

    //Espacios de la clase
    DBConexion cn;

    //Constructor de la clase
    public DBPelicula() {
        cn = new DBConexion();
    }
    //Cierre del constructor

    /**
     * Obtiene los datos de una pelicula por el numero de identificacion 
     * proporcionado. 
     *
     * @param id Define el numero de identificacion de la pelicula.
     * @return Los datos de la pelicula.
     * @throws SQLException
     */
    public ResultSet getPeliculaById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idPelicula, "
                + "Nombre, "
                + "ClasificacionEdad, "
                + "Duracion, "
                + "Director, "
                + "Sinopsis, "
                + "UrlPelicula,"
                + "Estado "
                + "FROM pelicula "
                + "WHERE idPelicula = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre del constructor

    /**
     * Funcion que obtiene los datos de una pelicula por el nombre registrado.
     *
     * @param nombre Define el nombre de la pelicula.
     * @return Los datos de la pelicula.
     * @throws SQLException
     */
    public ResultSet getPeliculaByNombre(String nombre) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idPelicula, "
                + "Nombre, "
                + "ClasificacionEdad, "
                + "Duracion, "
                + "Director, "
                + "Sinopsis, "
                + "UrlPelicula, "
                + "Estado "
                + "FROM pelicula "
                + "WHERE Nombre = " + "\"" + nombre + "\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene los datos de una pelicula por su estado en cartelera.
     *
     * @param estado Define el estado de la cartelera de la pelicula en los 
     * multiplex.
     * @return Los datos de la pelicula.
     * @throws SQLException
     */
    public ResultSet getPeliculaByEstado(String estado) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idPelicula, "
                + "Nombre, "
                + "ClasificacionEdad, "
                + "Duracion, "
                + "Director, "
                + "Sinopsis, "
                + "UrlPelicula, "
                + "Estado "
                + "FROM pelicula "
                + "WHERE Estado = " + "\"" + estado + "\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene las peliculas registradas en la base de datos.
     *
     * @return Los datos de las peliculas.
     * @throws SQLException
     */
    public ResultSet getPeliculas() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idPelicula, "
                + "Nombre, "
                + "ClasificacionEdad, "
                + "Duracion, "
                + "Director, "
                + "Sinopsis, "
                + "UrlPelicula, "
                + "Estado "
                + "FROM pelicula "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Metodo que agrega una pelicula a la base de datos.
     *
     * @param p
     */
    public void insertarPelicula(Pelicula p) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into pelicula(Nombre, "
                    + "ClasificacionEdad, "
                    + "Duracion, "
                    + "Director, "
                    + "Sinopsis, "
                    + "UrlPelicula, "
                    + "Estado) "
                    + "values(?,?,?,?,?,?,?)");
            pstm.setString(1, p.getNombre());
            pstm.setString(2, p.getClasificacionEdad());
            pstm.setInt(3, p.getDuracion());
            pstm.setString(4, p.getDirector());
            pstm.setString(5, p.getSinopsis());
            pstm.setString(6, p.getUrlPelicula());
            pstm.setString(7, p.getEstado());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //Cierre del metodo

    /**
     * Metodo que elimina una pelicula de la base de datos.
     *
     * @param i
     * @throws SQLException
     */
    public void eliminarPelicula(int i) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "pelicula where idPelicula = " + i);
        pstm.executeUpdate();
    }
    //Cierre del metodo

    /**
     * Metodo que modifica un registro en la base de datos.
     * 
     * @param p
     * @throws SQLException
     */
    public void modifyPelicula(Pelicula p) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("update pelicula "
                + "set  Nombre = ? ,"
                + " ClasificacionEdad = ? ,"
                + " Duracion = ? ,"
                + " Director = ? ,"
                + " Sinopsis = ? ,"
                + " UrlPelicula = ? ,"
                + " Estado where idPelicula = ?");
        pstm.setString(1, p.getNombre());
        pstm.setString(2, p.getClasificacionEdad());
        pstm.setInt(3, p.getDuracion());
        pstm.setString(4, p.getDirector());
        pstm.setString(5, p.getSinopsis());
        pstm.setString(6, p.getUrlPelicula());
        pstm.setString(7, p.getEstado());
        pstm.setInt(8, p.getIdPelicula());
        pstm.executeUpdate();
    }
    //Cierre del metodo

    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
