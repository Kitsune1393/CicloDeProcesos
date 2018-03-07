package controlador;

import java.util.List;
import javax.swing.DefaultListModel;
import model.Proceso;
import vista.JFramePrincipal;

/**
 *
 * @author william
 */
public class ActualizarTiempoEstados extends Thread {

    private final List<Proceso> procesos;

    public ActualizarTiempoEstados(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    @Override
    public void run() {
        while (true) {

        }
    }
}
