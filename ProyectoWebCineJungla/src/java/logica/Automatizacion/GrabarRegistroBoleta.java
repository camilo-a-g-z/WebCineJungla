package logica.Automatizacion;

import datos.DBRegistroBoleta;
import logica.RegistroBoleta;

/**
 *
 * Clase que se encarga grabar registro de la boleta en la DB
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class GrabarRegistroBoleta {

    //Campos de la clase
    //Declaracion de variables
    RegistroBoleta rb = new RegistroBoleta();

    /**
     * Metodo constructor de la clase, se llama al metodo enviarRegistroCliente
     *
     * @param precio
     * @param Cantidad
     * @param SillaFuncion_idSillaFuncion
     * @param FacturaCliente_idFacturaCliente
     */
    public GrabarRegistroBoleta(Double precio,
            String Cantidad,
            int SillaFuncion_idSillaFuncion,
            int FacturaCliente_idFacturaCliente) {
        this.rb.setCantidad(Cantidad);
        this.rb.setPrecio(precio);
        this.rb.setSillaFuncion_idSillaFuncion(SillaFuncion_idSillaFuncion);
        this.rb.setFacturaCliente_idFacturaCliente(FacturaCliente_idFacturaCliente);
        enviarRegistroCliente();
    }
    //Cierre del metodo

    /**
     * Metodo que intenta enviar el registro del cliente a la DB
     */
    private void enviarRegistroCliente() {
        try {
            DBRegistroBoleta DBrb = new DBRegistroBoleta();
            DBrb.insertarRegistroBoletaToFacturaCliente(rb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Cierre del metodo

}
