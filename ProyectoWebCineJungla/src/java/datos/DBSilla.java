package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Silla;

/**
 *
 * @author Camilo Garcia
 */
public class DBSilla {
    DBConexion cn;
    //constructor
    public DBSilla(){
        cn = new DBConexion();
    }
    public ResultSet getSillaById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSilla, "
                + "Tipo, "
                + "Ubicacion, "
                + "Sala_idSala "
                + "FROM silla "
                + "WHERE idSilla = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getSillaByTipo(String tipo) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSilla, "
                + "Tipo, "
                + "Ubicacion, "
                + "Sala_idSala "
                + "FROM silla "
                + "WHERE Tipo = "+"\""+tipo+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getSillaByUbicacion(String ubicacion) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSilla, "
                + "Tipo, "
                + "Ubicacion, "
                + "Sala_idSala "
                + "FROM silla "
                + "WHERE Ubicacion = "+"\""+ubicacion+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarSilla(Silla s){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into silla(Tipo, "
                + "Ubicacion, "
                + "Sala_idSala) "
                + "values(?,?,?)");
            pstm.setString(1, s.getTipo());
            pstm.setString(2, s.getUbicacion());
            pstm.setInt(3, s.getSala_idSala());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarSilla(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "silla where idSilla = "+i);
            pstm.executeUpdate();
    }
    public void modifySilla(Silla s) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update silla "
                + "set  Tipo = ? , Ubicacion = ? ,"
                + "Sala_idSala = ? where idSilla = ?");
        pstm.setString(1, s.getTipo());
        pstm.setString(2, s.getUbicacion());
        pstm.setInt(3, s.getSala_idSala());
        pstm.setInt(4, s.getIdSilla());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
