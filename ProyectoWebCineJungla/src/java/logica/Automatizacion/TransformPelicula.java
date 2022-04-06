package logica.Automatizacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Pelicula;

/**
 * Clase para convertir la pelicula de la consulta SQL en un objeto Pelicula
 *
 * *@author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class TransformPelicula {

    //Campos de la clase
    //Declaracion de variables
    private Pelicula pel;
    private ResultSet res;

    /**
     * Metodo constructor de la clase, llama al metodo transformar
     *
     * @param res
     * @throws SQLException
     */
    public TransformPelicula(ResultSet res) throws SQLException {
        this.res = res;
        transformar();
        System.out.println("Anrtes");
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de obtener los datos de una pelicula de la BD y
     * guardarlos en un objeto tipo Pelicula
     */
    private void transformar() {
        try {
            while (res.next()) {
                pel.setClasificacionEdad(res.getString("ClasificacionEdad"));
                pel.setDirector(res.getString("Director"));
                pel.setDuracion(res.getInt("Duracion"));
                pel.setEstado(res.getString("Estado"));
                pel.setNombre(res.getString("Nombre"));
                pel.setSinopsis(res.getString("Sinopsis"));
                pel.setUrlPelicula(res.getString("UrlPelicula"));
                pel.setIdPelicula(res.getInt("idPelicula"));
                System.out.println("Termino");
            }

        } catch (Exception e) {
            System.out.println("Problema en " + e.getLocalizedMessage() + " and " + e.getMessage());
        }
    }
    //Cierre del metodo

    //Metodo getter del objeto Pelicula
    public Pelicula getPeli() {
        return pel;
    }
    //Cierre del metodo

}
