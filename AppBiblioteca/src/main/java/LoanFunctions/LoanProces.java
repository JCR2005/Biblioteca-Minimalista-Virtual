package LoanFunctions;

import Lists.History;
import Models.Book;
import Models.Loan;
import Resources.Posters;
import SerializationFunctions.Serialitation;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

/**
 * La clase LoanProces gestiona el proceso de préstamo de un libro,
 * incluyendo la interacción con el usuario, la actualización del estado del libro
 * y el registro en el historial.
 *
 * @author Carlos Rodriguez
 */
public class LoanProces {

    // Variables de instancia privadas para los recursos y funcionalidades de préstamo de libro.
    private final Posters posters;
    private final Scanner entry;
    private final Serialitation serealitation;

    /**
     * Constructor para inicializar una nueva instancia de LoanProces.
     *
     * @param posters Objeto para mostrar mensajes y menús al usuario.
     * @param entry Objeto para capturar la entrada del usuario.
     * @param serialitation Objeto para manejar la serialización de datos.
     */
    public LoanProces(Posters posters, Scanner entry, Serialitation serialitation) {
        this.posters = posters;
        this.entry = entry;
        this.serealitation = serialitation;
    }

    /**
     * Muestra un menú para iniciar el proceso de préstamo de un libro y maneja
     * la entrada del usuario.
     *
     * @param book El libro que se va a prestar.
     */
    public void Loan(Book book) {
        String option;
        do {
            posters.menuPrestamo();
            option = entry.nextLine();

            switch (option) {
                case "1" -> {
                    realiceProcesLoan(book);
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
     * Realiza el proceso completo de préstamo, solicitando el nombre del usuario,
     * mostrando la confirmación y actualizando el estado del libro.
     *
     * @param book El libro que se va a prestar.
     */
    public void realiceProcesLoan(Book book) {
        String user = getNameUser();

        posters.mensajePrestamoLibro();
        posters.mostrarDatosPrestamoLibro(book.getId().toString(), book.getTitle(), user, "Prestamo", LocalDateTime.now().toString());

        posters.menuCancelacionPrestamoDevolcion("el prestamo");
        String option = entry.nextLine();
        if (option.equals("0")) {
            return;
        }
        addLoan(book.getId(), book.getTitle(), user, "Prestamo", LocalDateTime.now(), false);
        book.setDisonibilityState(false);
        book.setNumberOfTimesLoan(book.getNumberOfTimesBorrowed() + 1);
    }

    /**
     * Agrega un nuevo registro de préstamo al historial de la biblioteca y lo serializa.
     *
     * @param id El UUID del libro.
     * @param title El título del libro.
     * @param user El nombre del usuario.
     * @param operation La operación realizada (en este caso, "Prestamo").
     * @param date La fecha y hora del préstamo.
     * @param automatic Booleano que indica si la operación fue automática (true) o manual (false).
     */
    public void addLoan(UUID id, String title, String user, String operation, LocalDateTime date, boolean automatic) {
        Loan loan = new Loan(id, title, user, "Prestamo", date);
        History history = new History();

        if (serealitation.ValidateListLoanExist()) {
            history = serealitation.deserealizacionListaDePrestamos();
        }
        history.addLoanList(loan);
        serealitation.serealizarListaDePrestamos(history);
        if (!automatic) {
            posters.mensajeDeAceptacionPrestamoLibro();
            entry.nextLine();
        }
    }

    /**
     * Solicita y valida el nombre del usuario para el préstamo, asegurando que el campo no esté vacío.
     *
     * @return El nombre del usuario ingresado.
     */
    public String getNameUser() {
        String user;
        do {
            posters.pedirUsuarioPrestamo();
            user = entry.nextLine();

            if (user.isEmpty()) {
                posters.mostrarMensajeErrorCampoVacio();
                entry.nextLine();
                entry.nextLine();
            } else {
                return user;
            }
        } while (true);
    }
}