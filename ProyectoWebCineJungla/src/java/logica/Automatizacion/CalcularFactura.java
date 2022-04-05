package logica.Automatizacion;

import datos.DBFacturaCliente;
import datos.DBRegistroBoleta;
import datos.DBRegistroComida;
import java.sql.ResultSet;
import logica.FacturaCliente;

/**
 *
 * @author User
 */
public class CalcularFactura {
    private int idFactura = 0;
    private ResultSet res1;
    private ResultSet res2;
    private Double costo = 0.0;
    public CalcularFactura(int idFactura) {
        this.idFactura = idFactura;
        proceso();
    }
    
    private void proceso(){
        obtenerDatos();
        calcularCosto();
        enviarDB();
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
        try{
            while(res1.next()){
                costo += res1.getDouble("Precio");
            }
            while(res2.next()){
                costo += res2.getDouble("Precio");
            }
            System.out.println(costo);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void enviarDB(){
        ResultSet res3;
        FacturaCliente fc = new FacturaCliente();
        try{
            DBFacturaCliente DBf = new DBFacturaCliente();
            res3 = DBf.getFacturaClienteById(idFactura);
            res3.next();
            fc.setAño(res3.getInt("Año"));
            fc.setMes(res3.getInt("Mes"));
            fc.setDia(res3.getInt("Dia"));
            fc.setCliente_idCliente(res3.getInt("Cliente_idCliente"));
            fc.setIdFacturaCliente(res3.getInt("idFacturaCliente"));
            fc.setTotal(res3.getDouble("Total"));
            
            fc.setTotal(costo);
            
            DBf.modifyCliente(fc);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }
}
