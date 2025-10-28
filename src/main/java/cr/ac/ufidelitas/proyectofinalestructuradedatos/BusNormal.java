
package cr.ac.ufidelitas.proyectofinalestructuradedatos;

import javax.swing.JOptionPane;


public class BusNormal extends Bus{

    public BusNormal(String numeroBus, String terminal, int numeroParadas) {
        super(numeroBus, terminal, numeroParadas, TipoBus.NORMAL);
    }

    public BusNormal() {
    }
    

    public void mostrarBus() {
        JOptionPane.showMessageDialog(null, "Bus Normal #" + getNumeroBus() + "Terminal: " + getTerminal() + "Cantidad de Paradas: " + getNumeroParadas()
        + "Descripcion: Bus comun con varias paradas (2 o mas minimo)");
    }
    
}
