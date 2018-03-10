package controlador;

import javax.swing.SwingWorker;
import model.Ordenador;
import model.Proceso;
import vista.JFramePrincipal;

public class SWorkerCrearProceso extends SwingWorker<Void, Void> {

    private final JFramePrincipal jFramePrincipal;

    public SWorkerCrearProceso(JFramePrincipal jFramePrincipal) {
        this.jFramePrincipal = jFramePrincipal;
    }

    private double random(double inicio, double fin) {
        return (Math.random() * (fin - inicio)) + inicio;
    }

    @Override
    protected Void doInBackground() {
        jFramePrincipal.setCont(jFramePrincipal.getCont() + 1);
        Ordenador ordenador = jFramePrincipal.getOrdenador();
        jFramePrincipal.getProcesos().add(new Proceso(
                "P" + jFramePrincipal.getCont(),
                random(ordenador.getMemoria() * 0.1, ordenador.getMemoria()),
                random(ordenador.getDiscoDuro() * 0.1, ordenador.getDiscoDuro()),
                random(ordenador.getNucleos() * 0.1, ordenador.getNucleos()-1),
                random(2, 5)
        ));
        return null;
    }
}
