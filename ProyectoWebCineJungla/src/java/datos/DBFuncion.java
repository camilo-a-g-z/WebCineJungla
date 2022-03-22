package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Funcion;

/**
 *
 * @author Camilo Garcia
 */
public class DBFuncion {
    DBConexion cn;
    //constructor
    public DBFuncion(){
        cn = new DBConexion();
    }
    public ResultSet getFuncionById(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Horario, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula "
                + "FROM funcion "
                + "WHERE idFuncion = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFuncionByEmpleado(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Horario, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula "
                + "FROM funcion "
                + "WHERE Empleado_idEmpleado = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFuncionByPelicula(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Horario, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula "
                + "FROM funcion "
                + "WHERE Pelicula_idPelicula = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFuncionBySala(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Horario, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula "
                + "FROM funcion "
                + "WHERE Sala_idSala = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFuncionByHorario(String horario) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Horario, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula "
                + "FROM funcion "
                + "WHERE Horario = "+"\""+horario+"\"");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFunciones() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Horario, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula "
                + "FROM funcion "
                + "ORDER BY Horario ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public void insertarFuncion(Funcion f){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into funcion(Horario, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula) "
                + "values(?,?,?,?)");
            pstm.setDate(1, f.getHorario());
            pstm.setInt(2, f.getSala_idSala());
            pstm.setInt(3, f.getEmpleado_idEmpleado());
            pstm.setInt(4, f.getPelicula_idPelicula());

            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void eliminarFuncion(int i) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from funcion where idFuncion = "+i);
            pstm.executeUpdate();
    }
    public void modifyFuncion(Funcion f) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update funcion "
                + "set  Horario = ? , Sala_idSala = ? ,"
                + "Empleado_idEmpleado = ? , Pelicula_idPelicula = ? where idFuncion = ?");
        pstm.setDate(1, f.getHorario());
        pstm.setInt(2, f.getSala_idSala());
        pstm.setInt(3, f.getEmpleado_idEmpleado());
        pstm.setInt(4, f.getPelicula_idPelicula());
        pstm.setInt(5, f.getIdFuncion());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
