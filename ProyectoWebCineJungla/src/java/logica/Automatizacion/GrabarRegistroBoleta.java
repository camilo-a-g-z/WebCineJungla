package logica.Automatizacion;

import datos.DBRegistroBoleta;
import logica.RegistroBoleta;

/**
 *
 * @author Camilo Garcia
 */
public class GrabarRegistroBoleta {
    RegistroBoleta rb = new RegistroBoleta();

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
    
    private void enviarRegistroCliente(){
        try{
            DBRegistroBoleta DBrb = new DBRegistroBoleta();
            DBrb.insertarRegistroBoletaToFacturaCliente(rb);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
