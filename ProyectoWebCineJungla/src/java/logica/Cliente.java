package logica;

/**
 * Esta clase maneja todo lo referente a los datos del cliente.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class Cliente {

    //Espacios de la clase
    //Declaracion de variables
    private int idCliente = 0;
    private String Nombre = "";
    private Double PuntosJungla = 0.0;
    private String Correo = "";
    private String HashPsw = "";
    private int MedioPago_idMedioPago = 0;

    //metodos getters y setters
    //Metodo Get
    public int getIdCliente() {
        return idCliente;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
    public Double getPuntosJungla() {
        return PuntosJungla;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setPuntosJungla(Double PuntosJungla) {
        this.PuntosJungla = PuntosJungla;
    }
    //Cierre del metodo Set

    //Metodo Get
    public String getCorreo() {
        return Correo;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    //Cierre del metodo Set

    //Metodo Get
    public String getHashPsw() {
        return HashPsw;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setHashPsw(String HashPsw) {
        this.HashPsw = HashPsw;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getMedioPago_idMedioPago() {
        return MedioPago_idMedioPago;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setMedioPago_idMedioPago(int MedioPago_idMedioPago) {
        this.MedioPago_idMedioPago = MedioPago_idMedioPago;
    }
    //Cierre del metodo Set

}
