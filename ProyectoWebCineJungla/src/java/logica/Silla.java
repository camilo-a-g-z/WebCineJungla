package logica;

/**
 * Esta clase maneja lo referente a los datos de las sillas.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class Silla {
    
    //Espacios de la clase
    int idSilla = 0;
    String Tipo = "";
    String Ubicacion = "";
    int Sala_idSala = 0;
    
    //metodos getters y setters
    //Metodo Get
    public int getIdSilla() {
        return idSilla;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdSilla(int idSilla) {
        this.idSilla = idSilla;
    }
    //Cierre del metodo Set

    //Metodo Get
    public String getTipo() {
        return Tipo;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    //Cierre del metodo Set

    //Metodo Get
    public String getUbicacion() {
        return Ubicacion;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getSala_idSala() {
        return Sala_idSala;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setSala_idSala(int Sala_idSala) {
        this.Sala_idSala = Sala_idSala;
    }
    //Cierre del metodo Set
}
