
package CreacionTiquetes;


// Clase que representa la información de un tiquete de bus
public class Tiquete {
    // Atributos principales del tiquete
    private String nombre;
    private int id;
    private int edad;
    private String monedaCuenta;
    private String horaCompra;
    private String horaAbordaje;
    private String servicio;
    private String tipoBus;

    // Constructor: inicializa todos los valores del tiquete
    public Tiquete(String nombre, int id, int edad, String monedaCuenta, String horaCompra,
                   String horaAbordaje, String servicio, String tipoBus) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.monedaCuenta = monedaCuenta;
        this.horaCompra = horaCompra;
        this.horaAbordaje = horaAbordaje;
        this.servicio = servicio;
        this.tipoBus = tipoBus;
    }

    // Métodos GET y SET para acceder y modificar los atributos
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getMonedaCuenta() { return monedaCuenta; }
    public void setMonedaCuenta(String monedaCuenta) { this.monedaCuenta = monedaCuenta; }

    public String getHoraCompra() { return horaCompra; }
    public void setHoraCompra(String horaCompra) { this.horaCompra = horaCompra; }

    public String getHoraAbordaje() { return horaAbordaje; }
    public void setHoraAbordaje(String horaAbordaje) { this.horaAbordaje = horaAbordaje; }

    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }

    public String getTipoBus() { return tipoBus; }
    public void setTipoBus(String tipoBus) { this.tipoBus = tipoBus; }

    // Representación del objeto como texto (para mostrar en pantalla)
    @Override
    public String toString() {
        return "Tiquete { " +
                "nombre =' " + nombre + '\'' +
                ", id = " + id +
                ", edad = " + edad +
                ", monedaCuenta = ' " + monedaCuenta + '\'' +
                ", horaCompra = ' " + horaCompra + '\'' +
                ", horaAbordaje =  ' " + horaAbordaje + '\'' +
                ", servicio = ' " + servicio + '\'' +
                ", tipoBus= ' " + tipoBus + '\'' +
                '}';
    }
}