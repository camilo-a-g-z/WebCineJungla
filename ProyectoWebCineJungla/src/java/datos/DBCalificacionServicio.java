package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.CalificacionServicio;

/**
 *
 * @author Camilo Garcia
 */
public class DBCalificacionServicio {
    DBConexion cn;
    //constructor
    public DBCalificacionServicio(){
        cn = new DBConexion();
    }
    public ResultSet getCalificacionServicioById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionServicio, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM calificacionservicio "
                + "WHERE idCalificacionServicio = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getCalificacionServicioByCliente(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionServicio, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM calificacionservicio "
                + "WHERE Cliente_idCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getCalificacionServicioByFacturaCliente(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCalificacionServicio, "
                + "Calificacion, "
                + "Cliente_idCliente, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM calificacionservicio "
                + "WHERE FacturaCliente_idFacturaCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarCalificacionPelicula(CalificacionServicio c){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into "
                + "calificacionservicio(Calificacion, "
                + "Cliente_idCliente, "
                + "FacturaCliente_idFacturaCliente) "
                + "values(?,?,?)");
            pstm.setDouble(1, c.getCalificacion());
            pstm.setInt(2, c.getCliente_idCliente());
            pstm.setInt(3, c.getFacturaCliente_idFacturaCliente());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarCalificacionServicio(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from calificacionservicio"
                + " where idCalificacionServicio = "+i);
            pstm.executeUpdate();
    }
    public void modifyCalificacionServicio(CalificacionServicio c) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update calificacionpelicula "
                + "set  Calificacion = ? , Cliente_idCliente = ? ,"
                + "FacturaCliente_idFacturaCliente = ?  where idCalificacionServicio = ?");
        pstm.setDouble(1, c.getCalificacion());
        pstm.setInt(2, c.getCliente_idCliente());
        pstm.setInt(3, c.getFacturaCliente_idFacturaCliente());
        pstm.setInt(4, c.getIdCalificacionServicio());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
