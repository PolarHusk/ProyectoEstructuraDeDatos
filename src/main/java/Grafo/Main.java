/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Dylan
 */
public class Main {

    public static GrafoPonderado<Destino> crearGrafo() throws IOException {
        GrafoPonderado<Destino> grafoPonderado = new GrafoPonderado<>();

        Destino d1 = new Destino(1, 100, "San Jose");
        Destino d2 = new Destino(2, 200, "Desamparados");
        Destino d3 = new Destino(3, 150, "Curridabat");
        Destino d4 = new Destino(4, 180, "Escazu");
        Destino d5 = new Destino(5, 300, "Guadalupe");
        Destino d6 = new Destino(6, 250, "Tibas");
        Destino d7 = new Destino(7, 270, "Alajuela");
        Destino d8 = new Destino(8, 220, "Santa Ana");
        Destino d9 = new Destino(8, 220, "Belen");
        Destino d10 = new Destino(8, 220, "Heredia Centro");
        Destino d11 = new Destino(8, 220, "Cartago");
        Destino d12 = new Destino(8, 220, "La Lima");
        Destino d13 = new Destino(8, 220, "Turrialba");

        grafoPonderado.agregarVertice(d1);
        grafoPonderado.agregarVertice(d2);
        grafoPonderado.agregarVertice(d3);
        grafoPonderado.agregarVertice(d4);
        grafoPonderado.agregarVertice(d5);
        grafoPonderado.agregarVertice(d6);
        grafoPonderado.agregarVertice(d7);
        grafoPonderado.agregarVertice(d8);
        grafoPonderado.agregarVertice(d9);
        grafoPonderado.agregarVertice(d10);
        grafoPonderado.agregarVertice(d11);
        grafoPonderado.agregarVertice(d12);
        grafoPonderado.agregarVertice(d13);

        grafoPonderado.agregarArista(d1, d2, 10);
        grafoPonderado.agregarArista(d1, d3, 9);
        grafoPonderado.agregarArista(d1, d4, 8);
        grafoPonderado.agregarArista(d1, d6, 6);
        grafoPonderado.agregarArista(d1, d5, 7);

        grafoPonderado.agregarArista(d2, d1, 10);
        grafoPonderado.agregarArista(d3, d1, 9);
        grafoPonderado.agregarArista(d6, d1, 6);

        grafoPonderado.agregarArista(d4, d8, 7);
        grafoPonderado.agregarArista(d8, d9, 6);
        grafoPonderado.agregarArista(d9, d7, 8);
        grafoPonderado.agregarArista(d7, d10, 12);

        grafoPonderado.agregarArista(d10, d6, 9);
        grafoPonderado.agregarArista(d6, d5, 5);

        grafoPonderado.agregarArista(d3, d11, 14);
        grafoPonderado.agregarArista(d11, d12, 6);
        grafoPonderado.agregarArista(d12, d13, 18);
        
        serializarGrafo(grafoPonderado);
        
        return grafoPonderado;
    }

    public static void serializarGrafo(GrafoPonderado<Destino> rutas) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter("grafo.json")) {
            gson.toJson(rutas, writer);
        }

    }

}
