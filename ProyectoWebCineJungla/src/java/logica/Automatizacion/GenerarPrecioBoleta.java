package logica.Automatizacion;

import logica.Silla;

/**
 *
 * @author Camilo Garcia
 */
public class GenerarPrecioBoleta {
    private Silla silla = new Silla();
    private Double costo = 0.0;
    public GenerarPrecioBoleta(Silla silla) {
        this.silla = silla;
        calcularCosto();
    }
    private void calcularCosto(){
        if("General".equals(silla.getTipo())){
            costo = 7000.0;
        }else{
            costo = 10000.0;
        }
    }

    public Silla getSilla() {
        return silla;
    }

    public void setSilla(Silla silla) {
        this.silla = silla;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
    
}
