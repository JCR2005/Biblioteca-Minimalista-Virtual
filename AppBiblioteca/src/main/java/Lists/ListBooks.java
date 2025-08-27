package Lists;

import Models.Book;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * La clase ListBooks gestiona la colección de libros de la biblioteca. Utiliza
 * un HashMap para almacenar los libros, lo que permite un acceso rápido a
 * través de su UUID.
 *
 * @author Carlos Rodriguez
 */
public class ListBooks implements Serializable {

    private static final long serialVersionUID = 1L;
    private HashMap<UUID, Book> listBooks = new HashMap();

    /**
     * Agrega un libro a la lista, usando su UUID como clave.
     *
     * @param book El objeto Book a agregar.
     */
    public void addBookList(Book book) {
        listBooks.put(book.getId(), book);
    }

    /**
     * Filtra la lista de libros por título de forma insensible a mayúsculas y
     * minúsculas.
     *
     * @param titleAsociate El título o una parte del título a buscar.
     * @return Una lista de libros que coinciden con el criterio de búsqueda.
     */
    public List<Book> getListByTitles(String titleAsociate) {
        return listBooks.values().stream()
                .filter(libro -> libro.getTitle().toLowerCase().contains(titleAsociate.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Obtiene una lista de todos los libros disponibles para préstamo.
     *
     * @return Una lista de libros disponibles.
     */
    public List<Book> getListAviable() {
        return listBooks.values().stream()
                .filter(Book::isDisponibilityState)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene una lista de todos los libros que se encuentran actualmente en
     * préstamo.
     *
     * @return Una lista de libros en préstamo.
     */
    public List<Book> getListLoan() {
        return listBooks.values().stream()
                .filter(libro -> !libro.isDisponibilityState())
                .collect(Collectors.toList());
    }

    /**
     * Obtiene el mapa completo de libros.
     *
     * @return El HashMap de libros.
     */
    public HashMap<UUID, Book> getListBooks() {
        return listBooks;
    }

    /**
     * Obtiene una lista de todos los libros ordenados por el número de veces
     * que han sido prestados, de mayor a menor.
     *
     * @return Una lista ordenada de los libros.
     */
    public List<Book> getOrderedBooks() {
        return this.listBooks.values()
                .stream()
                .filter(book -> book.getNumberOfTimesBorrowed() > 0)
                .sorted(Comparator.comparingInt(Book::getNumberOfTimesBorrowed).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Obtiene una lista de libros que no han sido prestados nunca.
     *
     * @return Una lista de libros impopulares.
     */
    public List<Book> getUnpopularBooks() {
        return this.listBooks.values().stream()
                .filter(libro -> libro.getNumberOfTimesBorrowed() == 0)
                .collect(Collectors.toList());
    }
}
