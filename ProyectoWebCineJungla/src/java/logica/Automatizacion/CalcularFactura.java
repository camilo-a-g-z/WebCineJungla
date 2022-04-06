package logica.Automatizacion;

import datos.DBFacturaCliente;
import datos.DBFacturaRapida;
import datos.DBRegistroBoleta;
import datos.DBRegistroComida;
import java.sql.ResultSet;
import logica.FacturaCliente;
import logica.FacturaRapida;

/**
 * Esta clase se encarga de procesar los datos de la factura del cliente. para
 * asi obtener el total final
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class CalcularFactura {

    //Campos de la clase
    //Declaracion de variables
    private int idFactura = 0;
    private ResultSet res1;
    private ResultSet res2;
    private Double costo = 0.0;

    /**
     * Constructor de la clase, llama al metodo proceso
     *
     * @param idFactura
     */
    public CalcularFactura(int idFactura) {
        this.idFactura = idFactura;
        proceso();
    }
    //Cierre del constructor
    /**
     * Constructor de la clase, llama al metodo proceso
     *
     * @param idFactura
     */
    public CalcularFactura(int idFactura,int i) {
        this.idFactura = idFactura;
        proceso2();
    }
    //Cierre del constructor
    //Metodo que llama a otros metodos
    private void proceso() {
        obtenerDatos();
        calcularCosto();
        enviarDB();
    }
    //Cierre del metodo
    //Metodo que llama a otros metodos
    private void proceso2() {
        obtenerDatos2();
        calcularCosto();
        enviarDB2();
    }
    //Cierre del metodo
    //Metodo que obtiene los datos de la factura de la boleta
    //Y de la confiteria
    private void obtenerDatos() {
        try {
            DBRegistroBoleta DBrb = new DBRegistroBoleta();
            DBRegistroComida DBrc = new DBRegistroComida();
            res1 = DBrb.getRegistroBoletaByFacturaCliente(idFactura);
            res2 = DBrc.getRegistroComidaByFacturaCliente(idFactura);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Cierre del metodo
    private void obtenerDatos2() {
        try {
            DBRegistroBoleta DBrb = new DBRegistroBoleta();
            DBRegistroComida DBrc = new DBRegistroComida();
            res1 = DBrb.getRegistroBoletaByFacturaRapida(idFactura);
            res2 = DBrc.getRegistroComidaByFacturaRapida(idFactura);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Metodo que calcula el valor de los costos de la factura del cliente
     */
    private void calcularCosto() {
        try {
            while (res1.next()) {
                costo += res1.getDouble("Precio");
            }
            while (res2.next()) {
                costo += res2.getDouble("Precio");
            }
            System.out.println(costo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que obtiene los datos de la factura y los envia a la DB
     */
    private void enviarDB() {
        ResultSet res3;
        FacturaCliente fc = new FacturaCliente();
        try {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    private void enviarDB2() {
        ResultSet res3;
        FacturaRapida fc = new FacturaRapida();
        try {
            DBFacturaRapida DBf = new DBFacturaRapida();
            res3 = DBf.getFacturaRapidaById(idFactura);
            res3.next();
            fc.setAño(res3.getInt("Año"));
            fc.setMes(res3.getInt("Mes"));
            fc.setDia(res3.getInt("Dia"));
            fc.setEmpleado_idEmpleado(res3.getInt("Empleado_idEmpleado"));
            fc.setIdFacturaRapida(res3.getInt("idFacturaRapida"));
            fc.setTotal(res3.getDouble("Total"));

            fc.setTotal(costo);

            DBf.modifyCliente(fc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    //Cierre del metodo
}
