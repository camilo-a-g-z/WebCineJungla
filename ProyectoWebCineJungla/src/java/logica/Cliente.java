package logica;

/**
 *
 * @author Camilo Garcia
 */
public class Cliente {
    private int idCliente = 0;
    private String Nombre = "";
    private Double PuntosJungla = 0.0;
    private String Correo = "";
    private String HashPsw = "";
    private int MedioPago_idMedioPago = 0;
    
    //metodos getters y setters
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Double getPuntosJungla() {
        return PuntosJungla;
    }

    public void setPuntosJungla(Double PuntosJungla) {
        this.PuntosJungla = PuntosJungla;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getHashPsw() {
        return HashPsw;
    }

    public void setHashPsw(String HashPsw) {
        this.HashPsw = HashPsw;
    }

    public int getMedioPago_idMedioPago() {
        return MedioPago_idMedioPago;
    }

    public void setMedioPago_idMedioPago(int MedioPago_idMedioPago) {
        this.MedioPago_idMedioPago = MedioPago_idMedioPago;
    }
    
}
