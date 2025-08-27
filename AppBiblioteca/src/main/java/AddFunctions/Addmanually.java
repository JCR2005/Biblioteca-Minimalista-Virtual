package AddFunctions;

import Models.Book;
import Lists.ListBooks;
import SerializationFunctions.Serialitation;
import Resources.Posters;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * La clase Addmanually se encarga de gestionar el proceso de agregar un nuevo libro
 * a la biblioteca de forma manual, interactuando con el usuario para obtener los datos.
 *
 * @author Carlos Rodriguez
 */
public class Addmanually {

    
    // Variables de instancia privadas para los recursos y funcionalidades de agregado manual de libros.
    private final Scanner entry;
    private final Posters posters;
    private final Serialitation serialitation;

    /**
     * Constructor para inicializar una nueva instancia de Addmanually.
     *
     * @param entry Objeto Scanner para capturar la entrada del usuario.
     * @param posters Objeto Posters para mostrar mensajes y menús.
     * @param serialitation Objeto Serialitation para manejar la persistencia de datos.
     */
    public Addmanually(Scanner entry, Posters posters, Serialitation serialitation) {
        this.entry = entry;
        this.posters = posters;
        this.serialitation = serialitation;
    }

    /**
     * Inicia el proceso de agregar un libro de forma manual, solicitando y validando
     * el título, autor y año de publicación.
     */
    public void addManual() {
        String title = addTitle();
        if (title == null) {
            return;
        }
        String autor = addAutor();
        if (autor == null) {
            return;
        }
        int year = addYear();
        if (year == 0) {
            return;
        }
        validateData(title, autor, year);
    }

    /**
     * Agrega un nuevo libro a la lista de libros y la serializa.
     *
     * @param title El título del libro.
     * @param autor El autor del libro.
     * @param year El año de publicación del libro.
     * @param existList Indica si ya existe una lista de libros serializada.
     */
    public void addBookListBooks(String title, String autor, int year, boolean existList) {
        Book book = new Book(title, autor, year);
        ListBooks listBooks = new ListBooks();
        if (existList) {
            listBooks = serialitation.deserealizacionListaDeLibros();
        }
        listBooks.addBookList(book);
        serialitation.serealizarListaDeLibros(listBooks);
        posters.mensajeDeAceptacionAgregarLibro();
        entry.nextLine();
    }

    /**
     * Valida la información del libro con el usuario antes de agregarlo.
     *
     * @param title El título del libro a validar.
     * @param autor El autor del libro a validar.
     * @param year El año de publicación del libro a validar.
     */
    public void validateData(String title, String autor, int year) {
        do {
            posters.mostrarMensajeDePreguntaAgregarLibro(title, autor, year);
            String option = entry.nextLine();
            switch (option) {
                case "1" -> {
                    addBookListBooks(title, autor, year, serialitation.validarListaLibrosExistente());
                    entry.nextLine();
                    return;
                }
                case "2" -> {
                    entry.nextLine();
                    addManual();
                    return;
                }
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

    /**
     * Solicita al usuario el título del libro y valida que no esté vacío.
     *
     * @return El título ingresado por el usuario, o null si el usuario cancela.
     */
    public String addTitle() {
        String titulo;
        boolean campoAceptado = false;
        do {
            posters.mostrarMensajeAgregarLibro1();
            titulo = entry.nextLine();
            if (titulo.equals("0")) {
                return null;
            }
            if (titulo.isEmpty()) {
                posters.mostrarMensajeErrorCampoVacio();
                entry.nextLine();
            } else {
                campoAceptado = true;
            }
        } while (!campoAceptado);
        return titulo;
    }

    /**
     * Solicita al usuario el autor del libro y valida que no esté vacío.
     *
     * @return El autor ingresado por el usuario, o null si el usuario cancela.
     */
    public String addAutor() {
        String autor;
        boolean campoAceptado = false;
        do {
            posters.mostrarMensajeAgregarLibro2();
            autor = entry.nextLine();
            if (autor.equals("0")) {
                return null;
            }
            if (autor.isEmpty()) {
                posters.mostrarMensajeErrorCampoVacio();
                entry.nextLine();
            } else {
                campoAceptado = true;
            }
        } while (!campoAceptado);
        return autor;
    }

    /**
     * Solicita al usuario el año de publicación del libro y valida el formato y el rango.
     *
     * @return El año de publicación ingresado por el usuario, o 0 si el usuario cancela o el dato es inválido.
     */
    public int addYear() {
        int año = 0;
        boolean campoAceptado = false;
        final int añoMinimo = 1450;
        final int añoMaximo = LocalDate.now().getYear();
        do {
            posters.mostrarMensajeAgregarLibro3();
            try {
                año = entry.nextInt();
                if (año == 0) {
                    entry.nextLine();
                    return 0;
                }
                if (año < añoMinimo || año > añoMaximo) {
                    posters.mostrarMensajeErrorAgregar3();
                    entry.nextLine();
                    entry.nextLine();
                } else {
                    campoAceptado = true;
                }
            } catch (Exception e) {
                posters.mostrarMensajeErrorAgregar2();
                entry.nextLine();
                entry.nextLine();
            }
        } while (!campoAceptado);
        entry.nextLine();
        return año;
    }
}