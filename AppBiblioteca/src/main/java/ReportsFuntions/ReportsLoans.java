package ReportsFuntions;

import Lists.History;
import Lists.ListBooks;
import Models.Book;
import Models.Loan;
import Resources.Posters;
import SerializationFunctions.Serialitation;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * La clase ReportsLoans se encarga de generar y mostrar reportes
 * relacionados con el historial de préstamos de la biblioteca, incluyendo
 * búsquedas por nombre de usuario, título y UUID de libro.
 *
 * @author carlos
 */
public class ReportsLoans {

    private final Posters posters;
    private final Scanner entry;
    private final Serialitation serialization;

    /**
     * Constructor para inicializar una nueva instancia de ReportsLoans.
     *
     * @param posters Objeto para mostrar mensajes y menús al usuario.
     * @param entry Objeto para capturar la entrada del usuario.
     * @param serialitation Objeto para manejar la serialización de datos.
     */
    public ReportsLoans(Posters posters, Scanner entry, Serialitation serialitation) {
        this.serialization = serialitation;
        this.posters = posters;
        this.entry = entry;
    }
    
    /**
     * Valida si la lista de préstamos existe en el sistema.
     *
     * @return {@code true} si el historial de préstamos existe, {@code false} en caso contrario.
     */
    public boolean validateExistListBorrowedBooks() {
        return serialization.ValidateListLoanExist();
    }

