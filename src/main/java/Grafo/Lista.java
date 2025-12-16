package Grafo;

/**
 *
 * @author keagui1
 */
public class Lista<T extends Comparable<T>> {

    private Nodo<T> cabeza;

    public Lista() {
        this.cabeza = null;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public void addFirst(T newDato) {
        Nodo<T> nuevoNodo = new Nodo(newDato);
        nuevoNodo.setSiguiente(cabeza);
        this.cabeza = nuevoNodo;
    }

    public void addOrderAsc(T newDato) {
        Nodo<T> nuevoNodo = new Nodo(newDato);
        //compareTo:the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y

        // Si la lista está vacía o el nuevo dato es menor que el primero
        if (cabeza == null || newDato.compareTo(cabeza.getDato()) < 0) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            // Recorremos mientras no sea el último y el siguiente sea menor que newDato
            while (actual.getSiguiente() != null
                    && newDato.compareTo(actual.getSiguiente().getDato()) > 0) {
                actual = actual.getSiguiente();
            }
            // Insertamos el nuevo nodo después de actual
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
    }

    public void addOrderAscUniq(T newDato) {
        Nodo<T> nuevoNodo = new Nodo(newDato);
        //compareTo:the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y

        // Si la lista está vacía o el nuevo dato es menor que el primero
        if (cabeza == null || newDato.compareTo(cabeza.getDato()) < 0) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            // Recorremos mientras no sea el último y el siguiente sea menor que newDato
            while (actual.getSiguiente() != null) {
                int comparacion = newDato.compareTo(actual.getSiguiente().getDato());
                if (comparacion == 0) {
                    // Ya existe un dato igual, no se inserta
                    return;
                }
                actual = actual.getSiguiente();
            }
            // Insertamos el nuevo nodo después de actual
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public boolean remove(T dato) {
        // Si la lista está vacía
        if (cabeza == null) {
            return false;
        }

        // Si el nodo a remove está en la cabeza
        if (dato.compareTo(cabeza.getDato()) == 0) {
            cabeza = cabeza.getSiguiente();
            return true; // Eliminado
        }

        Nodo<T> actual = cabeza;

        // Recorremos hasta encontrar el nodo anterior al que queremos remove
        while (actual.getSiguiente() != null
                && dato.compareTo(actual.getSiguiente().getDato()) != 0) {
            actual = actual.getSiguiente();
        }

        // Si se encontró el nodo a remove
        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            return true; // Eliminado
        }

        return false; // No encontrado
    }

    public T removeT(T dato) {
        // Lista vacía
        if (cabeza == null) {
            return null;
        }

        // Si el dato está en la cabeza
        if (dato.compareTo(cabeza.getDato()) == 0) {
            T eliminado = cabeza.getDato();
            cabeza = cabeza.getSiguiente();
            return eliminado;
        }

        Nodo<T> actual = cabeza;

        // Buscar el nodo anterior al que queremos remove
        while (actual.getSiguiente() != null
                && dato.compareTo(actual.getSiguiente().getDato()) != 0) {
            actual = actual.getSiguiente();
        }

        // Si encontramos el nodo para remove
        if (actual.getSiguiente() != null) {
            T eliminado = actual.getSiguiente().getDato();
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            return eliminado;
        }

        // No encontrado
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.getDato()).append(" -> ");
            actual = actual.getSiguiente();
        }
        sb.append("null");
        return sb.toString();
    }

}
