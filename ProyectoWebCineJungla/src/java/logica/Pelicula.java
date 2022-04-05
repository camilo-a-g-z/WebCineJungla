package logica;

/**
 * Esta clase maneja todo lo referente a los datos de las peliculas proyectadas.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class Pelicula {
    
    //Espacios de la clase
    //Declaracion de variables
    private int idPelicula = 0;
    private String Nombre = "";
    private String ClasificacionEdad = "";
    private int Duracion = 0;
    private String Director = "";
    private String Sinopsis = "";
    private String UrlPelicula = "";
    private String Estado = "";
    
    //metodos setters y getters
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
    public String getUrlPelicula() {
        return UrlPelicula;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setUrlPelicula(String UrlPelicula) {
        this.UrlPelicula = UrlPelicula;
    }
    //Cierre del metodo Set
    
    //Metodo Get
    public int getIdPelicula() {
        return idPelicula;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
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
    public String getClasificacionEdad() {
        return ClasificacionEdad;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setClasificacionEdad(String ClasificacionEdad) {
        this.ClasificacionEdad = ClasificacionEdad;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getDuracion() {
        return Duracion;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }
    //Cierre del metodo Set

    //Metodo Get
    public String getDirector() {
        return Director;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setDirector(String Director) {
        this.Director = Director;
    }
    //Cierre del metodo Set

    //Metodo Get
    public String getSinopsis() {
        return Sinopsis;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setSinopsis(String Sinopsis) {
        this.Sinopsis = Sinopsis;
    }
    //Cierre del metodo Set
}
