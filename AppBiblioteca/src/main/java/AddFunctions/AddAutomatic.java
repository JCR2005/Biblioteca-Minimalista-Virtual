package AddFunctions;

import Models.Book;
import Lists.ListBooks;
import LoanFunctions.Loans;
import SerializationFunctions.Serialitation;
import Resources.Posters;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * La clase AddAutomatic gestiona el proceso de agregar libros a la biblioteca
 * de forma automática a partir de un archivo CSV.
 *
 * @author Carlos Rodriguez
 */
public class AddAutomatic {

    // Variables de instancia privadas para los recursos y funcionalidades de agregado automatico de libros.
    private final Scanner entry;
    private final Posters posters;
    private final Serialitation serialitation;

    private final List<String> errors = new ArrayList<>();
    private final List<String> bookAdds = new ArrayList<>();
    private final Loans operationsLoans;

    /**
     * Constructor para inicializar una nueva instancia de Addmanually.
     *
     * @param entry Objeto Scanner para capturar la entrada del usuario.
     * @param posters Objeto Posters para mostrar mensajes y menús.
     * @param serialitation Objeto Serialitation para manejar la persistencia de
     * datos.
     */
    public AddAutomatic(Scanner entry, Posters posters, Serialitation serialitation) {
        this.operationsLoans = new Loans(posters, entry, serialitation);
        this.entry = entry;
        this.posters = posters;
        this.serialitation = serialitation;
    }

    /**
     * Inicia el proceso de agregar libros de forma automática solicitando la
     * ruta del archivo.
     */
    public void startProces() {
        getPath();
    }

    /**
     * Solicita al usuario la ruta de un archivo, valida la entrada y procesa el
     * archivo. El proceso se repite si la entrada es un campo vacío.
     */
    public void getPath() {

        String path = "";
        do {

            posters.mostrarMensajePedirRutaArchivo();
            path = entry.nextLine();

            if (path.equals("0")) {
                return;
            }
            if (path.isEmpty()) {
                posters.mostrarMensajeErrorCampoVacio();
                entry.nextLine();

            } else {

                printByCSV(path);
                return;

            }
        } while (true);

    }

    /**
     * Valida el archivo en la ruta especificada y lee su contenido para
     * procesar cada línea.
     *
     * @param path La ruta al archivo CSV.
     */
    public void printByCSV(String path) {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println(" Error: El archivo no existe");
            return;
        }
        if (!file.isFile()) {
            System.out.println(" Error: La ruta no corresponde a un archivo");
            return;
        }
        if (!file.getName().toLowerCase().endsWith(".csv")) {
            System.out.println(" Error: Solo se permiten archivos CSV");
            return;
        }

        try (BufferedReader br = Files.newBufferedReader(file.toPath())) {
            String linea;
            int numeroLinea = 1;
            numeroLinea++;
            while ((linea = br.readLine()) != null) {
                procesLine(linea, numeroLinea);
                numeroLinea++;
            }

        } catch (IOException e) {
            System.out.println(" Error al leer el archivo: " + e.getMessage());
        }

        showResults();
    }

    /**
     * Procesa una línea del archivo CSV, valida los datos y agrega el libro a
     * la lista.
     *
     * @param line La línea del archivo CSV a procesar.
     * @param LineNumber El número de la línea actual.
     */
    private void procesLine(String line, int LineNumber) {
        String[] spaces = line.split(",");

        if (spaces.length < 5) {
            errors.add("Línea " + LineNumber + ": formato incorrecto (se esperaban 5 campos).");
            return;
        }

        try {
            UUID id = UUID.fromString(spaces[0].trim());
            String title = spaces[1].trim();
            String autor = spaces[2].trim();
            int year = (int) Double.parseDouble(spaces[3].trim());
            boolean diponibility = Boolean.parseBoolean(spaces[4].trim());

            ValidateData(title, autor, year);

            Book book = new Book(id, title, autor, year, diponibility);
            ListBooks listBooks = new ListBooks();
            if (serialitation.validarListaLibrosExistente()) {
                listBooks = serialitation.deserealizacionListaDeLibros();
            }
            if (!diponibility) {
                validateLoan(id, title);
                book.setNumberOfTimesLoan(book.getNumberOfTimesBorrowed() + 1);
            }

            listBooks.addBookList(book);
            serialitation.serealizarListaDeLibros(listBooks);

            bookAdds.add("Línea " + LineNumber + ": " + title);
        } catch (NumberFormatException e) {
            errors.add("Línea " + LineNumber + ": formato incorrecto(Año no compatible). ");
        } catch (IllegalArgumentException e) {
            errors.add("Línea " + LineNumber + ": formato incorrecto (UUID inválido).");
        }
    }

    /**
     * Agrega un préstamo si la disponibilidad del libro es falsa.
     *
     * @param id El UUID del libro.
     * @param title El título del libro.
     */
    public void validateLoan(UUID id, String title) {

        operationsLoans.getLoanProces().addLoan(id, title, "User", "Prestamo", LocalDateTime.now(), true);

    }

    /**
     * Valida los datos del libro antes de su creación.
     *
     * @param title El título del libro.
     * @param autor El autor del libro.
     * @param year El año de publicación.
     * @throws IllegalArgumentException si algún dato no es válido.
     */
    private void ValidateData(String title, String autor, int year) {
        if (title.isEmpty() || autor.isEmpty()) {
            throw new IllegalArgumentException("Título o autor vacío");
        }
        int yearNow = Year.now().getValue();
        if (year < 1450 || year > yearNow) {
            throw new IllegalArgumentException("Año inválido: " + year);
        }
    }

    /**
     * Muestra los resultados del proceso de importación: libros agregados y
     * errores encontrados.
     */
    private void showResults() {
        if (!bookAdds.isEmpty()) {
            posters.printTopLine();
            for (String libro : bookAdds) {
                posters.printBookAddedByMeansOfFile(libro);
            }
            posters.printAcceptanceMessageForBooksAddedByArchive();
            entry.nextLine();
        }

        if (!errors.isEmpty()) {
            posters.printTopLine();
            for (String erro : errors) {
                posters.printBookAddedByMeansOfFile(erro);
            }
            posters.mostrarMensajeErrorLibrosRechasadosinvalido();
            entry.nextLine();
        }
        errors.clear();
        bookAdds.clear();

    }

}
