package logica;

/**
 *
 * @author Camilo Garcia
 */
public class Multiplex {
    private int idMultiplex = 0;
    private String Nombre = "";
    private String Direccion = "";
    
    //Metodos Getters y Setters

    public int getIdMultiplex() {
        return idMultiplex;
    }

    public void setIdMultiplex(int idMultiplex) {
        this.idMultiplex = idMultiplex;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
}
