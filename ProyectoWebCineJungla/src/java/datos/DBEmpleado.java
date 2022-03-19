package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Empleado;

/**
 *
 * @author Camilo Garcia
 */
public class DBEmpleado {
    DBConexion cn;
    //constructor
    public DBEmpleado(){
        cn = new DBConexion();
    }
    public ResultSet getEmpleadoById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idEmpleado, "
                + "Nombre, "
                + "Cedula, "
                + "NumTelefono, "
                + "Salario, "
                + "FechaIngreso, "
                + "HashPws, "
                + "Multiplex_idMultiplex, "
                + "Rol_idRol "
                + "FROM empleadoo "
                + "WHERE idEmpleado = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getEmpleadoByCedula(String cedula) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idEmpleado, "
                + "Nombre, "
                + "Cedula, "
                + "NumTelefono, "
                + "Salario, "
                + "FechaIngreso, "
                + "HashPws, "
                + "Multiplex_idMultiplex, "
                + "Rol_idRol "
                + "FROM empleado "
                + "WHERE Cedula = ?");
        pstm.setString(1, cedula);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getEmpleadoLogin(String cedula) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idEmpleado, "
                + "HashPws "
                + "FROM empleado "
                + "WHERE Cedula = ?");
        pstm.setString(1, cedula);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getEmpleados() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idEmpleado, "
                + "Nombre, "
                + "Cedula, "
                + "NumTelefono, "
                + "Salario, "
                + "FechaIngreso, "
                + "HashPws, "
                + "Multiplex_idMultiplex, "
                + "Rol_idRol "
                + "FROM empleado "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarEmpleado(Empleado e){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into empleado(Nombre, "
                + "Cedula, "
                + "NumTelefono, "
                + "Salario, "
                + "FechaIngreso, "
                + "HashPsw, "
                + "Multiplex_idMultiplex, "
                + "Rol_idRol) "
                + "values(?,?,?,?,?,?,?,?)");
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getCedula());
            pstm.setString(3, e.getNumTelefono());
            pstm.setDouble(4, e.getSalario());
            pstm.setDate(5, e.getFechaIngreso());
            pstm.setString(6, e.getHashPsw());
            pstm.setInt(7, e.getMultiplex_idMultiplex());
            pstm.setInt(8, e.getRol_idRol());

            pstm.executeUpdate();
        }catch (SQLException error){
            System.out.println(error);
        }
    }
    public void eliminarEmpleado(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from cliente where idEmpleado = "+i);
            pstm.executeUpdate();
    }
    public void modifyEmpleado(Empleado e) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update empleado "
                + "set  Nombre = ? , "
                + "Cedula = ? ,"
                + "NumTelefono = ? , "
                + "Salario = ? , "
                + "FechaIngreso = ?, "
                + "HashPsw = ?, "
                + "Multiplex_idMultiplex = ?, "
                + "Rol_idRol = ? "
                + "where idEmpleado = ?");
        pstm.setString(1, e.getNombre());
        pstm.setString(2, e.getCedula());
        pstm.setString(3, e.getNumTelefono());
        pstm.setDouble(4, e.getSalario());
        pstm.setDate(5, e.getFechaIngreso());
        pstm.setString(6, e.getHashPsw());
        pstm.setInt(7, e.getMultiplex_idMultiplex());
        pstm.setInt(8, e.getRol_idRol());
        pstm.setInt(9, e.getIdEmpleado());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
