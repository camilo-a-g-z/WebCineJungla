package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Pelicula;

/**
 *
 * @author Camilo Garcia
 */
public class DBPelicula {
    DBConexion cn;
    //constructor
    public DBPelicula(){
        cn = new DBConexion();
    }
    public ResultSet getPeliculaById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idPelicula, "
                + "Nombre, "
                + "ClasificacionEdad, "
                + "Duracion, "
                + "Director, "
                + "Sinopsis, "
                + "UrlPelicula "
                + "FROM pelicula "
                + "WHERE idPelicula = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getPeliculaByNombre(String nombre) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idPelicula, "
                + "Nombre, "
                + "ClasificacionEdad, "
                + "Duracion, "
                + "Director, "
                + "Sinopsis, "
                + "UrlPelicula "
                + "FROM pelicula "
                + "WHERE Nombre = "+"\""+nombre+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getPeliculas() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idPelicula, "
                + "Nombre, "
                + "ClasificacionEdad, "
                + "Duracion, "
                + "Director, "
                + "Sinopsis, "
                + "UrlPelicula "
                + "FROM pelicula "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public void insertarComida(Pelicula p){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into cliente(Nombre, "
                + "ClasificacionEdad, "
                + "Duracion, "
                + "Director, "
                + "Sinopsis, UrlPelicula) "
                + "values(?,?,?,?,?,?)");
            pstm.setString(1, p.getNombre());
            pstm.setString(2, p.getClasificacionEdad());
            pstm.setString(3, p.getDuracion());
            pstm.setString(4, p.getDirector());
            pstm.setString(5, p.getSinopsis()); 
            pstm.setString(6, p.getUrlPelicula());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarPelicula(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "pelicula where idPelicula = "+i);
            pstm.executeUpdate();
    }
    public void modifyPelicula(Pelicula p) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update pelicula "
                + "set  Nombre = ? ,"
                + " ClasificacionEdad = ? ,"
                + " Duracion = ? ,"
                + " Director = ? ,"
                + " Sinopsis = ? ,"
                + " UrlPelicula = ? where idPelicula = ?");
        pstm.setString(1, p.getNombre());
        pstm.setString(2, p.getClasificacionEdad());
        pstm.setString(3, p.getDuracion());
        pstm.setString(4, p.getDirector());
        pstm.setString(5, p.getSinopsis());
        pstm.setString(6, p.getUrlPelicula());
        pstm.setInt(7, p.getIdPelicula());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
