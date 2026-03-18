/**
 * EXERCICI 02 — On posar breakpoints?
 *
 * SECCIÓ TEORIA: 3. Breakpoints
 *
 * Aquest programa valida una contrasenya amb 3 regles.
 * PROBLEMA: Sempre diu "CONTRASENYA VÀLIDA" encara que sigui curta!
 *
 * OBJECTIU: Aprendre a posar breakpoints al lloc correcte.
 *
 * PISTES:
 * - NO poseu breakpoint al main(). No hi passa res interessant.
 * - Poseu breakpoints DINS del mètode que fa la validació.
 * - Observeu el valor de cada comprovació (teMinim, teNumero, teMajuscula)
 *
 * @author La Salle Tarragona — Exercici Debugging
 */
public class Validador {

    /**
     * Valida si una contrasenya compleix els requisits.
     * Ha de tenir mínim 8 caràcters, un número i una majúscula.
     *
     * @param contrasenya La contrasenya a validar
     * @return true si és vàlida, false si no
     */
    public static boolean validarContrasenya(String contrasenya) {
        boolean teMinim = contrasenya.length() >= 8;
        boolean teNumero = false;
        boolean teMajuscula = false;

        for (int i = 0; i < contrasenya.length(); i++) {
            char c = contrasenya.charAt(i);
            if (Character.isDigit(c)) {
                teNumero = true;
            }
            if (Character.isUpperCase(c)) {
                teMajuscula = true;
            }
        }

        // BUG: Aquesta condició està malament!
        // Hauria de ser AND (&&) però usa OR (||)
        return teMinim || teNumero || teMajuscula;
    }

    public static void main(String[] args) {
        String[] proves = {"abc", "abcdefgh", "Abcdefg1", "12345678", "Ab1"};

        for (String prova : proves) {
            boolean resultat = validarContrasenya(prova);
            System.out.println("\"" + prova + "\" → " + (resultat ? "VÀLIDA" : "INVÀLIDA"));
        }

        System.out.println();
        System.out.println("Resultat esperat:");
        System.out.println("\"abc\" → INVÀLIDA (massa curta, sense número ni majúscula)");
        System.out.println("\"abcdefgh\" → INVÀLIDA (sense número ni majúscula)");
        System.out.println("\"Abcdefg1\" → VÀLIDA (compleix tot)");
        System.out.println("\"12345678\" → INVÀLIDA (sense majúscula)");
        System.out.println("\"Ab1\" → INVÀLIDA (massa curta)");
    }
}
