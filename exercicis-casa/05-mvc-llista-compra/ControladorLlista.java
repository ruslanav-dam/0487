/**
 * CONTROLADOR: ControladorLlista
 *
 * RESPONSABILITAT: Coordinar Model i Vista.
 * Conté 1 BUG intencionat.
 *
 * @author La Salle Tarragona — Exercici Debugging MVC
 */
public class ControladorLlista {

    private LlistaCompra model;
    private VistaLlista vista;

    public ControladorLlista() {
        this.model = new LlistaCompra();
        this.vista = new VistaLlista();
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            vista.mostrarMenu();
            int opcio = vista.llegirOpcio();
            continuar = processarOpcio(opcio);
        }

        vista.mostrarComiat();
    }

    private boolean processarOpcio(int opcio) {
        switch (opcio) {
            case 1:
                afegirProducte();
                return true;
            case 2:
                eliminarProducte();
                return true;
            case 3:
                vista.mostrarLlista(model);
                return true;
            case 4:
                double total = model.calcularTotal();
                vista.mostrarTotal(total);
                return true;
            case 5:
                return false;
            default:
                vista.mostrarMissatge("Opció no vàlida!");
                return true;
        }
    }

    private void afegirProducte() {
        String nom = vista.llegirNomProducte();
        double preu = vista.llegirPreu();
        if (model.afegir(nom, preu)) {
            vista.mostrarMissatge("Producte afegit!");
        } else {
            vista.mostrarMissatge("Llista plena!");
        }
    }

    private void eliminarProducte() {
        if (model.getNumProductes() == 0) {
            vista.mostrarMissatge("No hi ha productes per eliminar.");
            return;
        }
        vista.mostrarLlista(model);
        int posicio = vista.llegirPosicio();
        // BUG: no converteix de 1-based (el que introdueix l'usuari) a 0-based (el que espera el model)
        // Hauria de ser: model.eliminar(posicio - 1)
        if (model.eliminar(posicio)) {
            vista.mostrarMissatge("Producte eliminat!");
        } else {
            vista.mostrarMissatge("Posició no vàlida!");
        }
    }
}
