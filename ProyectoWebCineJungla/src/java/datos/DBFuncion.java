package datos;

import java.util.Date;
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
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Minuto, "
                + "Hora, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula, "
                + "Duracion "
                + "FROM funcion "
                + "WHERE idFuncion = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFuncionByEmpleado(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Minuto, "
                + "Hora, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula, "
                + "Duracion "
                + "FROM funcion "
                + "WHERE Empleado_idEmpleado = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFuncionByPelicula(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Minuto, "
                + "Hora, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula, "
                + "Duracion "
                + "FROM funcion "
                + "WHERE Pelicula_idPelicula = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFuncionBySala(int id) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Minuto, "
                + "Hora, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula, "
                + "Duracion "
                + "FROM funcion "
                + "WHERE Sala_idSala = "+id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFuncionByHorario(Date f) throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Horario, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula, "
                + "Duracion "
                + "FROM funcion "
                + "WHERE Horario = ?");
        pstm.setDate(1, (java.sql.Date) f);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getFunciones() throws SQLException{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Minuto, "
                + "Hora, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula, "
                + "Duracion "
                + "FROM funcion "
                + "ORDER BY Horario ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getFuncionByFechaPosterior(Date f) {
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT idFuncion, "
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Minuto, "
                + "Hora, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula, "
                + "Duracion "
                + "FROM funcion "
                + "WHERE Horario >= '"+f.getYear()
                +"-"+f.getMonth()+"-"+f.getDay()
                +" "+f.getHours()+":"+f.getMinutes()+":00'");
            ResultSet res = pstm.executeQuery();
            return res;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void insertarFuncion(Funcion f){
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into funcion("
                + "Año, "
                + "Mes, "
                + "Dia, "
                + "Minuto, "
                + "Hora, "
                + "Sala_idSala, "
                + "Empleado_idEmpleado, "
                + "Pelicula_idPelicula, "
                + "Duracion) "
                + "values(?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, f.getAño());
            pstm.setInt(2, f.getMes());
            pstm.setInt(3, f.getDia());
            pstm.setInt(4, f.getMinuto());
            pstm.setInt(5, f.getHora());
            pstm.setInt(6, f.getSala_idSala());
            pstm.setInt(7, f.getEmpleado_idEmpleado());
            pstm.setInt(8, f.getPelicula_idPelicula());
            pstm.setInt(9, f.getDuracion());

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
                + "set  Año = ? , Mes = ? , "
                + "Dia = ? , Minuto = ? , "
                + "Hora = ? , Sala_idSala = ? ,"
                + "Empleado_idEmpleado = ? , Pelicula_idPelicula = ? "
                + "Duracion = ? where idFuncion = ?");
        pstm.setInt(1, f.getAño());
        pstm.setInt(2, f.getMes());
        pstm.setInt(3, f.getDia());
        pstm.setInt(4, f.getMinuto());
        pstm.setInt(5, f.getHora());
        pstm.setInt(6, f.getSala_idSala());
        pstm.setInt(7, f.getEmpleado_idEmpleado());
        pstm.setInt(8, f.getPelicula_idPelicula());
        pstm.setInt(9, f.getDuracion());
        pstm.setInt(10, f.getIdFuncion());
        pstm.executeUpdate();
    }
    public String getMensaje() {
        return cn.getMensaje();
    }
}
