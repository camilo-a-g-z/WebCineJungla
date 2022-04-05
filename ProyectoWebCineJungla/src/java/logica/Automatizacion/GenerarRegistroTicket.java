package logica.Automatizacion;
/**
 *Silla
 * @author Camilo Garcia
 */
public class GenerarRegistroTicket {
    private int idSillaFuncion = 0;
    private int idFactura = 0;
    
    public GenerarRegistroTicket(int idSillaFuncion, int idFactura ) {
        this.idSillaFuncion = idSillaFuncion;
        this.idFactura = idFactura;
        proceso();
    }
    
    private void proceso(){
        ObtenerDatosSillaFuncion dataS = new ObtenerDatosSillaFuncion(idSillaFuncion);
        GenerarPrecioBoleta precio = new GenerarPrecioBoleta(dataS.getSilla());
        GrabarRegistroBoleta registro = new GrabarRegistroBoleta(
                precio.getCosto(),"1",idSillaFuncion,idFactura);
        
    }
    
    
    
}
