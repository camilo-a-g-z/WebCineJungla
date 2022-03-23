/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Automatizacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import logica.Funcion;

/**
 *
 * @author Miguel
 */
public class obtenerFuncionPorDia {

    private ArrayList<Funcion> con = new ArrayList<Funcion>();
    private ResultSet res;
    Date fechaActual;

    public obtenerFuncionPorDia(ResultSet res) throws SQLException {
        this.res = res;
        obtenerPorDia(res);
    }

    private void obtenerPorDia(ResultSet res) throws SQLException {
        try {
            SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
            Calendar calendar = Calendar.getInstance();

            fechaActual = calendar.getTime();
            String formattedDate = dtf.format(fechaActual);
            fechaActual = dtf.parse(formattedDate);

            while (res.next()) {
                if (res.getDate("Horario").before(fechaActual)) {

                } else {
                    Funcion f = new Funcion();
                    f.setEmpleado_idEmpleado(res.getInt("idFuncion"));
                    f.setHorario(res.getDate("Horario"));
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

    public ArrayList getArrayListFunciones() {
        return con;
    }

}
