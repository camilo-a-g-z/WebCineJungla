package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.FacturaCliente;

/**
 *
 * @author Camilo Garcia
 */
public class DBFacturaCliente {
    DBConexion cn;
    //constructor
    public DBFacturaCliente(){
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
    public ResultSet getFacturaClienteById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFacturaCliente, "
                + "Total, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Cliente_idCliente "
                + "FROM facturacliente "
                + "WHERE idFacturaCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFacturaClienteByCliente(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFacturaCliente, "
                + "Total, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Cliente_idCliente "
                + "FROM facturacliente "
                + "WHERE Cliente_idCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarFacturaCliente(FacturaCliente f){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into facturacliente(Total, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Cliente_idCliente) "
                + "values(?,?,?,?,?)");
            pstm.setDouble(1, f.getTotal());
            pstm.setInt(2, f.getAño());
            pstm.setInt(3, f.getMes());
            pstm.setInt(4, f.getDia());
            pstm.setInt(5, f.getCliente_idCliente());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarFacturaCliente(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "facturacliente where idFacturaCliente = "+i);
            pstm.executeUpdate();
    }
    public void modifyCliente(FacturaCliente f) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update facturacliente "
                + "set  Total = ? , Año = ? , Mes = ? , Dia = ? ,"
                + "Cliente_idCliente = ? where idFacturaCliente = ?");
        pstm.setDouble(1, f.getTotal());
        pstm.setInt(2, f.getAño());
        pstm.setInt(3, f.getMes());
        pstm.setInt(4, f.getDia());
        pstm.setInt(5, f.getCliente_idCliente());
        pstm.setInt(6, f.getIdFacturaCliente());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
