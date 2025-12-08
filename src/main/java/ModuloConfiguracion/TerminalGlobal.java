/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModuloConfiguracion;

/**
 *
 * @author Dylan
 */
public class TerminalGlobal {
    
    // Para pasar el objeto terminal entre todas las clases

    private static Terminal terminal;

    public static Terminal getTerminal() {
        return terminal;
    }

    public static void setTerminal(Terminal t) {
        terminal = t;
    }
}