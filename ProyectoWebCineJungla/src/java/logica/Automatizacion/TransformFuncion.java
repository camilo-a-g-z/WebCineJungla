package logica.Automatizacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import logica.Funcion;

/**
 * Clase para convertir las funciones traidas de la consulta SQL en ArrayList
 *
 ** @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class TransformFuncion {

    //Campos de la clase
    //Declaracion de variables
    private ArrayList<Funcion> con = new ArrayList<Funcion>();
    private ResultSet res;

    /**
     * Metodo constructor de la clase, llama al metodo transformar
     *
     * @param res
     * @throws SQLException
     */
    public TransformFuncion(ResultSet res) throws SQLException {
        this.res = res;
        transformar();
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de obtener las funciones de la BD y pasarlas a un
     * arraylist
     *
     * @throws SQLException
     */
    private void transformar() throws SQLException {
        System.out.println("Aqui bien");
        while (res.next()) {
            Funcion f = new Funcion();
            f.setIdFuncion(res.getInt("idFuncion"));
            f.setEmpleado_idEmpleado(res.getInt("Empleado_idEmpleado"));
            f.setAño(res.getInt("Año"));
            f.setMes(res.getInt("Mes"));
            f.setDia(res.getInt("Dia"));
            f.setHora(res.getInt("Hora"));
            f.setMinuto(res.getInt("Minuto"));
            f.setHorario(generarDate(
                    res.getInt("Año"),
                    res.getInt("Mes"),
                    res.getInt("Dia"),
                    res.getInt("Hora"),
                    res.getInt("Minuto")));
            f.setHorarioC(generarCalendar(
                    res.getInt("Año"),
                    res.getInt("Mes"),
                    res.getInt("Dia"),
                    res.getInt("Hora"),
                    res.getInt("Minuto")));
            f.setSala_idSala(res.getInt("Sala_idSala"));
            f.setPelicula_idPelicula(res.getInt("Pelicula_idPelicula"));
            f.setDuracion(res.getInt("Duracion"));
            con.add(f);
        }
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de generar una fecha segun los parametros que le
     * llegan, retorna un Date
     *
     * @param Año
     * @param Mes
     * @param Dia
     * @param Hora
     * @param Minuto
     * @return Date
     */
    private Date generarDate(int Año, int Mes, int Dia, int Hora, int Minuto) {
        Date d = new Date();
        d.setYear(Año);
        d.setMonth(Mes);
        d.setDate(Dia);
        d.setHours(Hora);
        d.setMinutes(Minuto);
        return d;
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de generar una fecha segun los parametros que le
     * llegan, retorna un Caledar
     *
     * @param Año
     * @param Mes
     * @param Dia
     * @param Hora
     * @param Minuto
     * @return Calendar
     */
    private Calendar generarCalendar(int Año, int Mes, int Dia, int Hora, int Minuto) {
        Calendar c = Calendar.getInstance();
        c.set(Dia, Minuto, Dia, Hora, Minuto);
        return c;
    }
//Cierre del metodo

    //Metodo getter del arrayList de funciones
    public ArrayList getArrayListFunciones() {
        return con;
    }
    //Cierre del metodo

}
