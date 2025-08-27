package Models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * La clase Loan representa un registro de una transacción de préstamo o devolución de un libro.
 * Almacena información clave sobre la transacción, como el UUID del libro,
 * el usuario, el tipo de operación y la fecha.
 * Esta clase es serializable para permitir que sus objetos se guarden en un archivo.
 * @author Carlos Rodriguez
 */
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final UUID id;
    private final String user;
    private final String operation;
    private final LocalDateTime date;
    private final String title;

    /**
     * Construye un nuevo objeto Loan con todos los detalles de la transacción.
     * Todos los campos son finales, por lo que el objeto es inmutable después de su creación.
     * @param id El identificador único (UUID) del libro.
     * @param title El título del libro.
     * @param user El nombre del usuario involucrado en la transacción.
     * @param operation El tipo de operación, como "Prestamo" o "Devolucion".
     * @param date La fecha y hora de la transacción.
     */
    public Loan(UUID id, String title, String user, String operation, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.operation = operation;
        this.date = date;
        this.title = title;
    }

    /**
     * Obtiene el título del libro.
     * @return El título del libro.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtiene el identificador único del libro.
     * @return El UUID del libro.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String getUser() {
        return user;
    }

    /**
     * Obtiene el tipo de operación (p. ej., "Prestamo" o "Devolucion").
     * @return El tipo de operación.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Obtiene la fecha y hora de la transacción.
     * @return La fecha y hora de la transacción.
     */
    public LocalDateTime getDate() {
        return date;
    }
}