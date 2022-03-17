package logica;

/**
 *
 * @author Camilo Garcia
 */
public class SillaFuncion {
    private int idSillaFuncion = 0;
    private String Estado = "";
    private int Silla_idSilla = 0;
    private int Funcion_idFuncion = 0;
    //metodos getters y setters

    public int getIdSillaFuncion() {
        return idSillaFuncion;
    }

    public void setIdSillaFuncion(int idSillaFuncion) {
        this.idSillaFuncion = idSillaFuncion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getSilla_idSilla() {
        return Silla_idSilla;
    }

    public void setSilla_idSilla(int Silla_idSilla) {
        this.Silla_idSilla = Silla_idSilla;
    }

    public int getFuncion_idFuncion() {
        return Funcion_idFuncion;
    }

    public void setFuncion_idFuncion(int Funcion_idFuncion) {
        this.Funcion_idFuncion = Funcion_idFuncion;
    }
    
}
