package logica.Automatizacion;

import datos.DBFuncion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.Funcion;

/**
 *
 * @author Miguel
 */
public class rellenoSalas {

    DBFuncion funcionDB = new DBFuncion();
    ArrayList funciones = new ArrayList();
    public rellenoSalas(int sala, int pelicula) throws SQLException {
        
    }
    public void metodo(int sala, int pelicula){
        try{
            ResultSet DBf = funcionDB.getFuncionBySala(sala);
            while (DBf.next()) {
                Funcion f  = new Funcion();
                f.setIdFuncion(Integer.parseInt(DBf.getString("idFuncion")));
                f.setHorario(DBf.getString("Horario"));//DD/MM/AA/HH/MM
                funciones.add(f);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
