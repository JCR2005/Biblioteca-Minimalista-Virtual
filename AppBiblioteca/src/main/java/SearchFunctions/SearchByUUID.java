package SearchFunctions;

import Lists.ListBooks;
import LoanFunctions.Loans;
import Models.Book;
import Resources.Posters;
import SerializationFunctions.Serialitation;
import java.util.Scanner;
import java.util.UUID;

/**
 * La clase SearchByUUID gestiona la búsqueda de libros usando un identificador
 * único (UUID). Esta clase también maneja las opciones de préstamo y devolución
 * de los libros encontrados.
 *
 * @author Carlos Rodriguez
 */
public class SearchByUUID {

    // Variables de instancia privadas para los recursos y funcionalidades de la búsqueda por UUID.
    private final Posters posters;
    private final Scanner entry;
    private final Serialitation serealitation;

    /**
     * Constructor para inicializar una nueva instancia de SearchByUUID.
     *
     * @param posters Objeto para mostrar mensajes y menús al usuario.
     * @param entry Objeto para capturar la entrada del usuario desde la
     * consola.
     * @param serialitation Objeto para manejar la serialización y
     * deserialización de la lista de libros.
     */
    public SearchByUUID(Posters posters, Scanner entry, Serialitation serialitation) {
        this.posters = posters;
        this.entry = entry;
        this.serealitation = serialitation;
    }

    /**
     * Muestra un menú para que el usuario ingrese el UUID de un libro a buscar
     * y gestiona la lógica de búsqueda. El bucle continúa hasta que el usuario
     * ingrese "0" para salir o se encuentre un UUID válido.
     */
    public void searhForUUID() {

        String idAuxiliar;
        UUID id;
        do {
            posters.mostrarMensajePedirUUID();
            idAuxiliar = entry.nextLine();
            if (idAuxiliar.equals("0")) {
                return;
            }
            try {

                id = UUID.fromString(idAuxiliar);

                if (serealitation.validarListaLibrosExistente()) {
                    showBooksByUUID(id);
                } else {
                    posters.mensajeNoSeEnocntoHistorialDePrestamos();
                    entry.nextLine();
                    return;
                }
                return;
            } catch (Exception e) {
                posters.mostrarMensajeErrorUUIDinvalido();
                entry.nextLine();

            }
        } while (true);

    }

    /**
     * Busca y muestra un libro usando su UUID. Una vez encontrado, se le
     * presentan al usuario las opciones de préstamo.
     *
     * @param id El UUID del libro a buscar.
     */
    public void showBooksByUUID(UUID id) {

        ListBooks listBooks = serealitation.deserealizacionListaDeLibros();
        Book book = listBooks.getListBooks().get(id);
        posters.mensajeBusquedaLibro();
        posters.mostrarDatosLibro(book.getId().toString(), book.getTitle(), book.getAutor(), book.getYear(), book.showStateLoan());
        opctionsLoans(book);
    }

    /**
     * Presenta un menú al usuario con opciones de préstamo o devolución para un
     * libro.
     *
     * @param book El objeto Book para el cual se mostrarán las opciones de
     * préstamo.
     */
    public void opctionsLoans(Book book) {
        Loans operationsLoans = new Loans(posters,entry,serealitation);
        String opcion = "";
        do {

            posters.menuOpcionesPrestamo();
            opcion = entry.nextLine();
            switch (opcion) {
                case "1" -> {
                    operationsLoans.startOptionsLoans(book.getId());
                    return;
                }

                case "2" -> {
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
