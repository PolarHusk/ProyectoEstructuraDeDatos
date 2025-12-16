/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import AtencionTiquetes.*;
import ConsultaBCCR.*;
import Grafo.*;
import CreacionTiquetes.ColaPrioridad;
import CreacionTiquetes.SerializacionColaPrioridad;
import CreacionTiquetes.Tiquete;
import LlenadoColas.*;
import ModuloConfiguracion.*;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Dylan
 */
public class Interfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Usuario[] usuarios = SerializacionUsuarios.cargarUsuarios();

        Usuario logueado = iniciarSesion(usuarios);

        if (logueado == null) {
            System.out.println("No se pudo iniciar sesion. Cerrando programa.");
        }

        ColaPrioridad cola = cargarConfiguracion();

        int opcion;

        Terminal terminal = TerminalGlobal.getTerminal();

        GrafoPonderado<Destino> rutas = Grafo.Main.crearGrafo();

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "SISTEMA DE ATENCION DE TIQUETES BUSNOVATECH\n"
                    + "1. Crear Tiquete\n"
                    + "2. Abordar (Atender siguiente tiquete)\n"
                    + "3. Mostrar tiquetes en fila de Bus\n"
                    + "4. Agregar mas buses\n"
                    + "5. Mostrar tiquetes en la cola de prioridad\n"
                    + "6. Mostrar tiquetes atendidos\n"
                    + "7. Mostrar Rutas\n"
                    + "8. Salir"));

            switch (opcion) {
                case 1:
                    creacionTiquetes(cola);
                    break;
                case 2:
                    atencionTiquetes(cola);
                    break;
                case 3:
                    terminal.mostrarTiquetesPorBus();
                    break;
                case 4:
                    ListaBuses<Bus> buses = TerminalGlobal.getTerminal().getBuses();
                    int busesNuevo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el total de buses a agregar (Normal): "));
                    terminal.generarBusNuevo(buses, busesNuevo);
                    break;
                case 5:
                    System.out.println(" -----COLA DE PRIORIDAD DE TIQUETES---- ");
                    System.out.println(cola.toString());

                    int opcionConfirmar = JOptionPane.showConfirmDialog(null, "Desea enviar los tiquetes denegados a la fila de buses?", "Cola de Prioridad", JOptionPane.YES_NO_OPTION);
                    if (opcionConfirmar == JOptionPane.YES_OPTION) {
                        while (!cola.estaVacia()) {
                            Tiquete rechazado = cola.desencolar();
                            LlenadoColas1.enviarTiquetesaBus(rechazado, terminal.getBuses());
                            break;
                        }
                    } else if (opcionConfirmar == JOptionPane.NO_OPTION) {
                        break;
                    }
                case 6:
                    mostrarTiquetesAtendidos();
                    break;
                case 7:
                    mostrarGrafoPonderado(rutas);
                    break;
                case 8:
                    SerializacionConfig config;
                    config = new SerializacionConfig(TerminalGlobal.getTerminal());
                    config.GuardarConfig(TerminalGlobal.getTerminal());
                    LlenadoColas1.guardarColasPendientes(TerminalGlobal.getTerminal().getBuses(), "colas.json");
                    System.out.println("Archivo guardado");
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    return;
                default:
                    throw new AssertionError();
            }

        } while (opcion != 8);

    }

    public static ColaPrioridad cargarConfiguracion() {

        SerializacionConfig config = SerializacionConfig.AbrirConfig();

        Terminal terminal;
        if (config == null) {
            System.out.println("El archivo config.json no existe creando configuracion nueva...");
            String nombreTerminal = JOptionPane.showInputDialog("Ingrese el nombre de la terminal: ");
            int totalBuses = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de buses por terminal (minimo 3): "));
            terminal = new Terminal(nombreTerminal, totalBuses);
            config = new SerializacionConfig(terminal);
            config.GuardarConfig(terminal);
            System.out.println("Archivo guardado");
        } else {
            terminal = config.getTermina1();
            System.out.println("Nombre de la terminal: " + config.getTermina1().getNombre());
            System.out.println("Cantidad Buses: " + config.getTermina1().getBuses().getCantidad());
        }
        TerminalGlobal.setTerminal(terminal);

        ColaPrioridad cola = SerializacionColaPrioridad.desseralizarColaPrioridad("tiquetes.json");

        if (cola == null) {
            cola = new ColaPrioridad();
            return cola;
        } else {
            return cola;
        }

    }

    public static void creacionTiquetes(ColaPrioridad cola) {

        Terminal terminal1 = TerminalGlobal.getTerminal();

        String nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del tiquete: "));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad: "));
        String moneda = JOptionPane.showInputDialog("Ingrese el tipo de moneda: ");
//        String fechaCreacionVieja = JOptionPane.showInputDialog("Ingrese la fecha: ");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        String fechaCreacionNueva = LocalDateTime.now().format(formato);
        String servicio = JOptionPane.showInputDialog("Ingrese el tipo de servicio (VIP,Regular,Carga,Ejecutivo): ");
