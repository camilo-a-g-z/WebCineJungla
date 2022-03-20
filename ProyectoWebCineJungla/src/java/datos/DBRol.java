package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Rol;

/**
 *
 * @author Camilo Garcia
 */
public class DBRol {
    DBConexion cn;
    //constructor
    public DBRol(){
        cn = new DBConexion();
    }
    public ResultSet getRolById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRol, "
                + "Nombre "
                + "FROM rol "
                + "WHERE idRol = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getRolByNombre(String nombre) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRol, "
                + "Nombre "
                + "FROM rol "
                + "WHERE Nombre = "+"\""+nombre+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getRoles() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRol, "
                + "Nombre "
                + "FROM rol "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarRol(Rol r){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into rol(Nombre) "
                + "values(?)");
            pstm.setString(1, r.getNombre());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarRol(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "rol where idRol= "+i);
            pstm.executeUpdate();
    }
    public void modifyRol(Rol r) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update rol "
                + "set  Nombre = ? where idRol = ?");
        pstm.setString(1, r.getNombre());
        pstm.setInt(2, r.getIdRol());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
