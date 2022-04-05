package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.RegistroBoleta;

/**
 *
 * @author Camilo Garcia
 */
public class DBRegistroBoleta {
    DBConexion cn;
    //constructor
    public DBRegistroBoleta(){
        cn = new DBConexion();
    }
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
    public String getMensaje() {
        return cn.getMensaje();
    }
}
