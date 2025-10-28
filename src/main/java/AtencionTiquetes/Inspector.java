
package AtencionTiquetes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Inspector {
    
      private boolean ocupado;

    public Inspector() {
        this.ocupado = false;
    }
    
    public boolean isOcupado() { return ocupado; }

    public void atender(Tiquete t) {
        ocupado = true;
        t.setHoraAbordaje(obtenerHoraActual());
        guardarTiquete(t);
        ocupado = false;
        System.out.println("Tiquete " + t.getId() + " atendido en bus " + t.getTipoBus());
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
            for (int i = 0; i < existentes.length; i++) nuevoArray[i] = existentes[i];
            nuevoArray[existentes.length] = t;

            try (FileWriter writer = new FileWriter("atendidos.json")) {
                gson.toJson(nuevoArray, writer);
            }

        } catch (IOException e) {
            System.out.println("Error al guardar atendidos.json: " + e.getMessage());
        }
    }



    
}
