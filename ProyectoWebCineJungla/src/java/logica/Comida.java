package logica;

/**
 *
 * @author Camilo Garcia
 */
public class Comida {
    private int idComida = 0;
    private String Nombre = "";
    private Double Precio = 0.0;
    private Double Stock = 0.0;
    private int Multiplex_idMultiplex = 0;
    private String UrlImagen = "";
    //metodos getters y setters

    public String getUrlImagen() {
        return UrlImagen;
    }

    public void setUrlImagen(String UrlImagen) {
        this.UrlImagen = UrlImagen;
    }
    
    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public Double getStock() {
        return Stock;
    }

    public void setStock(Double Stock) {
        this.Stock = Stock;
    }

    public int getMultiplex_idMultiplex() {
        return Multiplex_idMultiplex;
    }

    public void setMultiplex_idMultiplex(int Multiplex_idMultiplex) {
        this.Multiplex_idMultiplex = Multiplex_idMultiplex;
    }
    
}
