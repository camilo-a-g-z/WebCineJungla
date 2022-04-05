package logica.Automatizacion;

import datos.DBFuncion;
import datos.DBSala;
import datos.DBSilla;
import datos.DBSillaFuncion;
import java.sql.ResultSet;
import logica.Silla; 
import logica.SillaFuncion;

/**
 *
 * @author Camilo Garcia
 */
public class ObtenerDatosSillaFuncion {
    private int idSilaFuncion;
    private SillaFuncion sf = new SillaFuncion();
    private Silla silla = new Silla();
    
    public ObtenerDatosSillaFuncion(int idSilaFuncion) {
        this.idSilaFuncion = idSilaFuncion;
        proceso();
    }
    private void proceso(){
        obtenerSillaFuncion();
        obtenerSilla();
        actualizarEstado();
    }
    private void obtenerSillaFuncion(){
        try{
            DBSillaFuncion DBsf = new DBSillaFuncion();
            ResultSet res1 = DBsf.getSillaFuncionById(idSilaFuncion);
            res1.next();
            sf.setIdSillaFuncion(res1.getInt("idSillaFuncion"));
            sf.setEstado(res1.getString("Estado"));
            sf.setFuncion_idFuncion(res1.getInt("Funcion_idFuncion"));
            sf.setSilla_idSilla(res1.getInt("Silla_idSilla"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void obtenerSilla(){
        try{
            DBSilla DBs = new DBSilla();
            ResultSet res1 = DBs.getSillaById(sf.getSilla_idSilla());
            res1.next();
            silla.setIdSilla(res1.getInt("idSilla"));
            silla.setSala_idSala(res1.getInt("Sala_idSala"));
            silla.setTipo(res1.getString("Tipo"));
            silla.setUbicacion(res1.getString("Ubicacion"));
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }

    private void actualizarEstado(){
        DBSillaFuncion DBsf = new DBSillaFuncion();
        try{
            sf.setEstado("Ocupada");
            DBsf.modifySillaFuncion(sf);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public int obtenerIdMultiplex(){
        int idMultiplex = 0;
        int idSala = 0;
        try{
            DBFuncion DBf = new DBFuncion();
            ResultSet res = DBf.getFuncionById(sf.getFuncion_idFuncion());
            res.next();
            idSala = res.getInt("Sala_idSala");
            DBSala DBs = new DBSala();
            ResultSet resS = DBs.getSalaById(idSala);
            resS.next();
            idMultiplex = resS.getInt("Multiplex_idMultiplex");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return idMultiplex;
    }
    
    public int getIdSilaFuncion() {
        return idSilaFuncion;
    }

    public void setIdSilaFuncion(int idSilaFuncion) {
        this.idSilaFuncion = idSilaFuncion;
    }

    public SillaFuncion getSf() {
        return sf;
    }

    public void setSf(SillaFuncion sf) {
        this.sf = sf;
    }

    public Silla getSilla() {
        return silla;
    }

    public void setSilla(Silla silla) {
        this.silla = silla;
    }
    
}
