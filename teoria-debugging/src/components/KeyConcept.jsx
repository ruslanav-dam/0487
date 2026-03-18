export default function KeyConcept({ title, children }) {
  return (
    <div className="key-concept">
      <h4 className="key-concept-title">{title}</h4>
      <div className="key-concept-body">{children}</div>
    </div>
  )
}
