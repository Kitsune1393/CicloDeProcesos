package controlador;

import javax.swing.SwingWorker;
import vista.JFramePrincipal;

public class SWorkerEstadosProcesos extends SwingWorker<Void, Void> {

    private final JFramePrincipal jFramePrincipal;

    public SWorkerEstadosProcesos(JFramePrincipal jFramePrincipal) {
        this.jFramePrincipal = jFramePrincipal;
    }
    @Override
    protected Void doInBackground() {
        
        return null;
    }
}
