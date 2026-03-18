export default function Hero() {
  return (
    <header className="hero">
      <div className="hero-bg" />
      <div className="hero-content">
        <div className="hero-badge-row">
          <span className="hero-badge blue">RA3</span>
          <span className="hero-badge purple">Entorns de Desenvolupament</span>
          <span className="hero-badge teal">0487</span>
        </div>
        <h1>Depuració de programari</h1>
        <p className="hero-subtitle">
          Aprèn a trobar errors amb el depurador de l'IDE — breakpoints, inspecció de variables
          i navegació pas a pas del codi.
        </p>
        <div className="hero-meta">
          <span>La Salle Tarragona</span>
          <span className="dot">·</span>
          <span>DAM — Videojocs</span>
        </div>
      </div>
    </header>
  )
}
