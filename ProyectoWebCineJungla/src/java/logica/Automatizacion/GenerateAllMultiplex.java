package logica.Automatizacion;

import datos.DBMultiplex;
import logica.Multiplex;

/**
 *
 * Clase que se encarga de crear un Multiplex con sus caracteristicas
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class GenerateAllMultiplex {

    //Campos de la clase
    //Declaracion de variables
    private String NombreMultiplex = "";
    private String DireccionMultiplex = "";
    private int idMultiplex = 0;
    private int CantidadSalas = 0;

    /**
     * Metodo constructor de la clase, llama al metodo logica
     *
     * @param NombreMultiplex
     * @param DireccionMultiplex
     * @param CantidadSalas
     */
    public GenerateAllMultiplex(String NombreMultiplex, String DireccionMultiplex, int CantidadSalas) {
        this.NombreMultiplex = NombreMultiplex;
        this.CantidadSalas = CantidadSalas;
        this.DireccionMultiplex = DireccionMultiplex;
        logica();
    }

    //Cierre del metodo
    /**
     * Metodo que se encarga de llamar a otros metodos e instanciar clases
     */
    private void logica() {
        crearMultiplex();
        GenerateSalas gSalas = new GenerateSalas(idMultiplex, CantidadSalas);
        GenerarSillas gSillas = new GenerarSillas(gSalas.getIds());
    }

    //Cierre del metodo
    /**
     * Metodo que se encarga de crear un Multiplex y guardarlo en la base de
     * datos
     */
    private void crearMultiplex() {
        DBMultiplex DBm = new DBMultiplex();
        Multiplex m = new Multiplex();
        m.setDireccion(DireccionMultiplex);
        m.setNombre(NombreMultiplex);
        DBm.insertarMultiplex(m);
        idMultiplex = Integer.parseInt(DBm.getLastId());
    }

    //Cierre del metodo
    //Getters y setters
    public String getDireccionMultiplex() {
        return DireccionMultiplex;
    }

    public void setDireccionMultiplex(String DireccionMultiplex) {
        this.DireccionMultiplex = DireccionMultiplex;
    }

    public String getNombreMultiplex() {
        return NombreMultiplex;
    }

    public void setNombreMultiplex(String NombreMultiplex) {
        this.NombreMultiplex = NombreMultiplex;
    }

    public int getCantidadSalas() {
        return CantidadSalas;
    }

    public void setCantidadSalas(int CantidadSalas) {
        this.CantidadSalas = CantidadSalas;
    }

}
