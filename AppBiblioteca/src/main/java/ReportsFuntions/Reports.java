package ReportsFuntions;


import SerializationFunctions.Serialitation;
import Resources.Posters;
import java.util.Scanner;

/**
 * La clase Reports actúa como el punto de entrada y el menú principal para
 * todas las funciones de reportes de la biblioteca. Delega las tareas
 * específicas de libros y préstamos a las clases ReportsBooks y ReportsLoans.
 *
 * @author Carlos Rodriguez
 */
public class Reports {

    private final Posters posters;
    private final Scanner entry;
    private final ReportsBooks reportsBooks;
    private final ReportsLoans reportsLoans;

    /**
     * Constructor para inicializar una nueva instancia de Reports.
     *
     * @param posters Objeto para mostrar mensajes y menús al usuario.
     * @param entry Objeto para capturar la entrada del usuario.
     * @param serialitation Objeto para manejar la serialización de datos.
     */
    public Reports(Posters posters, Scanner entry, Serialitation serialitation) {
        this.posters = posters;
        this.entry = entry;
        this.reportsBooks = new ReportsBooks(posters, entry, serialitation);
        this.reportsLoans = new ReportsLoans(posters, entry, serialitation);
    }

    /**
     * Muestra el menú de reportes y maneja la navegación según la opción
     * elegida por el usuario.
     */
    public void Reports() {
        String option;
        do {
            posters.showOptionsReportes();
            option = entry.nextLine();
            switch (option) {

                case "1" -> {
                    if (reportsBooks.validateExistListBooks()) {
                        reportsBooks.printList();
                    } else {
                        posters.mensajeNoSeEncontroLibrosEnBaseDatos();
                        entry.nextLine();
                    }
                }
                case "2" -> {
                    if (reportsBooks.validateExistListBooks()) {
                        reportsBooks.getListofAvailableBooks();
                    } else {
                        posters.mensajeNoSeEncontroLibrosEnBaseDatos();
                        entry.nextLine();
                    }
                }
                case "3" -> {
                    if (reportsBooks.validateExistListBooks()) {
                        reportsBooks.getListofBorrowedBooks();
                    } else {
                        posters.mensajeNoSeEncontroLibrosEnBaseDatos();
                        entry.nextLine();
                    }
                }
                case "4" -> {
                    if (reportsLoans.validateExistListBorrowedBooks()) {
                        reportsLoans.printLoanList();
                    } else {
                        posters.mensajeNoSeEnocntoHistorialDePrestamos();
                        entry.nextLine();
                    }
                }
                case "5" ->
                    reportsLoans.searhBook();
                case "6" ->
                    reportsLoans.searchForName();
                case "7" -> {
                    if (reportsLoans.validateExistListBorrowedBooks()) {
                        reportsLoans.processPopularityReport();
                    } else {
                        posters.mensajeNoSeEnocntoHistorialDePrestamos();
                        entry.nextLine();
                    }
                }
                case "8" -> {
                    if (reportsBooks.validateExistListBooks()) {
                        reportsLoans.processUnpopularReport();
                    } else {
                        posters.mensajeNoSeEnocntoHistorialDePrestamos();
                        entry.nextLine();
                    }
                }
                case "0" -> {
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