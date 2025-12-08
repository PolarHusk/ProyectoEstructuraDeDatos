package ModuloConfiguracion;

import AtencionTiquetes.ColaTiquetes;
import AtencionTiquetes.Inspector;
import javax.swing.JOptionPane;

public class BusPreferencial extends Bus {

    public BusPreferencial(String terminal, int numeroParadas ,TipoBus tipo, String id) {
        super(terminal, numeroParadas, tipo, id);
    }

    public BusPreferencial() {
    }

    public void mostrarBus() { // Metodo para mostrar la descripcion del bus
        JOptionPane.showMessageDialog(null, "Bus Preferencial #" + getNumeroBus() + "Terminal: " + getTerminal() + "Cantidad de Paradas: " + getNumeroParadas()
                + "Descripcion: Atiende a personas con discapacidades, embarazo, empresariales y adultos mayores");

    }

}
