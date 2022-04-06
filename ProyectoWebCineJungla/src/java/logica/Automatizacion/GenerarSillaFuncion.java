package logica.Automatizacion;

import datos.DBSilla;
import datos.DBSillaFuncion;
import java.sql.ResultSet;
import logica.SillaFuncion;

/**
 *
 * @author User
 */
public class GenerarSillaFuncion {
    private int idFuncion = 0;
    private int idSala = 0;

    public GenerarSillaFuncion(int idFuncion, int idSala) {
        this.idFuncion=idFuncion;
        this.idSala=idSala;
        proceso();
    }
    private void proceso(){
        DBSilla DBs = new DBSilla();
        DBSillaFuncion DBsf = new DBSillaFuncion();
        ResultSet res1;
        try{
            res1 = DBs.getSillaByidSala(idSala);
            while(res1.next()){
                System.out.println("ID de la silla: "+res1.getInt("idSilla"));
                SillaFuncion sf = new SillaFuncion();
                sf.setEstado("Libre");
                sf.setFuncion_idFuncion(idFuncion);
                sf.setSilla_idSilla(res1.getInt("idSilla"));
                
                DBsf.insertarSillaFuncion(sf);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
