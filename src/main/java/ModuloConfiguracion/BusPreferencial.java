package ModuloConfiguracion;

import javax.swing.JOptionPane;

public class BusPreferencial extends Bus {

    public BusPreferencial(String numeroBus, String terminal, int numeroParadas) {
        super(numeroBus, terminal, numeroParadas, TipoBus.PREFERENCIAL);
    }

    public BusPreferencial() {
    }

    public void mostrarBus() { // Metodo para mostrar la descripcion del bus
        JOptionPane.showMessageDialog(null, "Bus Preferencial #" + getNumeroBus() + "Terminal: " + getTerminal() + "Cantidad de Paradas: " + getNumeroParadas()
                + "Descripcion: Atiende a personas con discapacidades, embarazo, empresariales y adultos mayores");

    }

}
