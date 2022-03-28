package logica;

/**
 *
 * @author Camilo Garcia
 */
public class Pelicula {
    private int idPelicula = 0;
    private String Nombre = "";
    private String ClasificacionEdad = "";
    private Double Duracion = 0.0;
    private String Director = "";
    private String Sinopsis = "";
    private String UrlPelicula = "";
    private String Estado = "";
    //metodos setters y getters

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public String getUrlPelicula() {
        return UrlPelicula;
    }

    public void setUrlPelicula(String UrlPelicula) {
        this.UrlPelicula = UrlPelicula;
    }
    
    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClasificacionEdad() {
        return ClasificacionEdad;
    }

    public void setClasificacionEdad(String ClasificacionEdad) {
        this.ClasificacionEdad = ClasificacionEdad;
    }

    

    public Double getDuracion() {
        return Duracion;
    }

    public void setDuracion(Double Duracion) {
        this.Duracion = Duracion;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public void setSinopsis(String Sinopsis) {
        this.Sinopsis = Sinopsis;
    }
    
}
