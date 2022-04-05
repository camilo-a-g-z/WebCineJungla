package logica;

/**
 * Esta clase maneja los datos referentes a las acciones disponibles para los
 * roles
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class AccionRol {

    //Espacios de la clase
    //Declaracion de variables de la clase
    private int idAccionRol = 0;
    private String Nombre = "";
    private int Rol_idRol = 0;

    //Metodos getters y setters
    //Metodo Get
    public int getIdAccionRol() {
        return idAccionRol;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdAccionRol(int idAccionRol) {
        this.idAccionRol = idAccionRol;
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
    public int getRol_idRol() {
        return Rol_idRol;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setRol_idRol(int Rol_idRol) {
        this.Rol_idRol = Rol_idRol;
    }
    //Cierre del metodo Set
}
