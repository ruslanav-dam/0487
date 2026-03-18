import { useState, useEffect } from 'react'

const sections = [
  { id: 'que-es', label: '1. Què és depurar?' },
  { id: 'entorn', label: '2. L\'entorn' },
  { id: 'breakpoints', label: '3. Breakpoints' },
  { id: 'navegacio', label: '4. Navegació' },
  { id: 'variables', label: '5. Variables' },
  { id: 'callstack', label: '6. Call Stack' },
  { id: 'estrategies', label: '7. Estratègies' },
  { id: 'mvc-debug', label: '8. MVC + Debug' },
  { id: 'quiz', label: '9. Quiz' },
]

export default function Nav() {
  const [active, setActive] = useState('')

  useEffect(() => {
    const observer = new IntersectionObserver(
      (entries) => {
        entries.forEach((entry) => {
          if (entry.isIntersecting) {
            setActive(entry.target.id)
          }
        })
      },
      { rootMargin: '-20% 0px -70% 0px' }
    )

    sections.forEach(({ id }) => {
      const el = document.getElementById(id)
      if (el) observer.observe(el)
    })

    return () => observer.disconnect()
  }, [])

  return (
    <nav className="sticky-nav">
      <div className="nav-inner">
        {sections.map(({ id, label }) => (
          <a
            key={id}
            href={`#${id}`}
            className={`nav-link ${active === id ? 'active' : ''}`}
          >
            {label}
          </a>
        ))}
      </div>
    </nav>
  )
}
