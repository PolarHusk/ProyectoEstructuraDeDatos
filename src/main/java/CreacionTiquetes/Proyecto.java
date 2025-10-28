

package CreacionTiquetes;


public class Proyecto {

    public static void main(String[] args) {
         // Se crea una nueva Cola de Prioridad
        ColaPrioridad cola = new ColaPrioridad();

        // Se agregan 10 tiquetes con diferentes tipos de bus y servicios
        // Se colocan manualmente las horas para no usar librerías externas
        cola.encolar(new Tiquete(" Ana ", 1, 25, " Colones ", " 10:00 ", "-1", " VIP ", " P "));
        cola.encolar(new Tiquete(" Luis ", 2, 33, " Dólares ", " 10:05 ", "-1", " Regular ", " N "));
        cola.encolar(new Tiquete(" Carlos ", 3, 45, "  Colones ", " 10:07 ", "-1", " Ejecutivo ", " D "));
        cola.encolar(new Tiquete(" María ", 4, 29, " Dólares ", " 10:09 ", "-1", " Regular ", " N "));
        cola.encolar(new Tiquete(" Elena ", 5, 21, " Colones ", " 10:11 ", "-1", " Carga ", " P "));
        cola.encolar(new Tiquete(" Tomás ", 6, 32, " Dólares ", " 10:15 ", "-1", " VIP ", " D "));
        cola.encolar(new Tiquete(" Lucía ", 7, 27, " Colones ", " 10:20 ", "-1", " Ejecutivo ", " N "));
        cola.encolar(new Tiquete(" Pedro ", 8, 40, " Colones ", " 10:23 ", "-1", " Regular ", " D "));
        cola.encolar(new Tiquete(" Sofía ", 9, 36, " Dólares ", " 10:25 ", "-1", " VIP ", " P "));
        cola.encolar(new Tiquete(" Jorge ", 10, 41, " Colones ", " 10:30 ", "-1", " Regular ", " N "));

        // Se imprime toda la cola ordenada por prioridad
        System.out.println(" -----COLA DE PRIORIDAD DE TIQUETES---- ");
        System.out.println(cola.toString());
        
        ColaPrioridad ColaPrioridad = new ColaPrioridad();
        SerializacionColaPrioridad serializacionColaPrioridad = new SerializacionColaPrioridad(); 
        serializacionColaPrioridad.serializarColaPrioridad(cola,"valoresColaPrioridad.json");
    }
}
      
    

