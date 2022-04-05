package logica;

import java.util.Calendar;
import java.util.Date;

/**
 * Esta clase maneja todo lo referente a los datos de las funciones.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class Funcion {

    //Espacios de la clase
    //Declaracion de variables
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
    private Calendar HorarioC = Calendar.getInstance();

    //metodos setters y getters
    //Metodo Get
    public Calendar getHorarioC() {
        return HorarioC;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setHorarioC(Calendar HorarioC) {
        this.HorarioC = HorarioC;
    }
    //Cierre del metodo Set

    //Metodo Get
    public Date getHorario() {
        return Horario;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setHorario(Date Horario) {
        this.Horario = Horario;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getDuracion() {
        return Duracion;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getIdFuncion() {
        return idFuncion;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdFuncion(int idFucnion) {
        this.idFuncion = idFucnion;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getAño() {
        return Año;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setAño(int Año) {
        this.Año = Año;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getMes() {
        return Mes;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setMes(int Mes) {
        this.Mes = Mes;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getDia() {
        return Dia;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setDia(int Dia) {
        this.Dia = Dia;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getMinuto() {
        return Minuto;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setMinuto(int Minuto) {
        this.Minuto = Minuto;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getHora() {
        return Hora;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setHora(int Hora) {
        this.Hora = Hora;
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

    //Metodo Get    
    public int getEmpleado_idEmpleado() {
        return Empleado_idEmpleado;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setEmpleado_idEmpleado(int Empleado_idEmpleado) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getPelicula_idPelicula() {
        return Pelicula_idPelicula;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setPelicula_idPelicula(int Pelicula_idPelicula) {
        this.Pelicula_idPelicula = Pelicula_idPelicula;
    }
    //Cierre del metodo Set
}
