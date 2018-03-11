package controlador;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.SwingWorker;
import model.Proceso;
import vista.JFramePrincipal;

public class SWorkerRefrescarVista extends SwingWorker<Void, Void> {

    private final DefaultListModel modelInicio;
    private final DefaultListModel modelEnEjecucion;
    private final DefaultListModel modelEnEspera;
    private final DefaultListModel modelListo;
    private final DefaultListModel modelTerminado;
    private final List<Proceso> procesos;
    private final JFramePrincipal jFramePrincipal;

    public SWorkerRefrescarVista(JFramePrincipal jFramePrincipal) {
        modelInicio = new DefaultListModel();
        jFramePrincipal.getjListInicio().setModel(modelInicio);
        modelEnEjecucion = new DefaultListModel();
        jFramePrincipal.getjListEnEjecucion().setModel(modelEnEjecucion);
        modelEnEspera = new DefaultListModel();
        jFramePrincipal.getjListEnEspera().setModel(modelEnEspera);
        modelListo = new DefaultListModel();
        jFramePrincipal.getjListListo().setModel(modelListo);
        modelTerminado = new DefaultListModel();
        jFramePrincipal.getjListTerminado().setModel(modelTerminado);
        procesos = jFramePrincipal.getProcesos();
        this.jFramePrincipal = jFramePrincipal;
    }

    @Override
    protected Void doInBackground() {
        long time = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - time > 50) {
                if (!jFramePrincipal.getjButtonCrearProceso().isEnabled()) {
                    if (procesos.get(0).isEnEjecucion()) {
                        jFramePrincipal.getjButtonCrearProceso().setEnabled(true);
                        jFramePrincipal.getjSliderVelocidad().setEnabled(true);
                    }
                }
                time = System.currentTimeMillis();
                jFramePrincipal.actualizarConsumoOrdenador();
                for (Proceso proceso : procesos) {
                    switch (proceso.getEstado()) {
                        case 1://Inicio
                            if (!modelInicio.contains(proceso)) {
                                modelInicio.addElement(proceso);
                            }
                            break;
                        case 2://Listo
                            modelInicio.removeElement(proceso);
                            modelEnEspera.removeElement(proceso);
                            if (!modelListo.contains(proceso)) {
                                modelListo.addElement(proceso);
                            }
                            break;
                        case 3://Ejecucion
                            modelListo.removeElement(proceso);
                            if (!modelEnEjecucion.contains(proceso)) {
                                modelEnEjecucion.addElement(proceso);
                                if (proceso.isEnEjecucion()) {
                                    jFramePrincipal.getjListEnEjecucion().setSelectedIndex(
                                            modelEnEjecucion.size()
                                    );
                                }
                            }
                            break;
                        case 4://Espera
                            modelEnEjecucion.removeElement(proceso);
                            if (!modelEnEspera.contains(proceso)) {
                                modelEnEspera.addElement(proceso);
                            }
                            break;
                        case 5://Terminado
                            modelEnEjecucion.removeElement(proceso);
                            if (!modelTerminado.contains(proceso)) {
                                modelTerminado.addElement(proceso);
                            }
                            break;
                    }
                }
                jFramePrincipal.getjListEnEjecucion().updateUI();
            }
        }
    }
}
