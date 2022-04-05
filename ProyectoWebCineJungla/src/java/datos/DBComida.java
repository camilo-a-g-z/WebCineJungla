package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Comida;

/**
 * Esta clase guarda todo lo referente al area de confiteria de los multiplex.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBComida {
    
    //Espacios de la clase
    DBConexion cn;
    
    //Constructor de la clase
    public DBComida(){
        cn = new DBConexion();
    }
    //Cierre del constructor
    
    /**
     * Funcion que obtiene un producto con un numero de identificacion 
     * proporcionado.
     * 
     * @param id El parametro id define la identificacion que se proporciona.
     * @return El producto que se relaciona con el id.
     * @throws SQLException 
     */
    public ResultSet getComidaById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idComida, "
                + "Nombre, "
                + "Precio, "
                + "Stock, "
                + "Multiplex_idMultiplex, "
                + "UrlImagen "
                + "FROM comida "
                + "WHERE idComida = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene un producto de la confiteria con el nombre 
     * proporcionado.
     * 
     * @param nombre Define el nombre de un producto que se solicita.
     * @return Datos del producto relacionado con el nombre.
     * @throws SQLException 
     */
    public ResultSet getComidaByNombre(String nombre) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idComida, "
                + "Nombre, "
                + "Precio, "
                + "Stock, "
                + "Multiplex_idMultiplex, "
                + "UrlImagen "
                + "FROM comida "
                + "WHERE Nombre = "+"\""+nombre+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene un producto por los productos ofecidos en un 
     * multiplex especifico.
     * 
     * @param id Define el numero de identificacion de un multiplex.
     * @return Los datos del producto.
     * @throws SQLException 
     */
    public ResultSet getComidaByMultiplex(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idComida, "
                + "Nombre, "
                + "Precio, "
                + "Stock, "
                + "Multiplex_idMultiplex, "
                + "UrlImagen "
                + "FROM comida "
                + "WHERE Multiplex_idMultiplex = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Funcion que obtiene datos de un producto.
     * 
     * @return Los datos de un producto.
     * @throws SQLException 
     */
    public ResultSet getComidas() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idComida, "
                + "Nombre, "
                + "Precio, "
                + "Stock, "
                + "Multiplex_idMultiplex, "
                + "UrlImagen "
                + "FROM comida "
                + "ORDER BY Nombre ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion
    
    /**
     * Metodo que agrega un producto a la lista de productos comestibles 
     * ofrecidos por la empresa.
     * 
     * @param c 
     */
    public void insertarComida(Comida c){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into comida(Nombre, "
                + "Precio, "
                + "Stock, "
                + "Multiplex_idMultiplex, "
                + "UrlImagen) "
                + "values(?,?,?,?,?)");
            pstm.setString(1, c.getNombre());
            pstm.setDouble(2, c.getPrecio());
            pstm.setDouble(3, c.getStock());
            pstm.setInt(4, c.getMultiplex_idMultiplex());
            pstm.setString(5, c.getUrlImagen());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    //Cierre del metodo
    
    /**
     * Metodo que elimina un producto de la lista de productos comestibles 
     * ofertados.
     * 
     * @param i
     * @throws SQLException 
     */
    public void eliminarComida(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from comida where idComida = "+i);
            pstm.executeUpdate();
    }
    //Cierre del metodo
    
    /**
     * Metodo que modifica un registro de la base de datos.
     * 
     * @param c
     * @throws SQLException 
     */
    public void modifyComida(Comida c) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update comida "
                + "set  Nombre = ? , Precio = ? ,"
                + "Stock = ? , Multiplex_idMultiplex = ? , "
                + "UrlImagen = ? where idComida = ?");
        pstm.setString(1, c.getNombre());
        pstm.setDouble(2, c.getPrecio());
        pstm.setDouble(3, c.getStock());
        pstm.setInt(4, c.getMultiplex_idMultiplex());
        pstm.setString(5, c.getUrlImagen());
        pstm.setInt(6, c.getIdComida());
        pstm.executeUpdate();
    }
    //Cierre del metodo
    
    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
