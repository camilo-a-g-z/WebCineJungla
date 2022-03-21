package logica;

/**
 *
 * @author Camilo Garcia
 */
public class Funcion {
    private int idFuncion = 0;
    private String Horario = "";
    private int Sala_idSala = 0;
    private int Empleado_idEmpleado = 0;
    private int Pelicula_idPelicula = 0;
    //metodos setters y getters

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFucnion) {
        this.idFuncion = idFucnion;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public int getSala_idSala() {
        return Sala_idSala;
    }

    public void setSala_idSala(int Sala_idSala) {
        this.Sala_idSala = Sala_idSala;
    }

    public int getEmpleado_idEmpleado() {
        return Empleado_idEmpleado;
    }

    public void setEmpleado_idEmpleado(int Empleado_idEmpleado) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
    }

    public int getPelicula_idPelicula() {
        return Pelicula_idPelicula;
    }

    public void setPelicula_idPelicula(int Pelicula_idPelicula) {
        this.Pelicula_idPelicula = Pelicula_idPelicula;
    }
    
}
