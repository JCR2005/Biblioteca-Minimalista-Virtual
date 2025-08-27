package LoanFunctions;

import Lists.History;
import Models.Book;
import Models.Loan;
import Resources.Posters;
import SerializationFunctions.Serialitation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

/**
 * La clase ReturnProces gestiona el proceso de devolución de un libro,
 * incluyendo la actualización del estado del libro y el registro en el historial.
 *
 * @author Carlos Rodriguez
 */
public class ReturnProces {

    private final Posters posters;
    private final Scanner entry;
    private final Serialitation serealitation;

    /**
     * Constructor para inicializar una nueva instancia de ReturnProces.
     *
     * @param posters Objeto para mostrar mensajes y menús al usuario.
     * @param entry Objeto para capturar la entrada del usuario.
     * @param serialitation Objeto para manejar la serialización de datos.
     */
    public ReturnProces(Posters posters, Scanner entry, Serialitation serialitation) {
        this.posters = posters;
        this.entry = entry;
        this.serealitation = serialitation;
    }

    /**
     * Muestra un menú para iniciar el proceso de devolución de un libro.
     *
     * @param book El libro que se va a devolver.
     */
    public void returnBook(Book book) {
        String option;
        do {
            posters.menuDevolucion();
            option = entry.nextLine();

            switch (option) {
                case "1" -> {
                    realiceProcesReturn(book);
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

    /**
     * Realiza el proceso de devolución del libro, obteniendo los datos del préstamo,
     * confirmando con el usuario, y registrando la devolución.
     *
     * @param book El libro que se va a devolver.
     */
    public void realiceProcesReturn(Book book) {
        Loan loan = getDataLoan(book.getId());
        posters.mensajePrestamoLibro();
        posters.mostrarDatosPrestamoLibro(book.getId().toString(), book.getTitle(), loan.getUser(), "Devolucion", loan.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        posters.menuCancelacionPrestamoDevolcion("la devolución");
        String option = entry.nextLine();
        if (option.equals("0")) {
            return;
        }
        agregarDevolucion(book.getId(), book.getTitle(), loan.getUser(), "Devolucion", LocalDateTime.now());
        book.setDisonibilityState(true);
    }

    /**
     * Agrega un nuevo registro de devolución al historial de préstamos.
     *
     * @param id El UUID del libro.
     * @param title El título del libro.
     * @param user El nombre del usuario.
     * @param operation La operación realizada (en este caso, "Devolucion").
     * @param date La fecha y hora de la devolución.
     */
    public void agregarDevolucion(UUID id, String title, String user, String operation, LocalDateTime date) {
        Loan loan = new Loan(id, title, user, "Devolucion", date);
        History history = new History();

        if (serealitation.ValidateListLoanExist()) {
            history = serealitation.deserealizacionListaDePrestamos();
        }
        history.addLoanList(loan);
        serealitation.serealizarListaDePrestamos(history);
        posters.mensajeDeAceptacionDevolucionLibro();
        entry.nextLine();
    }

    /**
     * Obtiene los datos del último préstamo de un libro a partir del historial.
     *
     * @param id El UUID del libro.
     * @return El objeto Loan del préstamo más reciente.
     */
    public Loan getDataLoan(UUID id) {
        History historial = serealitation.deserealizacionListaDePrestamos();
        return historial.getLoanBook(id);
    }
}