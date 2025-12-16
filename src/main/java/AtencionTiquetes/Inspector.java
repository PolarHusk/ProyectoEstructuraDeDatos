package AtencionTiquetes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import CreacionTiquetes.*;
import javax.swing.JOptionPane;
import ConsultaBCCR.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Inspector {

    private boolean ocupado;

    public Inspector() {
        this.ocupado = false;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public Tiquete atender(Tiquete t) {
        ocupado = true;

        Double precioTiquete = 0.0;

        if (t.getServicio().equals("VIP")) {
            precioTiquete = 100.00 + 20.00;
        } else if (t.getServicio().equals("Regular")) {
            precioTiquete = 20.00;
        } else if (t.getServicio().equals("Ejecutivo")) {
            precioTiquete = 1000.00 + 20.00;
        } else if (t.getServicio().equals("Carga")) {
            int carga = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la lb de carga: "));
            precioTiquete = 20.00 + carga * 10.00;
        }

        if (t.getMonedaCuenta().equals("Colones")) {
            ServicioBCCR servicio = new ServicioBCCR();
            IndicadorEconomico indicador = null;
            String fechaHoy = obtenerFechaActual();
            try {
                indicador = servicio.obtenerIndicador(
                        "318", fechaHoy, fechaHoy,
                        "Sebastian Sandi Vega", "N", "sebasandi940@gmail.com", "SSS082DES5"
                );
            } catch (Exception ex) {
            }
            BigDecimal tipoCambio = ConsultaBCCR.MainBCCR.tipoCambio(indicador);
            double tipoCambioDecimal = tipoCambio.doubleValue();
            precioTiquete = precioTiquete * tipoCambioDecimal;
        }

        int opcion = JOptionPane.showConfirmDialog(null, "Tiquete #: " + t.getId() + "\npaga: " + precioTiquete,
                "Pago requerido", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "El usuario denego el pago, volvera a la fila de prioridad");
            ocupado = false;
            return t;
        }

        t.setHoraAbordaje(obtenerHoraActual());
        t.setAtendido(true);
        guardarTiquete(t);
        ocupado = false;
        System.out.println("Tiquete " + t.getId() + " atendido en bus # " + t.getNumeroBus());
        JOptionPane.showMessageDialog(null, t.toString());
        return null;
    }

    private String obtenerHoraActual() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formato);
    }

    private void guardarTiquete(Tiquete t) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Tiquete[] existentes;
            try (FileReader reader = new FileReader("atendidos.json")) {
                existentes = gson.fromJson(reader, Tiquete[].class);
            } catch (IOException e) {
                existentes = new Tiquete[0];
            }

            Tiquete[] nuevoArray = new Tiquete[existentes.length + 1];
            for (int i = 0; i < existentes.length; i++) {
                nuevoArray[i] = existentes[i];
            }
            nuevoArray[existentes.length] = t;

            try (FileWriter writer = new FileWriter("atendidos.json")) {
                gson.toJson(nuevoArray, writer);
            }

        } catch (IOException e) {
            System.out.println("Error al guardar atendidos.json: " + e.getMessage());
        }
    }

    public static String obtenerFechaActual() {

        LocalDate fechaActual = LocalDate.now();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return fechaActual.format(formato);

    }

}
