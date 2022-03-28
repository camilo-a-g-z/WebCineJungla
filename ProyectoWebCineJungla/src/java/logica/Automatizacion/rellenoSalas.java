package logica.Automatizacion;

import datos.DBFuncion;
import datos.DBPelicula;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import logica.Funcion;

/**
 *
 * @author Miguel
 */
public class rellenoSalas {

    DBFuncion funcionDB = new DBFuncion();
    DBPelicula pel = new DBPelicula();
    ArrayList<Funcion> conf = new ArrayList<Funcion>();
    ArrayList<Funcion> funcionDiaActual = new ArrayList<Funcion>();
    Date fechaActual;
    Date fechaFinal;
    Date fechaDinamica;
    int auxHr;
    int auxMin;
    int auxDurPel;

    public rellenoSalas(int sala, int pelicula, int anio, int mes, int dia, int hora, int min) {
        rellenarFuncion(sala, pelicula);
        fechaActual.setYear(anio);
        fechaActual.setMonth(mes);

        fechaActual.setDate(dia);
        fechaFinal = fechaActual;
        fechaFinal.setMonth(fechaFinal.getMonth() + 1);
    }

    public void rellenarFuncion(int sala, int pelicula) {

        try {
            SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ResultSet DBp = pel.getPeliculaById(pelicula);
            ResultSet DBf = funcionDB.getFuncionBySala(sala);
            obtenerFuncionPorDia transf = new obtenerFuncionPorDia(DBf);
            conf = transf.getArrayListFunciones();

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
                    for (int j = 0; j < funcionDiaActual.size() && !coincidePelicula; j++) {
                        if (funcionDiaActual.get(j).getPelicula_idPelicula() == pelicula) {
                            coincidePelicula = true;
                        }
                    }
                    if (coincidePelicula == false) {
                        Collections.sort(funcionDiaActual, new ordenarFuncionPorHorario());

                        for (int i = 0; i < funcionDiaActual.size() - 1; i++) {

                            //Al horario de la funcion se le suma la duracion de la pelicula
                            auxMin = funcionDiaActual.get(i).getDuracion() % 60;
                            auxHr = (int) (funcionDiaActual.get(i).getDuracion() / 60);
                            fechaDinamica = funcionDiaActual.get(i).getHorario();
                            fechaDinamica.setMinutes(fechaDinamica.getMinutes() + auxMin);
                            fechaDinamica.setHours(fechaDinamica.getHours() + auxHr);
                            //Al horario y la duracion se le suma ademas la duracion de
                            //la pelicula que queremos agregar

                        }
                    }
                }

                funcionDiaActual.clear();
                //Se aumentara en un dia por cada bucle del while
                fechaActual.setDate(fechaActual.getDate() + 1);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
