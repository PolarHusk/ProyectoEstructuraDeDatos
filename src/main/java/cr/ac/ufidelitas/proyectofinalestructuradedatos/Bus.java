
package cr.ac.ufidelitas.proyectofinalestructuradedatos;


public abstract class Bus {
    private String numeroBus;
    private String ruta;
    private int numeroParadas;
    private TipoBus tipo;

    public Bus(String numeroBus, String ruta, int numeroParadas, TipoBus tipo) {
        this.numeroBus = numeroBus;
        this.ruta = ruta;
        this.numeroParadas = numeroParadas;
        this.tipo = tipo;
    }

    public String getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(String numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
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
    
    public abstract void mostrarBus();
    
    
    
}
