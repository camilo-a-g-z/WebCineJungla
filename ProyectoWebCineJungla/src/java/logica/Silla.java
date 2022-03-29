package logica;

/**
 *
 * @author Camilo Garcia
 */
public class Silla {
    int idSilla = 0;
    String Tipo = "";
    String Ubicacion = "";
    int Sala_idSala = 0;
    //metodos getters y setters
    
    public int getIdSilla() {
        return idSilla;
    }

    public void setIdSilla(int idSilla) {
        this.idSilla = idSilla;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public int getSala_idSala() {
        return Sala_idSala;
    }

    public void setSala_idSala(int Sala_idSala) {
        this.Sala_idSala = Sala_idSala;
    }
    
}
