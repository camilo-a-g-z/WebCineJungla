package logica;

import java.sql.Date;

/**
 *
 * @author Camilo Garcia
 */
public class Empleado {
    private int idEmpleado = 0;
    private String Nombre = "";
    private String Cedula= "";
    private String NumTelefono = "";
    private Double Salario = 0.0;
    private int Año = 0;
    private int Mes = 0;
    private int dia = 0;
    private String HashPsw = "";
    private int Multiplex_idMultiplex = 0;
    private int Rol_idRol = 0;
    
    //metodos getters y setters
    public int getAño() {    
        return Año;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    public void setAño(int Año) {    
        this.Año = Año;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNumTelefono() {
        return NumTelefono;
    }

    public void setNumTelefono(String NumTelefono) {
        this.NumTelefono = NumTelefono;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }

    public String getHashPsw() {
        return HashPsw;
    }

    public void setHashPsw(String HashPsw) {
        this.HashPsw = HashPsw;
    }

    public int getMultiplex_idMultiplex() {
        return Multiplex_idMultiplex;
    }

    public void setMultiplex_idMultiplex(int Multiplex_idMultiplex) {
        this.Multiplex_idMultiplex = Multiplex_idMultiplex;
    }

    public int getRol_idRol() {
        return Rol_idRol;
    }

    public void setRol_idRol(int Rol_idRol) {
        this.Rol_idRol = Rol_idRol;
    }
    
}
