package logica;

import java.sql.Date;

/**
 *
 * @author Camilo Garcia
 */
public class FacturaCliente {
    private int idFacturaCliente = 0;
    private Double Total = 0.0;
    private Date Fecha;
    private int Cliente_idCliente = 0;
    //metodos getters y setters

    public int getIdFacturaCliente() {
        return idFacturaCliente;
    }

    public void setIdFacturaCliente(int idFacturaCliente) {
        this.idFacturaCliente = idFacturaCliente;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getCliente_idCliente() {
        return Cliente_idCliente;
    }

    public void setCliente_idCliente(int Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }
    
}
