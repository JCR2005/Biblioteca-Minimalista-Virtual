package Lists;

import Models.Loan;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * La clase History gestiona una lista de préstamos de libros (Loan).
 * Es serializable para permitir la persistencia de los datos del historial.
 *
 * @author Carlos Rodriguez
 */
public class History implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Loan> ListLoans = new ArrayList<>();

    /**
     * Agrega un nuevo préstamo a la lista de préstamos.
     *
     * @param loan El objeto Loan a agregar.
     */
    public void addLoanList(Loan loan) {
        ListLoans.add(loan);
    }

    /**
     * Obtiene la lista completa de préstamos.
     *
     * @return La lista de préstamos (ArrayList de objetos Loan).
     */
    public ArrayList<Loan> getListLoans() {
        return ListLoans;
    }

    /**
     * Establece la lista de préstamos.
     *
     * @param listLoans La nueva lista de préstamos para reemplazar la actual.
     */
    public void setListLoans(ArrayList<Loan> listLoans) {
        this.ListLoans = listLoans;
    }

    /**
     * Busca y devuelve el préstamo más reciente de un libro específico, identificado por su UUID.
     *
     * @param id El UUID del libro para el cual se busca el préstamo.
     * @return El objeto Loan del préstamo más reciente, o null si no se encuentra ningún préstamo.
     */
    public Loan getLoanBook(UUID id) {
        return ListLoans.stream()
                .filter(p -> p.getId().toString().equals(id.toString()))
                .max(Comparator.comparing(Loan::getDate))
                .orElse(null);
    }

    /**
     * Filtra y devuelve una lista de préstamos que contienen una parte del título de un libro.
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     *
     * @param titleAsociate El título o parte del título a buscar.
     * @return Una nueva lista con los préstamos que coinciden.
     */
    public ArrayList<Loan> getListByTitles(String titleAsociate) {
        return ListLoans.stream()
                .filter(prestamo -> prestamo.getTitle().toLowerCase()
                .contains(titleAsociate.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Filtra y devuelve una lista de préstamos que corresponden a un UUID específico de libro.
     *
     * @param id El UUID del libro a buscar.
     * @return Una nueva lista con los préstamos que coinciden.
     */
    public ArrayList<Loan> getListByUUIDS(UUID id) {
        return ListLoans.stream()
                .filter(prestamo -> prestamo.getId().equals(id))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    /**
     * Filtra y devuelve una lista de préstamos que contienen una parte del nombre de un usuario.
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     *
     * @param name El nombre o parte del nombre del usuario a buscar.
     * @return Una nueva lista con los préstamos que coinciden.
     */
    public ArrayList<Loan> getListByNames(String name) {
        return ListLoans.stream()
                .filter(prestamo -> prestamo.getUser().toLowerCase()
                .contains(name.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}