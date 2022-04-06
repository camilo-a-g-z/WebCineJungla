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
    
    //Espacios de la clase
    DBConexion cn;
    
    //Constructor de la clase
    public DBSillaFuncion(){
        cn = new DBConexion();
    }
    //Cierre del constructor
    
    /**
     * Funcion que obtiene datos de una silla mediante el numero de 
     * identificacion proporcionado.
     * 
     * @param id Define el numero de identificacion de la silla de la funcion.
     * @return Datos de la silla.
     * @throws SQLException 
     */
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
    //Cierre de la funcion
  
    /**
     * Funcion que obtiene datos de una silla mediante su estado de ocupacion.
     * 
     * @param estado defiene el estado de ocupacion de la silla (Libre, 
     * reservado, ocupado).
     * @return Datos de la silla.
     * @throws SQLException 
     */
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
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene datos de una silla mediante el numero de 
     * identificacion proporcionado.
     * 
     * @param id Define el numero de identificacion de la silla.
     * @return Datos de la silla.
     * @throws SQLException 
     */
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
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene el datos de una silla mediante el numero de 
     * identificacion de la proyeccion. 
     * 
     * @param id Define el numero de identificacion de la funcion.
     * @return Datos de la silla.
     * @throws SQLException 
     */
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
    public ResultSet getSillaFuncionByidFuncionAndEstado(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT *  " +
            "FROM silla a, sillafuncion b " +
            " where b.Funcion_idFuncion = "+id+" AND b.Silla_idSilla = a.idSilla AND Estado = \"Libre\" ;");
        ResultSet res = pstm.executeQuery();
        return res; 
    }
    //Cierre de la funcion
    
    /**
     * Agrega una silla en la funcion en la base de datos.
     * 
     * @param s 
     */
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
    //Cierre del metodo
    
    /**
     * Elimina una silla en la funcion de la base de datos. 
     * 
     * @param i
     * @throws SQLException 
     */
    public void eliminarSillaFuncion(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "sillafuncion where idSillaFuncion = "+i);
            pstm.executeUpdate();
    }
    //Cierre del metodo
    
    /**
     * Modifica un registro dentro de la base de datos.
     * 
     * @param s
     * @throws SQLException 
     */
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
    //Cierre del metodo
    
    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
