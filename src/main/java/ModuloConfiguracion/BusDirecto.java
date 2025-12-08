package ModuloConfiguracion;

import AtencionTiquetes.ColaTiquetes;
import AtencionTiquetes.Inspector;
import javax.swing.JOptionPane;

public class BusDirecto extends Bus {

    public BusDirecto(String terminal, TipoBus tipo, String id) {
        super(terminal, 1, tipo, id);
    }



    public BusDirecto() {
    }

    public void mostrarBus() {
        JOptionPane.showMessageDialog(null, "Bus Directo #" + getNumeroBus() + "Terminal: " + getTerminal() + "Cantidad de Paradas: " + getNumeroParadas()
                + "Descripcion: Bus Directo con una unica parada");
    }

}
