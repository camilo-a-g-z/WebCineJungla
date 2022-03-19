package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.CalificacionPelicula;

/**
 *
 * @author Camilo Garcia
 */
public class DBCalificacionPelicula {
    DBConexion cn;
    //constructor
    public DBCalificacionPelicula(){
        cn = new DBConexion();
    }
    public ResultSet getCalificacionPeliculaById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionPelicula, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "Pelicula_idPelicula "
                + "FROM calificacionpelicula "
                + "WHERE idCalificacionPelicula = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getCalificacionPeliculaByCliente(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionPelicula, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "Pelicula_idPelicula "
                + "FROM calificacionpelicula "
                + "WHERE Cliente_idCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getCalificacionPeliculaByPelicula(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionPelicula, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "Pelicula_idPelicula "
                + "FROM calificacionpelicula "
                + "WHERE Pelicula_idPelicula = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public void insertarCalificacionPelicula(CalificacionPelicula c){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into "
                + "calificacionpelicula(Calificacion, "
                + "Cliente_idCliente, "
                + "Pelicula_idPelicula) "
                + "values(?,?,?)");
            pstm.setDouble(1, c.getCalificacion());
            pstm.setInt(2, c.getCliente_idCliente());
            pstm.setInt(3, c.getPelicula_idPelicula());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarCalificacionPelicula(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from calificacionpelicula"
                + " where idCalificacionPelicula = "+i);
            pstm.executeUpdate();
    }
    public void modifyCalificacionPelicula(CalificacionPelicula c) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update calificacionpelicula "
                + "set  Calificacion = ? , Cliente_idCliente = ? ,"
                + "Pelicula_idPelicula = ?  where idCalificacionPelicula = ?");
        pstm.setDouble(1, c.getCalificacion());
        pstm.setInt(2, c.getCliente_idCliente());
        pstm.setInt(3, c.getPelicula_idPelicula());
        pstm.setInt(4, c.getIdCalificacionPelicula());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
