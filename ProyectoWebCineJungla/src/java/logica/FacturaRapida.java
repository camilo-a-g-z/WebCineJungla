package logica;

import java.sql.Date;

/**
 * Esta clase maneja todo lo referente a los datos de la facturacion.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class FacturaRapida {

    //Espacios de la clase
    //Declaracion de variables
    private int idFacturaRapida = 0;
    private Double Total = 0.0;
    private int Año = 0;
    private int Mes = 0;
    private int Dia = 0;
    private int Empleado_idEmpleado = 0;

    //Metodos getters y setters
    //Metodo Get
    public int getAño() {
        return Año;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setAño(int Año) {
        this.Año = Año;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getMes() {
        return Mes;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setMes(int Mes) {
        this.Mes = Mes;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getDia() {
        return Dia;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setDia(int Dia) {
        this.Dia = Dia;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getIdFacturaRapida() {
        return idFacturaRapida;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdFacturaRapida(int idFacturaRapida) {
        this.idFacturaRapida = idFacturaRapida;
    }
    //Cierre del metodo Set

    //Metodo Get
    public Double getTotal() {
        return Total;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setTotal(Double Total) {
        this.Total = Total;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getEmpleado_idEmpleado() {
        return Empleado_idEmpleado;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setEmpleado_idEmpleado(int Empleado_idEmpleado) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
    }
    //Cierre del metodo Set
}
