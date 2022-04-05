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
 * @author Camilo Garcia
 */
public class TransformFuncion {

    private ArrayList<Funcion> con = new ArrayList<Funcion>();
    private ResultSet res;

    public TransformFuncion(ResultSet res) throws SQLException {
        this.res = res;
        transformar();
    }

    private void transformar() throws SQLException {
        System.out.println("Aqui bien");
        while (res.next()) {
            Funcion f = new Funcion();
            f.setEmpleado_idEmpleado(res.getInt("idFuncion"));
            f.setAño(res.getInt("Año"));
            f.setMes(res.getInt("Mes"));
            f.setDia(res.getInt("Dia"));
            f.setHora(res.getInt("Hora"));
            f.setMinuto(res.getInt("Minuto"));
            f.setHorario(   generarDate(
                    res.getInt("Año"),
                    res.getInt("Mes"),
                    res.getInt("Dia"),
                    res.getInt("Hora"),
                    res.getInt("Minuto"))   );
            f.setHorarioC(  generarCalendar(
                    res.getInt("Año"),
                    res.getInt("Mes"),
                    res.getInt("Dia"),
                    res.getInt("Hora"),
                    res.getInt("Minuto")));
            f.setSala_idSala(res.getInt("Sala_idSala"));
            f.setEmpleado_idEmpleado(res.getInt("Empleado_idEmpleado"));
            f.setPelicula_idPelicula(res.getInt("Pelicula_idPelicula"));
            f.setDuracion(res.getInt("Duracion"));
            con.add(f);
        }
    }
    private Date generarDate(int Año, int Mes, int Dia, int Hora, int Minuto){
        Date d = new Date();
        d.setYear(Año);
        d.setMonth(Mes);
        d.setDate(Dia);
        d.setHours(Hora);
        d.setMinutes(Minuto);
        return d;
    }
    private Calendar generarCalendar(int Año, int Mes, int Dia, int Hora, int Minuto){
        Calendar c = Calendar.getInstance();
        c.set(Dia, Minuto, Dia, Hora, Minuto);
        return c;
    }
    public ArrayList getArrayListFunciones() {
        return con;
    }

}
