package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.FacturaRapida;

/**
 *
 * @author Camilo Garcia
 */
public class DBFacturaRapida {
    DBConexion cn;
    //constructor
    public DBFacturaRapida(){
        cn = new DBConexion();
    }
    public ResultSet getFacturaRapidaById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFacturaRapida, "
                + "Total, "
                + "Fecha, "
                + "Empleado_idEmpleado "
                + "FROM facturarapida "
                + "WHERE idFacturaRapida = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFacturaRapidaByEmpleado(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFacturaRapida, "
                + "Total, "
                + "Fecha, "
                + "Empleado_idEmpleado "
                + "FROM facturarapida "
                + "WHERE Empleado_idEmpleado = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarFacturaRapida(FacturaRapida f){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into facturarapida(Total, "
                + "Fecha, "
                + "Empleado_idEmpleado) "
                + "values(?,?,?)");
            pstm.setDouble(1, f.getTotal());
            pstm.setDate(2, f.getFecha());
            pstm.setInt(3, f.getEmpleado_idEmpleado());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarFacturaRapida(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from "
                + "facturarapida where idFacturaRapida = "+i);
            pstm.executeUpdate();
    }
    public void modifyCliente(FacturaRapida f) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update facturarapida "
                + "set  Total = ? , Fecha = ? ,"
                + "Empleado_idEmpleado = ? where idFacturaRapida = ?");
        pstm.setDouble(1, f.getTotal());
        pstm.setDate(2, f.getFecha());
        pstm.setInt(3, f.getEmpleado_idEmpleado());
        pstm.setInt(4, f.getIdFacturaRapida());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
