package Resources;

/**
 * La clase Posters maneja la visualización de mensajes y menús en la consola,
 * utilizando códigos de escape ANSI para dar formato y color al texto.
 *
 * @author carlos
 */
public class Posters {

    /** Código ANSI para restaurar el color y el formato del texto al predeterminado. */
    private final String ANSI_RESET = "\u001B[0m";
    /** Código ANSI para el color de texto negro. */
    private final String ANSI_BLACK = "\u001B[30m";
    /** Código ANSI para el color de texto rojo. */
    private final String ANSI_RED = "\u001B[31m";
    /** Código ANSI para el color de texto verde. */
    private static final String ANSI_GREEN = "\u001B[32m";
    /** Código de escape para texto en negrita. */
    private final String NEGRITE = "\033[0;1m";
    /** Código ANSI para el color de texto amarillo. */
    private final String ANSI_YELLOW = "\u001B[33m";

    /**
     * Obtiene el código de escape ANSI para restaurar el formato.
     *
     * @return El código de escape ANSI de restablecimiento.
     */
    public String getANSI_RESET() {
        return ANSI_RESET;
    }

    /**
     * Obtiene el código de escape ANSI para el color negro.
     *
     * @return El código de escape ANSI para el color negro.
     */
    public String getANSI_BLACK() {
        return ANSI_BLACK;
    }

    /**
     * Obtiene el código de escape ANSI para el color rojo.
     *
     * @return El código de escape ANSI para el color rojo.
     */
    public String getANSI_RED() {
        return ANSI_RED;
    }

    /**
     * Obtiene el código de escape para texto en negrita.
     *
     * @return El código de escape para negrita.
     */
    public String getNEGRITE() {
        return NEGRITE;
    }

    /**
     * Obtiene el código de escape ANSI para el color amarillo.
     *
     * @return El código de escape ANSI para el color amarillo.
     */
    public String getANSI_YELLOW() {
        return ANSI_YELLOW;
    }

    /**
     * Imprime una serie de saltos de línea para limpiar la pantalla de la consola.
     */
    public void salto() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

