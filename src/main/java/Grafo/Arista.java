package Grafo;

/**
 *
 * @author keagui1
 */
public class Arista<T extends Comparable<T>> implements Comparable<Arista<T>> {

    private T destino;
    private int peso;

    public Arista(T destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public Arista() {
    }
    

    public T getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public int compareTo(Arista<T> otra) {
        return this.destino.compareTo(otra.destino);
    }

    @Override
    public String toString() {
        return destino + "(" + peso + ")";
    }
}
