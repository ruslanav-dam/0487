export default function Callout({ type = 'info', children }) {
  return (
    <div className={`callout callout--${type}`}>
      <div className="callout-content">{children}</div>
    </div>
  )
}
