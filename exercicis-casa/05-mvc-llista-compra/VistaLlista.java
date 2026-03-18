import java.util.Scanner;

/**
 * VISTA: VistaLlista
 *
 * RESPONSABILITAT: Mostrar informació a pantalla i llegir dades.
 * Conté 1 BUG intencionat.
 *
 * @author La Salle Tarragona — Exercici Debugging MVC
 */
public class VistaLlista {

    private Scanner scanner;

    public VistaLlista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("=== LLISTA DE LA COMPRA ===");
        System.out.println("1. Afegir producte");
        System.out.println("2. Eliminar producte");
        System.out.println("3. Veure llista");
        System.out.println("4. Veure total");
        System.out.println("5. Sortir");
        System.out.print("Opció: ");
    }

    public int llegirOpcio() {
        while (!scanner.hasNextInt()) {
            System.out.print("Introdueix un número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String llegirNomProducte() {
        System.out.print("Nom del producte: ");
        scanner.nextLine(); // netejar buffer
        return scanner.nextLine();
    }

    public double llegirPreu() {
        System.out.print("Preu: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Introdueix un número: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public int llegirPosicio() {
        System.out.print("Número del producte a eliminar: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Introdueix un número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Mostra la llista de productes.
     * BUG: mostra els índexs des de 0, però l'usuari espera des de 1.
     */
    public void mostrarLlista(LlistaCompra llista) {
        if (llista.getNumProductes() == 0) {
            System.out.println("La llista està buida.");
            return;
        }
        System.out.println("--- Productes ---");
        for (int i = 0; i < llista.getNumProductes(); i++) {
            Producte p = llista.getProducte(i);
            // BUG: mostra i en lloc de i+1, però l'eliminació espera número 1-based
            System.out.println(i + ". " + p.getNom() + " - " + p.getPreu() + " EUR");
        }
    }

    public void mostrarTotal(double total) {
        System.out.printf("TOTAL: %.2f EUR%n", total);
    }

    public void mostrarMissatge(String missatge) {
        System.out.println(missatge);
    }

    public void mostrarComiat() {
        System.out.println("Adéu!");
    }
}
