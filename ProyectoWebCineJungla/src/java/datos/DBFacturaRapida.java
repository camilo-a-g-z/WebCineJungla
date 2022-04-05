package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.FacturaRapida;

/**
 * Esta clase guarda lo referente al area de facturacion de boleteria.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBFacturaRapida {
    
    //Espacios de la clase
    DBConexion cn;
    
    //Constructor de la clase
    public DBFacturaRapida(){
        cn = new DBConexion();
    }
    //Cierre del constructor
    
    /**
     * 
     * @return El ultimo numero de identificacion. 
     */
    public String getLastId(){
        try{
            PreparedStatement pstm_2 = cn.getConexion().prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet res = pstm_2.executeQuery();
            res.next();
            return res.getString("LAST_INSERT_ID()");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene la facturacion de un cliente con su numero de 
     * identificacion.
     * 
     * @param id defiene el numero de identificacion de la factura del cliente.
     * @return La facturacion del cliente.
     * @throws SQLException 
     */
    public ResultSet getFacturaRapidaById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFacturaRapida, "
                + "Total, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Empleado_idEmpleado "
                + "FROM facturarapida "
                + "WHERE idFacturaRapida = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene la facturacion de un cliente con el numero de 
     * identificacion del empleado.
     * 
     * @param id defiene el numero de identificacion del empleado.
     * @return La facturacion del cliente.
     * @throws SQLException 
     */
    public ResultSet getFacturaRapidaByEmpleado(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFacturaRapida, "
                + "Total, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Empleado_idEmpleado "
                + "FROM facturarapida "
                + "WHERE Empleado_idEmpleado = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Metodo que agrega la facturacion a la base de datos.
     * 
     * @param f 
     */
    public void insertarFacturaRapida(FacturaRapida f){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into facturarapida(Total, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Empleado_idEmpleado) "
                + "values(?,?,?,?,?)");
            pstm.setDouble(1, f.getTotal());
            pstm.setInt(2, f.getAño());
            pstm.setInt(3, f.getMes());
            pstm.setInt(4, f.getDia());
            pstm.setInt(5, f.getEmpleado_idEmpleado());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    //Cierre del metodo
    
    /**
     * Metodo que elimina una Facturacion de la base de datos. 
     * 
     * @param i
     * @throws SQLException 
     */ 
    public void eliminarFacturaRapida(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "facturarapida where idFacturaRapida = "+i);
            pstm.executeUpdate();
    }
    //Cierre del metodo
    
    /**
     * Metodo que modifica un registro de la base de datos.
     * 
     * @param f
     * @throws SQLException 
     */
    public void modifyCliente(FacturaRapida f) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update facturarapida "
                + "set  Total = ? , Año = ? , Mes = ? , Dia = ? ,"
                + "Empleado_idEmpleado = ? where idFacturaRapida = ?");
        pstm.setDouble(1, f.getTotal());
        pstm.setInt(2, f.getAño());
        pstm.setInt(3, f.getMes());
        pstm.setInt(4, f.getDia());
        pstm.setInt(5, f.getEmpleado_idEmpleado());
        pstm.setInt(6, f.getIdFacturaRapida());
        pstm.executeUpdate();
    }
    //Cierre del metodo
    
    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
