/**
 * EXERCICI CASA 05 — Llista de la Compra (MVC)
 *
 * CONCEPTE: Debugging complet en un projecte MVC
 * DIFICULTAT: Alta (3 bugs distribuïts entre les 3 capes)
 *
 * PROBLEMA: El programa té 3 bugs:
 *   - Un al Model
 *   - Un a la Vista
 *   - Un al Controlador
 *
 * TASCA:
 * 1. Executa el programa i prova totes les opcions
 * 2. Identifica els 3 problemes
 * 3. Per cada bug, pensa: a quina capa MVC serà?
 * 4. Usa el debugger i el Call Stack per trobar-los
 * 5. Corregeix-los tots
 *
 * ENTREGA: Els fitxers corregits + per cada bug:
 *   - A quina capa estava (Model/Vista/Controlador)
 *   - Com l'has trobat (quin breakpoint, què has vist al Call Stack)
 *   - Per què fallava i com l'has arreglat
 *
 * @author La Salle Tarragona — Exercici Debugging MVC
 */
public class Main {

    public static void main(String[] args) {
        ControladorLlista controlador = new ControladorLlista();
        controlador.iniciar();
    }
}
