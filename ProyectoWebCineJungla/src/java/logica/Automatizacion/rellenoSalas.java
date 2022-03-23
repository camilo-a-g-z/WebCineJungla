package logica.Automatizacion;

import datos.DBFuncion;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import logica.Funcion;

/**
 *
 * @author Miguel
 */
public class rellenoSalas {

    DBFuncion funcionDB = new DBFuncion();
    ArrayList<Funcion> conf = new ArrayList<Funcion>();
    ArrayList<Funcion> funcionDiaActual = new ArrayList<Funcion>();
    Date fechaActual;
    Date fechaFinal;

    public rellenoSalas(int sala, int pelicula) {
        rellenarFuncion(sala, pelicula);
    }

    //Funcion f = new Funcion();
    //f.setIdFuncion(Integer.parseInt(DBf.getString("idFuncion")));
    //f.setHorario(DBf.getDate("Horario"));//DD/MM/AA/HH/MM
    //funciones.add(f);
    public void rellenarFuncion(int sala, int pelicula) {

        try {
            SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
            Calendar calendar = Calendar.getInstance();
            fechaActual = calendar.getTime();
            String formattedDate = dtf.format(fechaActual);
            fechaActual = dtf.parse(formattedDate);

            ResultSet DBf = funcionDB.getFuncionBySala(sala);
            obtenerFuncionPorDia transf = new obtenerFuncionPorDia(DBf);
            conf = transf.getArrayListFunciones();
            Iterator<Funcion> iterador = funcionDiaActual.iterator();

            Calendar c = Calendar.getInstance();
            c.setTime(fechaActual);
            c.add(Calendar.MONTH, 1);
            fechaFinal = c.getTime();

            boolean coincidePelicula = false;

            //Mientras el mes actual sea menor al siguiente mes
            while (fechaActual.getMonth() < fechaFinal.getMonth()) {
                for (int i = 0; i < conf.size(); i++) {
                    if (conf.get(i).getHorario().equals(fechaActual)) {
                        funcionDiaActual.add(conf.get(i));
                    }
                }
                if (funcionDiaActual.isEmpty()) {
                    //Rellenar con una funcion
                } else {
                    for (int i = 0; i < funcionDiaActual.size() && !coincidePelicula; i++) {
                        if (funcionDiaActual.get(i).getPelicula_idPelicula() == pelicula) {
                            coincidePelicula = true;
                        }
                    }
                    if (coincidePelicula == false) {
                        //Rellenar con una funcion
                    }
                }

                funcionDiaActual.clear();
                //Se aumentara en un dia por cada bucle del while
                c.setTime(fechaActual);
                c.add(Calendar.DATE, 1);
                fechaActual = c.getTime();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
