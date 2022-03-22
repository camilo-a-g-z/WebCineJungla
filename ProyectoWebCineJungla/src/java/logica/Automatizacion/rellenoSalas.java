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
        ResultSet DBf = funcionDB.getFuncionBySala(sala);
        while (DBf.next()) {
            for (int x = 1; x <= DBf.getMetaData().getColumnCount(); x++) {
                System.out.print(DBf.getString(x) + "\t");
            }

            System.out.println("");
        }
    }
}
