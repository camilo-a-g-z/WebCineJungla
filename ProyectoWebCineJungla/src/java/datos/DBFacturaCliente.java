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
    public ResultSet getFacturaClienteById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFacturaCliente, "
                + "Total, "
                + "Fecha, "
                + "Cliente_idCliente "
                + "FROM facturacliente "
                + "WHERE idFacturaCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFacturaClienteByCliente(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFacturaCliente, "
                + "Total, "
                + "Fecha, "
                + "Cliente_idCliente "
                + "FROM facturacliente "
                + "WHERE Cliente_idCliente = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarFacturaCliente(FacturaCliente f){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into facturacliente(Total, "
                + "Fecha, "
                + "Cliente_idCliente) "
                + "values(?,?,?)");
            pstm.setDouble(1, f.getTotal());
            pstm.setDate(2, f.getFecha());
            pstm.setInt(3, f.getCliente_idCliente());

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
                + "set  Total = ? , Fecha = ? ,"
                + "Cliente_idCliente = ? where idFacturaCliente = ?");
        pstm.setDouble(1, f.getTotal());
        pstm.setDate(2, f.getFecha());
        pstm.setInt(3, f.getCliente_idCliente());
        pstm.setInt(4, f.getIdFacturaCliente());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
