/**
 * MODEL: Comptador
 * 
 * RESPONSABILITAT: Emmagatzemar el valor del comptador i fer operacions
 * 
 * Aquest model conté 2 BUGS intencionats que has de trobar amb el debugger.
 * 
 * @author La Salle Tarragona - Exercici Debugging MVC
 */
public class Comptador {
    
    // Atribut privat - estat del model
    private int valor;
    
    /**
     * Constructor - Inicialitza el comptador
     */
    public Comptador() {
        this.valor = 0;
    }
    
    /**
     * Incrementa el comptador en 1
     */
    public void incrementar() {
        // BUG #1: Aquesta línia està malament!
        // Hauria d'incrementar, però fa una altra cosa
        valor = valor - 1;
    }
    
    /**
     * Decrementa el comptador en 1
     */
    public void decrementar() {
        valor = valor - 1;
    }
    
    /**
     * Reinicia el comptador a 0
     */
    public void reiniciar() {
        // BUG #2: No fa el que hauria!
        valor = 1;
    }
    
    /**
     * Obté el valor actual del comptador
     * 
     * @return El valor actual
     */
    public int getValor() {
        return valor;
    }
}