    /**
     * Imprime en pantalla una lista completa de todas las transacciones de préstamo
     * y devolución registradas en el historial.
     */
    public void printLoanList() {
        History listLoans = serialization.deserealizacionListaDePrestamos();
        posters.mensajeEncabeadoReportes();

        if (listLoans.getListLoans().size() <= 0) {
            posters.mensajeNoSeEnocntoHistorialDePrestamos();
            entry.nextLine();
            return;
        }
        for (Loan loan : listLoans.getListLoans()) {
            posters.mostrarDatosPrestamoLibro(loan.getId().toString(), loan.getTitle(), loan.getUser(), loan.getOperation(), loan.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        }

        posters.mesajeContinuar();
        entry.nextLine();
    }

    /**
     * Permite al usuario buscar préstamos por el nombre de un usuario en un bucle interactivo.
     * El usuario puede salir del bucle ingresando "0".
     */
    public void searchForName() {
        String name;
        do {
            posters.mostrarMensajePedirNombre();
            name = entry.nextLine();

            if (name.equals("0")) {
                return;
            } else {
                if (validateExistListBorrowedBooks()) {
                    printByNamesList(serialization.deserealizacionListaDePrestamos(), name);
                } else {
                    posters.mensajeNoSeEnocntoHistorialDePrestamos();
                    entry.nextLine();
                    return;
                }
            }
        } while (true);
    }

    /**
     * Imprime en pantalla una lista de préstamos filtrada por el nombre de un usuario.
     *
     * @param listaDePrestamos El historial de préstamos completo.
     * @param name El nombre del usuario a buscar.
     */
    public void printByNamesList(History listaDePrestamos, String name) {
        posters.mensajeEncabeadoReportes();

        if (listaDePrestamos.getListByNames(name).isEmpty()) {
            posters.mensajeNoSeEnocntoHistorialDePrestamosUsuario();
            entry.nextLine();
            return;
        }
        for (Loan prestamo : listaDePrestamos.getListByNames(name)) {
            posters.mostrarDatosPrestamoLibro(prestamo.getId().toString(), prestamo.getTitle(), prestamo.getUser(), prestamo.getOperation(), prestamo.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        }

        posters.mesajeContinuar();
        entry.nextLine();
    }

    /**
     * Permite al usuario buscar préstamos por el título de un libro en un bucle interactivo.
     * El usuario puede salir del bucle ingresando "0".
     */
    public void searchForTitle() {
        String title;
        do {
            posters.mensajeEncabeadoReportes();
            posters.mostrarMensajePedriTituloLibro();
            title = entry.nextLine();

            if (title.equals("0")) {
                return;
            } else {
                if (validateExistListBorrowedBooks()) {
                    printByTitlesList(serialization.deserealizacionListaDePrestamos(), title);
                } else {
                    posters.mensajeNoSeEnocntoHistorialDePrestamos();
                    entry.nextLine();
                    return;
                }
            }
        } while (true);
    }

    /**
     * Imprime en pantalla una lista de préstamos filtrada por el título de un libro.
     *
     * @param listLoans El historial de préstamos completo.
     * @param title El título del libro a buscar.
     */
    public void printByTitlesList(History listLoans, String title) {
        posters.mensajeEncabeadoReportes();

        if (listLoans.getListByTitles(title).isEmpty()) {
            posters.mensajeNoSeEnocntoLibros();
            entry.nextLine();
            return;
        }
        for (Loan loan : listLoans.getListByTitles(title)) {
            posters.mostrarDatosPrestamoLibro(loan.getId().toString(), loan.getTitle(), loan.getUser(), loan.getOperation(), loan.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        }

        posters.mesajeContinuar();
        entry.nextLine();
    }

    /**
     * Muestra un submenú para que el usuario elija cómo buscar un libro en el historial de préstamos.
     */
    public void searhBook() {
        String option;
        do {
            posters.menuBusquedaLibroReportesPrestamo();
            option = entry.nextLine();
            switch (option) {
                case "1" ->
                    searhForUUID();
                case "2" -> {
                    searchForTitle();
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
     * Permite al usuario buscar préstamos por el UUID de un libro, con validación de formato.
     */
    public void searhForUUID() {
        String idAuxiliar;
        UUID id;
        do {
            posters.mostrarMensajePedirUUID();
            idAuxiliar = entry.nextLine();

            try {
                if (idAuxiliar.equals("0")) {
                    return;
                }
                id = UUID.fromString(idAuxiliar);

                if (validateExistListBorrowedBooks()) {
                    printByUUIDsList(serialization.deserealizacionListaDePrestamos(), id);
                } else {
                    posters.mensajeNoSeEnocntoHistorialDePrestamos();
                    entry.nextLine();
                    return;
                }
            } catch (Exception e) {
                posters.mostrarMensajeErrorUUIDinvalido();
                entry.nextLine();
            }
        } while (true);
    }

    /**
     * Imprime en pantalla una lista de préstamos filtrada por el UUID de un libro.
     *
     * @param listLoan El historial de préstamos completo.
     * @param id El UUID del libro a buscar.
     */
    public void printByUUIDsList(History listLoan, UUID id) {
        posters.mensajeEncabeadoReportes();

        if (listLoan.getListByUUIDS(id).isEmpty()) {
            posters.mensajeNoSeEnocntoHistorialDePrestamos();
            entry.nextLine();
            return;
        }
        for (Loan loan : listLoan.getListByUUIDS(id)) {
            posters.mostrarDatosPrestamoLibro(loan.getId().toString(), loan.getTitle(), loan.getUser(), loan.getOperation(), loan.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        }

        posters.mesajeContinuar();
        entry.nextLine();
    }
    
    // Métodos para reportes de popularidad de libros (Lógica duplicada)
    
    public void processPopularityReport() {
        ListBooks listBooks = serialization.deserealizacionListaDeLibros();

        if (listBooks.getOrderedBooks().isEmpty()) {
            posters.mensajeNoSeEnocntoHistorialDePrestamos();
            entry.nextLine();
        } else {
            imprimirLista(listBooks.getOrderedBooks());
        }
    }

    public void processUnpopularReport() {
        ListBooks listBooks = serialization.deserealizacionListaDeLibros();

        if (listBooks.getUnpopularBooks().isEmpty()) {
            posters.mensajeNoSeEnocntoHistorialDeNoPopulares();
            entry.nextLine();
        } else {
            imprimirLista(listBooks.getUnpopularBooks());
        }
    }

    public void imprimirLista(List<Book> listBooks) {
        posters.mensajeEncabeadoReportes();
        for (Book book : listBooks) {
            posters.mostrarDatosLibro(book.getId().toString(), book.getTitle(), book.getAutor(), book.getYear(), book.showStateLoan());
        }
        posters.mesajeContinuar();
        entry.nextLine();
    }
    
    public History getListBorrowd(UUID id) {
        boolean existList = serialization.ValidateListLoanExist();

        if (existList) {
            return serialization.deserealizacionListaDePrestamos();
        } else {
            posters.mensajeNoSeEnocntoHistorialDePrestamos();
            entry.nextLine();
            return null;
        }
    }
}