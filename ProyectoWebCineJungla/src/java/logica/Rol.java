package logica;

/**
 * Esta clase maneja todo lo referente a los roles de empleados en la empresa.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class Rol {

    //Espacios de la clase
    //Declaracion de variables
    private int idRol = 0;
    private String Nombre = "";

    //metodos getters y setters
    //Metodo Get
    public int getIdRol() {
        return idRol;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdRol(int idRol) {
        this.idRol = idRol;
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
