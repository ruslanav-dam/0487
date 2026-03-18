export default function MvcDiagram() {
  return (
    <div className="mvc-diagram">
      <h4 className="mvc-title">Flux MVC amb el depurador</h4>
      <div className="mvc-grid">
        <div className="mvc-box mvc-main">
          <div className="mvc-label">Main</div>
          <div className="mvc-desc">Crea i inicia el Controlador</div>
        </div>
        <div className="mvc-arrow">↓</div>
        <div className="mvc-box mvc-controller">
          <div className="mvc-label">Controlador</div>
          <div className="mvc-desc">Coordina tot: rep l'opció de la Vista i crida el Model</div>
        </div>
        <div className="mvc-branches">
          <div className="mvc-branch">
            <div className="mvc-arrow">↙</div>
            <div className="mvc-box mvc-model">
              <div className="mvc-label">Model</div>
              <div className="mvc-desc">Dades + càlculs<br/>(incrementar, reiniciar...)</div>
            </div>
          </div>
          <div className="mvc-branch">
            <div className="mvc-arrow">↘</div>
            <div className="mvc-box mvc-vista">
              <div className="mvc-label">Vista</div>
              <div className="mvc-desc">Pantalla + teclat<br/>(menú, mostrar valor...)</div>
            </div>
          </div>
        </div>
      </div>
      <p className="mvc-footer">
        El <strong>Call Stack</strong> et mostra exactament aquest camí:
        Main → Controlador → Model (o Vista)
      </p>
    </div>
  )
}
