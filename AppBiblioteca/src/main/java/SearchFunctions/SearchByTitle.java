package SearchFunctions;

import Lists.ListBooks;
import Models.Book;
import Resources.Posters;
import SerializationFunctions.Serialitation;
import java.util.Scanner;

/**
 * La clase SearchByTitle se encarga de buscar libros por título en el sistema de la biblioteca.
 *
 * @author Carlos Rodriguez 
 */
public class SearchByTitle {

    
    // Variables de instancia privadas para los recursos y funcionalidades de la busqueda por titulos.
    private final Posters posters;
    private final Scanner entry;
    private final Serialitation serealitation;

    /**
     * Constructor para inicializar una nueva instancia de SearchByTitle.
     * @param posters Objeto para mostrar mensajes al usuario.
     * @param entry Objeto para capturar la entrada del usuario desde la consola.
     * @param serialitation Objeto para manejar la serialización y deserialización de la lista de libros.
     */
    public SearchByTitle(Posters posters, Scanner entry, Serialitation serialitation) {
        this.posters = posters;
        this.entry = entry;
        this.serealitation = serialitation;
    }
    
    /**
     * Muestra un menú para que el usuario ingrese el título de un libro a buscar
     * y gestiona la lógica de búsqueda. El bucle continúa hasta que el usuario
     * ingrese "0" para salir.
     */
    public void searchForTitle() {
        String titulo = "";
        do {
            posters.mensajeBusquedaLibro();
            posters.mostrarMensajePedriTituloLibro();
            titulo = entry.nextLine();

            if (titulo.equals("0")) {
                return;
            } else {

                if (serealitation.validarListaLibrosExistente()) {
                    getBookListByTitle(titulo.toLowerCase());
                } else {
                    posters.mensajeNoSeEncontroLibrosEnBaseDatos();
                    entry.nextLine();
                }
            }
        } while (true);
    }

    /**
     * Obtiene y muestra una lista de libros que coinciden con el título de búsqueda.
     * @param title El título (convertido a minúsculas) a buscar en la lista de libros.
     */
    public void getBookListByTitle(String title) {
        
        ListBooks listBooks = serealitation.deserealizacionListaDeLibros();

        int total = listBooks.getListByTitles(title).size();

        posters.mensajeBusquedaLibro();

        if (total <= 0) {
            posters.mensajeNoSeEnocntoLibros();
            entry.nextLine();
            return;
        }

        for (Book book : listBooks.getListByTitles(title)) {
            posters.mostrarDatosLibro(book.getId().toString(), book.getTitle(), book.getAutor(), book.getYear(), book.showStateLoan());
        }

        posters.mesajeContinuar();
        entry.nextLine();

    }
}