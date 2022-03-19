package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Cliente;

/**
 *
 * @author Camilo Garcia
 */
public class DBCliente {
    DBConexion cn;
    //constructor
    public DBCliente(){
        cn = new DBConexion();
    }
    public ResultSet getClienteById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCliente, "
                + "Nombre, "
                + "PuntosJungla, "
                + "Correo, "
                + "MedioPago_idMedioPago "
                + "FROM cliente "
                + "WHERE idCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getClienteByCorreo(String correo) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCliente, "
                + "Nombre, "
                + "PuntosJungla, "
                + "Correo, "
                + "MedioPago_idMedioPago "
                + "FROM cliente "
                + "WHERE Correo = ?");
        pstm.setString(1, correo);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getClienteLogin(String correo) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCliente, "
                + "HashPws "
                + "FROM cliente "
                + "WHERE Correo = ?");
        pstm.setString(1, correo);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getClienteByNombre(String nombre) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCliente, "
                + "Nombre, "
                + "PuntosJungla, "
                + "Correo, "
                + "MedioPago_idMedioPago "
                + "FROM cliente "
                + "WHERE Nombre = "+"\""+nombre+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getClientes() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idCliente, "
                + "Nombre, "
                + "PuntosJungla, "
                + "Correo, "
                + "MedioPago_idMedioPago "
                + "FROM cliente "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public void insertarCliente(Cliente c){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into cliente(Nombre, "
                + "PuntosJungla, "
                + "Correo, "
                + "HashPsw, "
                + "MedioPago_idMedioPago) "
                + "values(?,?,?,?,?)");
            pstm.setString(1, c.getNombre());
            pstm.setDouble(2, c.getPuntosJungla());
            pstm.setString(3, c.getCorreo());
            pstm.setString(4, c.getHashPsw());
            pstm.setInt(5, c.getMedioPago_idMedioPago());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarCliente(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from cliente where idCliente = "+i);
            pstm.executeUpdate();
    }
    public void modifyCliente(Cliente c) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update cliente "
                + "set  Nombre = ? , PuntosJungla = ? ,"
                + "Correo = ? , HashPsw = ? , MedioPago_idMedioPago = ?  where idCliente = ?");
        pstm.setString(1, c.getNombre());
        pstm.setDouble(2, c.getPuntosJungla());
        pstm.setString(3, c.getCorreo());
        pstm.setString(4, c.getHashPsw());
        pstm.setInt(5, c.getMedioPago_idMedioPago());
        pstm.setInt(6, c.getIdCliente());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
