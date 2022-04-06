package logica;

import java.sql.Date;

/**
 * Esta clase maneja todo lo referente a los datos de los Empleados de la
 * empresa.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class Empleado {

    //Espacios de la clase
    //Declaracion de variables
    private int idEmpleado = 0;
    private String Nombre = "";
    private String Cedula = "";
    private String NumTelefono = "";
    private Double Salario = 0.0;
    private int Año = 0;
    private int Mes = 0;
    private int dia = 0;
    private String HashPsw = "";
    private int Multiplex_idMultiplex = 0;
    private int Rol_idRol = 0;

    //metodos getters y setters
    //Metodo Get
    public int getAño() {
        return Año;
    }
    //Cierre del metodo Get

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
        return dia;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setDia(int dia) {
        this.dia = dia;
    }
    //Cierre del metodo Set

    //Metodo Set
    public void setAño(int Año) {
        this.Año = Año;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getIdEmpleado() {
        return idEmpleado;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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
    public String getCedula() {
        return Cedula;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }
    //Cierre del metodo Set

    //Metodo Get
    public String getNumTelefono() {
        return NumTelefono;
    }
    //Cierre del metodo Get

    //Metodo Set    
    public void setNumTelefono(String NumTelefono) {
        this.NumTelefono = NumTelefono;
    }
    //Cierre del metodo Set

    //Metodo Get
    public Double getSalario() {
        return Salario;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setSalario(Double Salario) {
        this.Salario = Salario;
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
    public int getMultiplex_idMultiplex() {
        return Multiplex_idMultiplex;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setMultiplex_idMultiplex(int Multiplex_idMultiplex) {
        this.Multiplex_idMultiplex = Multiplex_idMultiplex;
    }
    //Cierre del metodo Set

    //Metodo Get
    public int getRol_idRol() {
        return Rol_idRol;
    }
    //Cierre del metodo Get

    //Metodo Set
    public void setRol_idRol(int Rol_idRol) {
        this.Rol_idRol = Rol_idRol;
    }
    //Cierre del metodo Set
}
