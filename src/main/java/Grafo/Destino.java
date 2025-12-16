package Grafo;

public class Destino implements Comparable<Destino> {

    private int id;
    private int costo;
    private String nombre;

    public Destino(int id, int valor, String nombre) {
        this.id = id;
        this.costo = valor;
        this.nombre = nombre;
    }

    public Destino() {
    }
    

    public int getId() {
        return id;
    }

    public int getCosto() {
        return costo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Destino otro) {
        return Integer.compare(this.id, otro.id);
    }

    @Override
    public String toString() {
        return nombre + "(" + id + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Destino) {
            return this.id == ((Destino) obj).id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
