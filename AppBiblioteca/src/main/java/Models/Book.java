package Models;

import java.io.Serializable;
import java.util.UUID;

/**
 * La clase Book representa un libro en la biblioteca. Contiene información como
 * su identificador único (UUID), título, autor, año de publicación, estado de
 * disponibilidad y el número de veces que ha sido prestado. Esta clase
 * implementa la interfaz Serializable para permitir la persistencia de sus
 * objetos en archivos.
 *
 * * @author Carlos Rodriguez
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    // Atributos de la clase
    private UUID id;
    private String title;
    private String autor;
    private int year;
    private boolean disponibilityState;
    private int numberOfTimesBorrowed = 0;

    /**
     * Constructor para crear un nuevo libro con un ID generado automáticamente.
     * El estado de disponibilidad se establece por defecto en true
     * (disponible).
     *
     * @param title El título del libro.
     * @param autor El autor del libro.
     * @param year El año de publicación del libro.
     */
    public Book(String title, String autor, int year) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.autor = autor;
        this.year = year;
        this.disponibilityState = true;
    }

    /**
     * Constructor para crear un libro a partir de datos existentes.
     *
     * @param id El identificador único del libro.
     * @param title El título del libro.
     * @param autor El autor del libro.
     * @param year El año de publicación del libro.
     * @param DisponibilityState El estado de disponibilidad del libro.
     */
    public Book(UUID id, String title, String autor, int year, boolean DisponibilityState) {
        this.id = id;
        this.title = title;
        this.autor = autor;
        this.year = year;
        this.disponibilityState = DisponibilityState;
    }

    /**
     * Obtiene el número de veces que el libro ha sido prestado.
     *
     * @return El número de préstamos.
     */
    public int getNumberOfTimesBorrowed() {
        return numberOfTimesBorrowed;
    }

    /**
     * Establece el número de veces que el libro ha sido prestado.
     *
     * @param numberOfTimesBorrowed El nuevo número de préstamos.
     */
    public void setNumberOfTimesLoan(int numberOfTimesBorrowed) {
        this.numberOfTimesBorrowed = numberOfTimesBorrowed;
    }

    /**
     * Devuelve el estado de disponibilidad del libro en un formato de texto
     * legible.
     *
     * @return "Disponible" si el libro está disponible, "No disponible" en caso
     * contrario.
     */
    public String showStateLoan() {
        if (!this.disponibilityState) {
            return "No disponible";
        }
        return "Disponible";
    }

    /**
     * Obtiene el identificador único del libro.
     *
     * @return El UUID del libro.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Establece el identificador único del libro.
     *
     * @param id El nuevo UUID del libro.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Obtiene el año de publicación del libro.
     *
     * @return El año de publicación.
     */
    public int getYear() {
        return year;
    }

    /**
     * Verifica el estado de disponibilidad del libro.
     *
     * @return {@code true} si el libro está disponible, {@code false} si no lo
     * está.
     */
    public boolean isDisponibilityState() {
        return disponibilityState;
    }

    /**
     * Establece el estado de disponibilidad del libro.
     *
     * @param estadoDisponibilidad El nuevo estado de disponibilidad.
     */
    public void setDisonibilityState(boolean estadoDisponibilidad) {
        this.disponibilityState = estadoDisponibilidad;
    }
}
