
package cr.ac.ufidelitas.proyectofinalestructuradedatos;

import javax.swing.JOptionPane;

public class BusPreferencial extends Bus {

    public BusPreferencial(String numeroBus, String ruta, int numeroParadas) {
        super(numeroBus, ruta, numeroParadas, TipoBus.PREFERENCIAL);
    }

    
    @Override
    public void mostrarBus() { // Metodo para mostrar la descripcion del bus
        JOptionPane.showMessageDialog(null, "Bus Preferencial #" + getNumeroBus() + "Terminal: " + getRuta() + "Cantidad de Paradas: " + getNumeroParadas()
        + "Descripcion: Atiende a personas con discapacidades, embarazo, empresariales y adultros mayores");
        
    }
    
}
