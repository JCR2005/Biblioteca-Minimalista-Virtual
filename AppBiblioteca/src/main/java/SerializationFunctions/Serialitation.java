package SerializationFunctions;

import Lists.History;
import Lists.ListBooks;
import Resources.Posters;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

/**
 * La clase Serialitation se encarga de gestionar la persistencia de datos para
 * la aplicación de la biblioteca. Maneja la serialización y deserialización de
 * los objetos ListBooks y History a archivos.
 *
 * @author carlos
 */
public class Serialitation {

    //Mensajes de advertemcia en caso de error.
    private final Posters posters = new Posters();

    /**
     * Detecta el sistema operativo y determina la ruta base para guardar los
     * archivos de la aplicación. Crea el directorio si no existe.
     *
     * @return La ruta absoluta del directorio de la aplicación.
     */
    public String detectarSistema() {
        String rutaBase;
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            rutaBase = System.getenv("APPDATA");
            if (rutaBase == null) {
                rutaBase = System.getProperty("user.home");
            }
        } else if (os.contains("mac")) {
            rutaBase = System.getProperty("user.home") + "/Library/Application Support";
        } else {
            rutaBase = System.getProperty("user.home");
        }

        rutaBase += File.separator + "Biblioteca";
        File carpeta = new File(rutaBase);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        return rutaBase;
    }

    /**
     * Valida si el archivo que contiene la lista de libros serializada existe
     * en el sistema.
     *
     * @return {@code true} si el archivo de la lista de libros existe,
     * {@code false} en caso contrario.
     */
    public boolean validarListaLibrosExistente() {
        String ruta = detectarSistema() + File.separator + "listaDeLibros.dat";
        File archivo = new File(ruta);
        return archivo.exists();
    }

    /**
     * Valida si el archivo que contiene el historial de préstamos serializado
     * existe en el sistema.
     *
     * @return {@code true} si el archivo del historial de préstamos existe,
     * {@code false} en caso contrario.
     */
    public boolean ValidateListLoanExist() {
        String ruta = detectarSistema() + File.separator + "historialDePrestamos.dat";
        File archivo = new File(ruta);
        return archivo.exists();
    }

    /**
     * Serializa un objeto ListBooks y lo guarda en un archivo.
     *
     * @param listaDeLibros La lista de libros a serializar.
     */
    public void serealizarListaDeLibros(ListBooks listaDeLibros) {
        String ruta = detectarSistema() + File.separator + "listaDeLibros.dat";
        try (ObjectOutputStream serealizar = new ObjectOutputStream(new FileOutputStream(ruta))) {
            serealizar.writeObject(listaDeLibros);
        } catch (IOException e) {
            posters.mostrarMensajeErrorSerializacion();

        }
    }

    /**
     * Deserializa la lista de libros desde un archivo.
     *
     * @return El objeto ListBooks deserializado, o {@code null} si ocurre un
     * error.
     */
    public ListBooks deserealizacionListaDeLibros() {
        String ruta = detectarSistema() + File.separator + "listaDeLibros.dat";
        try (ObjectInputStream deserealizar = new ObjectInputStream(new FileInputStream(ruta))) {
            return (ListBooks) deserealizar.readObject();
        } catch (IOException | ClassNotFoundException e) {
            posters.mostrarMensajeErrorSerializacion();

            return null;
        }
    }

    /**
     * Serializa un objeto History (historial de préstamos) y lo guarda en un
     * archivo.
     *
     * @param listaDePrestamos El historial de préstamos a serializar.
     */
    public void serealizarListaDePrestamos(History listaDePrestamos) {
        String ruta = detectarSistema() + File.separator + "historialDePrestamos.dat";
        try (ObjectOutputStream serealizar = new ObjectOutputStream(new FileOutputStream(ruta))) {
            serealizar.writeObject(listaDePrestamos);
        } catch (IOException e) {
            posters.mostrarMensajeErrorSerializacion();

        }
    }

    /**
     * Deserializa el historial de préstamos desde un archivo.
     *
     * @return El objeto History deserializado, o {@code null} si ocurre un
     * error.
     */
    public History deserealizacionListaDePrestamos() {
        String ruta = detectarSistema() + File.separator + "historialDePrestamos.dat";
        try (ObjectInputStream deserealizar = new ObjectInputStream(new FileInputStream(ruta))) {
            return (History) deserealizar.readObject();
        } catch (IOException | ClassNotFoundException e) {
            posters.mostrarMensajeErrorSerializacion();
            return null;
        }
    }
}
