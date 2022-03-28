package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Comida;

/**
 *
 * @author Camilo Garcia
 */
public class DBComida {
    DBConexion cn;
    //constructor
    public DBComida(){
        cn = new DBConexion();
    }
    public ResultSet getComidaById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idComida, "
                + "Nombre, "
                + "Precio, "
                + "Stock, "
                + "Multiplex_idMultiplex "
                + "FROM comida "
                + "WHERE idComida = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getComidaByNombre(String nombre) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idComida, "
                + "Nombre, "
                + "Precio, "
                + "Stock, "
                + "Multiplex_idMultiplex "
                + "FROM comida "
                + "WHERE Nombre = "+"\""+nombre+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getComidaByMultiplex(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idComida, "
                + "Nombre, "
                + "Precio, "
                + "Stock, "
                + "Multiplex_idMultiplex "
                + "FROM comida "
                + "WHERE Multiplex_idMultiplex = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getComidas() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idComida, "
                + "Nombre, "
                + "Precio, "
                + "Stock, "
                + "Multiplex_idMultiplex "
                + "FROM comida "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public void insertarComida(Comida c){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into comida(Nombre, "
                + "Precio, "
                + "Stock, "
                + "Multiplex_idMultiplex) "
                + "values(?,?,?,?)");
            pstm.setString(1, c.getNombre());
            pstm.setDouble(2, c.getPrecio());
            pstm.setDouble(3, c.getStock());
            pstm.setInt(4, c.getMultiplex_idMultiplex());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarComida(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from comida where idComida = "+i);
            pstm.executeUpdate();
    }
    public void modifyComida(Comida c) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update comida "
                + "set  Nombre = ? , Precio = ? ,"
                + "Stock = ? , Multiplex_idMultiplex = ? where idComida = ?");
        pstm.setString(1, c.getNombre());
        pstm.setDouble(2, c.getPrecio());
        pstm.setDouble(3, c.getStock());
        pstm.setInt(4, c.getMultiplex_idMultiplex());
        pstm.setInt(5, c.getIdComida());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
