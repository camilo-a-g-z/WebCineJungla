package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.AccionRol;

/**
 *
 * @author Camilo Garcia
 */
public class DBAccionRol {
    DBConexion cn;
    //constructor
    public DBAccionRol(){
        cn = new DBConexion();
    }
    public ResultSet getAccionRolById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idAccionRol, "
                + "Nombre, "
                + "Rol_idRol "
                + "FROM accionrol "
                + "WHERE idAccionRol = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getAccionRolByNombre(String nombre) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idAccionRol, "
                + "Nombre, "
                + "Rol_idRol "
                + "FROM accionrol "
                + "WHERE Nombre = "+"\""+nombre+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getAccionRoles() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idAccionRol, "
                + "Nombre, "
                + "Rol_idRol "
                + "FROM accionrol "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public void insertarAccionRol(AccionRol a){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into accionrol(Nombre, "
                + "Rol_idRol) "
                + "values(?,?)");
            pstm.setString(1, a.getNombre());
            pstm.setInt(2, a.getRol_idRol());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarAccionRol(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from accionrol"
                + " where idAccionRol = "+i);
            pstm.executeUpdate();
    }
    public void modifyCliente(AccionRol a) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update accionrol "
                + "set  Nombre = ? , Rol_idRol = ?  where idAccionRol = ?");
        pstm.setString(1, a.getNombre());
        pstm.setInt(2, a.getRol_idRol());
        pstm.setInt(3, a.getIdAccionRol());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
