package logica.Automatizacion;

import datos.DBCliente;
import datos.DBEmpleado;
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
public final class rellenoSalas {

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
    int sala, pelicula, anio, mes, dia, hora, min;
    public rellenoSalas(int sala, int pelicula, int anio, int mes, int dia, int hora, int min) {
        this.sala=sala;
        this.pelicula=pelicula;
        this.anio=anio;
        this.mes=mes;
        this.dia=dia;
        this.hora=hora;
        this.min=min;
        fechaActual = generarCalendar(anio, mes, dia, hora, min);
        fechaFinal = generarCalendar(anio, mes, dia, hora, min);

        horaInicial = fechaActual;
        horaInicial.set(Calendar.HOUR_OF_DAY, 12);
        horaInicial.set(Calendar.MINUTE, 00);
        horaFinal = fechaActual;
        horaFinal.set(Calendar.HOUR_OF_DAY, 23);
        horaFinal.set(Calendar.MINUTE, 00);

        fechaFinal.add(Calendar.MONTH, 1);

//        pruebaFunciones();
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
            ResultSet DBf = funcionDB.getFuncionBySala(sala);
            obtenerFuncionPorDia transf = new obtenerFuncionPorDia(DBf);
            conf = transf.getArrayListFunciones();
            DBPelicula test = new DBPelicula();
            ResultSet DBp = test.getPeliculaById(1);
            Pelicula peli = new Pelicula();
            while(DBp.next()){
                peli.setClasificacionEdad(DBp.getString("ClasificacionEdad"));
                peli.setDirector(DBp.getString("Director"));
                peli.setDuracion(DBp.getInt("Duracion"));
                peli.setEstado(DBp.getString("Estado"));
                peli.setNombre(DBp.getString("Nombre"));
                peli.setSinopsis(DBp.getString("Sinopsis"));
                peli.setUrlPelicula(DBp.getString("UrlPelicula"));
                peli.setIdPelicula(DBp.getInt("idPelicula"));
            }
            objPel = peli;
            auxDurPel = objPel.getDuracion();
            //pruebaPeliculas();
            //auxDurPel = arregloTesteoPel.get(0).getDuracion();
            auxMin = auxDurPel % 60;
            auxHr = (int) auxDurPel / 60;
            //System.out.println(auxDurPel + "=" + auxHr + ":" + auxMin);

            boolean coincidePelicula = false;
            int a = 0;
            //Mientras el mes actual sea menor al siguiente mes
            while (fechaActual.get(Calendar.MONTH) < fechaFinal.get(Calendar.MONTH)) {
                //  System.out.println("Horario C "+ conf.get(0).getHorarioC());
                //  System.out.println("fechaActual "+ fechaActual);
                //System.out.println("Se revisa dia del mes: " + (a + 1));
                horaInicial.set(Calendar.HOUR_OF_DAY, 12);
                horaInicial.set(Calendar.MINUTE, 00);
                horaFinal.set(Calendar.HOUR_OF_DAY, 22);
                horaFinal.set(Calendar.MINUTE, 00);

                for (int i = 0; i < conf.size(); i++) {
                    //System.out.println("El tamaño del arreglo de funciones es " + conf.size());
                    //System.out.println(conf.get(i).getHorarioC().get(Calendar.YEAR) + " y " + (fechaActual.get(Calendar.YEAR)));
                    //System.out.println(conf.get(i).getHorarioC().get(Calendar.MONTH) + " y " + (fechaActual.get(Calendar.MONTH)));
                    //System.out.println(conf.get(i).getHorarioC().get(Calendar.DAY_OF_MONTH) + " y " + (fechaActual.get(Calendar.DAY_OF_MONTH)));
                    //System.out.println("Fecha "+fechaActual.get(Calendar.DAY_OF_MONTH));
                    if ((conf.get(i).getAño() == (fechaActual.get(Calendar.YEAR)))
                            && (conf.get(i).getMes() == (fechaActual.get(Calendar.MONTH)))
                            && (conf.get(i).getDia() == (fechaActual.get(Calendar.DAY_OF_MONTH)))) {
                        //  System.out.println("ENTRA LINEA 95, por tanto se agregan funciones del dia en cuestion");
                        //  System.out.println(conf.get(i).getHorarioC().get(Calendar.DAY_OF_MONTH) + " y " + (fechaActual.get(Calendar.DAY_OF_MONTH)));
                        //  System.out.println(conf.get(i).getPelicula_idPelicula());
                        funcionDiaActual.add(conf.get(i));
                        //System.out.println("Entrar 1: "+conf.get(i).getDia());
                    }
                }

                if (funcionDiaActual.isEmpty()) {
                    //Rellenar con una funcion
                    // System.out.println("Entra linea 102, el dia actual no tiene funciones");
                    generarFuncion(fechaActual.get(Calendar.YEAR),fechaActual.get(Calendar.MONTH),a+1,12,0);
                } else {
                    //System.out.println("Entra LINEA 110, el dia actual SI tiene funciones");
                    for (int j = 0; j < funcionDiaActual.size() && !coincidePelicula; j++) {
                        if (funcionDiaActual.get(j).getPelicula_idPelicula() == pelicula) {
                            //System.out.println("AQUI ENTRA linea 106, por lo tanto la pelicula ya se esta proyectando este dia");
                            coincidePelicula = true;
                        }
                    }
                    if (coincidePelicula == false) {
//                        System.out.println("ENTRA LINEA 112, la pelicula que se quiere introducir no coincide con ninguna de las funciones");
                        Collections.sort(funcionDiaActual, new ordenarFuncionPorHorario());

                        //Si hay hueco antes de la primera funcion
                        if (funcionDiaActual.get(0).getHora() > (horaInicial.get(Calendar.HOUR_OF_DAY))) {

                            Calendar fechaAux = Calendar.getInstance();
                            fechaAux = horaInicial;
                            fechaAux.add(Calendar.MINUTE, auxMin);
                            fechaAux.add(Calendar.HOUR_OF_DAY, auxHr);
                            //System.out.println("ENTRA LINEA 123, hay tiempo entre la primera funcion y el inicio del dia (12)");
                            Date auxDate = new Date();
                            Date auxDate2 = new Date();
                            auxDate.setHours(fechaAux.get(Calendar.HOUR_OF_DAY));
                            auxDate.setMinutes(fechaAux.get(Calendar.MINUTE));

                            auxDate2.setHours(funcionDiaActual.get(0).getHorarioC().get(Calendar.HOUR_OF_DAY));
                            auxDate2.setMinutes(funcionDiaActual.get(0).getHorarioC().get(Calendar.MINUTE));

                            //System.out.println(fechaAux.before(funcionDiaActual.get(0).getHorarioC()));
                            if (auxDate.equals(auxDate2) || (auxDate.before(auxDate2))) {
                                //Insertar Funcion con hora auxDate
                                generarFuncion(auxDate.getYear(), auxDate.getMonth(), auxDate.getDate(),
                                        auxDate.getHours(), auxDate.getMinutes());
                                
                                //System.out.println("ENTRA LINEA 128, hay tiempo suficiente para introducir la pelicula despues de las (12) "
                                //        + "y antes de la primera funcion");
                                InsercionAntesFuncion = true;
                            }

                        }

                        //Insercion despues de la ultima funcion y antes de que sean las 12
                        if (!InsercionAntesFuncion) {
                            //System.out.println("AQUI ENTRA");

                            Calendar auxCal = Calendar.getInstance();
                            auxCal = funcionDiaActual.get(funcionDiaActual.size() - 1).getHorarioC();
                            // System.out.println("La ultima funcion es a las:" + auxCal.get(Calendar.HOUR_OF_DAY) + ":" + auxCal.get(Calendar.MINUTE));
                            // System.out.println("La ultima hora del dia es :" + horaFinal.get(Calendar.HOUR_OF_DAY) + ":" + horaFinal.get(Calendar.MINUTE));

                            auxCal.add(auxCal.MINUTE, funcionDiaActual.get(funcionDiaActual.size() - 1).getDuracion() % 60);
                            auxCal.add(auxCal.HOUR_OF_DAY, (int) (funcionDiaActual.get(funcionDiaActual.size() - 1).getDuracion() / 60));
                            // System.out.println("La ultima funcion mas su duracion es:" + auxCal.get(Calendar.HOUR_OF_DAY) + ":" + auxCal.get(Calendar.MINUTE));

                            auxCal.add(auxCal.MINUTE, auxMin);
                            auxCal.add(Calendar.HOUR_OF_DAY, auxHr);
                            //System.out.println("La ultima funcion mas su duracion mas la duracion de la pelicula que queremos meter es:" + auxCal.get(Calendar.HOUR_OF_DAY) + ":" + auxCal.get(Calendar.MINUTE));
                            Date auxDate = new Date();
                            auxDate.setHours(auxCal.get(Calendar.HOUR_OF_DAY));
                            auxDate.setMinutes(auxCal.get(Calendar.MINUTE));
                            //System.out.println(auxDate.getHours() + ":" + auxDate.getMinutes());

                            Date auxDate2 = new Date();
                            auxDate2.setHours(horaFinal.get(Calendar.HOUR_OF_DAY));
                            auxDate2.setMinutes(horaFinal.get(Calendar.MINUTE));
                            //  System.out.println(auxDate2.getHours() + ":" + auxDate2.getMinutes());
                            //  System.out.println(auxDate.equals(auxDate2));
                            //  System.out.println((auxDate.before(auxDate2)));

                            if (auxDate.equals(auxDate2) || (auxDate.before(auxDate2))) {
                                //Insertar Funcion con hora auxDate
                                generarFuncion(auxDate.getYear(), auxDate.getMonth(), auxDate.getDate(),
                                        auxDate.getHours(), auxDate.getMinutes());
                                //System.out.println("ENTRA LINEA 180, hay tiempo suficiente para introducir la funcion despues de la ultima funcion y antes de las 12 de la noche");
                                InsercionAntesFuncion = true;
                            }

                        }
                        //System.out.println(InsercionAntesFuncion);
                        if (!InsercionAntesFuncion && funcionDiaActual.size() >= 2) {
                            //Verificar huecos entre funciones
                            for (int i = 0; i < funcionDiaActual.size() - 1 && !InsercionAntesFuncion; i++) {

                                //System.out.println("Entro a la linea 190, no se ingresaron despues de las 12 y antes de la primera funcion"
                                //        + " ni despues de la ultima funcion y antes de las 12");
                                Date auxDate = new Date();
                                Date auxDate2 = new Date();

                                Calendar auxCal = Calendar.getInstance();

                                auxCal = funcionDiaActual.get(i).getHorarioC();
                                //System.out.println("Horario Inicial de la funcion" + auxCal.get(Calendar.HOUR_OF_DAY) + ":" + auxCal.get(Calendar.MINUTE));
                                auxCal.add(auxCal.MINUTE, (funcionDiaActual.get(i).getDuracion() % 60));
                                //System.out.println("Horario Inicial de la funcion mas minutos" + auxCal.get(Calendar.HOUR_OF_DAY) + ":" + auxCal.get(Calendar.MINUTE));
                                auxCal.add(auxCal.HOUR_OF_DAY, (int) (funcionDiaActual.get(i).getDuracion() / 60));
                                //System.out.println("Horario Inicial de la funcion mas horas" + auxCal.get(Calendar.HOUR_OF_DAY) + ":" + auxCal.get(Calendar.MINUTE));
                                auxCal.add(auxCal.MINUTE, auxMin);
                                //System.out.println("Horario Inicial de la funcion mas minutos de la funcion" + auxCal.get(Calendar.HOUR_OF_DAY) + ":" + auxCal.get(Calendar.MINUTE));
                                auxCal.add(auxCal.HOUR_OF_DAY, auxHr);
                                //System.out.println("Horario Inicial de la funcion mas hora de la funcion" + auxCal.get(Calendar.HOUR_OF_DAY) + ":" + auxCal.get(Calendar.MINUTE));

                                auxDate.setHours(auxCal.get(Calendar.HOUR_OF_DAY));
                                auxDate.setMinutes(auxCal.get(Calendar.MINUTE));
                                // System.out.println(auxDate.getHours() + ":" + auxDate.getMinutes());

                                Calendar otroCalendar = null;
                                otroCalendar = funcionDiaActual.get(i + 1).getHorarioC();
                                otroCalendar.add(Calendar.MINUTE, -(funcionDiaActual.get(i + 1).getDuracion() & 60));
                                otroCalendar.add(Calendar.HOUR_OF_DAY, -(int) (funcionDiaActual.get(i + 1).getDuracion() / 60));
                                //System.out.println("Horario Inicial de la funcion" + otroCalendar.get(Calendar.HOUR_OF_DAY) + ":" + otroCalendar.get(Calendar.MINUTE));

                                otroCalendar.add(Calendar.MINUTE, -auxMin);
                                otroCalendar.add(Calendar.MINUTE, -2);
                                otroCalendar.add(Calendar.HOUR_OF_DAY, -auxHr);
                                //System.out.println("Horario Inicial de la funcion" + otroCalendar.get(Calendar.HOUR_OF_DAY) + ":" + otroCalendar.get(Calendar.MINUTE));

                                auxDate2.setHours(otroCalendar.get(Calendar.HOUR_OF_DAY));
                                auxDate2.setMinutes(otroCalendar.get(Calendar.MINUTE));
                                //System.out.println(auxDate.equals(auxDate2));
                                //System.out.println(auxDate.before(auxDate2));
                                if (auxDate.equals(auxDate2) || (auxDate.before(auxDate2))) {
                                    //Ingresar funcion con horas auxDate
                                    generarFuncion(auxDate.getYear(), auxDate.getMonth(), auxDate.getDate(),
                                        auxDate.getHours(), auxDate.getMinutes());
                                    //System.out.println("ENTRA LINEA 215, se ingresa una funcion entre funciones");
                                    InsercionAntesFuncion = true;
                                }

                            }
                        }
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
    private void generarFuncion(int Año, int Mes, int Dia, int Hora, int Minuto){
        Funcion f = new Funcion();
        f.setAño(Año);
        f.setMes(Mes);
        f.setDia(Dia);
        f.setDia(Dia);
        f.setHora(Hora);
        f.setHora(Hora);
        f.setMinuto(Minuto);
        f.setDuracion(auxDurPel);
        f.setEmpleado_idEmpleado(1);
        f.setPelicula_idPelicula(pelicula);
        f.setSala_idSala(sala);
        //conexion base datos
        DBFuncion DBf = new DBFuncion();
        DBEmpleado DBc = new DBEmpleado();
        //resulset
        ResultSet res1;
        
        try{
            res1 =DBc.getEmpleadosRandom();
            res1.next();
            f.setEmpleado_idEmpleado(res1.getInt("idEmpleado"));
            DBf.insertarFuncion(f);
            int idFuncion = Integer.parseInt(DBf.getLastId());
            
            System.out.println("Dia: "+Dia+ "   id: "+idFuncion + "  Sala : "+f.getSala_idSala());
            GenerarSillaFuncion gsf = new GenerarSillaFuncion(idFuncion,f.getSala_idSala());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
