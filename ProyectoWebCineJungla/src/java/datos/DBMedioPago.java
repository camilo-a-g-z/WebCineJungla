package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.MedioPago;

/**
 *
 * @author Camilo Garcia
 */
public class DBMedioPago {
    DBConexion cn;
    //constructor
    public DBMedioPago(){
        cn = new DBConexion();
    }
    public ResultSet getMedioPagoById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMedioPago, "
                + "Nombre "
                + "FROM mediopago "
                + "WHERE idMedioPago = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getMedioPagoByNombre(String nombre) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMedioPago, "
                + "Nombre "
                + "FROM mediopago "
                + "WHERE Nombre = "+nombre);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getMedioPagos() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMedioPago, "
                + "Nombre "
                + "FROM mediopago "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarMedioPago(MedioPago m){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into mediopago(Nombre) "
                + "values(?)");
            pstm.setString(1, m.getNombre());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarMedioPago(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "mediopago where idMedioPago = "+i);
            pstm.executeUpdate();
    }
    public void modifyCliente(MedioPago m) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update mediopago "
                + "set  Nombre = ? where idMedioPago = ?");
        pstm.setString(1, m.getNombre());
        pstm.setInt(2, m.getIdMedioPago());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
