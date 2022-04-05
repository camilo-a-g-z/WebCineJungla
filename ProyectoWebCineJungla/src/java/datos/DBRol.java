package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Rol;

/**
 * Esta clase guarda todo lo referente a los roles de los empleados.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBRol {
    
    //Espacios de la clase
    DBConexion cn;
    
    //Constructor de la clase
    public DBRol(){
        cn = new DBConexion();
    }
    //Cierre del constructor
    
    /**
     * Funcion que obtiene los datos un rol en la empresa por su numero de 
     * identificacion. 
     * 
     * @param id Define el numero de identificacion del rol.
     * @return Los datos de un rol.
     * @throws SQLException 
     */
    public ResultSet getRolById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRol, "
                + "Nombre "
                + "FROM rol "
                + "WHERE idRol = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene un rol en la empresa por el nombre asignado.
     * 
     * @param nombre define el nombre asignado al rol.
     * @return Los datos de un rol.
     * @throws SQLException 
     */
    public ResultSet getRolByNombre(String nombre) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRol, "
                + "Nombre "
                + "FROM rol "
                + "WHERE Nombre = "+"\""+nombre+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene los roles disponibles dentro de la empresa. 
     * 
     * @return LOs roles de la empresa.
     * @throws SQLException 
     */
    public ResultSet getRoles() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRol, "
                + "Nombre "
                + "FROM rol "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Agrega un rol disponible a la base de datos
     * 
     * @param r 
     */
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
    //Cierre del metodo
    
    /**
     * Elimina un rol disponible de la base de datos.
     * 
     * @param i
     * @throws SQLException 
     */
    public void eliminarRol(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "rol where idRol= "+i);
            pstm.executeUpdate();
    }
    //Cierre del metodo
    
    /**
     * Modifica un registro dentro de la base de datos.
     * 
     * @param r
     * @throws SQLException 
     */
    public void modifyRol(Rol r) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update rol "
                + "set  Nombre = ? where idRol = ?");
        pstm.setString(1, r.getNombre());
        pstm.setInt(2, r.getIdRol());
        pstm.executeUpdate();
    }
    //Cierre del metodo
    
    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
