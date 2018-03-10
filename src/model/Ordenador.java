package model;

/**
 *
 * @author william
 */
public class Ordenador {

    private double memoria;
    private double discoDuro;
    private double nucleos;
    private double memoriaEnUso;
    private double discoDuroEnUso;
    private double nucleosEnUso;

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

    public double getMemoriaEnUso() {
        return memoriaEnUso;
    }

    public double getDiscoDuroEnUso() {
        return discoDuroEnUso;
    }

    public double getNucleosEnUso() {
        return nucleosEnUso;
    }

    public boolean isExistResources(Proceso proceso) {
        return memoria - memoriaEnUso > proceso.getMemoria()
                && discoDuro - discoDuroEnUso > proceso.getDiscoDuro()
                && nucleos - nucleosEnUso > proceso.getNucleos();
    }

    public void addProcess(Proceso proceso) {
        this.memoriaEnUso += proceso.getMemoria();
        this.discoDuroEnUso += proceso.getDiscoDuro();
        this.nucleosEnUso += proceso.getNucleos();
    }

    public void finishProcess(Proceso proceso) {
        if (this.memoriaEnUso - proceso.getMemoria() > 0
                && this.discoDuroEnUso - proceso.getDiscoDuro() > 0
                && this.nucleosEnUso - proceso.getNucleos() > 0) {
            this.memoriaEnUso -= proceso.getMemoria();
            this.discoDuroEnUso -= proceso.getDiscoDuro();
            this.nucleosEnUso -= proceso.getNucleos();
        }
    }
}
