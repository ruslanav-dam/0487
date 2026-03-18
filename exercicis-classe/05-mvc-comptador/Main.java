/**
 * PUNT D'ENTRADA de l'aplicació.
 *
 * Només crea el Controlador i el posa en marxa.
 * No fa res més! (Responsabilitat mínima)
 *
 * @author La Salle Tarragona - Exercici Debugging MVC
 */
public class Main {

    public static void main(String[] args) {
        ControladorComptador controlador = new ControladorComptador();
        controlador.iniciar();
    }
}
