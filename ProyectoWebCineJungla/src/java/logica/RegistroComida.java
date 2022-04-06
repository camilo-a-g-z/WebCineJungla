package logica;

/**
 * Esta clase maneja todo lo referente a los registros de la confiteria.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class RegistroComida {

    //Espacios de la clase
    //Declaracion de varaiables
    private int idRegistroComida = 0;
    private String Cantidad = "";
    private Double Precio = 0.0;
    private int Comida_idComida = 0;
    private int FacturaRapida_idFacturaRapida;
    private int FacturaCliente_idFacturaCliente;

    //Metodos getters y setters 
    //Metodo Get
    public int getIdRegistroComida() {
        return idRegistroComida;
    }
    //Cierre del Metodo Get

    //Metodo Set
    public void setIdRegistroComida(int idRegistroComida) {
        this.idRegistroComida = idRegistroComida;
    }
    //Cierre del Metodo Set

    //Metodo Get
    public String getCantidad() {
        return Cantidad;
    }
    //Cierre del Metodo Get

    //Metodo Set
    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }
    //Cierre del Metodo Set

    //Metodo Get    
    public Double getPrecio() {
        return Precio;
    }
    //Cierre del Metodo Get

    //Metodo Set
    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }
    //Cierre del Metodo Set

    //Metodo Get
    public int getComida_idComida() {
        return Comida_idComida;
    }
    //Cierre del Metodo Get

    //Metodo Set
    public void setComida_idComida(int Comida_idComida) {
        this.Comida_idComida = Comida_idComida;
    }
    //Cierre del Metodo Set

    //Metodo Get
    public int getFacturaRapida_idFacturaRapida() {
        return FacturaRapida_idFacturaRapida;
    }
    //Cierre del Metodo get

    //Metodo Set
    public void setFacturaRapida_idFacturaRapida(int FacturaRapida_idFacturaRapida) {
        this.FacturaRapida_idFacturaRapida = FacturaRapida_idFacturaRapida;
    }
    //Cierre del Metodo Set

    //Metodo Get
    public int getFacturaCliente_idFacturaCliente() {
        return FacturaCliente_idFacturaCliente;
    }
    //Cierre del Metodo Get

    //Metodo Set
    public void setFacturaCliente_idFacturaCliente(int FacturaCliente_idFacturaCliente) {
        this.FacturaCliente_idFacturaCliente = FacturaCliente_idFacturaCliente;
    }
    //Cierre del Metodo Set
}
