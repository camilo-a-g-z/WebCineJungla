package logica.Automatizacion;

/**
 *
 * Esta clase genera un ticket segun la silla y la funcion
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class GenerarRegistroTicket {

    //Campos de la clase
    //Declaracion de variables
    private int idSillaFuncion = 0;
    private int idFactura = 0;

    /**
     * Metodo constructor de la clase, llama al metodo proceso
     *
     * @param idSillaFuncion
     * @param idFactura
     */
    public GenerarRegistroTicket(int idSillaFuncion, int idFactura) {
        this.idSillaFuncion = idSillaFuncion;
        this.idFactura = idFactura;
        proceso();
    }
    //Cierre del metodo
    
    public GenerarRegistroTicket(int idSillaFuncion, int idFactura, int i) {
        this.idSillaFuncion = idSillaFuncion;
        this.idFactura = idFactura;
        proceso2();
    }

    /**
     * Metodo que se encarga de obtener y grabar el registro de la boleta
     */
    private void proceso() {
        ObtenerDatosSillaFuncion dataS = new ObtenerDatosSillaFuncion(idSillaFuncion);
        GenerarPrecioBoleta precio = new GenerarPrecioBoleta(dataS.getSilla());
        GrabarRegistroBoleta registro = new GrabarRegistroBoleta(
                precio.getCosto(), "1", idSillaFuncion, idFactura);

    }
    //Cierre del metodo
    private void proceso2() {
        ObtenerDatosSillaFuncion dataS = new ObtenerDatosSillaFuncion(idSillaFuncion);
        GenerarPrecioBoleta precio = new GenerarPrecioBoleta(dataS.getSilla());
        GrabarRegistroBoleta registro = new GrabarRegistroBoleta(
                precio.getCosto(), "1", idSillaFuncion, idFactura,1);

    }
}
