package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.SillaFuncion;

/**
 * Esta clase guarda todo lo referente a la informacion de las salas de las 
 * funciones.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBSillaFuncion {
    DBConexion cn;
    //constructor
    public DBSillaFuncion(){
        cn = new DBConexion();
    }
    public ResultSet getSillaFuncionById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSillaFuncion, "
                + "Estado, "
                + "Silla_idSilla, "
                + "Funcion_idFuncion "
                + "FROM sillafuncion "
                + "WHERE idSillaFuncion = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getSillaFuncionByEstado(String estado) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSillaFuncion, "
                + "Estado, "
                + "Silla_idSilla, "
                + "Funcion_idFuncion "
                + "FROM sillafuncion "
                + "WHERE Estado = "+"\""+estado+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getSillaFuncionByidSilla(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSillaFuncion, "
                + "Estado, "
                + "Silla_idSilla, "
                + "Funcion_idFuncion "
                + "FROM sillafuncion "
                + "WHERE Silla_idSilla = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getSillaFuncionByidFuncion(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSillaFuncion, "
                + "Estado, "
                + "Silla_idSilla, "
                + "Funcion_idFuncion "
                + "FROM sillafuncion "
                + "WHERE Funcion_idFuncion = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarSillaFuncion(SillaFuncion s){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into sillafuncion(Estado, "
                + "Silla_idSilla, "
                + "Funcion_idFuncion) "
                + "values(?,?,?)");
            pstm.setString(1, s.getEstado());
            pstm.setInt(2, s.getSilla_idSilla());
            pstm.setInt(3, s.getFuncion_idFuncion());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarSillaFuncion(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "sillafuncion where idSillaFuncion = "+i);
            pstm.executeUpdate();
    }
    public void modifySillaFuncion(SillaFuncion s) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update sillafuncion "
                + "set  Estado = ? , Silla_idSilla = ? ,"
                + "Funcion_idFuncion = ? where idSillaFuncion = ?");
        pstm.setString(1, s.getEstado());
        pstm.setInt(2, s.getSilla_idSilla());
        pstm.setInt(3, s.getFuncion_idFuncion());
        pstm.setInt(4, s.getIdSillaFuncion());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
