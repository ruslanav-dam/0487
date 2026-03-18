/**
 * EXERCICI 03 — Step Over, Step Into, Step Out
 *
 * SECCIÓ TEORIA: 4. Navegar pel codi pas a pas
 *
 * Una botiga calcula el preu final amb descomptes i IVA.
 * PROBLEMA: El preu final no quadra!
 *
 * OBJECTIU: Practicar Step Into per entrar dins mètodes
 *           i Step Over per saltar-los.
 *
 * PASSOS:
 * 1. Posa breakpoint a la línia "double preuFinal = calcularPreuFinal(...)"
 * 2. Fes STEP INTO (F7/F11) per entrar dins calcularPreuFinal()
 * 3. Dins, fes STEP INTO a aplicarDescompte() — veuràs el bug!
 * 4. Fes STEP OUT (Shift+F8/Shift+F11) per tornar
 * 5. STEP OVER (F8/F10) a aplicarIVA() — no cal entrar, funciona bé
 *
 * @author La Salle Tarragona — Exercici Debugging
 */
public class Botiga {

    /**
     * Aplica un descompte al preu.
     * @param preu Preu original
     * @param descompte Percentatge de descompte (ex: 20 per 20%)
     * @return Preu amb descompte
     */
    public static double aplicarDescompte(double preu, double descompte) {
        // BUG: suma el descompte en lloc de restar-lo!
        return preu + (preu * descompte / 100);
    }

    /**
     * Aplica l'IVA al preu.
     * @param preu Preu sense IVA
     * @return Preu amb 21% d'IVA
     */
    public static double aplicarIVA(double preu) {
        return preu * 1.21;
    }

    /**
     * Calcula el preu final: primer descompte, després IVA.
     */
    public static double calcularPreuFinal(double preu, double descompte) {
        double preuAmbDescompte = aplicarDescompte(preu, descompte);
        double preuAmbIVA = aplicarIVA(preuAmbDescompte);
        return preuAmbIVA;
    }

    public static void main(String[] args) {
        double preuOriginal = 100.0;
        double descompte = 20.0; // 20%

        double preuFinal = calcularPreuFinal(preuOriginal, descompte);

        System.out.println("Preu original: " + preuOriginal + " EUR");
        System.out.println("Descompte: " + descompte + "%");
        System.out.println("Preu final (amb IVA 21%): " + preuFinal + " EUR");
        System.out.println();
        System.out.println("Esperat: 100 - 20% = 80 → 80 * 1.21 = 96.80 EUR");
        System.out.println("(Si surt 145.20, el descompte s'està SUMANT!)");
    }
}
