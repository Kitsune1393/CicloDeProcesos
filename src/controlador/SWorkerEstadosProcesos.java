package controlador;

import java.util.List;
import javax.swing.SwingWorker;
import model.Ordenador;
import model.Proceso;
import vista.JFramePrincipal;

public class SWorkerEstadosProcesos extends SwingWorker<Void, Void> {

    private final List<Proceso> procesos;
    private final Ordenador ordenador;
    private final JFramePrincipal jFramePrincipal;

    public SWorkerEstadosProcesos(JFramePrincipal jFramePrincipal) {
        this.procesos = jFramePrincipal.getProcesos();
        this.ordenador = jFramePrincipal.getOrdenador();
        this.jFramePrincipal = jFramePrincipal;
    }

    @Override
    protected Void doInBackground() {
        long time = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - time > jFramePrincipal.getVelocidad()) {
                time = System.currentTimeMillis();
                for (Proceso proceso : procesos) {
                    if (proceso.isVisitado()) {
                        switch (proceso.getEstado()) {
                            case 1:
                                proceso.setEstado(2);//Pasa a la lista de listo
                                proceso.setVisitado(false);
                                break;
                            case 2:
                                proceso.setEstado(3);//Se dirige a ejecución
                                proceso.setVisitado(false);
                                break;
                            case 3:
                                if (!proceso.isEnEjecucion()) {
                                    if (ordenador.isExistResources(proceso)) {
                                        ordenador.addProcess(proceso);
                                        proceso.setEnEjecucion(true);
                                    } else {
                                        proceso.setEstado(4);
                                        proceso.setVisitado(false);
                                    }
                                } else {
                                    proceso.setTiempo(proceso.getTiempo() - 1);
                                }
                                if (proceso.getTiempo() <= 0) {
                                    proceso.setEstado(5);
                                    ordenador.finishProcess(proceso);
                                }
                                break;
                            case 4:
                                proceso.setEstado(2);
                                proceso.setVisitado(false);
                                break;
                        }
                    } else {
                        proceso.setVisitado(true);
                    }
                }
            }
        }
    }
}
