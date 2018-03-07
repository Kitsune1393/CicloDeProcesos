package model;

import java.text.DecimalFormat;

/**
 *
 * @author william
 */
public class Proceso {

    private String nombre;
    private double memoria;
    private double discoDuro;
    private double nucleos;
    private double tiempo;
    /**
     * 1- Inicio 2- Listo 3- Ejecución 4- Espera 5- Terminado
     */
    private int estado;

    public Proceso(String nombre, double memoria, double discoDuro, double nucleos, double tiempo) {
        this.nombre = nombre;
        this.memoria = memoria;
        this.discoDuro = discoDuro;
        this.nucleos = nucleos;
        this.tiempo = tiempo;
        this.estado = 1;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMemoria() {
        return memoria;
    }

    public void setMemoria(double memoria) {
        this.memoria = memoria;
    }

    public double getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(double discoDuro) {
        this.discoDuro = discoDuro;
    }

    public double getNucleos() {
        return nucleos;
    }

    public void setNucleos(double nucleos) {
        this.nucleos = nucleos;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###");
        return nombre + " - "
                + df.format(tiempo) + " s - "
                + df.format(memoria) + " M.Gb - "
                + df.format(discoDuro) + " DD.Gb - "
                + df.format(nucleos)+" N";
    }

}
