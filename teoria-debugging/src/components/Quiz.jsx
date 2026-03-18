import { useState, useEffect } from 'react'

const questions = [
  {
    q: "El mètode calcularMitjana() retorna un valor incorrecte. On poses el breakpoint?",
    options: [
      "Al main(), a la primera línia",
      "Dins de calcularMitjana(), a la línia que fa el càlcul",
      "A la Vista, on es mostra el resultat",
      "No cal breakpoint, afegeixo un println",
    ],
    correct: 1,
    explanation: "El breakpoint s'ha de posar al mètode sospitós, directament a la línia que modifica les dades.",
  },
  {
    q: "Estàs dins de incrementar() i vols tornar al Controlador per veure què fa després. Quina acció?",
    options: [
      "Step Into (F7)",
      "Step Over (F8)",
      "Step Out (Shift+F8)",
      "Resume (F9)",
    ],
    correct: 2,
    explanation: "Step Out surt del mètode actual i torna al punt on va ser cridat (el Controlador).",
  },
  {
    q: "L'usuari tria 'Decrementar' però el comptador es reinicia a 0. On és el bug?",
    options: [
      "Al Model — el mètode decrementar() està malament",
      "A la Vista — llegeix malament l'opció",
      "Al Controlador — crida el mètode equivocat del Model",
      "Al Main — no inicialitza bé el Controlador",
    ],
    correct: 2,
    explanation: "Si l'acció fa una cosa diferent de l'esperada, el problema és al Controlador, que decideix quin mètode del Model cridar.",
  },
  {
    q: "El programa para al breakpoint. Veus que 'valor' és 0. Fas Step Over i ara 'valor' és -1. El mètode era incrementar(). Quin és el bug?",
    options: [
      "Falta una variable",
      "La línia fa valor = valor - 1 en lloc de valor = valor + 1",
      "El breakpoint està mal posat",
      "Hi ha un error de compilació",
    ],
    correct: 1,
    explanation: "Si el valor baixa quan hauria de pujar, l'operació és incorrecta: resta en lloc de sumar.",
  },
  {
    q: "Estàs a la línia System.out.println('Hola'). Quina acció és la correcta?",
    options: [
      "Step Into — per veure com funciona println",
      "Step Over — no vull entrar dins mètodes del JDK",
      "Step Out — surto del programa",
      "Resume — ja he acabat de depurar",
    ],
    correct: 1,
    explanation: "Mai Step Into a mètodes de Java (println, nextInt...). Usa Step Over per saltar-los.",
  },
  {
    q: "El Call Stack mostra: incrementar():28 Comptador → processarOpcio():64 ControladorComptador → main():5 Main. On estàs ara?",
    options: [
      "A main() de Main",
      "A processarOpcio() del ControladorComptador",
      "A incrementar() del Comptador",
      "No es pot saber amb aquesta informació",
    ],
    correct: 2,
    explanation: "El Call Stack es llegeix de dalt a baix: la línia superior és on ets ara (incrementar del Comptador).",
  },
  {
    q: "Vols veure com canvia una variable dins d'un bucle que s'executa 100 vegades. Quin tipus de breakpoint uses?",
    options: [
      "Simple — i faig Step Over 100 vegades",
      "Condicional — per exemple: i == 50",
      "Temporal — i espero que pari",
      "Cap — afegeixo un println dins el bucle",
    ],
    correct: 1,
    explanation: "Un breakpoint condicional para NOMÉS quan es compleix la condició. Perfecte per no haver de fer Step Over 100 vegades.",
  },
  {
    q: "En un programa MVC, el menú mostra 4 opcions però hauria de mostrar 5. On busques el bug?",
    options: [
      "Al Model",
      "A la Vista",
      "Al Controlador",
      "Al Main",
    ],
    correct: 1,
    explanation: "La Vista s'encarrega de mostrar informació a pantalla. Si el menú no mostra una opció, el bug és a la Vista.",
  },
  {
    q: "Has entrat per error dins de System.out.println() amb Step Into i estàs perdut dins del JDK. Com surts?",
    options: [
      "Tanques el programa i tornes a començar",
      "Step Out (Shift+F8) per sortir del mètode actual",
      "Step Over fins arribar al final",
      "Elimines el breakpoint",
    ],
    correct: 1,
    explanation: "Step Out surt del mètode actual i torna al punt on va ser cridat. És la forma ràpida de 'escapar' d'un mètode.",
  },
  {
    q: "Quin és el primer pas de l'estratègia de depuració?",
    options: [
      "Posar breakpoints a tot arreu",
      "Reproduir l'error — identificar exactament què fa malament",
      "Mirar el codi línia per línia",
      "Preguntar a un company",
    ],
    correct: 1,
    explanation: "Primer has de saber exactament quin és el problema: què esperes que faci i què fa realment. Sense això, no saps què buscar.",
  },
]

const STORAGE_KEY = 'quiz-debugging-stats'

