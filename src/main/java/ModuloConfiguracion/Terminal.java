package ModuloConfiguracion;

import java.util.Random;

public class Terminal {

    // Se buscara implementar una clase para el manejo de las listas de terminales
    // Para asi tener una lista de terminales y cada una con una lista de buses
    private String nombre;
    private Bus buses[];

    public Terminal(String nombre, int totalBuses) {
        this.nombre = nombre;
        this.buses = generarBuses(totalBuses);

    }    
    public Terminal(){}

    private Bus[] generarBuses(int totalBuses) {
        Random random = new Random();
        Bus nuevosBuses[] = new Bus[totalBuses];
        nuevosBuses[0] = new BusPreferencial("Bus-001", nombre, 2 + random.nextInt(10));
        nuevosBuses[1] = new BusDirecto("Bus-002", nombre);

        for (int i = 2; i < totalBuses; i++) {
            int paradas = 2 + random.nextInt(10);
            nuevosBuses[i] = new Bus("Bus-00" + (i + 1), nombre, paradas, TipoBus.NORMAL);
        }
        return nuevosBuses;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bus[] getBuses() {
        return buses;
    }

    public void setBuses(Bus[] buses) {
        this.buses = buses;
    }

}
