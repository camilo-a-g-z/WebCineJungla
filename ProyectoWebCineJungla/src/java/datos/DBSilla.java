package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Silla;

/**
 * Esta clase guarda la informacion de lo referente a las sillas de cada sala.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBSilla {
    
    //Espacios de la clase
    DBConexion cn;
    
    //Constructor de la clase
    public DBSilla(){
        cn = new DBConexion();
    }
    //Cierre del constructor
    
    /**
     * Funcion que obtiene los datos de una silla mediante su numero de 
     * identificacion.
     * 
     * @param id Define el numero de identificacion de la silla.
     * @return Datos de la silla.
     * @throws SQLException 
     */
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
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene datos de la silla de acuerdo al tipo de silla.
     * 
     * @param tipo Define el tipo de silla (normal, preferencial).
     * @return Datos de la silla.
     * @throws SQLException 
     */
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
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene datos de la silla por el numero de identificacion de
     * la sala.
     * 
     * @param id Define el numero de identificacion de la sala.
     * @return Datos de la silla.
     * @throws SQLException 
     */
    public ResultSet getSillaByidSala(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSilla, "
                + "Tipo, "
                + "Ubicacion, "
                + "Sala_idSala "
                + "FROM silla "
                + "WHERE Sala_idSala = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene datos de la silla por la posicion de la silla.
     * 
     * @param ubicacion Define la ubicacion de la silla dentro de la sala.
     * @return Datos de la silla.
     * @throws SQLException 
     */
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
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene los datos de las sillas.
     * 
     * @return Los datos de las sillas.
     * @throws SQLException 
     */
    public ResultSet getSillas() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idSilla, "
                + "Tipo, "
                + "Ubicacion, "
                + "Sala_idSala "
                + "FROM silla ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Metodo que agrega una silla a la base de datos.
     * 
     * @param s 
     */
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
    //Cierre del metodo
    
    /**
     * Metodo que elimina una silla de la base de datos.
     * 
     * @param i
     * @throws SQLException 
     */
    public void eliminarSilla(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "silla where idSilla = "+i);
            pstm.executeUpdate();
    }
    //Cierre del metodo
    
    /**
     * Modifica un registro de la base de datos.
     * 
     * @param s
     * @throws SQLException 
     */
    public void modifySilla(Silla s) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update silla "
                + "set  Tipo = ? , Ubicacion = ? ,"
                + "Sala_idSala = ?  where idSilla = ?");
        pstm.setString(1, s.getTipo());
        pstm.setString(2, s.getUbicacion());
        pstm.setInt(3, s.getSala_idSala());
        pstm.setInt(4, s.getIdSilla());
        pstm.executeUpdate();
    }
    //Cierre del metodo
    
    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
