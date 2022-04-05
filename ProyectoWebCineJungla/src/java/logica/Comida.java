package logica;

/**
 * Esta clase maneja todo lo referente a los datos de los productos comestibles 
 * ofrecidos.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class Comida {

    //Espacios de la clase
    //Declaracion de variables 
    private int idComida = 0;
    private String Nombre = "";
    private Double Precio = 0.0;
    private Double Stock = 0.0;
    private int Multiplex_idMultiplex = 0;
    private String UrlImagen = "";

    //metodos getters y setters
    //Metodo Get
    public String getUrlImagen() {
        return UrlImagen;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setUrlImagen(String UrlImagen) {
        this.UrlImagen = UrlImagen;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getIdComida() {
        return idComida;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdComida(int idComida) {
        this.idComida = idComida;
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
    public Double getPrecio() {
        return Precio;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }
    //Cierre del metodo Set

    //Metodo Get
    public Double getStock() {
        return Stock;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setStock(Double Stock) {
        this.Stock = Stock;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getMultiplex_idMultiplex() {
        return Multiplex_idMultiplex;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setMultiplex_idMultiplex(int Multiplex_idMultiplex) {
        this.Multiplex_idMultiplex = Multiplex_idMultiplex;
    }
    //Cierre del metodo Set
}
