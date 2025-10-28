package cr.ac.ufidelitas.proyectofinalestructuradedatos;

import javax.swing.JOptionPane;

public class BusDirecto extends Bus {

    public BusDirecto(String numeroBus, String terminal) {
        super(numeroBus, terminal, 1, TipoBus.DIRECTO);
    }

    public BusDirecto() {
    }
    
        public void mostrarBus() {
        JOptionPane.showMessageDialog(null, "Bus Directo #" + getNumeroBus() + "Terminal: " + getTerminal() + "Cantidad de Paradas: " + getNumeroParadas()
                + "Descripcion: Bus Directo con una unica parada");
    }

}
