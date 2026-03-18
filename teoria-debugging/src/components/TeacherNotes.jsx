import { useState } from 'react'

export default function TeacherNotes({ id, children, visible }) {
  const [open, setOpen] = useState(false)

  if (!visible) return null

  return (
    <div className={`teacher-notes ${open ? 'open' : ''}`}>
      <button
        className="teacher-toggle"
        onClick={() => setOpen(!open)}
        aria-expanded={open}
        aria-controls={id}
      >
        <span>Claus per al professor</span>
        <span className={`arrow ${open ? 'up' : 'down'}`}>&#9662;</span>
      </button>
      {open && (
        <div id={id} className="teacher-body">
          {children}
        </div>
      )}
    </div>
  )
}
