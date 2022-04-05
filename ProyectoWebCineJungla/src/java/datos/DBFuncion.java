package datos;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Funcion;

/**
 * Esta clase guarda todo lo referente a las funciones ofrecidas por los
 * multiplex de la empresa.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class DBFuncion {

    //Espacios de la clase
    DBConexion cn;

    //Constructor de la clase
    public DBFuncion() {
        cn = new DBConexion();
    }
    //Cierre del constructor

    /**
     * Funcion que obtiene los datos de una proyeccion con nel numero de
     * identificacion proporcionado.
     *
     * @param id Defiene el numero de identifiacion asignado a la pelicula.
     * @return Los datos de la funcion.
     * @throws SQLException
     */
    public ResultSet getFuncionById(int id) throws SQLException {
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
                + "WHERE idFuncion = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la Funcion

    /**
     * Funcion que obtiene datos de una proyeccion con el numero de
     * identificacion del empleado asignado a esa funcion.
     *
     * @param id Define el numero de identificacion del empleado.
     * @return Los datos de la funcion.
     * @throws SQLException
     */
    public ResultSet getFuncionByEmpleado(int id) throws SQLException {
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
                + "WHERE Empleado_idEmpleado = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene los datos de una proyeccion a travez de los datos de
     * la pelicula.
     *
     * @param id Define el numero de identificacion de una pelicula.
     * @return Los datos de la funcion.
     * @throws SQLException
     */
    public ResultSet getFuncionByPelicula(int id) throws SQLException {
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
                + "WHERE Pelicula_idPelicula = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene los datos de una funcion a travez de los datos de la
     * sala donde sera proyectada.
     *
     * @param id define el numero de identificacion de una sala de un multiplex.
     * @return Los datos de la funcion.
     * @throws SQLException
     */
    public ResultSet getFuncionBySala(int id) throws SQLException {
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
                + "WHERE Sala_idSala = " + id);
        ResultSet res = pstm.executeQuery();
        return res;
    }
    //Cierre de la funcion

    /**
     * Funcion que obtiene datos de una proyeccion de acuerdo a la fecha.
     *
     * @param f define una fecha de proyeccion de una pelicula.
     * @return Los datos de la funcion.
     * @throws SQLException
     */
    public ResultSet getFuncionByHorario(Date f) throws SQLException {
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
    //Cierre de la funcion

    /**
     * Obtiene los datos de las proyecciones.
     *
     * @return Los datos de las proyecciones.
     * @throws SQLException
     */
    public ResultSet getFunciones() throws SQLException {
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
    //Cierre de la funcion

    /**
     * Funcion que obtiene los datos de una proyeccion con respecto a una fecha
     * solicitada.
     *
     * @param Anio Define el año en se se solicita la funcion.
     * @param Mes Define el mes en que se solicita la funcion.
     * @param Dia Define el dia en que se solicita la funcion.
     * @return Los datos de la funcion.
     */
    public ResultSet getFuncionByFechaPosterior(int Anio, int Mes, int Dia) {
        try {
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
                    + "WHERE Mes >=" + Mes + " AND  Dia >=" + Dia);
            ResultSet res = pstm.executeQuery();
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    //Cierre de la funcion

    /**
     * Metodo que agrega una proyeccion a la base de datos.
     *
     * @param f
     */
    public void insertarFuncion(Funcion f) {
        try {
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
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //Cierre del metodo

    /**
     * Metodo que elimina una proyeccion de la base de datos.
     *
     * @param i
     * @throws SQLException
     */
    public void eliminarFuncion(int i) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("delete from funcion where idFuncion = " + i);
        pstm.executeUpdate();
    }
    //Cierre del metodo

    /**
     * Metodo que modifica un registro de la base de datos.
     *
     * @param f
     * @throws SQLException
     */
    public void modifyFuncion(Funcion f) throws SQLException {
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
    //Cierre del metodo

    //Metodo Get
    public String getMensaje() {
        return cn.getMensaje();
    }
    //Cierre del metodo Get
}