    public void mostrarLogo() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║ ╔════╗  ══╦══ ╔════╗  ╗     ══╦══ ╔════╗ ══╦══ ╔════╗ ╔════╗ ╔════╗  ║");
        System.out.println("║ ║    ║    ║   ║    ║  ║       ║   ║    ║   ║   ║      ║      ║    ║  ║");
        System.out.println("║ ╠════╩╗   ║   ╠════╩╗ ║       ║   ║    ║   ║   ╠═══╣  ║      ╠════╣  ║");
        System.out.println("║ ║     ║   ║   ║     ║ ║       ║   ║    ║   ║   ║      ║      ║    ║  ║");
        System.out.println("║ ╚═════╝ ══╩══ ╚═════╝ ╚════ ══╩══ ╚════╝   ╩   ╚════╝ ╚════╝ ╩    ╩  ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");

    }

    public void menuBiblioteca() {
       
        System.out.println(NEGRITE + "                               BIBLIOTECA                               ");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                      ║");
        System.out.println(NEGRITE + "                            1.BUSQUEDA DE LIBROS                        ");
        System.out.println("");
        System.out.println(NEGRITE + "                            2.AGREGAR LIBROS                            ");
        System.out.println("");
        System.out.println(NEGRITE + "                            3.RESPOTES                                  ");
        System.out.println("");
        System.out.println(NEGRITE + "                            4.SALIR                                     ");
        System.out.println("" + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Ingrese una opcion                                                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void mostrarMensajeError1() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println("");
        System.out.println("                  Por favor, ingrese una opción valida                  ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Presiones enter para iniciar                                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }

    public void mensajeEncabeadoAgregarLibro() {
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(NEGRITE + "                             ❝AGREGAR LIBRO❞                            " + ANSI_RESET);

    }

    public void mostrarMensajeAgregarLibro1() {
        salto();
        mensajeEncabeadoAgregarLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println("                 Por favor, ingresar el titulo del libro.               ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Presiones enter para continuar(para regresar ingrese 0)              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }

    public void mostrarMensajeAgregarLibro2() {
        salto();
        mensajeEncabeadoAgregarLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println("                  Por favor, ingresar el autor del libro.               ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Presiones enter para continuar(para regresar ingrese 0)              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }

    public void mostrarMensajeAgregarLibro3() {
        salto();
        mensajeEncabeadoAgregarLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println("          Por favor, ingresar el año de publicacion del libro.          ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Presiones enter para continuar(para regresar ingrese 0)              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }

    public void mostrarMensajeErrorCampoVacio() {

        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_RED + "                             ❌ CAMPO VACIO ❌                            " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_YELLOW + "                          (El campo esta vacio!)                       ");
        System.out.println("");
        System.out.println(" ⚠️ 1.El campo no puede ir vacion.\n"
                + " ⚠️ 2.Dio enter por error.\n"
                + " ⚠️ 3.Compruebe que ingreso un dato." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();
    }

    public void mostrarMensajeErrorAgregar2() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_RED + "                           ❌ VALOR INVALIDO ❌                           " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_YELLOW + "                   (El valor ingresado no es valido!)                   ");
        System.out.println("");
        System.out.println(" ⚠️ 1.El campo espera un valor numerico.\n"
                + " ⚠️ 2.Ingreso carcteres." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();
    }

    public void mostrarMensajeErrorAgregar3() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_RED + "                           ❌ FUERA DE RANGO ❌                           " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_YELLOW + "                 (El año ingresado esta fuera de rango!)                ");
        System.out.println("");
        System.out.println(" ⚠️ 1.El año debe ser mayor a 1450.\n"
                + " ⚠️ 2.El año ingresado debe ser menor o igual al año actual(2025)\n"
                + " ⚠️ 3.El formato ingresado no es corecto(formato aceptado: yyyy)" + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();
    }

    public void mensajeContinuar() {

        System.out.println("║ Presiones enter para continuar                                       ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }

    public void mostrarMensajeDePreguntaAgregarLibro(String titulo, String autor, int año) {

        salto();
        mensajeEncabeadoAgregarLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println(ANSI_YELLOW + "⚠ Por favor, verificar datos antes de agregar el libro a la biblioteca!. " + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("  ● Titulo: " + titulo);
        System.out.println("  ●  Autor: " + autor);
        System.out.println("  ●    Año: " + año);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("                         1.Agregar libro                                ");
        System.out.println("                         2.Volver a ingresar datos                      ");
        System.out.println("                         3.Cancelar y regresar                          ");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Ingrese una opcion                                                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void menuaddBook() {

        salto();
        mensajeEncabeadoAgregarLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println("                      1.Agregar libro manualmente                       ");
        System.out.println("");
        System.out.println("                      2.Agregar libros por archivo                      ");
        System.out.println("");
        System.out.println("                      3.Regresar                                        ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Ingrese una opcion                                                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void menuBusquedaLibro() {

        salto();
        mensajeBusquedaLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println("                          1.Busqueda por UUID                           ");
        System.out.println("");
        System.out.println("                          2.Busqueda por titulo                         ");
        System.out.println("");
        System.out.println("                          3.Regresar                                    ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Ingrese una opcion                                                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void menuBusquedaLibroReportesPrestamo() {

        salto();
        mensajeEncabeadoReportes();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println("                           1.Reporte por UUID                           ");
        System.out.println("");
        System.out.println("                           2.Reporte por titulo                         ");
        System.out.println("");
        System.out.println("                           3.Regresar                                   ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Ingrese una opcion                                                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void mensajeEncabeadoReportes() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(NEGRITE + "                                ❝REPORTE❞                               " + ANSI_RESET);

    }

    public void showOptionsReportes() {

        salto();
        mensajeEncabeadoReportes();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println("                  1.Lista completa de libros                            ");
        System.out.println("");
        System.out.println("                  2.Lista de libros disponibles                         ");
        System.out.println("");
        System.out.println("                  3.Lista de libros no disponibles                      ");
        System.out.println("");
        System.out.println("                  4.Historial de prestamos y devoluciones               ");
        System.out.println("");
        System.out.println("                  5.Historial por titulo o UUID                         ");
        System.out.println("");
        System.out.println("                  6.Historial por usuario                               ");
        System.out.println("");
        System.out.println("                  7.Lista de libros populares                           ");
        System.out.println("");
        System.out.println("                  8.Lista de libros nunca prestados                     ");
        System.out.println("");
        System.out.println("                  0.Regresar                                            ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Ingrese una opcion                                                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void mostrarMensajePedirUUID() {
        salto();
        mensajeBusquedaLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println("                        Ingrese el UUID asociado                       ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Presiones enter para buscar(para regresar ingrese 0)                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }

    public void mesajeContinuar() {

        System.out.println("║ Presiones enter para buscar                                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void mensajeBusquedaLibro() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(NEGRITE + "                             BUSQUEDA LIBRO                             " + ANSI_RESET);

    }
    
    

    public void mensajePrestamoLibro() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println("                             ❝PRESTAMO LIBRO❞                           ");

    }

    public void menuPrestamo() {

        salto();
        mensajePrestamoLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("                           1.Realizar prestamo                          ");
        System.out.println("                           2.Cancelar                                   ");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Ingrese una opcion                                                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void pedirUsuarioPrestamo() {

        salto();
        mensajePrestamoLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("                     Ingrese el nombre del usuario                      ");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Presiones enter para continuar                                       ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void menuDevolucion() {

        salto();
        mensajePrestamoLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("                          1.Realisar devolución                         ");
        System.out.println("                          2.Cancelar                                    ");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Ingrese una opcion                                                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void menuOpcionesPrestamo() {

        System.out.println("                        1.Ver opciones de prestamo                      ");
        System.out.println("                        2.Continuar                                     ");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Ingrese una opcion                                                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void mostrarDatosLibro(String id, String titulo, String autor, int año, String diponibilidad) {

        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println(getNEGRITE() + "   UUID: " + id + getANSI_RESET()
                + "\n   Titulo:         " + titulo
                + "\n   Autor:          " + autor
                + "\n   Lanzamiento:    " + año
                + "\n   Disponibilidad: " + diponibilidad);
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");

    }

    public void mostrarDatosPrestamoLibro(String id, String titulo, String user, String accion, String fecha) {

        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println(getNEGRITE() + "   UUID: " + id + getANSI_RESET()
                + "\n   Titulo:         " + titulo
                + "\n   Usuario:        " + user
                + "\n   Proceso:        " + accion
                + "\n   fecha:          " + fecha);
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");

    }

    public void menuCancelacionPrestamoDevolcion(String accion) {

        System.out.println("  Presiones enter para realizar "+accion+"(para cancelar ingrese 0)   ");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

    }

    public void mostrarMensajeErrorUUIDinvalido() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_RED + "                          ❌ 𝙸𝙳 𝙽𝙾 𝚁𝙴𝙲𝙾𝙽𝙾𝙲𝙸𝙳𝙾 ❌                         " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_YELLOW + "               (𝙲𝚘𝚖𝚙𝚛𝚞𝚎𝚋𝚎 𝚜𝚒 𝚎𝚕 𝚒𝚍 𝚒𝚗𝚐𝚛𝚎𝚜𝚊𝚍𝚘 𝚎𝚜 𝚌𝚘𝚛𝚎𝚌𝚝𝚘!)             ");
        System.out.println("");
        System.out.println(" ⚠️ 1.El id ingresado no esta vinculado a ningun libro.\n"
                + " ⚠️ 2.Formato de id no identificado.\n"
                + " ⚠️ 3.Campo vacio." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();
    }

    public void mostrarMensajePedriTituloLibro() {
        
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println("                  Por favor, ingrese el titulo del libro                ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Presiones enter para buscar(para regresar ingrese 0)                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }

    public void mostrarMensajePedirNombre() {
       
        mensajePrestamoLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println("                Por favor, ingrese el nombre del usuario               ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Presiones enter para buscar(para regresar ingrese 0)                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }

    public void mensajeNoSeEnocntoLibros() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_YELLOW + "                        ⚠ Ningun libro encontrado ⚠                     " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_YELLOW + "               (𝙲𝚘𝚖𝚙𝚛𝚞𝚎𝚋𝚎 𝚜𝚒 𝚎𝚕 titulo 𝚒𝚗𝚐𝚛𝚎𝚜𝚊𝚍𝚘 𝚎𝚜 𝚌𝚘𝚛𝚎𝚌𝚝𝚘!)           ");
        System.out.println("");
        System.out.println(" ⚠️ 1.El titulo ingresado no esta vinculado a ningun libro.\n"
                + " ⚠️ 2.Titulo mal escrito.\n"
                + " ⚠️ 3.Campo vacio." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }

    public void mensajeNoSeEncontroLibrosEnBaseDatos() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_YELLOW + "                        ⚠ Ningun libro encontrado ⚠                     " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_YELLOW + "                          (Ningun libro agregado!)                      ");
        System.out.println("");
        System.out.println(" ⚠️ 1.Aun no sen han agregado libros a la base de datos .\n"
                + " ⚠️ 2.Compruebe con el administrador.\n"
                + " ⚠️ 3.Agrege libros a la base de datos." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }

    public void mensajeNoSeEnocntoLibrosDisponibles() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_YELLOW + "                        ⚠ Ningun libro encontrado ⚠                     " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_YELLOW + "                      (Ningun libro esta disponible!)                   ");
        System.out.println("");
        System.out.println(" ⚠️ 1.Comprobar en la lista general de libros.\n"
                + " ⚠️ 2.Todos los libros estan en prestamo" + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }

    public void mensajeNoSeEnocntoHistorialDePrestamos() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_YELLOW + "                      ⚠ Ningun prestamo encontrado ⚠                    " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_YELLOW + "                     (Ningun prestamo realizado aun!)                   ");
        System.out.println("");
        System.out.println(" ⚠️ 1.Comprobar en la lista general de libros.\n"
                + " ⚠️ 2.Todos los libros nunca han sido prestados." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }

    public void mensajeNoSeEnocntoHistorialDeNoPopulares() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_YELLOW + "                      ⚠ Ningun libro encontrado ⚠                    " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_YELLOW + "                      (Ningun libro no popular!)                   ");
        System.out.println("");
        System.out.println(" ⚠️ 1.Comprobar en la lista general de libros.\n"
                + " ⚠️ 2.Todos los libros han sido prestado minimo una sola ves." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }

    public void mensajeNoSeEnocntoHistorialDePrestamosUsuario() {
        salto();
                      System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_YELLOW + "                       ⚠ Ningun usuario encontrado ⚠                    " + ANSI_RESET);
                      System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_YELLOW + "                      (Ningun usuario asociado aun!)                   ");
        System.out.println("");
        System.out.println(" ⚠️ 1.Comprobar en la lista general de prestamos.\n"
                + " ⚠️ 2.Verificar que el usuario ingresado esa correcto." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }

    public void mensajeNoSeEnocntoLibrosNoDisponibles() {
        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_YELLOW + "                        ⚠ Ningun libro encontrado ⚠                     " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_YELLOW + "                       (Ningun libro esta prestado!)                    ");
        System.out.println("");
        System.out.println(" ⚠️ 1.Comprobar en la lista general de libros.\n"
                + " ⚠️ 2.Todos los libros estan disponibles" + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }

    public void mensajeDeAceptacionAgregarLibro() {

        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_GREEN + "                    ✅ LIBRO AGREGADO EXITOSAMENTE ✅️                     " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_GREEN + "                        (El libro fue agregado!)           ");
        System.out.println("");
        System.out.println(" 1.Puedes buscarlo, en las opciones de busqueda.\n"
                + " ️2.Puedes hacer operaciones de prestamo y devolucion." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }

    public void mensajeDeAceptacionPrestamoLibro() {

        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_GREEN + "                    ✅ LIBRO PRESTADO EXITOSAMENTE ✅️                    " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_GREEN + "                       (El libro fue prestado!)                         ");
        System.out.println("");
        System.out.println(" 1.El libro desde ahora ya no estara disponible.\n"
                + " ️2.El prestamo queda registrado en el historial." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }

    public void mensajeDeAceptacionDevolucionLibro() {

        salto();
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_GREEN + "                     ✅ LIBRO DEVUELTO EXITOSAMENTE ✅️                    " + ANSI_RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_GREEN + "                        (El libro fue devuelto!)                         ");
        System.out.println("");
        System.out.println(" 1.El libro desde ahora ya estara disponible.\n"
                + " ️2.La devoluvió queda registrado en el historial." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }

    
     public void mostrarMensajePedirRutaArchivo() {
        salto();
        mensajeEncabeadoAgregarLibro();
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("");
        System.out.println("                      Ingrese la ruta de su archivo                     ");
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Presiones enter para buscar(para regresar ingrese 0)                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }
     
     
     public void printAcceptanceMessageForBooksAddedByArchive() {

       
                     
        System.out.println(ANSI_GREEN + "                    ✅ LIBROS AGREGADOS EXITOSAMENTE ✅️                  " + ANSI_RESET);
                     System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_GREEN + "                (Los libros ya estan en la base de datos!)              ");
        System.out.println("");
        System.out.println(" 1.Solo los libros con datos correctos fueron agregados.");
        
        System.out.println("");
        System.out.println(ANSI_YELLOW+" 2.Observacion, si el libro ya existia, este se actualizara al archivo." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }
     
     public void printBookAddedByMeansOfFile(String libroAgregado){
     
         System.out.println("");
         System.out.println("  "+libroAgregado);
         System.out.println("");
         System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
     
     }
     
     public void printTopLine(){
     
         salto();
         System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
     
     }
     
     
     
     public void printMessageNoRejectedBooks() {

       
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");                
        System.out.println(ANSI_GREEN + "                      ✅ NO HAY LIBROS RECHAZADOS ✅️                     " + ANSI_RESET);
                     System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println(ANSI_GREEN + "                      (Los libros fueron aceptados!)                    ");
        System.out.println("");
        System.out.println(" 1.Todos los datos tenian el formato correcto." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();

    }
     
     
     
    public void mostrarMensajeErrorLibrosRechasadosinvalido() {
       
                  
        System.out.println(ANSI_RED + "                         ❌ LIBROS NO AGREGADOS ❌                        " + ANSI_RESET);
                   System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
     System.out.println(ANSI_YELLOW + "           (𝙲𝚘𝚖𝚙𝚛𝚞𝚎𝚋𝚎 que los datos 𝚒𝚗𝚐𝚛𝚎𝚜𝚊𝚍𝚘s son 𝚌𝚘𝚛𝚎𝚌𝚝𝚘s!)           ");
        System.out.println("");
        System.out.println(" ⚠️ 1.UUID no acuerdo al formato(0-9, a-f).\n"
                + " ⚠️ 2.Formato para año(YYYY, mayor a 1450 y menor al año actual).\n"
                + " ⚠️ 3.Sin titulo o autor." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();
    }
    
    
    public void mostrarMensajeErrorSerializacion() {
        salto();
                   System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println(ANSI_RED + "                          ❌ ALGO SALIO MAL ❌                         " + ANSI_RESET);
                   System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
     System.out.println(ANSI_YELLOW + "               (Ocurrio un problema con la base de datos!)             ");
        System.out.println("");
        System.out.println(" ⚠️ 1.El archivo no pudo ser obtenido\n"
                + " ⚠️ 2.Formato de archivo no valido.\n"
                + " ⚠️ 3.Contacta a soporte." + ANSI_RESET);
        System.out.println("");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        mensajeContinuar();
    }
    
}
