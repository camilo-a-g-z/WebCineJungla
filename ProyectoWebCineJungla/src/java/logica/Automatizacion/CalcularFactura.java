package logica.Automatizacion;

import datos.DBRegistroBoleta;
import datos.DBRegistroComida;

/**
 *
 * @author User
 */
public class CalcularFactura {
    private int idFactura = 0;

    public CalcularFactura(int idFactura) {
        this.idFactura = idFactura;
        proceso();
    }
    
    private void proceso(){
        try{
            DBRegistroBoleta DBrb = new DBRegistroBoleta();
            DBRegistroComida DBrc = new DBRegistroComida();
            //ResultSet
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
