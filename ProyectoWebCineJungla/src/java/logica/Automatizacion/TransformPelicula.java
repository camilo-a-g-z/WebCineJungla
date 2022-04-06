/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Automatizacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Pelicula;

/**
 *
 * @author Miguel
 */
public class TransformPelicula {

    private Pelicula pel;
    private ResultSet res;

    public TransformPelicula(ResultSet res) throws SQLException {
        this.res = res;
        transformar();
        System.out.println("Anrtes");
    }

    private void transformar() {
        try{
            while(res.next()){
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
            
        }catch(Exception e){
            System.out.println("Problema en " + e.getLocalizedMessage()+" and "+e.getMessage());
        }
    }

    public Pelicula getPeli() {
        return pel;
    }

}
