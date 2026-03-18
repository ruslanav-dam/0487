const icons = {
  idea: '💡',
  warning: '⚠️',
  danger: '🚫',
  success: '✅',
  info: 'ℹ️',
}

export default function Callout({ type = 'info', children }) {
  return (
    <div className={`callout callout--${type}`}>
      <span className="callout-icon">{icons[type] || icons.info}</span>
      <div className="callout-content">{children}</div>
    </div>
  )
}
