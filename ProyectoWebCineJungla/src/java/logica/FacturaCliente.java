package logica;

import java.sql.Date;

/**
 * Esta clase maneja todo lo referente a los datos de la facturacion del 
 * cliente.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class FacturaCliente {

    //Espacio de las clases
    //Declaracion de variables
    private int idFacturaCliente = 0;
    private Double Total = 0.0;
    private int Año = 0;
    private int Mes = 0;
    private int Dia = 0;
    private int Cliente_idCliente = 0;

    //metodos getters y setters
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
    public int getIdFacturaCliente() {
        return idFacturaCliente;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdFacturaCliente(int idFacturaCliente) {
        this.idFacturaCliente = idFacturaCliente;
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
    public int getCliente_idCliente() {
        return Cliente_idCliente;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setCliente_idCliente(int Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }
    //Cierre del metodo Set
}
