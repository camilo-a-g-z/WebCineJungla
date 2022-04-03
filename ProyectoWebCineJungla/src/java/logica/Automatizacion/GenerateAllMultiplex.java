package logica.Automatizacion;

import datos.DBMultiplex;
import logica.Multiplex;

/**
 *
 * @author Camilo Garcia
 */
public class GenerateAllMultiplex {
    private String NombreMultiplex = "";
    private String DireccionMultiplex = "";
    private int idMultiplex = 0;
    private int CantidadSalas = 0;

    public GenerateAllMultiplex(String NombreMultiplex, String DireccionMultiplex ,int CantidadSalas) {
        this.NombreMultiplex = NombreMultiplex;
        this.CantidadSalas = CantidadSalas;
        this.DireccionMultiplex = DireccionMultiplex;
        logica();
    }
    
    private void logica(){
        crearMultiplex();
        GenerateSalas gSalas = new GenerateSalas(idMultiplex,CantidadSalas);
        GenerarSillas gSillas = new GenerarSillas(gSalas.getIds());
    }
    private void crearMultiplex(){
        DBMultiplex DBm = new DBMultiplex();
        Multiplex m = new Multiplex() ;
        m.setDireccion(DireccionMultiplex);
        m.setNombre(NombreMultiplex);
        DBm.insertarMultiplex(m);
        idMultiplex = Integer.parseInt(DBm.getLastId());
    }
    //Getters y setters
    public String getDireccionMultiplex() {    
        return DireccionMultiplex;
    }

    public void setDireccionMultiplex(String DireccionMultiplex) {    
        this.DireccionMultiplex = DireccionMultiplex;
    }

    public String getNombreMultiplex() {
        return NombreMultiplex;
    }

    public void setNombreMultiplex(String NombreMultiplex) {
        this.NombreMultiplex = NombreMultiplex;
    }

    public int getCantidadSalas() {
        return CantidadSalas;
    }

    public void setCantidadSalas(int CantidadSalas) {
        this.CantidadSalas = CantidadSalas;
    }
    
    
}
