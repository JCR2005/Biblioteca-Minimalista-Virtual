package LoanFunctions;

import Models.Book;
import Lists.ListBooks;
import SerializationFunctions.Serialitation;
import Resources.Posters;
import java.util.Scanner;
import java.util.UUID;

/**
 * La clase OperationsLoans actúa como un punto de acceso central para gestionar
 * las operaciones de préstamo y devolución de libros.
 *
 * @author Carlos Rodriguez
 */
public class Loans {

    private final LoanProces loanProces;
    private final ReturnProces returnProces;
    private final Serialitation serialization;

    /**
     * Constructor para inicializar una nueva instancia de OperationsLoans.
     *
     * @param posters Objeto para mostrar mensajes y menús al usuario.
     * @param entry Objeto para capturar la entrada del usuario.
     * @param serialitation Objeto para manejar la serialización de datos.
     */
    public Loans(Posters posters, Scanner entry, Serialitation serialitation) {
        this.serialization = serialitation;
        this.loanProces = new LoanProces(posters, entry, serialitation);
        this.returnProces = new ReturnProces(posters, entry, serialitation);
    }
    
    /**
     * Obtiene el objeto LoanProces.
     *
     * @return El objeto LoanProces.
     */
    public LoanProces getLoanProces() {
        return loanProces;
    }

    /**
     * Muestra las opciones de préstamo o devolución para un libro específico,
     * basándose en su estado de disponibilidad.
     *
     * @param id El UUID del libro para el cual se desea realizar la operación.
     */
    public void startOptionsLoans(UUID id) {
        ListBooks listaDeLibros = serialization.deserealizacionListaDeLibros();
        Book libro = listaDeLibros.getListBooks().get(id);

        if (libro.isDisponibilityState()) {
            loanProces.Loan(libro);
        } else {
            returnProces.returnBook(libro);
        }
        serialization.serealizarListaDeLibros(listaDeLibros);
    }
}