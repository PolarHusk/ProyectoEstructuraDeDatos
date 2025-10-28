package ModuloConfiguracion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SerializacionConfig {
    
    private Terminal termina1;
    private Usuario usuarios[];

    public SerializacionConfig() {
    }

    public SerializacionConfig(Terminal termina1) {
        this.termina1 = termina1;
    }
    
    

    public void GuardarConfig(Terminal terminal) {

        Gson gson = new GsonBuilder().create();

        try (FileWriter writer = new FileWriter("config.json")) {
            gson.toJson(this, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static SerializacionConfig AbrirConfig() {
        File archivoCargar = new File("config.json");
        Gson gson = new GsonBuilder().create();
        if (archivoCargar.exists()) {
            System.out.println(archivoCargar.exists());
            try (FileReader reader = new FileReader(archivoCargar)) {
                System.out.println(archivoCargar);
                return gson.fromJson(reader, SerializacionConfig.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
            return null;
    
    }

    public Terminal getTermina1() {
        return termina1;
    }

    public void setTermina1(Terminal termina1) {
        this.termina1 = termina1;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
