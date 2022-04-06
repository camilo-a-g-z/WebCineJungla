package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.RegistroComida;

/**
 * Esta clase guarda todo lo referente al area de registro de la confiteria.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBRegistroComida {
    
    //Espacios de la clase
    DBConexion cn;
    
    //Constructor de la clase
    public DBRegistroComida(){
        cn = new DBConexion();
    }
    //Cierre del constructor
    
    /**
     * Funcion que obtiene el registro de la comida mediante el numero de 
     * identificacion del registro.
     * @param id Define el numero de identificacion del registro.
     * @return Los datos del registro.
     * @throws SQLException 
     */
    public ResultSet getRegistroComidaById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRegistroComida, "
                + "Precio, "
                + "Cantidad, "
                + "Comida_idComida, "
                + "FacturaRapida_idFacturaRapida, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM registrocomida "
                + "WHERE idRegistroComida = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene el registro de la comida mediante el numero de 
     * identificacion del producto.
     * @param id Define el numero de identificacion del producto consumible.
     * @return Los datos del registro.
     * @throws SQLException 
     */
    public ResultSet getRegistroComidaByComida(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRegistroComida, "
                + "Precio, "
                + "Cantidad, "
                + "Comida_idComida, "
                + "FacturaRapida_idFacturaRapida, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM registrocomida "
                + "WHERE Comida_idComida = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene el registro de la comida mediante el numero de 
     * identificacion de la facturacion.
     * @param id Define el numero de identificacion de la factura.
     * @return Los datos del registro.
     * @throws SQLException 
     */
    public ResultSet getRegistroComidaByFacturaRapida(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRegistroComida, "
                + "Precio, "
                + "Cantidad, "
                + "Comida_idComida, "
                + "FacturaRapida_idFacturaRapida, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM registrocomida "
                + "WHERE FacturaRapida_idFacturaRapida = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getRegistroComidaByFacturaClienteResumen(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idComida, Nombre, cantidad, a.`Precio` " +
            "FROM mydb.registrocomida a , mydb.comida b  " +
            "where a.FacturaCliente_idFacturaCliente = "+id+" AND b.idComida = a.Comida_idComida");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getRegistroComidaByFacturaRapidaResumen(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idComida, Nombre, cantidad, a.`Precio` " +
            "FROM mydb.registrocomida a , mydb.comida b  " +
            "where a.FacturaRapida_idFacturaRapida = "+id+" AND b.idComida = a.Comida_idComida");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene el registro de la comida mediante el numero de 
     * identificacion de la facturacion del cliente.
     * @param id Define el numero de identificacion de la factura del cliente.
     * @return Los datos del registro.
     * @throws SQLException 
     */
    public ResultSet getRegistroComidaByFacturaCliente(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRegistroComida, "
                + "Precio, "
                + "Cantidad, "
                + "Comida_idComida, "
                + "FacturaRapida_idFacturaRapida, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM registrocomida "
                + "WHERE FacturaCliente_idFacturaCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Metodo que agrega un registro de la comida a la clase FacturaRapida.
     * @param r 
     */
    public void insertarRegistroComidaToFacturaRapida(RegistroComida r){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into registrocomida(Precio, "
                + "Cantidad, "
                + "Comida_idComida, "
                + "FacturaRapida_idFacturaRapida) "
                + "values(?,?,?,?)");
            pstm.setDouble(1, r.getPrecio());
            pstm.setString(2, r.getCantidad());
            pstm.setInt(3, r.getComida_idComida());
            pstm.setInt(4, r.getFacturaRapida_idFacturaRapida());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    //Cierre del metodo.
    
    /**
     * Metodo que agrega un registro de la comida a la clase FacturaCliente.
     * @param r 
     */
    public void insertarRegistroComidaToFacturaCliente(RegistroComida r){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into registrocomida(Precio, "
                + "Cantidad, "
                + "Comida_idComida, "
                + "FacturaCliente_idFacturaCliente) "
                + "values(?,?,?,?)");
            pstm.setDouble(1, r.getPrecio());
            pstm.setString(2, r.getCantidad());
            pstm.setInt(3, r.getComida_idComida());
            pstm.setInt(4, r.getFacturaCliente_idFacturaCliente());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    //Cierre del metodo
    
    /**
     * Meotodo que elimina un registro de la base de datos.
     * @param i
     * @throws SQLException 
     */
    public void eliminarRegistroComida(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "registrocomida where idRegistroComida = "+i);
            pstm.executeUpdate();
    }
    public void eliminarRegistroComidaByFacturaCliente(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "registrocomida where FacturaCliente_idFacturaCliente = "+i);
            pstm.executeUpdate();
    }
    public void eliminarRegistroComidaByFacturaRapida(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "registrocomida where FacturaRapida_idFacturaRapida = "+i);
            pstm.executeUpdate();
    }
    //Cierre del metodo
    
    /**
     * Metodo que modifica un registro de la comida de la clase FacturaRapida.
     * @param r
     * @throws SQLException 
     */
    public void modifyRegistroComidaToFacturaRapida(RegistroComida r) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update registrocomida "
                + "set  Precio = ? , Cantidad = ? ,"
                + "SComida_idComida = ? , "
                + "FacturaRapida_idFacturaRapida = ? where idRegistroComida = ?");
        pstm.setDouble(1, r.getPrecio());
        pstm.setString(2, r.getCantidad());
        pstm.setInt(3, r.getComida_idComida());
        pstm.setInt(4, r.getFacturaRapida_idFacturaRapida());
        pstm.setInt(5, r.getIdRegistroComida());
        pstm.executeUpdate();
    }
    //Cierre de la funcion
    
    /**
     * Metodo que modifica un registro de la comida de la clase FacturaCliente.
     * @param r
     * @throws SQLException 
     */
    public void modifyRegistroComidaToFacturaCliente(RegistroComida r) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update registrocomida "
                + "set  Precio = ? , Cantidad = ? ,"
                + "Comida_idComida = ? , "
                + "FacturaCliente_idFacturaCliente = ? where idRegistroBoleta = ?");
        pstm.setDouble(1, r.getPrecio());
        pstm.setString(2, r.getCantidad());
        pstm.setInt(3, r.getComida_idComida());
        pstm.setInt(4, r.getFacturaCliente_idFacturaCliente());
        pstm.setInt(5, r.getIdRegistroComida());
        pstm.executeUpdate();
    }
    //Cierre del metodo
    
    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
