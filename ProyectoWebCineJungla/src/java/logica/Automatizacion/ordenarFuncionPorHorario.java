/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Automatizacion;

import java.util.Comparator;
import logica.Funcion;

/**
 *
 * @author Miguel
 */
public class ordenarFuncionPorHorario implements Comparator<Funcion> {

    int aux;

    @Override
    public int compare(Funcion o1, Funcion o2) {
        if (o1.getHorario().before(o2.getHorario())) {
            aux = -1;
        } else {
            aux = 1;
        }
        return aux;
    }
}
