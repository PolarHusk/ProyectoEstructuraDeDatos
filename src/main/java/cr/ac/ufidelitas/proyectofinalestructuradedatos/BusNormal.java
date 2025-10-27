
package cr.ac.ufidelitas.proyectofinalestructuradedatos;

import javax.swing.JOptionPane;


public class BusNormal extends Bus{

    public BusNormal(String numeroBus, String ruta, int numeroParadas) {
        super(numeroBus, ruta, numeroParadas, TipoBus.NORMAL);
    }

    @Override
    public void mostrarBus() {
        JOptionPane.showMessageDialog(null, "Bus Normal #" + getNumeroBus() + "Terminal: " + getRuta() + "Cantidad de Paradas: " + getNumeroParadas()
        + "Descripcion: Bus comun con varias paradas (2 o mas minimo)");
    }
    
}
