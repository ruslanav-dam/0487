/**
 * EXERCICI CASA 03 — Calculadora de Nòmina
 *
 * CONCEPTE: Step Into / Step Over / Step Out
 * DIFICULTAT: Mitjana (2 bugs en mètodes encadenats)
 *
 * Aquest programa calcula el salari net d'un treballador:
 *   Salari brut → aplicar IRPF → aplicar Seguretat Social → Salari net
 *
 * PROBLEMA: El salari net no quadra!
 *
 * TASCA:
 * 1. Posa breakpoint a la crida de calcularSalariNet()
 * 2. Fes Step Into per entrar dins el mètode
 * 3. Dins, fes Step Into a cada sub-mètode per trobar on falla
 * 4. Usa Step Out per sortir quan el mètode funciona bé
 * 5. Quan trobis el bug, usa Step Over per saltar els correctes
 *
 * ENTREGA: El fitxer corregit + explicació de:
 *   - A quin mètode has fet Step Into i per què
 *   - A quin mètode has fet Step Over i per què
 *   - On has usat Step Out
 *
 * @author La Salle Tarragona — Exercici Debugging
 */
public class CalculadoraNomina {

    /**
     * Calcula la retenció d'IRPF segons el tram.
     * Sous fins a 12.450€: 19%
     * Sous de 12.450€ a 20.200€: 24%
     * Sous superiors a 20.200€: 30%
     *
     * @param salari Salari brut anual
     * @return Quantitat retinguda per IRPF
     */
    public static double calcularIRPF(double salari) {
        double percentatge;
        if (salari <= 12450) {
            percentatge = 19;
        } else if (salari <= 20200) {
            percentatge = 24;
        } else {
            percentatge = 30;
        }
        return salari * percentatge / 100;
    }

    /**
     * Calcula la cotització a la Seguretat Social (6.35%).
     *
     * @param salari Salari brut anual
     * @return Quantitat cotitzada
     */
    public static double calcularSS(double salari) {
        // BUG: usa 6.35 com si fos percentatge directe, però divideix per 10 en lloc de 100
        return salari * 6.35 / 10;
    }

    /**
     * Calcula el bonus per antiguitat.
     * Cada any d'antiguitat afegeix un 1.5% del salari base.
     *
     * @param salari Salari base
     * @param anys Anys d'antiguitat
     * @return Bonus per antiguitat
     */
    public static double calcularBonusAntiguitat(double salari, int anys) {
        return salari * anys * 1.5 / 100;
    }

    /**
     * Calcula el salari net final.
     */
    public static double calcularSalariNet(double salariBrut, int anysAntiguitat) {
        double bonus = calcularBonusAntiguitat(salariBrut, anysAntiguitat);
        double salariAmbBonus = salariBrut + bonus;

        double retencioIRPF = calcularIRPF(salariAmbBonus);
        double cotitzacioSS = calcularSS(salariAmbBonus);

        // BUG: suma les retencions en lloc de restar-les!
        double salariNet = salariAmbBonus + retencioIRPF + cotitzacioSS;

        return salariNet;
    }

    public static void main(String[] args) {
        System.out.println("=== Calculadora de Nòmina ===");
        System.out.println();

        double salariBrut = 25000.0;
        int anysAntiguitat = 5;

        System.out.println("Salari brut: " + salariBrut + " EUR/any");
        System.out.println("Anys antiguitat: " + anysAntiguitat);
        System.out.println();

        double bonus = calcularBonusAntiguitat(salariBrut, anysAntiguitat);
        double salariAmbBonus = salariBrut + bonus;
        System.out.println("Bonus antiguitat (5 anys x 1.5%): " + bonus + " EUR");
        System.out.println("Salari amb bonus: " + salariAmbBonus + " EUR");
        System.out.println();

        double irpf = calcularIRPF(salariAmbBonus);
        double ss = calcularSS(salariAmbBonus);
        System.out.println("Retenció IRPF (30%): " + irpf + " EUR");
        System.out.println("Cotització SS (6.35%): " + ss + " EUR");
        System.out.println("(SS esperat: " + (salariAmbBonus * 6.35 / 100) + " EUR)");
        System.out.println();

        double salariNet = calcularSalariNet(salariBrut, anysAntiguitat);
        double esperat = salariAmbBonus - irpf - (salariAmbBonus * 6.35 / 100);
        System.out.println("Salari net: " + salariNet + " EUR");
        System.out.println("(Esperat aprox: " + esperat + " EUR)");
        System.out.println();

        if (Math.abs(salariNet - esperat) > 1) {
            System.out.println("ATENCIÓ: El salari net NO quadra! Usa el debugger.");
        } else {
            System.out.println("Tot correcte!");
        }
    }
}
