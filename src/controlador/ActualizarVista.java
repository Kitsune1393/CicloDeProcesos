package controlador;

import javax.swing.DefaultListModel;
import vista.JFramePrincipal;

/**
 *
 * @author william
 */
public class ActualizarVista extends Thread {

    private final DefaultListModel modelInicio;
    private final DefaultListModel modelEnEjecucion;
    private final DefaultListModel modelEnEspera;
    private final DefaultListModel modelListo;
    private final DefaultListModel modelTerminado;

    public ActualizarVista(JFramePrincipal jFramePrincipal) {
        modelInicio = (DefaultListModel)jFramePrincipal.getjListInicio().getModel();
        modelEnEjecucion = (DefaultListModel)jFramePrincipal.getjListEnEjecucion().getModel();
        modelEnEspera = (DefaultListModel)jFramePrincipal.getjListEnEspera().getModel();
        modelListo = (DefaultListModel)jFramePrincipal.getjListListo().getModel();
        modelTerminado = (DefaultListModel)jFramePrincipal.getjListTerminado().getModel();
    }

    @Override
    public void run() {
        while (true) {
            
        }
    }
}
