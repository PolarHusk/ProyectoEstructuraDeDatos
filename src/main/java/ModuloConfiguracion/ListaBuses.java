/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModuloConfiguracion;

/**
 *
 * @author Dylan
 */
public class ListaBuses<T extends Comparable<T>> {

    private NodoBus<T> cabeza;
    private NodoBus<T> fin;
    private int cantidad = 0;

    public ListaBuses() {
        this.cabeza = null;
    }

    public NodoBus<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoBus<T> cabeza) {
        this.cabeza = cabeza;
    }

    public void addFirst(T newDato) {

        NodoBus<T> nuevoNodo = new NodoBus(newDato);

        if (cabeza == null) {
            cabeza = fin = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza);
            this.cabeza = nuevoNodo;
        }
        cantidad++;

    }

    public void addOrderAsc(T newDato) {
        NodoBus<T> nuevoNodo = new NodoBus(newDato);
        //compareTo:the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y

        // Si la lista está vacía o el nuevo dato es menor que el primero
        if (cabeza == null || newDato.compareTo(cabeza.getDato()) < 0) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        } else {
            NodoBus<T> actual = cabeza;
            // Recorremos mientras no sea el último y el siguiente sea menor que newDato
            while (actual.getSiguiente() != null
                    && newDato.compareTo(actual.getSiguiente().getDato()) > 0) {
                actual = actual.getSiguiente();
            }
            // Insertamos el nuevo nodo después de actual
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
        cantidad++;

    }

    public void addOrderAscUniq(T newDato) {
        NodoBus<T> nuevoNodo = new NodoBus(newDato);
        //compareTo:the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y

        // Si la lista está vacía o el nuevo dato es menor que el primero
        if (cabeza == null || newDato.compareTo(cabeza.getDato()) < 0) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        } else {
            NodoBus<T> actual = cabeza;
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
        cantidad++;

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
            cantidad--;

            return true; // Eliminado
        }

        NodoBus<T> actual = cabeza;

        // Recorremos hasta encontrar el nodo anterior al que queremos remove
        while (actual.getSiguiente() != null
                && dato.compareTo(actual.getSiguiente().getDato()) != 0) {
            actual = actual.getSiguiente();
        }

        // Si se encontró el nodo a remove
        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            cantidad--;

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
            cantidad--;

            return eliminado;
        }

        NodoBus<T> actual = cabeza;

        // Buscar el nodo anterior al que queremos remove
        while (actual.getSiguiente() != null
                && dato.compareTo(actual.getSiguiente().getDato()) != 0) {
            actual = actual.getSiguiente();
        }

        // Si encontramos el nodo para remove
        if (actual.getSiguiente() != null) {
            T eliminado = actual.getSiguiente().getDato();
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            cantidad--;

            return eliminado;
        }

        // No encontrado
        return null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Bus buscarbusPorTipo(TipoBus tipo) {
        NodoBus<T> actual = cabeza;
        while (actual != null) {

            Bus bus = (Bus) actual.getDato();

            if (bus.getTipo() == tipo) {
                return bus;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public Bus buscarBusConMenorCola() {
        NodoBus<T> actual = cabeza;

        Bus seleccionado = null;

        int menorCola = Integer.MAX_VALUE;

        while (actual != null) {
            Bus bus = (Bus) actual.getDato();
            if (bus.getTipo() == TipoBus.NORMAL) {

                if (seleccionado == null || bus.compareTo(seleccionado) < 0) {
                    seleccionado = bus;
                }
            }
            actual = actual.getSiguiente();
        }
        return seleccionado;

    }

    public Bus buscarBusPorNumero(String id) {
        NodoBus<T> actual = cabeza;

        while (actual != null) {
            Bus bus = (Bus) actual.getDato();
            if (bus.getNumeroBus().equals(id)) {
                return bus;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public String toString() {

        if (isEmpty()) {
            System.out.println("Lista vacia!!");
        }

        StringBuilder sb = new StringBuilder();
        NodoBus<T> actual = this.cabeza;
        while (actual != null) {
            sb.append(actual.toString());
            actual = actual.getSiguiente();
            if (actual != null) {
                sb.append("->");
            }
        }
        return sb.toString().trim();
    }

}
