package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Sala;

/**
 *
 * @author Camilo Garcia
 */
public class DBSala {
    DBConexion cn;
    //constructor
    public DBSala(){
        cn = new DBConexion();
    }
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
    public ResultSet getSalaById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSala, "
                + "Numero, "
                + "Multiplex_idMultiplex "
                + "FROM sala "
                + "WHERE idSala = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getSalaByNumero(int numero) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSala, "
                + "Numero, "
                + "Multiplex_idMultiplex "
                + "FROM sala "
                + "WHERE Numero = "+numero);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getSalaByidMultiplex(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSala, "
                + "Numero, "
                + "Multiplex_idMultiplex "
                + "FROM sala "
                + "WHERE Multiplex_idMultiplex = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getSalas() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSala, "
                + "Numero, "
                + "Multiplex_idMultiplex "
                + "FROM sala "
                + "ORDER BY Numero ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarSala(Sala s){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into sala(Numero ,"
                + " Multiplex_idMultiplex) "
                + "values(?,?)");
            pstm.setString(1, s.getNumero());
            pstm.setInt(2, s.getMultiplex_idMultiplex());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarSala(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "sala where idSala = "+i);
            pstm.executeUpdate();
    }
    public void modifySala(Sala s) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update sala "
                + "set  Numero = ? , Multiplex_idMultiplex = ? where idSala = ?");
        pstm.setString(1, s.getNumero());
        pstm.setInt(2, s.getMultiplex_idMultiplex());
        pstm.setInt(3, s.getIdSala());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
