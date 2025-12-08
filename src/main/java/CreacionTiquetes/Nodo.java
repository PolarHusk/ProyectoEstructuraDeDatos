package CreacionTiquetes;

// Clase que representa un nodo de la cola de prioridad
public class Nodo {

    private Tiquete dato;
    Nodo siguiente;

    public Nodo(Tiquete dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Tiquete getDato() {
        return dato;
    }

    public void setDato(Tiquete dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
