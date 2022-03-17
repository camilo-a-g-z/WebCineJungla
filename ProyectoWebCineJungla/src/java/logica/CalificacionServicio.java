package logica;

/**
 *
 * @author Camilo Garcia
 */
public class CalificacionServicio {
    private int idCalificacionServicio = 0;
    private Double Calificacion = 0.0;
    private int Cliente_idCliente = 0;
    private int FacturaCliente_idFacturaCliente = 0;
    //metodos setters y getters

    public int getIdCalificacionServicio() {
        return idCalificacionServicio;
    }

    public void setIdCalificacionServicio(int idCalificacionServicio) {
        this.idCalificacionServicio = idCalificacionServicio;
    }

    public Double getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(Double Calificacion) {
        this.Calificacion = Calificacion;
    }

    public int getCliente_idCliente() {
        return Cliente_idCliente;
    }

    public void setCliente_idCliente(int Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }

    public int getFacturaCliente_idFacturaCliente() {
        return FacturaCliente_idFacturaCliente;
    }

    public void setFacturaCliente_idFacturaCliente(int FacturaCliente_idFacturaCliente) {
        this.FacturaCliente_idFacturaCliente = FacturaCliente_idFacturaCliente;
    }
    
}
