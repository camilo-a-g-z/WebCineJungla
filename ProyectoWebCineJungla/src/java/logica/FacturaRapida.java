package logica;

import java.sql.Date;

/**
 *
 * @author Camilo garcia
 */
public class FacturaRapida {
    private int idFacturaRapida = 0;
    private Double Total = 0.0;
    private Date Fecha;
    private int Empleado_idEmpleado = 0;
    //Metodos getters y setters

    public int getIdFacturaRapida() {
        return idFacturaRapida;
    }

    public void setIdFacturaRapida(int idFacturaRapida) {
        this.idFacturaRapida = idFacturaRapida;
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

    public int getEmpleado_idEmpleado() {
        return Empleado_idEmpleado;
    }

    public void setEmpleado_idEmpleado(int Empleado_idEmpleado) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
    }
    
}
