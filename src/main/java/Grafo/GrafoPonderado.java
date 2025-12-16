package Grafo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GrafoPonderado<T extends Comparable<T>> {

    private Lista<Vertice<T, Arista<T>>> vertices;

    public GrafoPonderado() {
        vertices = new Lista<>();
    }

    public void agregarVertice(T dato) {
        if (buscarVertice(dato) == null) {
            vertices.addOrderAscUniq(new Vertice<>(dato));
        }
    }

    public void agregarArista(T origen, T destino, int peso) {
        Vertice<T, Arista<T>> vOrigen = buscarVertice(origen);
        if (vOrigen != null) {
            vOrigen.getAdyacentes().addOrderAscUniq(new Arista<>(destino, peso));
        }
    }

    private Vertice<T, Arista<T>> buscarVertice(T dato) {
        Nodo<Vertice<T, Arista<T>>> actual = vertices.getCabeza();
        while (actual != null) {
            if (actual.getDato().getValor().equals(dato)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void imprimir() {
        Nodo<Vertice<T, Arista<T>>> actual = vertices.getCabeza();
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    public Lista<Destino> obtenerVertices() {
        Lista<Destino> lista = new Lista<>();

        Nodo<Vertice<T, Arista<T>>> actual = vertices.getCabeza();
        while (actual != null) {
            lista.addOrderAscUniq((Destino) actual.getDato().getValor());
            actual = actual.getSiguiente();
        }
        return lista;
    }

    public String dijkstra(Destino origen, Destino destino) {

        Map<Destino, Integer> dist = new HashMap<>();
        Map<Destino, Destino> previo = new HashMap<>();
        PriorityQueue<Destino> cola
                = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        // Inicializar distancias
        Lista<Destino> vertices = obtenerVertices();
        Nodo<Destino> aux = vertices.getCabeza();

        while (aux != null) {
            dist.put(aux.getDato(), Integer.MAX_VALUE);
            aux = aux.getSiguiente();
        }

        dist.put(origen, 0);
        cola.add(origen);

        // Dijkstra
        while (!cola.isEmpty()) {
            Destino actual = cola.poll();

            if (actual.equals(destino)) {
                break;
            }

            Vertice<T, Arista<T>> vActual = buscarVertice((T) actual);
            if (vActual == null) {
                continue;
            }

            Nodo<Arista<T>> ady = vActual.getAdyacentes().getCabeza();
            while (ady != null) {
                Arista<Destino> arista = (Arista<Destino>) ady.getDato();
                Destino vecino = arista.getDestino();

                int nuevaDist = dist.get(actual) + arista.getPeso();

                if (nuevaDist < dist.get(vecino)) {
                    dist.put(vecino, nuevaDist);
                    previo.put(vecino, actual);
                    cola.add(vecino);
                }
                ady = ady.getSiguiente();
            }
        }

        return construirRuta(origen, destino, previo, dist);
    }

    private String construirRuta(Destino origen,Destino destino,Map<Destino, Destino> previo,Map<Destino, Integer> dist) {

        if (!dist.containsKey(destino) || dist.get(destino) == Integer.MAX_VALUE) {
            return "No existe ruta entre " + origen.getNombre()
                    + " y " + destino.getNombre();
        }

        Lista<Destino> camino = new Lista<>();
        Destino actual = destino;

        while (actual != null) {
            camino.addFirst(actual);
            actual = previo.get(actual);
        }

        StringBuilder sb = new StringBuilder("Ruta más corta:\n");

        Nodo<Destino> aux = camino.getCabeza();
        while (aux != null) {
            sb.append(aux.getDato().getNombre());
            if (aux.getSiguiente() != null) {
                sb.append(" → ");
            }
            aux = aux.getSiguiente();
        }

        sb.append("\nCosto total: ").append(dist.get(destino));
        return sb.toString();
    }

}
