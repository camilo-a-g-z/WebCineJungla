package logica;

/**
 * Esta clase maneja lo referente a los datos de las salas.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class Sala {

    //Espacios de la clase
    //Declaracion de variables
    private int idSala = 0;
    private String Numero = "";
    private int Multiplex_idMultiplex = 0;

    //metodos getters y setters
    //Metodo Get
    public int getIdSala() {
        return idSala;
    }
    //Cierre de metodo Get

    //Metodo Set
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }
    //Cierre de metodo Set

    //Metodo Get
    public String getNumero() {
        return Numero;
    }
    //Cierre de metodo Get

    //Metodo Set
    public void setNumero(String Numero) {
        this.Numero = Numero;
    }
    //Cierre de metodo Set

    //Metodo Get
    public int getMultiplex_idMultiplex() {
        return Multiplex_idMultiplex;
    }
    //Cierre de metodo Get

    //Metodo Set
    public void setMultiplex_idMultiplex(int Multiplex_idMultiplex) {
        this.Multiplex_idMultiplex = Multiplex_idMultiplex;
    }
    //Cierre de metodo Set
}
