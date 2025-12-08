/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModuloConfiguracion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Dylan
 */
public class SerializacionUsuarios {

    private static String nombreArchivo = "usuarios.json";
    private static int usuariosMax = 4;

    public static Usuario[] cargarUsuarios() {
        File archivo = new File(nombreArchivo);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (!archivo.exists()) {
            System.out.println("Archivo usuarios.json no existe. Creando con usuario admin...");

            Usuario[] usuarios = new Usuario[usuariosMax];
            usuarios[0] = new Usuario("admin", "1234");

            guardarUsuarios(usuarios);
            return usuarios;
        }

        try (FileReader reader = new FileReader(archivo)) {
            Usuario[] usuarios = gson.fromJson(reader, Usuario[].class);
            return usuarios;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void guardarUsuarios(Usuario[] usuarios) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            gson.toJson(usuarios, writer);
            System.out.println("Usuarios guardados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
