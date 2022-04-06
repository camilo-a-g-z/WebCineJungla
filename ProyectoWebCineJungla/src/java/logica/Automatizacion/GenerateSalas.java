package logica.Automatizacion;

import datos.DBSala;
import java.util.ArrayList;
import logica.Sala;

/**
 *
 * Clase que se encarga de generar las salas en un multiplex
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class GenerateSalas {
//Campos de la clase

    //Declaracion de variables
    private int idMultiplex = 0;
    private int cantidadSalas = 0;
    private ArrayList<Sala> salas = new ArrayList<Sala>();
    private ArrayList<Integer> ids = new ArrayList<Integer>();

    /**
     * Metodo constructor de la clases, llama al metodo crearSala cargarSalas
     *
     * @param idMultiplex
     * @param cantidadSalas
     */
    public GenerateSalas(int idMultiplex, int cantidadSalas) {
        this.cantidadSalas = cantidadSalas;
        this.idMultiplex = idMultiplex;
        crearSala();
        cargarSalas();
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de añadir salas al multiplex
     */
    private void crearSala() {
        for (int i = 0; i < cantidadSalas; i++) {
            Sala sala = new Sala();
            sala.setMultiplex_idMultiplex(idMultiplex);
            sala.setNumero(String.valueOf(i));
            salas.add(sala);
        }
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga añadir a la base de datos las salas
     */
    private void cargarSalas() {
        for (int i = 0; i < cantidadSalas; i++) {
            DBSala DBs = new DBSala();
            DBs.insertarSala(salas.get(i));
            ids.add(Integer.parseInt(DBs.getLastId()));
        }
    }
    //Cierre del metodo
    
    //Getters y setters
    public ArrayList<Integer> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Integer> ids) {
        this.ids = ids;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    public int getIdMultiplex() {
        return idMultiplex;
    }

    public void setIdMultiplex(int idMultiplex) {
        this.idMultiplex = idMultiplex;
    }

    public int getCantidadSalas() {
        return cantidadSalas;
    }

    public void setCantidadSalas(int cantidadSalas) {
        this.cantidadSalas = cantidadSalas;
    }

}
