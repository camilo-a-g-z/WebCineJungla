package logica.Automatizacion;

import datos.DBFuncion;
import datos.DBSala;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.Funcion;

/**
 * En esta clase se generan todas las funciones que tiene un multiplex 
 * pero limitado a una pelicula
 * @author Camilo Garcia
 */
public class FuncionesByMultiplex {
    private ArrayList<Funcion> funciones = new ArrayList<Funcion>();  
    //private ArrayList<Funcion> con = new ArrayList<Funcion>();  

    public FuncionesByMultiplex(int idPelicula, int idMultiplex) throws SQLException {
        generarFunciones(idPelicula, idMultiplex);
    }
    private void generarFunciones(int idPelicula, int idMultiplex) throws SQLException{
        obtenerFunciones(idMultiplex);
        separarByPelicula(idPelicula);
    }
    private void obtenerFunciones(int idMultiplex) throws SQLException{
        DBSala sala = new DBSala();
        DBFuncion funcion = new DBFuncion();
        ResultSet res = sala.getSalaByidMultiplex(idMultiplex);
        ResultSet res2 = null;
        while(res.next()){
            res2 = funcion.getFuncionBySala(res.getInt("idSala"));
            TransformFuncion tras = new TransformFuncion(res2);
            funciones.addAll(tras.getArrayListFunciones());
        }
    }
    private void separarByPelicula(int idPelicula){
        ArrayList<Funcion> modificado = new ArrayList<Funcion>();  
        for(int i=0;i<funciones.size();i++){
            
        }
    }
}