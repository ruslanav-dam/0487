import java.util.Scanner;

/**
 * VISTA: VistaComptador
 *
 * RESPONSABILITAT: Mostrar informació a pantalla i llegir dades de l'usuari.
 * NO fa càlculs ni guarda dades.
 *
 * @author La Salle Tarragona - Exercici Debugging MVC
 */
public class VistaComptador {

    private Scanner scanner;

    /**
     * Constructor - Inicialitza el Scanner per llegir de teclat
     */
    public VistaComptador() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Mostra el menú principal a pantalla
     */
    public void mostrarMenu() {
        System.out.println();
        System.out.println("=== COMPTADOR ===");
        System.out.println("1. Incrementar (+1)");
        System.out.println("2. Decrementar (-1)");
        System.out.println("3. Reiniciar (0)");
        System.out.println("4. Sortir");
        System.out.print("Tria una opció: ");
    }

    /**
     * Llegeix l'opció de l'usuari
     *
     * @return El número d'opció triat
     */
    public int llegirOpcio() {
        while (!scanner.hasNextInt()) {
            System.out.print("Si us plau, introdueix un número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Mostra el valor actual del comptador
     *
     * @param valor El valor a mostrar
     */
    public void mostrarValor(int valor) {
        System.out.println("Comptador: " + valor);
    }

    /**
     * Mostra el missatge de comiat
     */
    public void mostrarComiat() {
        System.out.println("Adéu!");
    }
}