function loadStats() {
  try {
    return JSON.parse(localStorage.getItem(STORAGE_KEY)) || { attempts: 0, perQuestion: {} }
  } catch {
    return { attempts: 0, perQuestion: {} }
  }
}

function saveStats(answers) {
  const stats = loadStats()
  stats.attempts++
  questions.forEach((q, i) => {
    if (!stats.perQuestion[i]) {
      stats.perQuestion[i] = { correct: 0, wrong: 0 }
    }
    if (answers[i] === q.correct) {
      stats.perQuestion[i].correct++
    } else if (answers[i] !== undefined) {
      stats.perQuestion[i].wrong++
    }
  })
  localStorage.setItem(STORAGE_KEY, JSON.stringify(stats))
}

export default function Quiz() {
  const [answers, setAnswers] = useState({})
  const [submitted, setSubmitted] = useState(false)

  const handleSelect = (qIndex, optIndex) => {
    if (submitted) return
    setAnswers({ ...answers, [qIndex]: optIndex })
  }

  const handleSubmit = () => {
    setSubmitted(true)
    saveStats(answers)
  }

  const handleRetry = () => {
    setAnswers({})
    setSubmitted(false)
  }

  const score = Object.entries(answers).filter(
    ([qi, ai]) => questions[parseInt(qi)].correct === ai
  ).length

  return (
    <div className="quiz">
      {questions.map((q, qi) => (
        <div key={qi} className="quiz-question">
          <p className="quiz-q"><strong>{qi + 1}.</strong> {q.q}</p>
          <div className="quiz-options">
            {q.options.map((opt, oi) => {
              let cls = 'quiz-option'
              if (answers[qi] === oi) cls += ' selected'
              if (submitted) {
                if (oi === q.correct) cls += ' correct'
                else if (answers[qi] === oi) cls += ' wrong'
              }
              return (
                <button
                  key={oi}
                  className={cls}
                  onClick={() => handleSelect(qi, oi)}
                >
                  <span className="quiz-letter">{'ABCD'[oi]}</span>
                  {opt}
                </button>
              )
            })}
          </div>
          {submitted && answers[qi] !== undefined && (
            <p className={`quiz-expl ${answers[qi] === q.correct ? 'correct' : 'wrong'}`}>
              {q.explanation}
            </p>
          )}
        </div>
      ))}

      <div className="quiz-footer">
        {!submitted ? (
          <button
            className="quiz-submit"
            onClick={handleSubmit}
            disabled={Object.keys(answers).length < questions.length}
          >
            Comprova les respostes
          </button>
        ) : (
          <>
            <div className="quiz-result">
              <span className="quiz-score">{score}/{questions.length}</span>
              <span>respostes correctes</span>
              {score === questions.length && <span className="quiz-perfect">Excel·lent!</span>}
            </div>
            <button className="quiz-submit quiz-retry" onClick={handleRetry} style={{ marginTop: '1rem' }}>
              Torna a intentar-ho
            </button>
          </>
        )}
      </div>
    </div>
  )
}

export function QuizStats() {
  const [stats, setStats] = useState(loadStats())

  useEffect(() => {
    const interval = setInterval(() => setStats(loadStats()), 2000)
    return () => clearInterval(interval)
  }, [])

  if (stats.attempts === 0) {
    return <p style={{ color: 'var(--muted)', fontStyle: 'italic' }}>Encara no hi ha intents registrats.</p>
  }

  return (
    <div className="quiz-stats">
      <p><strong>Total intents:</strong> {stats.attempts}</p>
      <div className="table-wrap" style={{ marginTop: '0.75rem' }}>
        <table className="compare-table">
          <thead>
            <tr>
              <th>#</th>
              <th>Pregunta</th>
              <th>Encerts</th>
              <th>Errors</th>
              <th>% encert</th>
            </tr>
          </thead>
          <tbody>
            {questions.map((q, i) => {
              const pq = stats.perQuestion[i] || { correct: 0, wrong: 0 }
              const total = pq.correct + pq.wrong
              const pct = total > 0 ? Math.round((pq.correct / total) * 100) : 0
              return (
                <tr key={i}>
                  <td><strong>{i + 1}</strong></td>
                  <td style={{ fontSize: '0.8rem' }}>{q.q.substring(0, 60)}...</td>
                  <td style={{ color: 'var(--success)', fontWeight: 700 }}>{pq.correct}</td>
                  <td style={{ color: 'var(--danger)', fontWeight: 700 }}>{pq.wrong}</td>
                  <td>
                    <span style={{
                      padding: '0.15rem 0.5rem',
                      borderRadius: '12px',
                      fontSize: '0.78rem',
                      fontWeight: 700,
                      background: pct >= 70 ? 'var(--success-light)' : pct >= 40 ? 'var(--warning-light)' : 'var(--danger-light)',
                      color: pct >= 70 ? 'var(--success)' : pct >= 40 ? 'var(--warning)' : 'var(--danger)',
                    }}>
                      {pct}%
                    </span>
                  </td>
                </tr>
              )
            })}
          </tbody>
        </table>
      </div>
    </div>
  )
}
