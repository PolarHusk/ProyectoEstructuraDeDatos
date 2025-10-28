
package CreacionTiquetes;


// Clase que representa un nodo de la cola de prioridad

public class Nodo {
    Tiquete dato; // Objeto Tiquete que guarda la información del cliente
    Nodo siguiente;   // Referencia al siguiente nodo de la cola

    // Constructor, inicializa el nodo con el tiquete recibido
    public Nodo(Tiquete dato) {
        this.dato = dato;
        this.siguiente = null; // el siguiente nodo es nulo
    }
}
    

