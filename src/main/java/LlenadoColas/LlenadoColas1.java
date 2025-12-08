/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package LlenadoColas;

import ModuloConfiguracion.*;
import CreacionTiquetes.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import AtencionTiquetes.*;

/**
 *
 * @author 50685
 */
public class LlenadoColas1 {

    public static void enviarTiquetesaBus(Tiquete tiqueteNuevo, ListaBuses<Bus> listaBuses) {

        TipoBus tipo = tiqueteNuevo.getTipoBusNuevo();

        Bus busAsignado = null;

        switch (tipo) {
            case NORMAL:
                busAsignado = listaBuses.buscarBusConMenorCola();
                break;
            case DIRECTO:
            case PREFERENCIAL:
                busAsignado = listaBuses.buscarbusPorTipo(tipo);
                break;
            default:
                throw new AssertionError();
        }

        if (busAsignado == null) {
            System.out.println("No hay buses disponibles" + tipo);
            return;
        }

        busAsignado.getCola().encolar(tiqueteNuevo);
        
        
        JOptionPane.showMessageDialog(null, "Tiquete # :" + tiqueteNuevo.getId()
                + " asignado al bus: " + busAsignado.getNumeroBus()
                + "");
        tiqueteNuevo.setNumeroBus(busAsignado.getNumeroBus());
    }

    public static void guardarColasPendientes(ListaBuses<Bus> listaBuses, String nombreArchivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        NodoBus<Bus> actual = listaBuses.getCabeza();

        int i = 0;

        ColaTiquetes[] colas = new ColaTiquetes[listaBuses.getCantidad()];

        while (actual != null) {
            Bus bus = (Bus) actual.getDato();
            colas[i++] = bus.getCola();
            actual = actual.getSiguiente();
        }

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            gson.toJson(colas, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
