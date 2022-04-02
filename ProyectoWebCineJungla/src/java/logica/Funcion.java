package logica;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Camilo Garcia
 */
public class Funcion {
    private int idFuncion = 0;
    private int Año = 0;
    private int Mes = 0;
    private int Dia = 0;
    private int Minuto = 0;
    private int Hora = 0;
    private int Sala_idSala = 0;
    private int Empleado_idEmpleado = 0;
    private int Pelicula_idPelicula = 0;
    private int Duracion = 0;
    private Date Horario;
    private Calendar HorarioC;
    //metodos setters y getters

    public Calendar getHorarioC() {
        return HorarioC;
    }

    public void setHorarioC(Calendar HorarioC) {
        this.HorarioC = HorarioC;
    }
    
    public Date getHorario() {
        return Horario;
    }

    public void setHorario(Date Horario) {
        this.Horario = Horario;
    }
    
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

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getMinuto() {
        return Minuto;
    }

    public void setMinuto(int Minuto) {
        this.Minuto = Minuto;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int Hora) {
        this.Hora = Hora;
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
