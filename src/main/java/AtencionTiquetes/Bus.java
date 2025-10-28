/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AtencionTiquetes;

/**
 *
 * @author SEBAS
 */
public class Bus {
    
      private String id;
    private ColaTiquetes cola;
    private Inspector inspector;

    public Bus(String id, int capacidadCola) {
        this.id = id;
        this.cola = new ColaTiquetes();
        this.inspector = new Inspector();
    }

    public String getId() { return id; }
    public Inspector getInspector() { return inspector; }
    public ColaTiquetes getCola() { return cola; }

    public void crearTiquete(String nombre, int idT, int edad, String moneda, String servicio) {
        Tiquete t = new Tiquete(nombre, idT, edad, moneda, servicio, this.id);

        if (cola.estaVacia() && !inspector.isOcupado()) {
            System.out.println("La cola está vacía. El inspector atenderá el tiquete inmediatamente");
            inspector.atender(t);
        } else {
            cola.encolar(t);
            System.out.println("Tiquete " + t.getId() + " agregado a la cola del bus " + id);
        }
    }

    public void abordar() {
        if (inspector.isOcupado()) {
            System.out.println("El inspector está ocupado");
            return;
        }
        if (cola.estaVacia()) {
            System.out.println("No hay tiquetes en espera");
            return;
        }

        Tiquete t = cola.desencolar();
        System.out.println("Atendiendo tiquete " + t.getId() + " del bus " + id);
        inspector.atender(t);
    }
    
}
