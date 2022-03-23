package logica.Automatizacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.Funcion;

/**
 * Clase para convertir las funciones traidas de la consulta SQL en ArrayList
 *
 * @author Camilo Garcia
 */
public class TransformFuncion {

    private ArrayList<Funcion> con = new ArrayList<Funcion>();
    private ResultSet res;

    public TransformFuncion(ResultSet res) throws SQLException {
        this.res = res;
        transformar(res);
    }

    private void transformar(ResultSet res) throws SQLException {
        while (res.next()) {
            Funcion f = new Funcion();
            f.setEmpleado_idEmpleado(res.getInt("idFuncion"));
            f.setHorario(res.getDate("Horario"));
            f.setSala_idSala(res.getInt("Sala_idSala"));
            f.setEmpleado_idEmpleado(res.getInt("Empleado_idEmpleado"));
            f.setPelicula_idPelicula(res.getInt("Pelicula_idPelicula"));
            con.add(f);
        }
    }

    public ArrayList getArrayListFunciones() {
        return con;
    }

}
