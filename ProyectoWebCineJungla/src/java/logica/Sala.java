Dpackage logica;

/**
 *
 * @author Camilo Garcia
 */
public class Sala {
    private int idSala = 0;
    private String Numero = "";
    private int Multiplex_idMultiplex = 0;
    //metodos getters y setters

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public int getMultiplex_idMultiplex() {
        return Multiplex_idMultiplex;
    }

    public void setMultiplex_idMultiplex(int Multiplex_idMultiplex) {
        this.Multiplex_idMultiplex = Multiplex_idMultiplex;
    }
    
}
