package logica;

import java.sql.Date;

/**
 *
 * @author Camilo garcia
 */
public class FacturaRapida {
    private int idFacturaRapida = 0;
    private Double Total = 0.0;
    private int Año = 0;
    private int Mes = 0;
    private int Dia = 0;
    private int Empleado_idEmpleado = 0;
    //Metodos getters y setters

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }
    
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

    public int getEmpleado_idEmpleado() {
        return Empleado_idEmpleado;
    }

    public void setEmpleado_idEmpleado(int Empleado_idEmpleado) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
    }
    
}
