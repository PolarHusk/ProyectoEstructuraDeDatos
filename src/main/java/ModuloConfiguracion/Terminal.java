package ModuloConfiguracion;

import java.util.Random;
import javax.swing.JOptionPane;

public class Terminal {

    private String nombre;
    private ListaBuses<Bus> buses;

    public Terminal(String nombre, int totalBuses) {
        this.nombre = nombre;
        this.buses = generarBuses(totalBuses);

    }

    public Terminal() {
    }

    private ListaBuses<Bus> generarBuses(int totalBuses) {
        Random random = new Random();
        ListaBuses<Bus> listaBuses = new ListaBuses<>();

        listaBuses.addFirst(new BusPreferencial(nombre, 2 + random.nextInt(10), TipoBus.PREFERENCIAL, "Bus-001"));
        listaBuses.addFirst(new BusDirecto(nombre, TipoBus.DIRECTO, "Bus-002"));

        for (int i = 2; i < totalBuses; i++) {
            int paradas = 2 + random.nextInt(10);
            String id = "Bus-00" + (i + 1);

            Bus nuevoBus = new Bus(nombre, paradas, TipoBus.NORMAL, id);
            listaBuses.addFirst(nuevoBus);
        }
        return listaBuses;
    }

    public void mostrarTiquetesPorBus() {
        NodoBus<Bus> actual = buses.getCabeza();

        if (actual == null) {
            System.out.println("No hay buses");
            return;
        }

        while (actual != null) {
            Bus bus = actual.getDato();
            int cantidad = actual.getDato().getCola().getCantidad();

            JOptionPane.showMessageDialog(null, "Bus #: " + bus.getNumeroBus()
                    + "-> " + cantidad + " personas en fila\n");

            actual = actual.getSiguiente();

        }

    }

    public void generarBusNuevo(ListaBuses<Bus> buses, int busesNuevos) {

        Random random = new Random();

        for (int i = 0; i < busesNuevos; i++) {
            int paradas = 2 + random.nextInt(10);
            String id = "Bus-10" + (i + 1);
            Bus nuevoBus = new Bus(nombre, paradas, TipoBus.NORMAL, id);
            buses.addFirst(nuevoBus);
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaBuses<Bus> getBuses() {
        return buses;
    }

}
