package logica.Automatizacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import logica.Funcion;

/**
 * Clase que se encarga de separar las funciones segun su horario, si es antes o
 * despues de una fecha introducida
 *
 * *@author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class obtenerFuncionPorDia {

    //Campos de la clase
    //Declaracion de variables
    private ArrayList<Funcion> con = new ArrayList<Funcion>();
    private ResultSet res;
    Date fechaActual;

    /**
     * Metodo constructor de la clase, llama al metodo obtenerPorDia
     *
     * @param res
     * @throws SQLException
     */
    public obtenerFuncionPorDia(ResultSet res) throws SQLException {
        this.res = res;
        obtenerPorDia(res);
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de separar las funciones segun si su horario es
     * antes o despues del introducido
     *
     * @param res
     * @throws SQLException
     */
    private void obtenerPorDia(ResultSet res) throws SQLException {
        try {
            SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
            Calendar calendar = Calendar.getInstance();

            fechaActual = calendar.getTime();
            String formattedDate = dtf.format(fechaActual);
            fechaActual = dtf.parse(formattedDate);
            int ma = fechaActual.getMonth() + 1;
            fechaActual.setMonth(ma);

            System.out.println("FechaActual/" + fechaActual.getMonth() + "/" + fechaActual.getDate());
            while (res.next()) {
                Date dat = new Date();
                dat.setYear(res.getInt("Año"));
                dat.setMonth(res.getInt("Mes"));
                dat.setDate(res.getInt("Dia"));
                dat.setHours(res.getInt("Hora"));
                dat.setMinutes(res.getInt("Minuto"));
                if (dat.getMonth() < fechaActual.getMonth()) {
                } else {
                    Funcion f = new Funcion();
                    f.setEmpleado_idEmpleado(res.getInt("idFuncion"));
                    Date da = new Date();
                    da.setYear(res.getInt("Año"));
                    da.setMonth(res.getInt("Mes"));
                    da.setDate(res.getInt("Dia"));
                    da.setHours(res.getInt("Hora"));
                    da.setMinutes(res.getInt("Minuto"));
                    f.setAño(res.getInt("Año"));
                    f.setMes(res.getInt("Mes"));
                    f.setDia(res.getInt("Dia"));
                    f.setMinuto(res.getInt("Minuto"));
                    f.setHora(res.getInt("Hora"));
                    f.setHorario(da);
                    f.setSala_idSala(res.getInt("Sala_idSala"));
                    f.setEmpleado_idEmpleado(res.getInt("Empleado_idEmpleado"));
                    f.setPelicula_idPelicula(res.getInt("Pelicula_idPelicula"));
                    con.add(f);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Cierre del metodo

    //Metodo getter del arrayList de le funciones
    public ArrayList getArrayListFunciones() {
        return con;
    }
    //Cierre del metodo

}
