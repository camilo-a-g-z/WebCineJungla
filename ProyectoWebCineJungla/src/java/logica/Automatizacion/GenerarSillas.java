package logica.Automatizacion;

import datos.DBSilla;
import java.util.ArrayList;
import logica.Silla;

/**
 *
 * @author Sillas
 */
public class GenerarSillas {
    private ArrayList<Integer> ids = new ArrayList<Integer>();
    private ArrayList<Silla> sillas = new ArrayList<Silla>();

    public GenerarSillas(ArrayList<Integer> ids) {
        this.ids = ids;
        generarSilla();
        CargarBaseDatos();
    }

    public GenerarSillas(int id) {
        generarSilla(id);
        CargarBaseDatos();
    }
    
    private void generarSilla(){
        
        for(int i =0;i<ids.size();i++){
            for (int j=1;j<=40;j++){
                Silla s = new Silla();
                s.setSala_idSala(ids.get(i));
                s.setTipo("General");
                s.setUbicacion(String.valueOf(j));
                sillas.add(s);
            }
            for (int j=41;j<=60;j++){
                Silla s = new Silla();
                s.setSala_idSala(ids.get(i));
                s.setTipo("Preferencial");
                s.setUbicacion(String.valueOf(j));
                sillas.add(s);
            }
        }
    }
    private void generarSilla(int id){
        for (int j=1;j<=40;j++){
            Silla s = new Silla();
            s.setSala_idSala(ids.get(id));
            s.setTipo("General");
            s.setUbicacion(String.valueOf(j));
            sillas.add(s);
        }
        for (int j=41;j<=60;j++){
            Silla s = new Silla();
            s.setSala_idSala(ids.get(id));
            s.setTipo("Preferencial");
            s.setUbicacion(String.valueOf(j));
            sillas.add(s);
        }
    }
    
    private void CargarBaseDatos(){
        for(int i=0;i<sillas.size();i++){
            DBSilla DBs = new DBSilla();
            DBs.insertarSilla(sillas.get(i));
        }
    }
}
