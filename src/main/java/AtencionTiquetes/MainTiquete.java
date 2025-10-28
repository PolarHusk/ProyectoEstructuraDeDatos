/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AtencionTiquetes;

/**
 *
 * @author SEBAS
 */
public class MainTiquete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bus bus1 = new Bus("Bus-01", 5);

        bus1.crearTiquete("Sebastian", 1001, 25, "USD", "VIP");
        bus1.crearTiquete("Laura", 1002, 30, "USD", "Regular");
        bus1.crearTiquete("Pedro", 1003, 40, "USD", "Carga");

        System.out.println("\n--- Abordar siguiente tiquete ---");
        bus1.abordar();

        System.out.println("\n--- Abordar siguiente tiquete ---");
        bus1.abordar();
    }
    
}
