/**
 * EXERCICI 01 — El teu primer debug
 *
 * SECCIÓ TEORIA: 1. Què és depurar?
 *
 * Aquest programa calcula la mitjana de 3 notes.
 * PROBLEMA: La mitjana sempre surt incorrecta!
 *
 * OBJECTIU: Trobar el bug usant el debugger per primera vegada.
 *
 * PASSOS:
 * 1. Executa el programa (Run) — veuràs que la mitjana és incorrecta
 * 2. Ara executa en mode DEBUG (botó amb la icona del bug)
 * 3. Posa un breakpoint a la línia del càlcul (línia amb "mitjana = ...")
 * 4. Observa les variables al panell Variables
 * 5. Fes Step Over i mira el resultat — és el que esperes?
 *
 * @author La Salle Tarragona — Exercici Debugging
 */
public class Calculadora {

    public static void main(String[] args) {
        double nota1 = 7.5;
        double nota2 = 8.0;
        double nota3 = 6.5;

        // BUG: Troba l'error en aquesta línia
        double mitjana = (nota1 + nota2 + nota3) / 2;

        System.out.println("Notes: " + nota1 + ", " + nota2 + ", " + nota3);
        System.out.println("Mitjana: " + mitjana);
        System.out.println("(Hauria de ser 7.33...)");

        if (mitjana >= 5) {
            System.out.println("APROVAT");
        } else {
            System.out.println("SUSPÈS");
        }
    }
}
