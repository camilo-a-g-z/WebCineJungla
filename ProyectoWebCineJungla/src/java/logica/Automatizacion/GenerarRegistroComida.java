package logica.Automatizacion;

import com.mysql.cj.protocol.Resultset;
import datos.DBComida;
import datos.DBRegistroComida;
import java.sql.ResultSet;
import logica.Comida;
import logica.RegistroComida;

/**
 *
 * @author User
 */
public class GenerarRegistroComida {
    private int idComida = 0;
    private int idFactura =0;
    private int cantidad = 0;
    private Double precio = 0.0;
    private Comida comida = new Comida();

    public GenerarRegistroComida(int idComida, int idFactura, int cantidad) {
        this.cantidad = cantidad;
        this.idFactura = idFactura;
        this.idComida = idComida;
        proceso();
    }
    
    private void proceso(){
        cargarComida();
        calcularPrecio();
        generarRegistro();
    }
    private void cargarComida(){
        try{
            DBComida DBc = new DBComida();
            ResultSet res1 = DBc.getComidaById(idComida);
            res1.next();
            comida.setIdComida(res1.getInt("idComida"));
            comida.setMultiplex_idMultiplex(res1.getInt("Multiplex_idMultiplex"));
            comida.setNombre(res1.getString("Nombre"));
            comida.setPrecio(res1.getDouble("Precio"));
            comida.setStock(res1.getDouble("Stock"));
            comida.setUrlImagen(res1.getString("UrlImagen"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void calcularPrecio(){
        precio = cantidad * comida.getPrecio();
    }
    
    private void generarRegistro(){
        try{
            RegistroComida rc = new RegistroComida();
            rc.setCantidad(String.valueOf(cantidad));
            rc.setComida_idComida(idComida);
            rc.setFacturaCliente_idFacturaCliente(idFactura);
            rc.setPrecio(precio);
            DBRegistroComida DBrc = new DBRegistroComida();
            DBrc.insertarRegistroComidaToFacturaCliente(rc);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
