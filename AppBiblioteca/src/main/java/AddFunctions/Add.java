package AddFunctions;

import Resources.Posters;
import SerializationFunctions.Serialitation;
import java.util.Scanner;

/**
 * La clase Add actúa como un punto de control para todas las funciones de
 * agregar libros a la biblioteca. Proporciona un menú al usuario para elegir
 * entre agregar libros manualmente o de forma automática desde un archivo.
 *
 * @author Carlos Rodriguez
 */
public class Add {

    private final Posters posters;
    private final Scanner entry;
    private final Addmanually addmanually;
    private final AddAutomatic addAutomatic;

    /**
     * Constructor para inicializar una nueva instancia de Add con sus dependencias.
     *
     * @param posters Objeto para mostrar mensajes y menús al usuario.
     * @param entry Objeto para capturar la entrada del usuario desde la consola.
     * @param serialitation Objeto para manejar la serialización de la lista de libros.
     */
    public Add(Posters posters, Scanner entry, Serialitation serialitation) {
        this.posters = posters;
        this.entry = entry;
        this.addmanually = new Addmanually(entry, posters, serialitation);
        this.addAutomatic = new AddAutomatic(entry, posters, serialitation);
    }

    /**
     * Muestra un menú de opciones para agregar libros y delega la tarea a la
     * clase correspondiente según la elección del usuario.
     */
    public void addBook() {
        String opcion;
        do {
            posters.menuaddBook();
            opcion = entry.nextLine();
            switch (opcion) {
                case "1" ->
                    addmanually.addManual();
                case "2" ->
                    addAutomatic.startProces();
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