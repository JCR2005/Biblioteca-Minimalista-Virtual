package Main;

import Resources.Posters;
import java.util.Scanner;

/**
 * La clase principal que sirve como punto de entrada para la aplicación de la
 * biblioteca. Desde aquí se inicializa y se ejecuta el menú principal.
 *
 * @author Carlos Rodriguez
 */
public class Main {

    /**
     * El método principal (main) de la aplicación.
     * @param args
     */
    public static void main(String[] args) {

        try (Scanner entry = new Scanner(System.in)) {
            Posters posters = new Posters();
            
            Biblioteca biblioteca = new Biblioteca(posters, entry);
            
            biblioteca.SelectLibraryOptions();
        }
    }
}
