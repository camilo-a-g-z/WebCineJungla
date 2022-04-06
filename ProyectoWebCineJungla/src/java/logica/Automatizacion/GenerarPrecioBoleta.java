package logica.Automatizacion;

import logica.Silla;

/**
 * Esta clase genera el precio de una boleta segun el tipo de silla
 *
 * * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno -
 * Cristian C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class GenerarPrecioBoleta {

    //Campos de la clase
    //Declaracion de variables
    private Silla silla = new Silla();
    private Double costo = 0.0;

    /**
     * Metodo constructor de la clase, llama al metodo calcularCosto
     *
     * @param silla
     */
    public GenerarPrecioBoleta(Silla silla) {
        this.silla = silla;
        calcularCosto();
    }
    //Cierre del metodo

    /**
     * Metodo que setea un valor segun el tipo de silla
     */
    private void calcularCosto() {
        if ("General".equals(silla.getTipo())) {
            costo = 7000.0;
        } else {
            costo = 10000.0;
        }
    }
    //Cierre del metodo

    //Metodos getter y setter de silla
    public Silla getSilla() {
        return silla;
    }
    //Cierre de metodos

    public void setSilla(Silla silla) {
        this.silla = silla;
    }

    //Metodos getter y setter del costo
    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
    //Cierre de metodos;

}
