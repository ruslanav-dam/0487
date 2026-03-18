/**
 * EXERCICI 04 — Inspeccionar variables dins un bucle
 *
 * SECCIÓ TEORIA: 5. Inspeccionar i modificar variables
 *
 * Aquest programa busca el valor màxim d'un array.
 * PROBLEMA: Retorna un valor incorrecte!
 *
 * OBJECTIU: Usar el panell de Variables i Watches per seguir
 *           com canvien les variables a cada iteració del bucle.
 *
 * PASSOS:
 * 1. Posa un breakpoint DINS del for, a la línia del if
 * 2. Afegeix un WATCH per a: max, numeros[i], i
 * 3. A cada iteració, observa si max s'actualitza quan toca
 * 4. Presta atenció al valor INICIAL de max
 *
 * BONUS: Prova un breakpoint CONDICIONAL amb condició: i == 3
 *        Així saltes directament a la 4a iteració.
 *
 * @author La Salle Tarragona — Exercici Debugging
 */
public class CercadorMax {

    /**
     * Troba el valor màxim d'un array d'enters.
     *
     * @param numeros L'array de números
     * @return El valor màxim
     */
    public static int trobarMaxim(int[] numeros) {
        // BUG: Inicialitza max a 0!
        // Si tots els números són negatius, retorna 0 (incorrecte)
        // Hauria de ser: int max = numeros[0];
        int max = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }
        return max;
    }

    /**
     * Calcula la mitjana d'un array.
     *
     * @param numeros L'array
     * @return La mitjana
     */
    public static double calcularMitjana(int[] numeros) {
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }
        // BUG 2: Divisió entera! Hauria de ser (double) suma / numeros.length
        return suma / numeros.length;
    }

    public static void main(String[] args) {
        System.out.println("=== Test 1: Números positius ===");
        int[] positius = {3, 7, 2, 9, 4};
        System.out.println("Array: {3, 7, 2, 9, 4}");
        System.out.println("Màxim: " + trobarMaxim(positius) + " (esperat: 9)");
        System.out.println("Mitjana: " + calcularMitjana(positius) + " (esperat: 5.0)");

        System.out.println();

        System.out.println("=== Test 2: Números negatius ===");
        int[] negatius = {-3, -7, -2, -9, -4};
        System.out.println("Array: {-3, -7, -2, -9, -4}");
        System.out.println("Màxim: " + trobarMaxim(negatius) + " (esperat: -2)");
        System.out.println("(Si surt 0, el bug és el valor inicial de max!)");

        System.out.println();

        System.out.println("=== Test 3: Mitjana amb decimals ===");
        int[] notes = {7, 8, 6};
        System.out.println("Array: {7, 8, 6}");
        System.out.println("Mitjana: " + calcularMitjana(notes) + " (esperat: 7.0)");
        System.out.println("(Si surt 7 en lloc de 7.0, comprova la divisió!)");
    }
}
