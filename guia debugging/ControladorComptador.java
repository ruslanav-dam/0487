/**
 * CONTROLADOR: ControladorComptador
 * 
 * RESPONSABILITAT: Coordinar Model i Vista, contenir la lògica de control
 * 
 * Aquest controlador conté 1 BUG intencionat que has de trobar.
 * 
 * @author La Salle Tarragona - Exercici Debugging MVC
 */
public class ControladorComptador {
    
    // El controlador TÉ el model i la vista
    private Comptador model;
    private VistaComptador vista;
    
    /**
     * Constructor - Crea el model i la vista
     */
    public ControladorComptador() {
        this.model = new Comptador();
        this.vista = new VistaComptador();
    }
    
    /**
     * Inicia l'aplicació - Bucle principal
     */
    public void iniciar() {
        boolean continuar = true;
        
        while (continuar) {
            // 1. Mostrar menú (Vista)
            vista.mostrarMenu();
            
            // 2. Llegir opció (Vista)
            int opcio = vista.llegirOpcio();
            
            // 3. Processar opció (Controlador)
            continuar = processarOpcio(opcio);
            
            // 4. Mostrar valor actualitzat (Vista mostra dades del Model)
            if (continuar) {
                vista.mostrarValor(model.getValor());
            }
        }
        
        // 5. Comiat (Vista)
        vista.mostrarComiat();
    }
    
    /**
     * Processa l'opció seleccionada per l'usuari
     * 
     * @param opcio L'opció (1-4)
     * @return true si continua, false si surt
     */
    private boolean processarOpcio(int opcio) {
        
        // BUG #3: Un dels casos està canviat!
        // Mira amb atenció què fa cada opció
        
        switch (opcio) {
            case 1:
                // Opció 1: Incrementar
                model.incrementar();
                return true;
                
            case 2:
                // Opció 2: Decrementar
                model.reiniciar();  // ← BUG aquí! Hauria de ser model.decrementar()
                return true;
                
            case 3:
                // Opció 3: Reiniciar
                model.reiniciar();
                return true;
                
            case 4:
                // Opció 4: Sortir
                return false;
                
            default:
                System.out.println("Opció no vàlida!");
                return true;
        }
    }
}
