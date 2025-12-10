package CreacionTiquetes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author keagui1
 */
public class SerializacionColaPrioridad {

    // Pila + nombre un archivo
    //Guardar en el JSON
    public void serializarColaPrioridad(ColaPrioridad ColaPrioridad, String archivo) {
        Gson gson = new GsonBuilder().create();
        try (FileWriter writer = new FileWriter(archivo)) {

            gson.toJson(ColaPrioridad, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Cargar desde el JSON
    public static ColaPrioridad desseralizarColaPrioridad(String archivo) {
        File archivoCargar = new File("tiquetes.json");
        Gson gson = new GsonBuilder().create();

        if (archivoCargar.exists()) {
            System.out.println(archivoCargar.exists());
            try (FileReader reader = new FileReader(archivo)) {
                return gson.fromJson(reader, ColaPrioridad.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
