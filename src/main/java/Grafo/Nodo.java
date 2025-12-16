package Grafo;

/**
 *
 * @author keagui1
 */
public class Nodo<T> {

    private T dato;
    private Nodo<T> siguiente;//El enlace

    public Nodo() {
    }

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return dato.toString();
    }

}
