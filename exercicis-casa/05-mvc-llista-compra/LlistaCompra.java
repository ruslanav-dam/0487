/**
 * MODEL: LlistaCompra
 *
 * RESPONSABILITAT: Emmagatzemar els productes i fer càlculs.
 * Conté 1 BUG intencionat.
 *
 * @author La Salle Tarragona — Exercici Debugging MVC
 */
public class LlistaCompra {

    private Producte[] productes;
    private int numProductes;
    private static final int MAX = 20;

    public LlistaCompra() {
        productes = new Producte[MAX];
        numProductes = 0;
    }

    /**
     * Afegeix un producte a la llista.
     */
    public boolean afegir(String nom, double preu) {
        if (numProductes >= MAX) {
            return false;
        }
        productes[numProductes] = new Producte(nom, preu);
        numProductes++;
        return true;
    }

    /**
     * Elimina un producte per posició (1-based des de la vista).
     * @param index Posició 0-based
     */
    public boolean eliminar(int index) {
        if (index < 0 || index >= numProductes) {
            return false;
        }
        for (int i = index; i < numProductes - 1; i++) {
            productes[i] = productes[i + 1];
        }
        productes[numProductes - 1] = null;
        numProductes--;
        return true;
    }

    /**
     * Calcula el preu total de tots els productes.
     */
    public double calcularTotal() {
        double total = 0;
        // BUG: usa <= en lloc de <, accedeix a un element null!
        for (int i = 0; i <= numProductes; i++) {
            total += productes[i].getPreu();
        }
        return total;
    }

    public int getNumProductes() {
        return numProductes;
    }

    public Producte getProducte(int index) {
        if (index >= 0 && index < numProductes) {
            return productes[index];
        }
        return null;
    }
}
