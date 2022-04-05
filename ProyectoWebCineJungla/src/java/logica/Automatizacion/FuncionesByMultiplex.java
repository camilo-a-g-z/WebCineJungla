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
 * En esta clase se generan todas las funciones que tiene un multiplex 
 * pero limitado a una pelicula
 * @author Camilo Garcia
 */
public class FuncionesByMultiplex {
    private ArrayList<Funcion> funciones = new ArrayList<Funcion>();  
    private int anio;
    private int mes;
    private int dia;
    //private ArrayList<Funcion> con = new ArrayList<Funcion>();  

    public FuncionesByMultiplex(int idPelicula, int idMultiplex, int anio, int mes, int dia){
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        try{
            generarFunciones(idPelicula, idMultiplex);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void generarFunciones(int idPelicula, int idMultiplex) throws SQLException, ParseException{
        obtenerFunciones(idMultiplex);
        separarByPelicula(idPelicula);
        separarByHorario();
    }
    private void obtenerFunciones(int idMultiplex) throws SQLException{
        DBSala sala = new DBSala();
        DBFuncion funcion = new DBFuncion();
        ResultSet res = sala.getSalaByidMultiplex(idMultiplex);
        while(res.next()){
            ResultSet res2 = funcion.getFuncionBySala(res.getInt("idSala"));
            TransformFuncion tras = new TransformFuncion(res2);
            funciones.addAll(tras.getArrayListFunciones());
        }
    }
    private void separarByPelicula(int idPelicula){
        ArrayList<Funcion> modificado = new ArrayList<Funcion>();  
        for(int i=0;i<funciones.size();i++){
            if(funciones.get(i).getPelicula_idPelicula() == idPelicula){
                modificado.add(funciones.get(i));
            }
        }
        funciones = new ArrayList<Funcion>();
        funciones.addAll(modificado);
    }
    private void separarByHorario() throws ParseException {
        Date dt = new Date();
        dt.setYear(anio);
        dt.setMonth(mes);
        dt.setDate(dia);
        Date comp = dt;
        comp.setMonth(dt.getMonth() - 1);
        comp.setDate(dt.getDate()-1);
        ArrayList<Funcion> modificado = new ArrayList<Funcion>();
        for(int i=0;i<funciones.size();i++){
            if(comp.before(funciones.get(i).getHorario())){
                modificado.add(funciones.get(i));
            }
        }
        funciones = new ArrayList<Funcion>();
        funciones.addAll(modificado);
        System.out.println(funciones.size());
    }

    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }
    
    
}
