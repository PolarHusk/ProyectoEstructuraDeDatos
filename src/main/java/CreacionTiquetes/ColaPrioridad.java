
package CreacionTiquetes;


public class ColaPrioridad {
    
    private Nodo frente; // Nodo del frente (inicio de la cola)
    private Nodo fin;    // Nodo del final (último en la cola)

    // Constructor: inicializa la cola vacía
    public ColaPrioridad() {
        frente = null;
        fin = null;
    }

    // Asigna prioridad según el tipo de bus
    // P = 1 (Preferencial), D = 2 (Directo), N = 3 (Normal)
    private int prioridad(String tipo) {
        if (tipo.equals("P")) return 1;
        if (tipo.equals("D")) return 2;
        if (tipo.equals("N")) return 3;
        return 4;
    }

    // Método para insertar (encolar) un nuevo tiquete según su prioridad
    public void encolar(Tiquete t) {
        Nodo nuevo = new Nodo(t);

        // Si la cola está vacía, el nuevo nodo es tanto frente como fin
        if (frente == null) {
            frente = fin = nuevo;
        } 
        // Si tiene mayor prioridad que el frente actual, se coloca al inicio
        else if (prioridad(t.getTipoBus()) < prioridad(frente.dato.getTipoBus())) {
            nuevo.siguiente = frente;
            frente = nuevo;
        } 
        // En otro caso, busca su posición según prioridad
        else {
            Nodo actual = frente;
            Nodo anterior = null;

            // Recorre hasta encontrar su posición correcta
            while (actual != null && prioridad(t.getTipoBus()) >= prioridad(actual.dato.getTipoBus())) {
                anterior = actual;
                actual = actual.siguiente;
            }

            // Inserta el nuevo nodo entre anterior y actual
            anterior.siguiente = nuevo;
            nuevo.siguiente = actual;

            // Si se insertó al final, se actualiza el puntero fin
            if (actual == null) {
                fin = nuevo;
            }
        }
    }

    // Método para eliminar (desencolar) el primer tiquete (frente)
    public Tiquete desencolar() {
        if (frente == null) return null; // Si está vacía, no hay nada que quitar
        Tiquete t = frente.dato;
        frente = frente.siguiente;
        if (frente == null) fin = null; // Si se eliminó el último, la cola queda vacía
        return t;
    }

    // Verifica si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Devuelve la cola completa como texto
    @Override
    public String toString() {
        if (frente == null) return "Cola vacía.";
        String texto = "";
        Nodo actual = frente;
        while (actual != null) {
            texto += actual.dato.toString() + "\n";
            actual = actual.siguiente;
        }
        return texto;
    }
    
}
