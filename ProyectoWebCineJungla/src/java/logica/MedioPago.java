package logica;

/**
 * Esta clase maneja todo lo referente a los datos de medio de Pago disponibles.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class MedioPago {
    private int idMedioPago = 0;
    private String Nombre = "";
    
    //Metodos Getters  y Setters
    //Metodo Get
    public int getIdMedioPago() {
        return idMedioPago;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }
    //Cierre del metodo Set

    //Metodo Get
    public String getNombre() {
        return Nombre;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    //Cierre del metodo Set
}
