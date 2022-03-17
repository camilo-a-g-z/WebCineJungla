package logica;

/**
 *
 * @author Camilo Garcia
 */
public class RegistroBoleta {
    private int idRegistroBoleta = 0;
    private Double Precio = 0.0;
    private String Cantidad = "";
    private int SillaFuncion_idSillaFuncion = 0;
    private int FacturaRapida_idFacturaRapida;
    private int FacturaCliente_idFacturaCliente;
    //metodos setters y getters

    public int getIdRegistroBoleta() {
        return idRegistroBoleta;
    }

    public void setIdRegistroBoleta(int idRegistroBoleta) {
        this.idRegistroBoleta = idRegistroBoleta;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getSillaFuncion_idSillaFuncion() {
        return SillaFuncion_idSillaFuncion;
    }

    public void setSillaFuncion_idSillaFuncion(int SillaFuncion_idSillaFuncion) {
        this.SillaFuncion_idSillaFuncion = SillaFuncion_idSillaFuncion;
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
