package logica;

/**
 *
 * @author Camilo Garcia
 */
public class CalificacionPelicula {
    private int idCalificacionPelicula = 0;
    private Double Calificacion = 0.0;
    private int Cliente_idCliente = 0;
    private int Pelicula_idPelicula = 0;
    //Metodos getters y setters

    public int getIdCalificacionPelicula() {
        return idCalificacionPelicula;
    }

    public void setIdCalificacionPelicula(int idCalificacionPelicula) {
        this.idCalificacionPelicula = idCalificacionPelicula;
    }

    public Double getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(Double Calificacion) {
        this.Calificacion = Calificacion;
    }

    public int getCliente_idCliente() {
        return Cliente_idCliente;
    }

    public void setCliente_idCliente(int Cliente_idCliente) {
        this.Cliente_idCliente = Cliente_idCliente;
    }

    public int getPelicula_idPelicula() {
        return Pelicula_idPelicula;
    }

    public void setPelicula_idPelicula(int Pelicula_idPelicula) {
        this.Pelicula_idPelicula = Pelicula_idPelicula;
    }
    
}
