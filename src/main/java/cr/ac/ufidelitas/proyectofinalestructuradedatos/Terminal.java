package cr.ac.ufidelitas.proyectofinalestructuradedatos;

import java.util.Random;

public class Terminal {

    // Se buscara implementar una clase para el manejo de las listas de terminales
    // Para asi tener una lista de terminales y cada una con una lista de buses
    private String nombre;
    private Bus buses[];
    Random random = new Random();

    public Terminal(String nombre, int totalBusesEnTerminal) {
        this.nombre = nombre;
        this.buses = new Bus[totalBusesEnTerminal];
        generarBuses(totalBusesEnTerminal);
    }

    private Bus[] generarBuses(int totalBuses) {
        buses[0] = new BusPreferencial("Bus-001", nombre, 2 + random.nextInt(10));
        buses[1] = new BusDirecto("Bus-002", nombre);
        
        for (int i = 2; i < totalBuses; i++) {
            int paradas = 2 + random.nextInt(10);
            buses[i] = new BusNormal("Bus-00" + (i+1), nombre, paradas);
        }
        return buses;
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
