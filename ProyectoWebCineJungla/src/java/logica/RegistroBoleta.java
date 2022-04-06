package logica;

/**
 * Esta clase maneja todo lo referente a los registros de la boleteria.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class RegistroBoleta {

    //Espacios de la clase
    //Declaracion de variables
    private int idRegistroBoleta = 0;
    private Double Precio = 0.0;
    private String Cantidad = "";
    private int SillaFuncion_idSillaFuncion = 0;
    private int FacturaRapida_idFacturaRapida;
    private int FacturaCliente_idFacturaCliente;

    //metodos setters y getters
    //Metodo Get
    public int getIdRegistroBoleta() {
        return idRegistroBoleta;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdRegistroBoleta(int idRegistroBoleta) {
        this.idRegistroBoleta = idRegistroBoleta;
    }
    //Cierre del metodo Set

    //Metodo Get
    public Double getPrecio() {
        return Precio;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }
    //Cierre del metodo Set

    //Metodo Get
    public String getCantidad() {
        return Cantidad;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getSillaFuncion_idSillaFuncion() {
        return SillaFuncion_idSillaFuncion;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setSillaFuncion_idSillaFuncion(int SillaFuncion_idSillaFuncion) {
        this.SillaFuncion_idSillaFuncion = SillaFuncion_idSillaFuncion;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getFacturaRapida_idFacturaRapida() {
        return FacturaRapida_idFacturaRapida;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setFacturaRapida_idFacturaRapida(int FacturaRapida_idFacturaRapida) {
        this.FacturaRapida_idFacturaRapida = FacturaRapida_idFacturaRapida;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getFacturaCliente_idFacturaCliente() {
        return FacturaCliente_idFacturaCliente;
    }//Cierre del metodo Get

    //Metodo Set    
    public void setFacturaCliente_idFacturaCliente(int FacturaCliente_idFacturaCliente) {
        this.FacturaCliente_idFacturaCliente = FacturaCliente_idFacturaCliente;
    }
    //Cierre del metodo Set

}
