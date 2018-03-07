package model;

/**
 *
 * @author william
 */
public class Ordenador {
    private double memoria;
    private double discoDuro;
    private double nucleos;

    public Ordenador(double memoria, double discoDuro, double nucleos) {
        this.memoria = memoria;
        this.discoDuro = discoDuro;
        this.nucleos = nucleos;
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
    
    
}
