package logica;

/**
 * Esta clase maneja lo referente a los datos de las sillas en las proyecciones.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class SillaFuncion {

    //Espacios de la clase
    //Declaracion de variables
    private int idSillaFuncion = 0;
    private String Estado = "";
    private int Silla_idSilla = 0;
    private int Funcion_idFuncion = 0;

    //metodos getters y setters
    //Metodo Get
    public int getIdSillaFuncion() {
        return idSillaFuncion;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdSillaFuncion(int idSillaFuncion) {
        this.idSillaFuncion = idSillaFuncion;
    }
    //Cierre del metodo Set

    //Metodo Get
    public String getEstado() {
        return Estado;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getSilla_idSilla() {
        return Silla_idSilla;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setSilla_idSilla(int Silla_idSilla) {
        this.Silla_idSilla = Silla_idSilla;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getFuncion_idFuncion() {
        return Funcion_idFuncion;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setFuncion_idFuncion(int Funcion_idFuncion) {
        this.Funcion_idFuncion = Funcion_idFuncion;
    }
    //Cierre del metodo Set
}
