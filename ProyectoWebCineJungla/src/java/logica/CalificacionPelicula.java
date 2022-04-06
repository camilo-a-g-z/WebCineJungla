package logica;

/**
 * Esta clase maneja los datos referentes a la calificacion de peliculas
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class CalificacionPelicula {

    //Espacios de la clase
    //Declaracion de variables
    private int idCalificacionPelicula = 0;
    private Double Calificacion = 0.0;
    private int Cliente_idCliente = 0;
    private int Pelicula_idPelicula = 0;

    //Metodos getters y setters
    //Metodo Get
    public int getIdCalificacionPelicula() {
        return idCalificacionPelicula;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdCalificacionPelicula(int idCalificacionPelicula) {
        this.idCalificacionPelicula = idCalificacionPelicula;
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
    public int getPelicula_idPelicula() {
        return Pelicula_idPelicula;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setPelicula_idPelicula(int Pelicula_idPelicula) {
        this.Pelicula_idPelicula = Pelicula_idPelicula;
    }
    //Cierre del metodo Set
}
