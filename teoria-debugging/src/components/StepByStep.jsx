export default function StepByStep({ number, title, description, usage, color }) {
  return (
    <div className={`step-card step-card--${color}`}>
      <div className={`step-key bg-${color}`}>{number}</div>
      <h4 className="step-title">{title}</h4>
      <p className="step-desc">{description}</p>
      <p className="step-usage"><strong>Usa-ho quan:</strong> {usage}</p>
    </div>
  )
}
