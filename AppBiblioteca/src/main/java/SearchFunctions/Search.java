package SearchFunctions;

import SerializationFunctions.Serialitation;
import Resources.Posters;
import java.util.Scanner;

/**
 * La clase Search actúa como un punto de control para todas las funciones de
 * búsqueda de libros dentro de la aplicación de la biblioteca. Delega las
 * tareas de búsqueda específicas a otras clases especializadas.
 *
 * @author Carlos Rodriguez
 */
public class Search {

    // Variables de instancia privadas para los recursos y funcionalidades de la búsqueda de libros.
    private final SearchByTitle searchByTitle;
    private final SearchByUUID searchByUUID;
    private final Posters posters;
    private final Scanner entry;

    /**
     * Constructor para inicializar la clase Search con sus dependencias.
     *
     * @param posters Objeto para mostrar mensajes y menús al usuario.
     * @param entry Objeto para capturar la entrada del usuario desde la
     * consola.
     * @param serialitation Objeto para manejar la serialización y
     * deserialización de la lista de libros.
     */
    public Search(Posters posters, Scanner entry, Serialitation serialitation) {
        this.posters = posters;
        this.entry = entry;
        this.searchByTitle = new SearchByTitle(posters, entry, serialitation);
        this.searchByUUID = new SearchByUUID(posters, entry, serialitation);
    }

    /**
     * Muestra el menú principal de búsqueda de libros y gestiona la selección
     * del usuario. El bucle continúa hasta que el usuario elige la opción de
     * salir.
     */
    public void searchBook() {

        String option = "";
        do {

            posters.menuBusquedaLibro();
            option = entry.nextLine();
            switch (option) {

                case "1" ->
                    searchByUUID.searhForUUID();

                case "2" ->
                    searchByTitle.searchForTitle();

                case "3" -> {
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
