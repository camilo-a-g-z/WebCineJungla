package logica.Automatizacion;

import datos.DBRegistroBoleta;
import datos.DBRegistroComida;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class CalcularFactura {
    private int idFactura = 0;
    private ResultSet res1;
    private ResultSet res2;
    private Double costo;
    public CalcularFactura(int idFactura) {
        this.idFactura = idFactura;
        proceso();
    }
    
    private void proceso(){
        obtenerDatos();
        calcularCosto();
    }
    private void obtenerDatos(){
        try{
            DBRegistroBoleta DBrb = new DBRegistroBoleta();
            DBRegistroComida DBrc = new DBRegistroComida();
            res1 = DBrb.getRegistroBoletaByFacturaCliente(idFactura);
            res2 = DBrc.getRegistroComidaByFacturaCliente(idFactura);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void calcularCosto(){
        
    }
}
