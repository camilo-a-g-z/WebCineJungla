package logica.Automatizacion;

import java.util.Comparator;
import logica.Funcion;

/**
 *
 * Clase que permite comparar el horario de dos funciones
 *
 * *@author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class ordenarFuncionPorHorario implements Comparator<Funcion> {

    //Campos de la clase
    //Declaracion de variables
    int aux;

    /**
     * Metodo que sobreescribe el compare de la interfaz Comparator Compara el
     * horario de dos funciones y retorna un entero segun la comparacion
     *
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(Funcion o1, Funcion o2) {
        if (o1.getHorarioC().before(o2.getHorarioC())) {
            aux = -1;
        } else {
            aux = 1;
        }
        return aux;
    }
    //Cierre del metodo
}
