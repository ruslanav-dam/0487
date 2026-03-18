export default function CodeBlock({ language, title, children, highlight = [] }) {
  const lines = children.split('\n')

  return (
    <div className="code-block">
      {title && <div className="code-title">{title}</div>}
      <pre>
        <code>
          {lines.map((line, i) => (
            <div
              key={i}
              className={`code-line ${highlight.includes(i + 1) ? 'highlighted' : ''}`}
            >
              <span className="line-num">{i + 1}</span>
              <span className="line-content">{line}</span>
            </div>
          ))}
        </code>
      </pre>
    </div>
  )
}
