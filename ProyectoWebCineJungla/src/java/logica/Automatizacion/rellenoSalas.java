package logica.Automatizacion;

import datos.DBFuncion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Miguel
 */
public class rellenoSalas {

    DBFuncion funcionDB = new DBFuncion();

    public rellenoSalas(int sala, int pelicula) throws SQLException {
        ResultSet obtenidoBD = funcionDB.getFuncionBySala(sala);
        while (obtenidoBD.next()) {
            for (int x = 1; x <= obtenidoBD.getMetaData().getColumnCount(); x++) {
                System.out.print(obtenidoBD.getString(x) + "\t");
            }

            System.out.println("");
        }
    }
}
