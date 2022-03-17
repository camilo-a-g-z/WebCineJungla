package logica;

/**
 *
 * @author Camilo Garcia
 */
public class RegistroComida {
    private int idRegistroComida = 0;
    private String Cantidad = "";
    private Double Precio = 0.0;
    private int Comida_idComida = 0;
    private int FacturaRapida_idFacturaRapida;
    private int FacturaCliente_idFacturaCliente;
    //Metodos getters y setters 

    public int getIdRegistroComida() {
        return idRegistroComida;
    }

    public void setIdRegistroComida(int idRegistroComida) {
        this.idRegistroComida = idRegistroComida;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public int getComida_idComida() {
        return Comida_idComida;
    }

    public void setComida_idComida(int Comida_idComida) {
        this.Comida_idComida = Comida_idComida;
    }

    public int getFacturaRapida_idFacturaRapida() {
        return FacturaRapida_idFacturaRapida;
    }

    public void setFacturaRapida_idFacturaRapida(int FacturaRapida_idFacturaRapida) {
        this.FacturaRapida_idFacturaRapida = FacturaRapida_idFacturaRapida;
    }

    public int getFacturaCliente_idFacturaCliente() {
        return FacturaCliente_idFacturaCliente;
    }

    public void setFacturaCliente_idFacturaCliente(int FacturaCliente_idFacturaCliente) {
        this.FacturaCliente_idFacturaCliente = FacturaCliente_idFacturaCliente;
    }
    
}
