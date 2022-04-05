package logica.Automatizacion;

import datos.DBFuncion;
import datos.DBPelicula;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.MONTH;
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
    ArrayList<Pelicula> arregloTesteoPel = new ArrayList<Pelicula>();
    Pelicula objPel;
    Calendar fechaActual = Calendar.getInstance();
    Calendar fechaFinal = Calendar.getInstance();
    Date fechaDinamica;
    Calendar horaInicial = Calendar.getInstance();
    Calendar horaFinal = Calendar.getInstance();
    boolean InsercionAntesFuncion = false;

    int auxHr;
    int auxMin;
    int auxDurPel;

    public rellenoSalas(int sala, int pelicula, int anio, int mes, int dia, int hora, int min) {
        System.out.println("ENTRO A RELLENO SALAS");

        fechaActual = generarCalendar(anio, mes, dia, hora, min);
        fechaFinal = generarCalendar(anio, mes, dia, hora, min);

        // System.out.println(fechaActual.get(Calendar.YEAR));
        // System.out.println(fechaActual.get(Calendar.MONTH));
        // System.out.println(fechaActual.get(Calendar.DATE));
        // System.out.println(fechaActual.get(Calendar.HOUR_OF_DAY));
        // System.out.println(fechaActual.get(Calendar.MINUTE));
        horaInicial = fechaActual;
        horaInicial.set(Calendar.HOUR_OF_DAY, 12);
        horaInicial.set(Calendar.MINUTE, 00);
        horaFinal = fechaActual;
        horaFinal.set(Calendar.HOUR_OF_DAY, 23);
        horaFinal.set(Calendar.MINUTE, 00);
        // System.out.println(horaInicial.get(Calendar.HOUR_OF_DAY) + " : " + horaInicial.get(Calendar.MINUTE));

        fechaFinal.add(Calendar.MONTH, 1);

        //System.out.println("Mes Inicial " + fechaActual.get(Calendar.MONTH) + "   Mes Final " + fechaFinal.get(Calendar.MONTH));
        pruebaFunciones();
        rellenarFuncion(sala, pelicula);
    }

    public Calendar generarCalendar(int Anio, int Mes, int Dia, int Hora, int Minuto) {
        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR, Anio);
        c.set(Calendar.MONTH, Mes);
        c.set(Calendar.DAY_OF_MONTH, Dia);
        c.set(Calendar.HOUR_OF_DAY, Hora);
        c.set(Calendar.MINUTE, Minuto);

        return c;
    }

    public void rellenarFuncion(int sala, int pelicula) {

        try {

            // ResultSet DBf = funcionDB.getFuncionBySala(sala);
            // obtenerFuncionPorDia transf = new obtenerFuncionPorDia(DBf);
            // conf = transf.getArrayListFunciones();  SE COMENTA ESTA LINEA POR PRUEBA
            // ResultSet DBp = pel.getPeliculaById(pelicula);
            //TransformPelicula pelTrans = new TransformPelicula(DBp);
            //objPel = pelTrans.getPeli();
            //auxDurPel = objPel.getDuracion();
            pruebaPeliculas();
            auxDurPel = arregloTesteoPel.get(0).getDuracion();

            boolean coincidePelicula = false;
            int a = 0;
            //Mientras el mes actual sea menor al siguiente mes
            while (fechaActual.get(Calendar.MONTH) < fechaFinal.get(Calendar.MONTH)) {
                //  System.out.println("Horario C "+ conf.get(0).getHorarioC());
                //  System.out.println("fechaActual "+ fechaActual);
                System.out.println("Se revisa dia del mes: " + (a + 1));
                horaInicial.set(Calendar.HOUR_OF_DAY, 12);
                horaInicial.set(Calendar.MINUTE, 00);

                for (int i = 0; i < conf.size(); i++) {
                    //System.out.println("El tamaño del arreglo de funciones es " + conf.size());
                    //System.out.println(conf.get(i).getHorarioC().get(Calendar.YEAR) + " y " + (fechaActual.get(Calendar.YEAR)));
                    //System.out.println(conf.get(i).getHorarioC().get(Calendar.MONTH) + " y " + (fechaActual.get(Calendar.MONTH)));
                    //System.out.println(conf.get(i).getHorarioC().get(Calendar.DAY_OF_MONTH) + " y " + (fechaActual.get(Calendar.DAY_OF_MONTH)));

                    if ((conf.get(i).getHorarioC().get(Calendar.YEAR) == (fechaActual.get(Calendar.YEAR)))
                            && (conf.get(i).getHorarioC().get(Calendar.MONTH) == (fechaActual.get(Calendar.MONTH)))
                            && (conf.get(i).getHorarioC().get(Calendar.DAY_OF_MONTH) == (fechaActual.get(Calendar.DAY_OF_MONTH)))) {
                        System.out.println("ENTRA LINEA 95, por tanto se agregan funciones del dia en cuestion");
                        funcionDiaActual.add(conf.get(i));
                    }
                }

                if (funcionDiaActual.isEmpty()) {
                    //Rellenar con una funcion
                    // System.out.println("Entra linea 102, el dia actual no tiene funciones");

                } else {
                    System.out.println("Entra LINEA 110, el dia actual SI tiene funciones");
                    for (int j = 0; j < funcionDiaActual.size() && !coincidePelicula; j++) {
                        if (funcionDiaActual.get(j).getPelicula_idPelicula() == pelicula) {
                            System.out.println("AQUI ENTRA linea 106, por lo tanto la pelicula ya se esta proyectando este dia");
                            coincidePelicula = true;
                        }
                    }
                    if (coincidePelicula == false) {
                        System.out.println("ENTRA LINEA 112, la pelicula que se quiere introducir no coincide con ninguna de las funciones");
                        Collections.sort(funcionDiaActual, new ordenarFuncionPorHorario());

                        //Si hay hueco antes de la primera funcion
                        if (funcionDiaActual.get(0).getHorarioC().get(Calendar.HOUR_OF_DAY) > (horaInicial.get(Calendar.HOUR_OF_DAY))) {
                            auxMin = auxDurPel % 60;
                            auxHr = (int) auxDurPel / 60;
                            Calendar fechaAux = Calendar.getInstance();
                            fechaAux = horaInicial;
                            fechaAux.add(Calendar.MINUTE, auxMin);
                            fechaAux.add(Calendar.HOUR_OF_DAY, auxHr);
                            System.out.println("ENTRA LINEA 123, hay tiempo entre la primera funcion y el inicio del dia (12)");
                            Date auxDate = new Date();
                            Date auxDate2 = new Date();
                            auxDate.setHours(fechaAux.get(Calendar.HOUR_OF_DAY));
                            auxDate.setMinutes(fechaAux.get(Calendar.MINUTE));

                            auxDate2.setHours(funcionDiaActual.get(0).getHorarioC().get(Calendar.HOUR_OF_DAY));
                            auxDate2.setMinutes(funcionDiaActual.get(0).getHorarioC().get(Calendar.MINUTE));

                            //System.out.println(fechaAux.before(funcionDiaActual.get(0).getHorarioC()));
                            if (auxDate.equals(auxDate2) || (auxDate.before(auxDate2))) {
                                //Insertar Funcion

                                System.out.println("ENTRA LINEA 128, hay tiempo suficiente para introducir la pelicula despues de las (12) "
                                        + "y antes de la primera funcion");
                                InsercionAntesFuncion = true;
                            }

                        }

                        //Insercion despues de la ultima funcion y antes de que sean las 12
                        if (!InsercionAntesFuncion) {
                            System.out.println("AQUI ENTRA");
                            auxMin = auxDurPel % 60;
                            auxHr = (int) auxDurPel / 60;
                            Calendar auxCal = Calendar.getInstance();
                            auxCal = funcionDiaActual.get(funcionDiaActual.size() - 1).getHorarioC();
                            auxCal.add(Calendar.MINUTE, (int) funcionDiaActual.get(funcionDiaActual.size() - 1).getDuracion() / 60);
                            auxCal.add(Calendar.HOUR_OF_DAY, funcionDiaActual.get(funcionDiaActual.size() - 1).getDuracion() % 60);
                            auxCal.add(Calendar.MINUTE, auxMin);
                            auxCal.add(Calendar.HOUR_OF_DAY, auxHr);
                            Date auxDate = new Date();
                            auxDate.setHours(auxCal.get(Calendar.HOUR_OF_DAY));
                            auxDate.setMinutes(auxCal.get(Calendar.MINUTE));
                            Date auxDate2 = new Date();
                            auxDate2.setHours(horaFinal.get(Calendar.HOUR_OF_DAY));
                            auxDate2.setMinutes(horaFinal.get(Calendar.MINUTE));
                            if (auxDate.equals(auxDate2) || (auxDate.before(auxDate2))) {
                                //Insertar Funcion

                                System.out.println("ENTRA LINEA 180, hay tiempo suficiente para introducir la funcion despues de la ultima funcion y antes de las 12 de la noche");
                                InsercionAntesFuncion = true;
                            }

                        }

                        /*   if (!InsercionAntesFuncion && funcionDiaActual.size()>2) {
                            //Verificar huecos entre funciones
                            for (int i = 0; i < funcionDiaActual.size()-1; i++) {

                                System.out.println("Entro a la linea 190, no se ingresaron despues de las 12 y antes de la primera funcion"
                                        + " ni despues de la ultima funcion y antes de las 12");

                                //Al horario de la funcion se le suma la duracion de la pelicula
                                auxMin = funcionDiaActual.get(i).getDuracion() % 60;

                                auxHr = (int) (funcionDiaActual.get(i).getDuracion() / 60);

                                System.out.println(auxMin + " : " + auxHr);
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
                        }*/
                    }
                }
                    funcionDiaActual.clear();
                    coincidePelicula = false;
                    InsercionAntesFuncion = false;
                    //Se aumentara en un dia por cada bucle del while
                    a = a + 1;
                    fechaActual.add(Calendar.DATE, 1);
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void pruebaFunciones() {
        Funcion prueba;

        prueba = new Funcion();
        prueba.setPelicula_idPelicula(1);
        prueba.setSala_idSala(1);
        prueba.setHorarioC(generarCalendar(2022, 4, 1, 12, 00));
        prueba.setDuracion(90);
        conf.add(prueba);

        prueba = new Funcion();
        prueba.setPelicula_idPelicula(2);
        prueba.setSala_idSala(1);
        prueba.setHorarioC(generarCalendar(2022, 4, 10, 12, 00));
        prueba.setDuracion(90);
        conf.add(prueba);

        prueba = new Funcion();
        prueba.setPelicula_idPelicula(3);
        prueba.setSala_idSala(1);
        prueba.setHorarioC(generarCalendar(2022, 4, 15, 12, 10));
        prueba.setDuracion(110);
        conf.add(prueba);

        prueba = new Funcion();
        prueba.setPelicula_idPelicula(4);
        prueba.setSala_idSala(1);
        prueba.setHorarioC(generarCalendar(2022, 4, 15, 14, 40));
        prueba.setDuracion(85);
        conf.add(prueba);
    }

    public void pruebaPeliculas() {
        Pelicula peli;
        peli = new Pelicula();
        peli.setDuracion(120);
        peli.setIdPelicula(1);
        arregloTesteoPel.add(peli);

    }
}
