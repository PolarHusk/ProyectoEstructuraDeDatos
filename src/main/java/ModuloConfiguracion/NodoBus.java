/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModuloConfiguracion;

/**
 *
 * @author Dylan
 */
public class NodoBus<T> {

    private T dato;
    private NodoBus<T> siguiente;//El enlace

    public NodoBus() {
    }

    public NodoBus(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoBus<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBus<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return dato.toString();
    }

}
