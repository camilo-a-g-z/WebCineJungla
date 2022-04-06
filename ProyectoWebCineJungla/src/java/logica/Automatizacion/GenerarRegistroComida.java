package logica.Automatizacion;

import com.mysql.cj.protocol.Resultset;
import datos.DBComida;
import datos.DBRegistroComida;
import java.sql.ResultSet;
import logica.Comida;
import logica.RegistroComida;

/**
 * Esta clase se encarga de obtener, procesar y generar registros de la
 * confiteria
 *
 * * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno -
 * Cristian C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class GenerarRegistroComida {

//Campos de la clase
    //Declaracion de variables
    private int idComida = 0;
    private int idFactura = 0;
    private int cantidad = 0;
    private Double precio = 0.0;
    private Comida comida = new Comida();

    /**
     * Constructor de la clase, llama al metodo proceso
     *
     * @param idComida
     * @param idFactura
     * @param cantidad
     */
    public GenerarRegistroComida(int idComida, int idFactura, int cantidad) {
        this.cantidad = cantidad;
        this.idFactura = idFactura;
        this.idComida = idComida;
        proceso();
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de llamar a 3 metodos
     */
    private void proceso() {
        cargarComida();
        calcularPrecio();
        generarRegistro();
    }
    //Cierre del metodo

    /**
     * Este metodo se encarga de obtener los datos de la comida de la BD y
     * guardarla en un objeto comida
     */
    private void cargarComida() {
        try {
            DBComida DBc = new DBComida();
            ResultSet res1 = DBc.getComidaById(idComida);
            res1.next();
            comida.setIdComida(res1.getInt("idComida"));
            comida.setMultiplex_idMultiplex(res1.getInt("Multiplex_idMultiplex"));
            comida.setNombre(res1.getString("Nombre"));
            comida.setPrecio(res1.getDouble("Precio"));
            comida.setStock(res1.getDouble("Stock"));
            comida.setUrlImagen(res1.getString("UrlImagen"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Cierre del metodo
    /**
     * Este metodo se encarga de calcular el precio de la comida
     */
    private void calcularPrecio() {
        precio = cantidad * comida.getPrecio();
    }
    //Cierre del metodo

    /**
     * Metodo que se encarga de registrar los datos de la comida y su precio en
     * la factura del cliente en la BD
     */
    private void generarRegistro() {
        try {
            RegistroComida rc = new RegistroComida();
            rc.setCantidad(String.valueOf(cantidad));
            rc.setComida_idComida(idComida);
            rc.setFacturaCliente_idFacturaCliente(idFactura);
            rc.setPrecio(precio);
            DBRegistroComida DBrc = new DBRegistroComida();
            DBrc.insertarRegistroComidaToFacturaCliente(rc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Cierre del metodo
}
