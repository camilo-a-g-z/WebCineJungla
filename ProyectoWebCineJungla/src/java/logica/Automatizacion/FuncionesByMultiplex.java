package logica.Automatizacion;

import datos.DBFuncion;
import datos.DBSala;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import logica.Funcion;

/**
 * En esta clase se generan todas las funciones que tiene un multiplex pero
 * limitado a una pelicula
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class FuncionesByMultiplex {

    //Campos de la clase
    //Declaracion de variables
    private ArrayList<Funcion> funciones = new ArrayList<Funcion>();
    private int anio;
    private int mes;
    private int dia;
    //private ArrayList<Funcion> con = new ArrayList<Funcion>();  

    /**
     * Metodo constructor de la clase, intenta llamar al metodo
     * generarFunciones teniendo en cuenta posibles errores
     *
     * @param idPelicula
     * @param idMultiplex
     * @param anio
     * @param mes
     * @param dia
     */
    public FuncionesByMultiplex(int idPelicula, int idMultiplex, int anio, int mes, int dia) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        try {
            generarFunciones(idPelicula, idMultiplex);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Cierre del constructor

    /**
     * Metodo que se encarga de llamar a otros metodos
     *
     * @param idPelicula
     * @param idMultiplex
     * @throws SQLException
     * @throws ParseException
     */
    private void generarFunciones(int idPelicula, int idMultiplex) throws SQLException, ParseException {
        obtenerFunciones(idMultiplex);
        separarByPelicula(idPelicula);
        separarByHorario();
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de obtener todas las funciones de una sala de un
     * Multiplex en especifico
     *
     * @param idMultiplex
     * @throws SQLException
     */
    private void obtenerFunciones(int idMultiplex) throws SQLException {
        DBSala sala = new DBSala();
        DBFuncion funcion = new DBFuncion();
        ResultSet res = sala.getSalaByidMultiplex(idMultiplex);
        while (res.next()) {
            ResultSet res2 = funcion.getFuncionBySala(res.getInt("idSala"));
            TransformFuncion tras = new TransformFuncion(res2);
            funciones.addAll(tras.getArrayListFunciones());
        }
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de separar las funciones segun el id de nuestra
     * preferencia
     *
     * @param idPelicula
     */
    private void separarByPelicula(int idPelicula) {
        ArrayList<Funcion> modificado = new ArrayList<Funcion>();
        for (int i = 0; i < funciones.size(); i++) {
            if (funciones.get(i).getPelicula_idPelicula() == idPelicula) {
                modificado.add(funciones.get(i));
            }
        }
        funciones = new ArrayList<Funcion>();
        funciones.addAll(modificado);
    }
    //Cierre del metodo

    /**
     * Este metodo separa las funciones que le lleguen si suceden antes de una
     * fecha en especifico
     *
     * @throws ParseException
     */
    private void separarByHorario() throws ParseException {
        Date dt = new Date();
        dt.setYear(anio);
        dt.setMonth(mes);
        dt.setDate(dia);
        Date comp = dt;
        comp.setMonth(dt.getMonth() - 1);
        comp.setDate(dt.getDate() - 1);
        ArrayList<Funcion> modificado = new ArrayList<Funcion>();
        for (int i = 0; i < funciones.size(); i++) {
            if (comp.before(funciones.get(i).getHorario())) {
                modificado.add(funciones.get(i));
            }
        }
        funciones = new ArrayList<Funcion>();
        funciones.addAll(modificado);
        System.out.println(funciones.size());
    }
    //Cierre del metodo

    /**
     * Metodo getter que permite obtener el arreglo de funciones
     *
     * @return
     */
    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }
    //Cierre del metodo

}
