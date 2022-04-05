package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.FacturaCliente;

/**
 * Esta clase guarda todo lo referente al area de facturacion de boleteria.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBFacturaCliente {
    
    //Espacios de la clase
    DBConexion cn;
    
    //Constructor de la clase
    public DBFacturaCliente(){
        cn = new DBConexion();
    }
    //Cierre del constructor
    
    /**
     * 
     * @return El ultimo numero de identificacion 
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
    //Cierre de la Funcion
    
    /**
     * Funcion que obtiene la facturacion de un cliente con su numero de 
     * identificacion.
     * 
     * @param id defiene el numero de identificacion de la factura del cliente.
     * @return La facturacion del cliente.
     * @throws SQLException 
     */
    public ResultSet getFacturaClienteById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFacturaCliente, "
                + "Total, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Cliente_idCliente "
                + "FROM facturacliente "
                + "WHERE idFacturaCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene la facturacion de un cliente con su numero de 
     * identificacion.
     * 
     * @param id defiene el numero de identificacion del cliente.
     * @return La facturacion del cliente.
     * @throws SQLException 
     */
    public ResultSet getFacturaClienteByCliente(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFacturaCliente, "
                + "Total, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Cliente_idCliente "
                + "FROM facturacliente "
                + "WHERE Cliente_idCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Metodo que agrega la facturacion a la base de datos.
     * 
     * @param f 
     */
    public void insertarFacturaCliente(FacturaCliente f){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into facturacliente(Total, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Cliente_idCliente) "
                + "values(?,?,?,?,?)");
            pstm.setDouble(1, f.getTotal());
            pstm.setInt(2, f.getAño());
            pstm.setInt(3, f.getMes());
            pstm.setInt(4, f.getDia());
            pstm.setInt(5, f.getCliente_idCliente());

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
    public void eliminarFacturaCliente(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "facturacliente where idFacturaCliente = "+i);
            pstm.executeUpdate();
    }
    //Cierre del metodo
    
    /**
     * Metodo que modifica un registro de la base de datos.
     * 
     * @param f
     * @throws SQLException 
     */
    public void modifyCliente(FacturaCliente f) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update facturacliente "
                + "set  Total = ? , Año = ? , Mes = ? , Dia = ? ,"
                + "Cliente_idCliente = ? where idFacturaCliente = ?");
        pstm.setDouble(1, f.getTotal());
        pstm.setInt(2, f.getAño());
        pstm.setInt(3, f.getMes());
        pstm.setInt(4, f.getDia());
        pstm.setInt(5, f.getCliente_idCliente());
        pstm.setInt(6, f.getIdFacturaCliente());
        pstm.executeUpdate();
    }
    //Cierre del metodo
    
    //Meotodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
