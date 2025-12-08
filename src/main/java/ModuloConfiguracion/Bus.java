package ModuloConfiguracion;

import AtencionTiquetes.*;
import CreacionTiquetes.*;

public class Bus implements Comparable<Bus>{

    private String terminal;
    private int numeroParadas;
    private TipoBus tipo;
    private String id;
    private ColaTiquetes cola;
    private Inspector inspector;

    public Bus(String terminal, int numeroParadas, TipoBus tipo, String id) {
        this.terminal = terminal;
        this.numeroParadas = numeroParadas;
        this.tipo = tipo;
        this.id = id;
        this.cola = new ColaTiquetes();
        this.inspector = new Inspector();
    }



    public Bus() {
    }

    public Inspector getInspector() {
        return inspector;
    }

    public ColaTiquetes getCola() {
        return cola;
    }

    public String getNumeroBus() {
        return id;
    }

    public void setNumeroBus(String numeroBus) {
        this.id = numeroBus;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public int getNumeroParadas() {
        return numeroParadas;
    }

    public void setNumeroParadas(int numeroParadas) {
        this.numeroParadas = numeroParadas;
    }

    public TipoBus getTipo() {
        return tipo;
    }

    public void setTipo(TipoBus tipo) {
        this.tipo = tipo;
    }


    public void crearTiquete(Tiquete t) {

        if (cola.estaVacia() && !inspector.isOcupado()) {
            System.out.println("La cola está vacía. El inspector atenderá el tiquete inmediatamente");
            inspector.atender(t);
        } else {
            cola.encolar(t);
            System.out.println("Tiquete " + t.getId() + " agregado a la cola del bus " + id);
        }
    }

    public Tiquete abordar() {
        if (inspector.isOcupado()) {
            System.out.println("El inspector está ocupado");
            return null;
        }
        if (cola.estaVacia()) {
            System.out.println("No hay tiquetes en espera");
            return null;
        }

        Tiquete t = cola.desencolar();
        System.out.println("Atendiendo tiquete " + t.getId() + " del bus " + id);
        Tiquete resultado = inspector.atender(t);
        
        return resultado;
        
    }

    @Override
    public int compareTo(Bus o) {
            return Integer.compare(this.cola.getCantidad(), o.cola.getCantidad());
        }
    }


