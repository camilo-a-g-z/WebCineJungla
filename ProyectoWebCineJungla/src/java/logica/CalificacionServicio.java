package logica;

/**
 * Esta clase maneja los datos referentes a la calificacion de los servicios
 * brindados por la empresa.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class CalificacionServicio {

    //Espacios de la clase
    //Declaracion de variables
    private int idCalificacionServicio = 0;
    private Double Calificacion = 0.0;
    private int Cliente_idCliente = 0;
    private int FacturaCliente_idFacturaCliente = 0;

    //metodos setters y getters
    //Metodo Get
    public int getIdCalificacionServicio() {
        return idCalificacionServicio;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdCalificacionServicio(int idCalificacionServicio) {
        this.idCalificacionServicio = idCalificacionServicio;
    }
    //Cierre del metodo Set

    //Metodo Get
    public Double getCalificacion() {
        return Calificacion;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setCalificacion(Double Calificacion) {
        this.Calificacion = Calificacion;
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

    //Metodo Get
    public int getFacturaCliente_idFacturaCliente() {
        return FacturaCliente_idFacturaCliente;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setFacturaCliente_idFacturaCliente(int FacturaCliente_idFacturaCliente) {
        this.FacturaCliente_idFacturaCliente = FacturaCliente_idFacturaCliente;
    }
    //Cierre del metodo Set
}
