package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Empleado;

/**
 * Esta clase guarda todo lo referente a los datos de los empleados.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBEmpleado {
    
    //Espacios de la clase
    DBConexion cn;
    
    //Constructor de la clase
    public DBEmpleado(){
        cn = new DBConexion();
    }
    //Cierre del constructor
    
    /**
     * Funcion que obtiene los los datos de un empleado con su numero de 
     * identificacion asociado.
     * 
     * @param id Define el numero de identificacion.
     * @return Los datos del empleado.
     * @throws SQLException 
     */
    public ResultSet getEmpleadoById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idEmpleado, "
                + "Nombre, "
                + "Cedula, "
                + "NumTelefono, "
                + "Salario, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "HashPsw, "
                + "Multiplex_idMultiplex, "
                + "Rol_idRol "
                + "FROM empleado "
                + "WHERE idEmpleado = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene datos del empleado con su numero de cedula asociado.
     * 
     * @param cedula Define el numero de cedula del empleado. 
     * @return Datos del empleado.
     * @throws SQLException 
     */
    public ResultSet getEmpleadoByCedula(String cedula) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idEmpleado, "
                + "Nombre, "
                + "Cedula, "
                + "NumTelefono, "
                + "Salario, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "HashPsw, "
                + "Multiplex_idMultiplex, "
                + "Rol_idRol "
                + "FROM empleado "
                + "WHERE Cedula = ?");
        pstm.setString(1, cedula);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene el acceso del empleado con su numero de cedula 
     * asociado.
     * 
     * @param cedula defiene el numero de cedula del empleado.
     * @return Datos del empleado.
     * @throws SQLException 
     */
    public ResultSet getEmpleadoLogin(String cedula) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idEmpleado, "
                + "HashPsw, "
                + "Cedula "
                + "FROM empleado "
                + "WHERE Cedula = ? ");
        pstm.setString(1, cedula);
        ResultSet res = pstm.executeQuery();
        
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene datos del empleado.
     * 
     * @return Datos del empleado.
     * @throws SQLException 
     */
    public ResultSet getEmpleados() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idEmpleado, "
                + "Nombre, "
                + "Cedula, "
                + "NumTelefono, "
                + "Salario, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "HashPsw, "
                + "Multiplex_idMultiplex, "
                + "Rol_idRol "
                + "FROM empleado "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    /**
     * Funcion que obtiene datos del empleado.
     * 
     * @return Datos del empleado.
     * @throws SQLException 
     */
    public ResultSet getEmpleadosRandom() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idEmpleado, "
                + "Nombre, "
                + "Cedula, "
                + "NumTelefono, "
                + "Salario, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "HashPsw, "
                + "Multiplex_idMultiplex, "
                + "Rol_idRol "
                + "FROM empleado "
                + "ORDER BY rand() ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Metodo que agrega un empleado a la base de datos de la empresa.
     * 
     * @param e 
     */
    public void insertarEmpleado(Empleado e){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into empleado(Nombre, "
                + "Cedula, "
                + "NumTelefono, "
                + "Salario, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "HashPsw, "
                + "Multiplex_idMultiplex, "
                + "Rol_idRol) "
                + "values(?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getCedula());
            pstm.setString(3, e.getNumTelefono());
            pstm.setDouble(4, e.getSalario());
            pstm.setInt(5, e.getAño());
            pstm.setInt(6, e.getMes());
            pstm.setInt(7, e.getDia());
            pstm.setString(8, e.getHashPsw());
            pstm.setInt(9, e.getMultiplex_idMultiplex());
            pstm.setInt(10, e.getRol_idRol());

            pstm.executeUpdate();
        }catch (SQLException error){
            System.out.println(error);
        }
    }
    //Cierre del metodo
    
    /**
     * Metodo que elimina un empleado de la base de datos de la empresa.
     * 
     * @param i
     * @throws SQLException 
     */
    public void eliminarEmpleado(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from cliente where idEmpleado = "+i);
            pstm.executeUpdate();
    }
    //Cierre del metodo
    
    /**
     * Metodo que modifica un registro de la base de datos.
     * 
     * @param e
     * @throws SQLException 
     */
    public void modifyEmpleado(Empleado e) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update empleado "
                + "set  Nombre = ? , "
                + "Cedula = ? ,"
                + "NumTelefono = ? , "
                + "Salario = ? , "
                + "Año = ? , "
                + "Mes = ? , "
                + "Dia = ? , "
                + "HashPsw = ?, "
                + "Multiplex_idMultiplex = ?, "
                + "Rol_idRol = ? "
                + "where idEmpleado = ?");
        pstm.setString(1, e.getNombre());
        pstm.setString(2, e.getCedula());
        pstm.setString(3, e.getNumTelefono());
        pstm.setDouble(4, e.getSalario());
        pstm.setInt(5, e.getAño());
        pstm.setInt(6, e.getMes());
        pstm.setInt(7, e.getDia());
        pstm.setString(8, e.getHashPsw());
        pstm.setInt(9, e.getMultiplex_idMultiplex());
        pstm.setInt(10, e.getRol_idRol());
        pstm.setInt(11, e.getIdEmpleado());
        pstm.executeUpdate();
    }
    //Cierre del metodo
    
    //Metodo get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
