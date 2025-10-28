/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AtencionTiquetes;

public class ColaTiquetes {

     private Nodo frente;
    private Nodo fin;
    private int cantidad;

    public ColaTiquetes() {
        this.frente = null;
        this.fin = null;
        this.cantidad = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Tiquete t) {
        Nodo nuevo = new Nodo(t);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        cantidad++;
        System.out.println("Tiquete " + t.getId() + " agregado a la cola.");
    }

    public Tiquete desencolar() {
        if (estaVacia()) return null;
        Tiquete t = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) fin = null; // cola quedó vacía
        cantidad--;
        return t;
    }

    public int getCantidad() {
        return cantidad;
    }
}
