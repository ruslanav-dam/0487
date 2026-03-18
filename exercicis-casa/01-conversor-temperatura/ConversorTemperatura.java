/**
 * EXERCICI CASA 01 — Conversor de Temperatura
 *
 * CONCEPTE: Primer contacte amb el debugger
 * DIFICULTAT: Fàcil (1 bug)
 *
 * Aquest programa converteix temperatures entre Celsius i Fahrenheit.
 * PROBLEMA: Les conversions donen resultats incorrectes!
 *
 * Resultat esperat:
 *   100°C → 212.0°F
 *   0°C → 32.0°F
 *   32°F → 0.0°C
 *   212°F → 100.0°C
 *
 * TASCA:
 * 1. Executa el programa i observa els resultats incorrectes
 * 2. Usa el debugger per trobar el bug
 * 3. Corregeix-lo i verifica que tots els resultats són correctes
 *
 * ENTREGA: El fitxer corregit + un comentari explicant:
 *   - On era el bug (línia i mètode)
 *   - Quin breakpoint has posat
 *   - Què has vist al panell de variables
 *
 * @author La Salle Tarragona — Exercici Debugging
 */
public class ConversorTemperatura {

    /**
     * Converteix graus Celsius a Fahrenheit.
     * Fórmula correcta: F = C * 9/5 + 32
     */
    public static double celsiusAFahrenheit(double celsius) {
        return celsius * 9 / 5 - 32;
    }

    /**
     * Converteix graus Fahrenheit a Celsius.
     * Fórmula correcta: C = (F - 32) * 5/9
     */
    public static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        System.out.println("=== Conversor de Temperatura ===");
        System.out.println();

        // Test Celsius → Fahrenheit
        double[] celsius = {100, 0, 37, -40};
        double[] esperatF = {212.0, 32.0, 98.6, -40.0};

        System.out.println("--- Celsius → Fahrenheit ---");
        for (int i = 0; i < celsius.length; i++) {
            double resultat = celsiusAFahrenheit(celsius[i]);
            String status = Math.abs(resultat - esperatF[i]) < 0.1 ? "OK" : "ERROR";
            System.out.println(celsius[i] + "°C → " + resultat + "°F (esperat: " + esperatF[i] + ") " + status);
        }

        System.out.println();

        // Test Fahrenheit → Celsius
        double[] fahrenheit = {32, 212, 98.6, -40};
        double[] esperatC = {0.0, 100.0, 37.0, -40.0};

        System.out.println("--- Fahrenheit → Celsius ---");
        for (int i = 0; i < fahrenheit.length; i++) {
            double resultat = fahrenheitACelsius(fahrenheit[i]);
            String status = Math.abs(resultat - esperatC[i]) < 0.1 ? "OK" : "ERROR";
            System.out.println(fahrenheit[i] + "°F → " + resultat + "°C (esperat: " + esperatC[i] + ") " + status);
        }
    }
}
