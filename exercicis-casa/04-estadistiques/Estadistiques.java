/**
 * EXERCICI CASA 04 — Estadístiques d'un Array
 *
 * CONCEPTE: Inspeccionar variables dins bucles + Watches
 * DIFICULTAT: Mitjana-Alta (3 bugs)
 *
 * Aquest programa calcula estadístiques d'un array de notes d'alumnes:
 * - Nota mínima i màxima
 * - Mitjana
 * - Quants aprovats (>= 5) i suspesos
 *
 * PROBLEMA: Diversos resultats surten incorrectes!
 *
 * TASCA:
 * 1. Posa breakpoints dins dels bucles
 * 2. Afegeix WATCHES per seguir com canvien les variables
 * 3. Observa a cada iteració si el comportament és l'esperat
 * 4. Prova un breakpoint CONDICIONAL per saltar a una iteració concreta
 *
 * ENTREGA: El fitxer corregit + per cada bug:
 *   - Quin Watch has usat per trobar-lo
 *   - A quina iteració del bucle has vist que fallava
 *
 * @author La Salle Tarragona — Exercici Debugging
 */
public class Estadistiques {

    /**
     * Troba la nota mínima de l'array.
     */
    public static double trobarMinim(double[] notes) {
        // BUG: inicialitza a 0 — si totes les notes són positives, 0 sempre serà el mínim
        double min = 0;
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] < min) {
                min = notes[i];
            }
        }
        return min;
    }

    /**
     * Troba la nota màxima de l'array.
     */
    public static double trobarMaxim(double[] notes) {
        double max = notes[0];
        for (int i = 1; i < notes.length; i++) {
            if (notes[i] > max) {
                max = notes[i];
            }
        }
        return max;
    }

    /**
     * Calcula la mitjana de les notes.
     */
    public static double calcularMitjana(double[] notes) {
        double suma = 0;
        // BUG: el bucle comença a 1 en lloc de 0, es salta la primera nota!
        for (int i = 1; i < notes.length; i++) {
            suma += notes[i];
        }
        return suma / notes.length;
    }

    /**
     * Compta quants alumnes han aprovat (nota >= 5).
     */
    public static int comptarAprovats(double[] notes) {
        int aprovats = 0;
        for (int i = 0; i < notes.length; i++) {
            // BUG: usa > 5 en lloc de >= 5 (un 5.0 no compta com aprovat!)
            if (notes[i] > 5) {
                aprovats++;
            }
        }
        return aprovats;
    }

    public static void main(String[] args) {
        System.out.println("=== Estadístiques de Notes ===");
        System.out.println();

        double[] notes = {7.5, 3.0, 5.0, 9.2, 4.5, 6.8, 8.0, 5.0, 2.5, 7.0};

        System.out.println("Notes: {7.5, 3.0, 5.0, 9.2, 4.5, 6.8, 8.0, 5.0, 2.5, 7.0}");
        System.out.println("Total alumnes: " + notes.length);
        System.out.println();

        double min = trobarMinim(notes);
        double max = trobarMaxim(notes);
        double mitjana = calcularMitjana(notes);
        int aprovats = comptarAprovats(notes);
        int suspesos = notes.length - aprovats;

        System.out.println("Nota mínima: " + min + " (esperat: 2.5)");
        System.out.println("Nota màxima: " + max + " (esperat: 9.2)");
        System.out.println("Mitjana: " + mitjana + " (esperat: 5.85)");
        System.out.println("Aprovats (>= 5): " + aprovats + " (esperat: 7)");
        System.out.println("Suspesos: " + suspesos + " (esperat: 3)");
        System.out.println();

        // Verificació
        boolean totOk = (min == 2.5) && (max == 9.2)
                && (Math.abs(mitjana - 5.85) < 0.01)
                && (aprovats == 7);

        if (totOk) {
            System.out.println("Tot correcte!");
        } else {
            System.out.println("Hi ha errors! Usa el debugger per trobar-los.");
        }
    }
}
