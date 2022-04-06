package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.RegistroBoleta;

/**
 * Esta clase guarda lo referente a los registros de boleteria.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBRegistroBoleta {
    
    //Espacios de la clase
    DBConexion cn;
    
    //Constructor de la clase
    public DBRegistroBoleta(){
        cn = new DBConexion();
    }
    
    /**
     * Funcion que obtiene los datos del registro a partir del numero de 
     * identificacion del registro.
     * 
     * @param id Define el numero de identificacion que se le da al registro.
     * @return Los datos del registro de la boleta.
     * @throws SQLException 
     */
    public ResultSet getRegistroBoletaById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRegistroBoleta, "
                + "Precio, "
                + "Cantidad, "
                + "SillaFuncion_idSillaFuncion, "
                + "FacturaRapida_idFacturaRapida, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM registroboleta "
                + "WHERE idRegistroBoleta= "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion.
    
    /**
     * Funcion que obtiene los datos del registro a partir del numero de 
     * identificacion de la silla elegida.
     * 
     * @param id define el numero de identificacion de una silla.
     * @return Los datos del registro de la boleta.
     * @throws SQLException 
     */
    public ResultSet getRegistroBoletaBySillaFuncion(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRegistroBoleta, "
                + "Precio, "
                + "Cantidad, "
                + "SillaFuncion_idSillaFuncion, "
                + "FacturaRapida_idFacturaRapida, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM registroboleta "
                + "WHERE SillaFuncion_idSillaFuncion = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene los datos del registro a partir del numero de 
     * identificacion de la factura.
     * 
     * @param id Define el numero de identificacion de una facturacion.
     * @return Los datos del registro de la boleta.
     * @throws SQLException 
     */
    public ResultSet getRegistroBoletaByFacturaRapida(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRegistroBoleta, "
                + "Precio, "
                + "Cantidad, "
                + "SillaFuncion_idSillaFuncion, "
                + "FacturaRapida_idFacturaRapida, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM registroboleta "
                + "WHERE FacturaRapida_idFacturaRapida = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getRegistroBoletaByFacturaClienteResumen(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSilla, Ubicacion, Precio, Tipo " +
            "FROM registroboleta a , sillafuncion b, silla c  " +
            "where a.FacturaCliente_idFacturaCliente = "+id+ " AND b.idSillaFuncion = a.SillaFuncion_idSillaFuncion " +
            "AND b.Silla_idSilla = c.idSilla");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getRegistroBoletaByFacturaRapidaResumen(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSilla, Ubicacion, Precio, Tipo " +
            "FROM registroboleta a , sillafuncion b, silla c  " +
            "where a.FacturaRapida_idFacturaRapida = "+id+ " AND b.idSillaFuncion = a.SillaFuncion_idSillaFuncion " +
            "AND b.Silla_idSilla = c.idSilla");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene los datos del registro a partir del numero de 
     * identificacion de la factura.
     * 
     * @param id Define el numero de identificacion de una facturacion.
     * @return Los datos del registro de la boleta.
     * @throws SQLException 
     */
    public ResultSet getRegistroBoletaByFacturaCliente(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idRegistroBoleta, "
                + "Precio, "
                + "Cantidad, "
                + "SillaFuncion_idSillaFuncion, "
                + "FacturaRapida_idFacturaRapida, "
                + "FacturaCliente_idFacturaCliente "
                + "FROM registroboleta "
                + "WHERE FacturaCliente_idFacturaCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Agrega un registro de boleta a la clase FacturaRapida.
     * 
     * @param r 
     */
    public void insertarRegistroBoletaToFacturaRapida(RegistroBoleta r){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into registroboleta(Precio, "
                + "Cantidad, "
                + "SillaFuncion_idSillaFuncion, "
                + "FacturaRapida_idFacturaRapida) "
                + "values(?,?,?,?)");
            pstm.setDouble(1, r.getPrecio());
            pstm.setString(2, r.getCantidad());
            pstm.setInt(3, r.getSillaFuncion_idSillaFuncion());
            pstm.setInt(4, r.getFacturaRapida_idFacturaRapida());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    //Cierre del metodo
    
    /**
     * Agrega un registro de la boleta a la clase FacturaCliente.
     * 
     * @param r 
     */ 
    public void insertarRegistroBoletaToFacturaCliente(RegistroBoleta r){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into registroboleta(Precio, "
                + "Cantidad, "
                + "SillaFuncion_idSillaFuncion, "
                + "FacturaCliente_idFacturaCliente) "
                + "values(?,?,?,?)");
            pstm.setDouble(1, r.getPrecio());
            pstm.setString(2, r.getCantidad());
            pstm.setInt(3, r.getSillaFuncion_idSillaFuncion());
            pstm.setInt(4, r.getFacturaCliente_idFacturaCliente());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    //Cierre del metodo
    
    /**
     * Elimina un registro de la boleta en la base de datos
     * 
     * @param i
     * @throws SQLException 
     */
    public void eliminarRegistroBoleta(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "registroboleta where idRegistroBoleta = "+i);
            pstm.executeUpdate();
    }
    public void eliminarRegistroBoletaByFacturaCliente(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "registroboleta where FacturaCliente_idFacturaCliente = "+i);
            pstm.executeUpdate();
    }
    public void eliminarRegistroBoletaByFacturaRapida(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "registroboleta where FacturaRapida_idFacturaRapida = "+i);
            pstm.executeUpdate();
    }
    
    //Cierre del metodo
    
    /**
     * Elimina un registro de la boleta en la clase FacturaRapida.
     * 
     * @param r
     * @throws SQLException 
     */
    public void modifyRegistroBoletaToFacturaRapida(RegistroBoleta r) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update registroboleta "
                + "set  Precio = ? , Cantidad = ? ,"
                + "SillaFuncion_idSillaFuncion = ? , "
                + "FacturaRapida_idFacturaRapida = ? where idRegistroBoleta = ?");
        pstm.setDouble(1, r.getPrecio());
        pstm.setString(2, r.getCantidad());
        pstm.setInt(3, r.getSillaFuncion_idSillaFuncion());
        pstm.setInt(4, r.getFacturaRapida_idFacturaRapida());
        pstm.setInt(5, r.getIdRegistroBoleta());
        pstm.executeUpdate();
    }
    
    //Cierre del metodo
    
    /**
     * Elimina un registro de la boleta en la clase FacturaCliente.
     * 
     * @param r
     * @throws SQLException 
     */ 
    public void modifyRegistroBoletaToFacturaCliente(RegistroBoleta r) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update registroboleta "
                + "set  Precio = ? , Cantidad = ? ,"
                + "SillaFuncion_idSillaFuncion = ? , "
                + "FacturaCliente_idFacturaCliente = ? where idRegistroBoleta = ?");
        pstm.setDouble(1, r.getPrecio());
        pstm.setString(2, r.getCantidad());
        pstm.setInt(3, r.getSillaFuncion_idSillaFuncion());
        pstm.setInt(4, r.getFacturaCliente_idFacturaCliente());
        pstm.setInt(5, r.getIdRegistroBoleta());
        pstm.executeUpdate();
    }
    //Cierre del metodo
    
    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
