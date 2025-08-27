package Main;

import AddFunctions.Add;
import SearchFunctions.Search;
import ReportsFuntions.Reports;
import Resources.Posters;
import SerializationFunctions.Serialitation;
import java.util.Scanner;

/**
 * La clase Biblioteca gestiona las operaciones de una biblioteca, como la
 * búsqueda, adición y generación de reports de libros.
 *
 * @author Carlos Rodriguez
 */
public class Biblioteca {

    // Variables de instancia privadas para los recursos y funcionalidades de la biblioteca.
    private final Serialitation serealitation = new Serialitation();
    private final Posters posters;
    private final Scanner entry;
    private final Add add;
    private final Search search;
    private final Reports reports;

    /**
     * Constructor para inicializar una nueva instancia de Biblioteca.
     *
     * @param carteles Objeto de la clase posters para mostrar mensajes y menús.
     * @param entrada Objeto de la clase Scanner para capturar la entry del
     * usuario.
     */
    public Biblioteca(Posters carteles, Scanner entrada) {
        this.posters = carteles;
        this.entry = entrada;
        this.search = new Search(posters, entry, serealitation);
        this.add = new Add(posters, entry, serealitation);
        this.reports = new Reports(posters, entry, serealitation);
    }

    /**
     * Muestra el menú principal de la biblioteca y gestiona las opciones del
     * usuario a través de un bucle infinito hasta que el usuario decida salir.
     */
    public void SelectLibraryOptions() {
        String option = "";
        do {
            posters.mostrarLogo();
            posters.menuBiblioteca();
            option = entry.nextLine();

            switch (option) {
                case "1" ->
                    search.searchBook();
                case "2" ->
                    add.addBook();
                case "3" ->
                    reports.Reports();
                case "4" -> {
                    return;
                }
                default -> {
                    posters.mostrarMensajeError1();
                    entry.nextLine();
                }

            }
        } while (true);
    }
}
