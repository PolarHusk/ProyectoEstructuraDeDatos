
package cr.ac.ufidelitas.proyectofinalestructuradedatos;


public class Bus {
    private String numeroBus;
    private String terminal;
    private int numeroParadas;
    private TipoBus tipo;

    public Bus(String numeroBus, String terminal, int numeroParadas, TipoBus tipo) {
        this.numeroBus = numeroBus;
        this.terminal = terminal;
        this.numeroParadas = numeroParadas;
        this.tipo = tipo;
    }
    
    public Bus(){}

    public String getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(String numeroBus) {
        this.numeroBus = numeroBus;
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
        
    
    
}
