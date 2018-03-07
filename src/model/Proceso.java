package model;

/**
 *
 * @author william
 */
public class Proceso {

    private String nombre;
    private double memoria;
    private double discoDuro;
    private double nucleos;
    private long tiempo;
    /**
     * 1- Inicio
     * 2- Listo
     * 3- Ejecución
     * 4- Espera
     * 5- Terminado
     */
    private int estado;

    public Proceso(String nombre, double memoria, double discoDuro, double nucleos, long tiempo) {
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

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return nombre + "-" + tiempo + "-" + memoria + "-" + discoDuro + "-" + nucleos;
    }

}
