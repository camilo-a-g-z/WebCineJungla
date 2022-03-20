package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.RegistroComida;

/**
 *
 * @author Camilo Garcia
 */
public class DBRegistroComida {
    DBConexion cn;
    //constructor
    public DBRegistroComida(){
        cn = new DBConexion();
    }
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
    
    public void eliminarRegistroComida(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "registrocomida where idRegistroComida = "+i);
            pstm.executeUpdate();
    }
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
    public String getMensaje() {
        return cn.getMensaje();
    }
}