//        String tipoBus = JOptionPane.showInputDialog("Ingrese el tipo de bus (P = Preferencial,D = Directo,N = Normal): ");

        String opcionesBus[] = {"PREFERENCIAL", "DIRECTO", "NORMAL"};
        TipoBus tipoBus;
        int opt = JOptionPane.showOptionDialog(null, "Seleccione el tipo de bus",
                "Tipo de Bus del tiquete", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesBus, opcionesBus[2]);

        switch (opt) {
            case 0:
                tipoBus = TipoBus.PREFERENCIAL;
                break;
            case 1:
                tipoBus = TipoBus.DIRECTO;
                break;
            case 2:
                tipoBus = TipoBus.NORMAL;
                break;
            default:
                throw new AssertionError();
        }

        cola.encolar(new Tiquete(nombre, id, edad, moneda, fechaCreacionNueva, " ", servicio, tipoBus, terminal1.getNombre()));

        Tiquete tiqueteNuevo = cola.desencolar();

        LlenadoColas1.enviarTiquetesaBus(tiqueteNuevo, TerminalGlobal.getTerminal().getBuses());

        SerializacionColaPrioridad serializacionColaPrioridad = new SerializacionColaPrioridad();
        serializacionColaPrioridad.serializarColaPrioridad(cola, "tiquetes.json");

    }

    public static void atencionTiquetes(ColaPrioridad cola) {

        String id = JOptionPane.showInputDialog("Ingrese el numero de bus a atender: ");

        Bus busSeleccionado = TerminalGlobal.getTerminal().getBuses().buscarBusPorNumero(id);

        if (busSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No existe ese bus");
            return;
        }

        Tiquete resultado = busSeleccionado.abordar();

        if (resultado != null) {
            cola.encolar(resultado);
        }

        LlenadoColas1.guardarColasPendientes(TerminalGlobal.getTerminal().getBuses(), "colas.json");
        SerializacionColaPrioridad serializacionColaPrioridad = new SerializacionColaPrioridad();
        serializacionColaPrioridad.serializarColaPrioridad(cola, "tiquetes.json");

    }

    public static Usuario iniciarSesion(Usuario[] usuarios) {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");
        String contrasena = JOptionPane.showInputDialog("Ingrese su contrasena: ");

        if (nombre == null || contrasena == null) {
            JOptionPane.showMessageDialog(null, "Inicio de sesion cancelado.");
            return null;
        }

        for (int i = 0; i < 10; i++) {
            Usuario logueado = usuarios[i];

            if (logueado.getNombre().equals(nombre) && logueado.getContrasena().equals(contrasena)) {
                return logueado;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrectos.");
        return null;
    }

    private static void mostrarTiquetesAtendidos() {
        Tiquete[] lista = cargarAtendidos();

        if (lista.length == 0) {
            System.out.println("No hay tiquetes atendidos todavía.");
            return;
        }

        System.out.println("Tiquetes atendidos");
        for (Tiquete t : lista) {
            System.out.println(t);
        }
    }

    private static Tiquete[] cargarAtendidos() {
        try {
            Gson gson = new Gson();

            try (FileReader reader = new FileReader("atendidos.json")) {
                Tiquete[] atendidos = gson.fromJson(reader, Tiquete[].class);

                if (atendidos == null) {
                    return new Tiquete[0]; // archivo vacío
                }
                return atendidos;
            }

        } catch (IOException e) {
            System.out.println("No se pudo leer atendidos.json: " + e.getMessage());
            return new Tiquete[0];
        }
    }

    private static void mostrarGrafoPonderado(GrafoPonderado<Destino> rutas) {

        rutas.imprimir();
        Lista<Destino> terminales = rutas.obtenerVertices();

        StringBuilder sb = new StringBuilder("Seleccione el destino:\n");
        Nodo<Destino> escogerTerminal = terminales.getCabeza();

        while (escogerTerminal != null) {
            Destino d = escogerTerminal.getDato();
            sb.append(d.getId()).append(" - ").append(d.getNombre()).append("\n");
            escogerTerminal = escogerTerminal.getSiguiente();
        }

        int idOrigen = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese ID del origen:\n" + sb)
        );

        int idDestino = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese ID del destino:\n" + sb)
        );

        Destino origen = null;
        Destino destino = null;

        Nodo<Destino> escogerDestino = terminales.getCabeza();
        while (escogerDestino != null) {
            Destino d = escogerDestino.getDato();
            if (d.getId() == idOrigen) {
                origen = d;
            }
            if (d.getId() == idDestino) {
                destino = d;
            }
            escogerDestino = escogerDestino.getSiguiente();
        }

        if (origen == null || destino == null) {
            JOptionPane.showMessageDialog(null, "Destino inválido");
            return;
        }

        String resultado = rutas.dijkstra(origen, destino);

        JOptionPane.showMessageDialog(
                null,
                resultado,
                "Ruta más corta",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

}
