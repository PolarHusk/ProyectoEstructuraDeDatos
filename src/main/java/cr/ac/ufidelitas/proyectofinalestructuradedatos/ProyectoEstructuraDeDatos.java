package cr.ac.ufidelitas.proyectofinalestructuradedatos;

import javax.swing.JOptionPane;

public class ProyectoEstructuraDeDatos {

    public static void main(String[] args) {
        SerializacionConfig config = SerializacionConfig.AbrirConfig();
        if (config == null) {
            System.out.println("El archivo config.json no existe creando configuracion nueva...");
            String nombreTerminal = JOptionPane.showInputDialog("Ingrese el nombre de la terminal: ");
            int totalBuses = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de buses por terminal (minimo 3): "));
            Terminal terminal = new Terminal(nombreTerminal, totalBuses);
            config = new SerializacionConfig(terminal);
            config.GuardarConfig(terminal);
            System.out.println("Archivo guardado");
        } else {
            System.out.println("Nombre de la terminal: " + config.getTermina1().getNombre());
            System.out.println("Cantidad Buses: " + config.getTermina1().getBuses().length);
        }

    }
}
