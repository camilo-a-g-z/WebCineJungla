package logica.Automatizacion;

import datos.DBSilla;
import java.util.ArrayList;
import logica.Silla;

/**
 *
 * Esta clase genera sillas y las agrega en la base de datos
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class GenerarSillas {

    //Campos de la clase
    //Declaracion de variables
    private ArrayList<Integer> ids = new ArrayList<Integer>();
    private ArrayList<Silla> sillas = new ArrayList<Silla>();

    /**
     * Metodo constructor de la clase, llama a los metodos generarSilla y 
     * CargarBaseDatos
     *
     * @param ids
     */
    public GenerarSillas(ArrayList<Integer> ids) {
        this.ids = ids;
        generarSilla();
        CargarBaseDatos();
    }
    //Cierre del metodo

    /**
     * Metodo constructor de la clase
     *
     * @param id
     */
    public GenerarSillas(int id) {
        generarSilla(id);
        CargarBaseDatos();
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de generar sillas y agregarlas a un arreglo
     */
    private void generarSilla() {

        for (int i = 0; i < ids.size(); i++) {
            for (int j = 1; j <= 40; j++) {
                Silla s = new Silla();
                s.setSala_idSala(ids.get(i));
                s.setTipo("General");
                s.setUbicacion(String.valueOf(j));
                sillas.add(s);
            }
            for (int j = 41; j <= 60; j++) {
                Silla s = new Silla();
                s.setSala_idSala(ids.get(i));
                s.setTipo("Preferencial");
                s.setUbicacion(String.valueOf(j));
                sillas.add(s);
            }
        }
    }

    //Cierre del metodo
    /**
     * Metodo que se encarga de generar sillas segun un id
     *
     * @param id
     */
    private void generarSilla(int id) {
        for (int j = 1; j <= 40; j++) {
            Silla s = new Silla();
            s.setSala_idSala(ids.get(id));
            s.setTipo("General");
            s.setUbicacion(String.valueOf(j));
            sillas.add(s);
        }
        for (int j = 41; j <= 60; j++) {
            Silla s = new Silla();
            s.setSala_idSala(ids.get(id));
            s.setTipo("Preferencial");
            s.setUbicacion(String.valueOf(j));
            sillas.add(s);
        }
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de insertar sillas a la base de datos
     */
    private void CargarBaseDatos() {
        DBSilla DBs = new DBSilla();
        for (int i = 0; i < sillas.size(); i++) {
            DBs.insertarSilla(sillas.get(i));
        }
    }
    //Cierre del metodo
}
