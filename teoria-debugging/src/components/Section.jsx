export default function Section({ id, number, title, color, children }) {
  return (
    <section id={id} className={`section section--${color}`}>
      <div className="section-header">
        <span className={`section-number bg-${color}`}>{number}</span>
        <h2 className="section-title">{title}</h2>
      </div>
      <div className="section-body">
        {children}
      </div>
    </section>
  )
}
