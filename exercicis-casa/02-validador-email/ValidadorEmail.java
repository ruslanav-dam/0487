/**
 * EXERCICI CASA 02 — Validador d'Email
 *
 * CONCEPTE: Saber on posar breakpoints
 * DIFICULTAT: Mitjana (2 bugs)
 *
 * Aquest programa valida adreces d'email amb 4 regles:
 * 1. Ha de contenir exactament un '@'
 * 2. Ha de contenir almenys un '.' després del '@'
 * 3. No pot començar per '@'
 * 4. Ha de tenir almenys 2 caràcters després de l'últim '.'
 *
 * PROBLEMA: Alguns emails invàlids es donen com a vàlids!
 *
 * TASCA:
 * 1. Executa el programa i compara resultats amb els esperats
 * 2. Identifica quins tests fallen
 * 3. Posa breakpoints als mètodes responsables
 * 4. Troba i corregeix els 2 bugs
 *
 * ENTREGA: El fitxer corregit + explicació de cada bug trobat
 *
 * @author La Salle Tarragona — Exercici Debugging
 */
public class ValidadorEmail {

    /**
     * Compta quantes vegades apareix un caràcter en un String.
     */
    public static int comptarCaracter(String text, char c) {
        int comptador = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) {
                comptador++;
            }
        }
        return comptador;
    }

    /**
     * Comprova si l'email té un punt després de l'arroba.
     */
    public static boolean tePuntDespresDArroba(String email) {
        int posArroba = email.indexOf('@');
        String despresArroba = email.substring(posArroba + 1);
        return despresArroba.contains(".");
    }

    /**
     * Comprova si hi ha almenys 2 caràcters després de l'últim punt.
     */
    public static boolean finalValid(String email) {
        int ultimPunt = email.lastIndexOf('.');
        String final_ = email.substring(ultimPunt + 1);
        // BUG: compara amb > 2 en lloc de >= 2
        return final_.length() > 2;
    }

    /**
     * Valida un email complet.
     */
    public static boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Regla 1: exactament un '@'
        int numArrobes = comptarCaracter(email, '@');
        // BUG: hauria de ser numArrobes != 1
        if (numArrobes > 1) {
            return false;
        }

        // Regla 2: no pot començar per '@'
        if (email.charAt(0) == '@') {
            return false;
        }

        // Regla 3: punt després de l'arroba
        if (!tePuntDespresDArroba(email)) {
            return false;
        }

        // Regla 4: mínim 2 caràcters després de l'últim punt
        if (!finalValid(email)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== Validador d'Email ===");
        System.out.println();

        String[][] tests = {
            {"alumne@lasalle.cat", "true"},
            {"professor@escola.edu", "true"},
            {"noarroba.com", "false"},
            {"dues@@arrobes.com", "false"},
            {"@comencaarroba.com", "false"},
            {"sense.punt@domini", "false"},
            {"final@curt.a", "false"},
            {"valid@domini.es", "true"},
        };

        for (String[] test : tests) {
            String email = test[0];
            boolean esperat = Boolean.parseBoolean(test[1]);
            boolean resultat = validarEmail(email);
            String status = (resultat == esperat) ? "OK" : "ERROR";
            System.out.println("\"" + email + "\" → " + resultat + " (esperat: " + esperat + ") " + status);
        }
    }
}
