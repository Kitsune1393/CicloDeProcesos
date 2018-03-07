package controlador;

import static java.lang.Thread.sleep;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.SwingWorker;
import model.Proceso;
import vista.JFramePrincipal;

public class SWorkerRefrescarVista extends SwingWorker<Void, String> {

    private final DefaultListModel modelInicio;
    private final DefaultListModel modelEnEjecucion;
    private final DefaultListModel modelEnEspera;
    private final DefaultListModel modelListo;
    private final DefaultListModel modelTerminado;
    private final List<Proceso> procesos;
    private final JFramePrincipal jFramePrincipal;

    public SWorkerRefrescarVista(JFramePrincipal jFramePrincipal) {
        this.jFramePrincipal = jFramePrincipal;
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
    }

    private void limpiarListas() {
        modelEnEjecucion.removeAllElements();
        modelEnEspera.removeAllElements();
        modelInicio.removeAllElements();
        modelListo.removeAllElements();
        modelTerminado.removeAllElements();
    }

    @Override
    protected Void doInBackground() {
        while (true) {
            try {
                limpiarListas();
                for (Proceso proceso : procesos) {
                    switch (proceso.getEstado()) {
                        case 1:
                            modelInicio.addElement(proceso);
                            break;
                        case 2:
                            modelListo.addElement(proceso);
                            break;
                        case 3:
                            modelEnEjecucion.addElement(proceso);
                            break;
                        case 4:
                            modelEnEspera.addElement(proceso);
                            break;
                        case 5:
                            modelTerminado.addElement(proceso);
                            break;
                    }
                }
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SWorkerRefrescarVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
