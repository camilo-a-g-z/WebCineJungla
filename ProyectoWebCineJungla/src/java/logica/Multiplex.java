package logica;

/**
 * Esta clase maneja todo lo referente a los datos de los multiplex
 * pertenecientes a la empresa.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class Multiplex {

    //Espacios de la clase
    //Declaracion de variables
    private int idMultiplex = 0;
    private String Nombre = "";
    private String Direccion = "";

    //Metodos Getters y Setters
    //Metodo Get
    public int getIdMultiplex() {
        return idMultiplex;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdMultiplex(int idMultiplex) {
        this.idMultiplex = idMultiplex;
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

    //Metodo Get
    public String getDireccion() {
        return Direccion;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    //Cierre del metodo Set
}
