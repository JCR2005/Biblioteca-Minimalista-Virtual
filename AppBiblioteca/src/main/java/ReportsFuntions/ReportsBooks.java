package ReportsFuntions;

import Lists.ListBooks;
import Models.Book;
import Resources.Posters;
import SerializationFunctions.Serialitation;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/**
 * La clase ReportsBooks se encarga de generar y mostrar reportes específicos
 * sobre los libros de la biblioteca. Actúa como un módulo para visualizar
 * listas de todos los libros, libros disponibles y libros prestados.
 *
 * * @author Carlos Rodriguez
 */
public class ReportsBooks {

    private final Posters posters;
    private final Scanner entry;
    private final Serialitation serialization;

    /**
     * Constructor para inicializar una nueva instancia de ReportsBooks.
     *
     * @param posters Objeto para mostrar mensajes y menús al usuario.
     * @param entry Objeto para capturar la entrada del usuario.
     * @param serialitation Objeto para manejar la serialización de datos.
     */
    public ReportsBooks(Posters posters, Scanner entry, Serialitation serialitation) {
        this.serialization = serialitation;
        this.posters = posters;
        this.entry = entry;
    }

    /**
     * Valida si la lista de libros existe en la base de datos (archivo
     * serializado).
     *
     * @return {@code true} si la lista de libros existe, {@code false} en caso
     * contrario.
     */
    public boolean validateExistListBooks() {
        return serialization.validarListaLibrosExistente();
    }

    /**
     * Imprime en pantalla una lista completa de todos los libros registrados en
     * la biblioteca.
     */
    public void printList() {
        ListBooks listBooks = serialization.deserealizacionListaDeLibros();
        posters.mensajeEncabeadoReportes();

        for (Map.Entry<UUID, Book> bookEntry : listBooks.getListBooks().entrySet()) {
            Book book = bookEntry.getValue();
            posters.mostrarDatosLibro(book.getId().toString(), book.getTitle(), book.getAutor(), book.getYear(), book.showStateLoan());
        }

        posters.mesajeContinuar();
        entry.nextLine();
    }

    /**
     * Obtiene y muestra una lista de todos los libros que están disponibles
     * para préstamo. Si no hay libros disponibles, muestra un mensaje
     * informativo.
     */
    public void getListofAvailableBooks() {
        ListBooks listBooks = serialization.deserealizacionListaDeLibros();
        int total = listBooks.getListAviable().size();
        posters.mensajeEncabeadoReportes();

        if (total <= 0) {
            posters.mensajeNoSeEnocntoLibrosDisponibles();
            entry.nextLine();
            return;
        }

        for (Book book : listBooks.getListAviable()) {
            posters.mostrarDatosLibro(book.getId().toString(), book.getTitle(), book.getAutor(), book.getYear(), book.showStateLoan());
        }

        posters.mesajeContinuar();
        entry.nextLine();
    }

    /**
     * Obtiene y muestra una lista de todos los libros que se encuentran
     * actualmente en préstamo. Si no hay libros prestados, muestra un mensaje
     * informativo.
     */
    public void getListofBorrowedBooks() {
        ListBooks listBooks = serialization.deserealizacionListaDeLibros();
        int total = listBooks.getListLoan().size();
        posters.mensajeEncabeadoReportes();

        if (total <= 0) {
            posters.mensajeNoSeEnocntoLibrosNoDisponibles();
            entry.nextLine();
            return;
        }

        for (Book book : listBooks.getListLoan()) {
            posters.mostrarDatosLibro(book.getId().toString(), book.getTitle(), book.getAutor(), book.getYear(), book.showStateLoan());
        }

        posters.mesajeContinuar();
        entry.nextLine();
    }
}
