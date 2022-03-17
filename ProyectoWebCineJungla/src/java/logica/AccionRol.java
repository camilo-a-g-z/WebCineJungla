package logica;

/**
 *
 * @author Camilo Garcia
 */
public class AccionRol {
    private int idAccionRol = 0;
    private String Nombre = "";
    private int Rol_idRol = 0;
    //Metodos getters y setters

    public int getIdAccionRol() {
        return idAccionRol;
    }

    public void setIdAccionRol(int idAccionRol) {
        this.idAccionRol = idAccionRol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getRol_idRol() {
        return Rol_idRol;
    }

    public void setRol_idRol(int Rol_idRol) {
        this.Rol_idRol = Rol_idRol;
    }
    
}
