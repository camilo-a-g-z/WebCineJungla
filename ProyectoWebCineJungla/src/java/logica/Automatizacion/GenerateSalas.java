package logica.Automatizacion;

import datos.DBSala;
import java.util.ArrayList;
import logica.Sala;

/**
 *
 * @author Camilo Garcia
 */
public class GenerateSalas {
    private int idMultiplex = 0;
    private int cantidadSalas = 0;
    private ArrayList<Sala> salas = new ArrayList<Sala>();
    private ArrayList<Integer> ids = new ArrayList<Integer>();

    public GenerateSalas(int idMultiplex, int cantidadSalas) {
        this.cantidadSalas = cantidadSalas;
        this.idMultiplex = idMultiplex;
        crearSala();
        cargarSalas();
    }
    private void crearSala(){
        for(int i=0;i<cantidadSalas;i++){
            Sala sala = new Sala();
            sala.setMultiplex_idMultiplex(idMultiplex);
            sala.setNumero(String.valueOf(i));
        }
    }
    private void cargarSalas(){
        for(int i=0;i<cantidadSalas;i++){
            DBSala DBs = new DBSala();
            DBs.insertarSala(salas.get(i));
            ids.add(Integer.parseInt(DBs.getLastId()));
        }
    }
    //Getters y setters
    public ArrayList<Integer> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Integer> ids) {
        this.ids = ids;
    }
    
    
    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }
    
    
    public int getIdMultiplex() {
        return idMultiplex;
    }

    public void setIdMultiplex(int idMultiplex) {
        this.idMultiplex = idMultiplex;
    }

    public int getCantidadSalas() {
        return cantidadSalas;
    }

    public void setCantidadSalas(int cantidadSalas) {
        this.cantidadSalas = cantidadSalas;
    }
    
}
