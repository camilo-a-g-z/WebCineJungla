package logica;

import java.util.Date;

/**
 *
 * @author Camilo Garcia
 */
public class Funcion {
    private int idFuncion = 0;
    private Date Horario;
    private int Sala_idSala = 0;
    private int Empleado_idEmpleado = 0;
    private int Pelicula_idPelicula = 0;
    private int Duracion = 0;
    //metodos setters y getters

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }
    
    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFucnion) {
        this.idFuncion = idFucnion;
    }

    public Date getHorario() {
        return Horario;
    }

    public void setHorario(Date Horario) {
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
