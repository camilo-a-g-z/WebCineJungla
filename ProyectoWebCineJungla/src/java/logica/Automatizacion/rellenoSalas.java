package logica.Automatizacion;

import datos.DBFuncion;
import datos.DBPelicula;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import logica.Funcion;
import logica.Pelicula;

/**
 *
 * @author Miguel
 */
public class rellenoSalas {

    DBFuncion funcionDB = new DBFuncion();
    DBPelicula pel = new DBPelicula();
    ArrayList<Funcion> conf = new ArrayList<Funcion>();
    ArrayList<Funcion> funcionDiaActual = new ArrayList<Funcion>();
    Pelicula objPel;
    Calendar fechaActual = Calendar.getInstance();
    Date fechaFinal;
    Date fechaDinamica;
    Date horaInicial;

    int auxHr;
    int auxMin;
    int auxDurPel;

    public rellenoSalas(int sala, int pelicula, int anio, int mes, int dia, int hora, int min) {
        System.out.println("ENTRO A RELLENO SALAS");
       
        fechaActual = generarCalendar(anio, mes, dia, hora, min);
        System.out.println(fechaActual.get(Calendar.YEAR));
        System.out.println(fechaActual.get(Calendar.MONTH));
        System.out.println(fechaActual.get(Calendar.DATE));
        System.out.println(fechaActual.get(Calendar.HOUR));
        System.out.println(fechaActual.get(Calendar.MINUTE));

        //fechaActual.setYear(anio);
        //fechaActual.setMonth(mes);
        //fechaActual.setDate(dia);
        // horaInicial = fechaActual.getTime();
        // horaInicial.setHours(12);
        // fechaFinal = fechaActual.getTime();
        // fechaFinal.setMonth(fechaFinal.getMonth() + 1);
        //rellenarFuncion(sala, pelicula);
    }

    public Calendar generarCalendar(int Anio, int Mes, int Dia, int Hora, int Minuto) {
        Calendar c = Calendar.getInstance();
        
        c.set(Calendar.YEAR, Anio);
        c.set(Calendar.MONTH, Mes);
        c.set(Calendar.DATE, Dia);
        c.set(Calendar.HOUR, Hora);
        c.set(Calendar.MINUTE, Minuto);

        return c;
    }

    public void rellenarFuncion(int sala, int pelicula) {
        /*
        try {

            ResultSet DBf = funcionDB.getFuncionBySala(sala);
            obtenerFuncionPorDia transf = new obtenerFuncionPorDia(DBf);
            // conf = transf.getArrayListFunciones();  SE COMENTA ESTA LINEA POR PRUEBA

            ResultSet DBp = pel.getPeliculaById(pelicula);
            TransformPelicula pelTrans = new TransformPelicula(DBp);
            objPel = pelTrans.getPeli();
            auxDurPel = objPel.getDuracion();

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
                    System.out.println("AQUI LINEA 69 SE AGREGA UNA FUNCION");
                } else {
                    for (int j = 0; j < funcionDiaActual.size() && !coincidePelicula; j++) {
                        if (funcionDiaActual.get(j).getPelicula_idPelicula() == pelicula) {
                            coincidePelicula = true;
                        }
                    }
                    if (coincidePelicula == false) {
                        Collections.sort(funcionDiaActual, new ordenarFuncionPorHorario());

                        //Si hay hueco antes de la primera funcion
                        if (funcionDiaActual.get(0).getHorario().after(horaInicial)) {
                            auxMin = auxDurPel % 60;
                            auxHr = (int) auxDurPel / 60;
                            Date fechaAux;
                            fechaAux = horaInicial;
                            fechaAux.setMinutes(fechaAux.getMinutes() + auxMin);
                            fechaAux.setHours(fechaAux.getHours() + auxHr);
                            if (fechaAux == (funcionDiaActual.get(0).getHorario()) || (fechaAux.before(funcionDiaActual.get(0).getHorario()))) {
                                //Insertar Funcion
                            }

                        } else {

                            //Verificar huecos entre funciones
                            for (int i = 0; i < funcionDiaActual.size() - 1; i++) {

                                //Al horario de la funcion se le suma la duracion de la pelicula
                                auxMin = funcionDiaActual.get(i).getDuracion() % 60;
                                auxHr = (int) (funcionDiaActual.get(i).getDuracion() / 60);
                                fechaDinamica = funcionDiaActual.get(i).getHorario();
                                fechaDinamica.setMinutes(fechaDinamica.getMinutes() + auxMin);
                                fechaDinamica.setHours(fechaDinamica.getHours() + auxHr);
                                //Al horario y la duracion se le suma ademas la duracion de
                                //la pelicula que queremos agregar

                                auxMin = auxDurPel % 60;
                                auxHr = (int) auxDurPel / 60;
                                fechaDinamica.setMinutes(fechaDinamica.getMinutes() + auxMin);
                                fechaDinamica.setHours(fechaDinamica.getHours() + auxHr);
                                if (fechaDinamica.before(funcionDiaActual.get(i + 1).getHorario()) || (fechaDinamica == (funcionDiaActual.get(i + 1).getHorario()))) {
                                    //Ingresar funcion
                                }

                            }
                        }
                        //Si hay hueco despues de la ultima funcion

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
         */

    }

    public void pruebaFunciones() {
        Funcion prueba1 = new Funcion();
        prueba1.setPelicula_idPelicula(1);
        prueba1.setSala_idSala(1);
        prueba1.setHorarioC(generarCalendar(2022, 4, 1, 10, 30));
        conf.add(prueba1);
    }
}
