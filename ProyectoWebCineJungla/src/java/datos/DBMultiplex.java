package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Multiplex;

/**
 *
 * @author Camilo Garcia
 */
public class DBMultiplex {
    DBConexion cn;
    //constructor
    public DBMultiplex(){
        cn = new DBConexion();
    }
    public ResultSet getMultiplexById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMultimplex, "
                + "Nombre, "
                + "Direccion "
                + "FROM multiplex "
                + "WHERE idMultiplex = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getMultiplexByNombre(String nombre) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMultimplex, "
                + "Nombre, "
                + "Direccion "
                + "FROM multiplex "
                + "WHERE Nombre = "+"\""+nombre+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getMultiplexs() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idMultiplex, "
                + "Nombre, "
                + "Direccion "
                + "FROM multiplex "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarMultiplex(Multiplex m){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into multiplex(Nombre ,"
                + " Direccion) "
                + "values(?,?)");
            pstm.setString(1, m.getNombre());
            pstm.setString(2, m.getDireccion());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarMultiplex(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "multiplex where idMultiplex = "+i);
            pstm.executeUpdate();
    }
    public void modifyCliente(Multiplex m) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update mediopago "
                + "set  Nombre = ? , Direccion = ? where idMedioPago = ?");
        pstm.setString(1, m.getNombre());
        pstm.setString(2, m.getDireccion());
        pstm.setInt(3, m.getIdMultiplex());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
