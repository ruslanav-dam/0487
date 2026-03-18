import { useState } from 'react'
import './App.css'
import Hero from './components/Hero'
import Nav from './components/Nav'
import Section from './components/Section'
import CodeBlock from './components/CodeBlock'
import Callout from './components/Callout'
import KeyConcept from './components/KeyConcept'
import CompareTable from './components/CompareTable'
import TeacherNotes from './components/TeacherNotes'
import StepByStep from './components/StepByStep'
import Quiz, { QuizStats } from './components/Quiz'
import MvcDiagram from './components/MvcDiagram'

function App() {
  const teacherMode = new URLSearchParams(window.location.search).has('prof')

  return (
    <div className="app">
      <Hero />
      <Nav />
      <main>

        {/* ===== SECCIÓ 1: QUÈ ÉS DEPURAR? ===== */}
        <Section id="que-es" number="1" title="Què és depurar?" color="accent">
          <p>
            <strong>Depurar</strong> (<em>debugging</em>) és el procés de trobar i corregir errors
            en un programa. El terme ve dels anys 40, quan Grace Hopper va trobar
            literalment una papallona (<em>bug</em>) atrapada dins un relé del computador Mark II.
          </p>

          <KeyConcept title="Per què no n'hi ha prou amb mirar el codi?">
            <ul>
              <li>Un programa pot tenir milers de línies — l'ull humà no ho pot abarcar tot.</li>
              <li>Els errors de lògica no donen errors de compilació: el codi compila bé però fa coses incorrectes.</li>
              <li>El flux real d'execució pot ser diferent del que imaginem (branques <code>if</code>, bucles, crides entre objectes).</li>
            </ul>
          </KeyConcept>

          <Callout type="idea">
            El depurador és com un <strong>raig X</strong> del programa: et permet veure què passa
            per dins mentre s'executa, línia a línia.
          </Callout>

          <TeacherNotes visible={teacherMode} id="tn-1">
            <p><strong>Clau per explicar:</strong> Fes la analogia del metge. Quan tens mal de panxa,
            el metge no obre directament — primer fa proves (raig X, anàlisis). El depurador és l'eina
            de diagnòstic del programador.</p>
            <p><strong>Error comú dels alumnes:</strong> Pensar que depurar = afegir <code>System.out.println()</code> a tot arreu.
            Explica que això és com "posar pegats" — el depurador és molt més potent i precís.</p>
          </TeacherNotes>
        </Section>

        {/* ===== SECCIÓ 2: L'ENTORN DE DEPURACIÓ ===== */}
        <Section id="entorn" number="2" title="L'entorn de depuració" color="purple">
          <p>
            Tots els IDEs moderns (IntelliJ, Eclipse, VS Code) inclouen un <strong>depurador integrat</strong>.
            L'entorn de depuració té quatre elements principals:
          </p>

          <div className="grid-2">
            <KeyConcept title="1. Editor amb breakpoints" icon="red-circle">
              <p>Al codi font, pots marcar línies on vols que el programa <strong>pari</strong>.
              Es marquen fent clic al marge esquerre (apareix un cercle vermell).</p>
            </KeyConcept>
            <KeyConcept title="2. Panell de variables" icon="eye">
              <p>Mostra el <strong>valor actual</strong> de totes les variables en l'àmbit actual.
              Es va actualitzant a cada pas.</p>
            </KeyConcept>
            <KeyConcept title="3. Panell de Call Stack" icon="layers">
              <p>Mostra la <strong>pila de crides</strong>: quins mètodes s'han cridat per arribar
              al punt actual. Útil per saber "com hem arribat aquí".</p>
            </KeyConcept>
            <KeyConcept title="4. Controls de navegació" icon="controls">
              <p>Botons per avançar pas a pas, entrar dins mètodes, continuar fins al proper
              breakpoint, etc.</p>
            </KeyConcept>
          </div>

          <Callout type="warning">
            <strong>Executar en mode Debug</strong> no és el mateix que <strong>Run</strong>.
            Has de prémer el botó amb la icona d'un insecte (bug), no el triangle verd de play!
          </Callout>

          <TeacherNotes visible={teacherMode} id="tn-2">
            <p><strong>Demostració en viu (5 min):</strong> Obre un programa senzill a l'IDE,
            mostra on es posa un breakpoint, com s'executa en Debug, i els 4 panells.
            Projecta la pantalla perquè tots vegin els panells.</p>
            <p><strong>Problema habitual:</strong> Alumnes que fan Run en lloc de Debug i es pregunten
            per què no para als breakpoints.</p>
          </TeacherNotes>
        </Section>

        {/* ===== SECCIÓ 3: BREAKPOINTS ===== */}
        <Section id="breakpoints" number="3" title="Breakpoints: on parar?" color="danger">
          <p>
            Un <strong>breakpoint</strong> (punt de ruptura) és una marca que li diu al depurador:
            "quan arribis aquí, <strong>para l'execució</strong>".
          </p>

          <KeyConcept title="Tipus de breakpoints">
            <CompareTable
              headers={['Tipus', 'Què fa', 'Quan usar-lo']}
              rows={[
                ['Simple', 'Para sempre que passa per la línia', 'El més habitual — per inspeccionar variables'],
                ['Condicional', 'Para només si es compleix una condició (ex: i == 5)', 'Dins de bucles — no vols parar 1000 vegades'],
                ['Temporal', "Para un cop i s'elimina sol", 'Quan vols comprovar que el programa arriba a un punt'],
              ]}
            />
          </KeyConcept>

          <Callout type="idea">
            <strong>On posar breakpoints?</strong> Pensa: "Quin mètode és el responsable de l'acció
            que falla?" → Posa el breakpoint <strong>dins</strong> d'aquell mètode, a la primera línia
            que modifica dades.
          </Callout>

          <CodeBlock language="java" title="Exemple: breakpoint al mètode que falla" highlight={[4]}>
{`public void incrementar() {
    // Si incrementar no funciona bé,
    // posa breakpoint aquí ↓
    valor = valor - 1;  // ← BREAKPOINT aquí!
    // Executa en Debug, i mira el panell Variables
    // per veure el valor ABANS i DESPRÉS
}`}
          </CodeBlock>

          <TeacherNotes visible={teacherMode} id="tn-3">
            <p><strong>Error típic:</strong> Alumnes que posen breakpoint al <code>main()</code> i despres fan Step Over
            fins arribar al codi que falla. Molt ineficient! Explica que el breakpoint s'ha de posar
            al lloc sospitós directament.</p>
            <p><strong>Exercici ràpid a classe (2 min):</strong> "Si el mètode <code>calcularMitjana()</code>
            retorna un valor incorrecte, a quina classe i quin mètode posaries el breakpoint?"</p>
          </TeacherNotes>
        </Section>

        {/* ===== SECCIÓ 4: CONTROLS DE NAVEGACIÓ ===== */}
        <Section id="navegacio" number="4" title="Navegar pel codi pas a pas" color="teal">
          <p>
            Un cop el programa para a un breakpoint, tens <strong>quatre accions</strong> principals
            per controlar l'execució:
          </p>

          <div className="steps-grid">
            <StepByStep
              number="F8"
              title="Step Over"
              description="Executa la línia actual i para a la següent. NO entra dins dels mètodes."
              usage="El que faràs servir el 90% del temps. Per avançar línia a línia."
              color="accent"
            />
            <StepByStep
              number="F7"
              title="Step Into"
              description="Entra DINS del mètode que hi ha a la línia actual."
              usage="Quan vols veure què fa un mètode teu (ex: model.incrementar())."
              color="purple"
            />
            <StepByStep
              number="⇧F8"
              title="Step Out"
              description="Surt del mètode actual i torna al punt on va ser cridat."
              usage="Quan t'has ficat dins d'un mètode per error (ex: System.out.println)."
              color="warning"
            />
            <StepByStep
              number="F9"
              title="Resume / Continue"
              description="Continua l'execució normal fins al proper breakpoint o fins que acabi."
              usage="Quan ja has vist el que necessitaves i vols anar al proper punt d'interès."
              color="success"
            />
          </div>

          <Callout type="danger">
            <strong>Regla d'or:</strong> Step Into només per a mètodes <strong>teus</strong>
            (incrementar, processarOpcio...). Mai Step Into a mètodes de Java (println, nextInt) —
            t'hi perdràs dins de centenars de línies del JDK!
          </Callout>

          <CompareTable
            headers={['Situació', 'Acció correcta', 'Per què']}
            rows={[
              ['Estic a model.incrementar()', 'Step Into (F7)', 'Vull veure què fa incrementar per dins'],
              ['Estic a System.out.println("Hola")', 'Step Over (F8)', 'No vull entrar dins println del JDK'],
              ['Estic dins d\'un mètode i ja he vist el que volia', 'Step Out (Shift+F8)', 'Surto i torno al punt que el va cridar'],
              ['Ja he inspeccionat, vull anar al proper breakpoint', 'Resume (F9)', 'Salto directament al proper punt d\'interès'],
            ]}
          />

          <TeacherNotes visible={teacherMode} id="tn-4">
            <p><strong>Demostració imprescindible:</strong> Fes en viu Step Into a <code>model.incrementar()</code>
            per mostrar com "saltem" del Controlador al Model. Despres fes Step Into a
            <code>System.out.println()</code> per mostrar com ens perdem dins del JDK — i com
            sortim amb Step Out.</p>
            <p><strong>Dreceres a IntelliJ:</strong> F7 (Into), F8 (Over), Shift+F8 (Out), F9 (Resume).
            A VS Code: F11, F10, Shift+F11, F5.</p>
          </TeacherNotes>
        </Section>

        {/* ===== SECCIÓ 5: INSPECCIONAR VARIABLES ===== */}
        <Section id="variables" number="5" title="Inspeccionar i modificar variables" color="success">
          <p>
            El veritable poder del depurador és poder <strong>veure l'estat del programa</strong> en qualsevol
            moment. Quan el programa para a un breakpoint, el panell de variables mostra tot el que
            necessites.
          </p>

          <KeyConcept title="Què pots fer amb les variables?">
            <ul>
              <li><strong>Veure el valor actual</strong> — de variables locals, paràmetres i atributs de l'objecte.</li>
              <li><strong>Veure com canvia</strong> — fes Step Over i observa el valor abans i després.</li>
              <li><strong>Watches</strong> — afegeix expressions personalitzades (ex: <code>array.length</code>, <code>nota &gt;= 5</code>).</li>
              <li><strong>Evaluate Expression</strong> — executa codi Java en temps real per provar coses (Alt+F8 a IntelliJ).</li>
            </ul>
          </KeyConcept>

          <CodeBlock language="java" title="Exemple: observar com canvia 'suma' dins un bucle" highlight={[5,6]}>
{`public static double calcularMitjana(double[] notes) {
    double suma = 0;        // ← Watches: suma = 0.0
    int comptador = 0;

    for (int i = 0; i < notes.length; i++) {
        suma += notes[i];   // ← A cada iteració, mira com creix 'suma'
        comptador++;         //   i com avança 'comptador'
    }

    return suma / comptador; // ← Evaluate: suma/comptador = ?
}`}
          </CodeBlock>

          <Callout type="success">
            <strong>Workflow professional:</strong><br/>
            1. Posa breakpoint al lloc sospitós<br/>
            2. Executa Debug<br/>
            3. Mira les variables — el valor és el que esperes?<br/>
            4. Step Over — ha canviat com esperaves?<br/>
            5. Si no → has trobat el bug!
          </Callout>

          <TeacherNotes visible={teacherMode} id="tn-5">
            <p><strong>Clau pedagògica:</strong> Insisteix que el depurador NO serveix per parar i ja.
            Serveix per <strong>OBSERVAR</strong>. Si no miren el panell de variables, no estan depurant.</p>
            <p><strong>Exercici en viu:</strong> Posa un breakpoint dins d'un bucle. Pregunta als alumnes:
            "Quin valor tindrà <code>suma</code> a la tercera iteració?" — que prediguin, i despres
            comproven amb el depurador.</p>
          </TeacherNotes>
        </Section>

        {/* ===== SECCIÓ 6: CALL STACK I FLUX ENTRE OBJECTES ===== */}
        <Section id="callstack" number="6" title="Call Stack: seguir el flux entre objectes" color="orange">
          <p>
            En programació orientada a objectes, el codi "salta" entre classes constantment.
            El <strong>Call Stack</strong> (pila de crides) et mostra <strong>el camí</strong> que ha
            seguit el programa per arribar al punt actual.
          </p>

          <CodeBlock language="text" title="Exemple de Call Stack en un programa MVC">
{`incrementar():28    Comptador          ← ESTÀS AQUÍ
processarOpcio():64 ControladorComptador  ← qui l'ha cridat
iniciar():38        ControladorComptador  ← qui ha cridat processarOpcio
main():5            Main                  ← on ha començat tot`}
          </CodeBlock>

          <p>
            Llegit de dalt a baix: "Estic a <code>incrementar()</code> del Comptador,
            que ha estat cridat per <code>processarOpcio()</code> del Controlador,
            que ha estat cridat per <code>iniciar()</code>, que ha estat cridat per <code>main()</code>."
          </p>

          <MvcDiagram />

          <Callout type="idea">
            El Call Stack és especialment útil quan un error es manifesta a un lloc però
            la <strong>causa real</strong> és a qui l'ha cridat. Exemple: <code>decrementar()</code>
            funciona bé, però el Controlador crida <code>reiniciar()</code> en lloc de <code>decrementar()</code>!
          </Callout>

          <TeacherNotes visible={teacherMode} id="tn-6">
            <p><strong>Moment clau de la classe:</strong> Aquí és on el debugging i el MVC es connecten.
            Fes que vegin al Call Stack com Main → Controlador → Model. Relaciona-ho amb el diagrama MVC.</p>
            <p><strong>Pregunta per fer pensar:</strong> "Si el Call Stack diu que estem a <code>reiniciar()</code>
            però l'usuari ha triat 'Decrementar', on és el bug?" → Al Controlador, que crida el mètode equivocat.</p>
          </TeacherNotes>
        </Section>

        {/* ===== SECCIÓ 7: ESTRATÈGIES DE DEPURACIÓ ===== */}
        <Section id="estrategies" number="7" title="Estratègies de depuració" color="warning">
          <p>
            No es tracta de posar breakpoints a l'atzar. Hi ha un <strong>mètode</strong> per depurar
            de forma eficient:
          </p>

          <div className="strategy-list">
            <div className="strategy">
              <div className="strategy-num">1</div>
              <div>
                <h4>Reprodueix l'error</h4>
                <p>Executa el programa i identifica <strong>exactament</strong> què fa malament.
                "Si trio opció 1, el comptador baixa en lloc de pujar."</p>
              </div>
            </div>
            <div className="strategy">
              <div className="strategy-num">2</div>
              <div>
                <h4>Localitza el sospitós</h4>
                <p>Pensa: <strong>quin mètode</strong> és el responsable d'aquesta acció?
                En quina classe està? Ves directament allà.</p>
              </div>
            </div>
            <div className="strategy">
              <div className="strategy-num">3</div>
              <div>
                <h4>Posa el breakpoint</h4>
                <p>Al mètode sospitós, a la primera línia que modifica dades.</p>
              </div>
            </div>
            <div className="strategy">
              <div className="strategy-num">4</div>
              <div>
                <h4>Observa i compara</h4>
                <p>Executa en Debug. Mira les variables: <strong>el valor és el que esperes?</strong>
                Fes Step Over: <strong>ha canviat com esperaves?</strong></p>
              </div>
            </div>
            <div className="strategy">
              <div className="strategy-num">5</div>
              <div>
                <h4>Diagnostica i corregeix</h4>
                <p>Si el valor no és l'esperat, has trobat el bug. Entén <strong>per què</strong> falla
                abans de canviar res. Corregeix i verifica.</p>
              </div>
            </div>
          </div>

          <Callout type="danger">
            <strong>Anti-patró:</strong> Mai canviïs codi "a l'atzar" a veure si funciona.
            PRIMER entén el problema amb el depurador, DESPRÉS corregeix.
          </Callout>

          <TeacherNotes visible={teacherMode} id="tn-7">
            <p><strong>Aquesta és la secció més important.</strong> Si els alumnes recorden una sola cosa,
            ha de ser aquest procés de 5 passos. Escriu-los a la pissarra i fes-los seguir per trobar cada bug.</p>
            <p><strong>Analogia bona:</strong> "Si el cotxe fa soroll, no canvies peces a l'atzar.
            Primer escoltes d'on ve el soroll (reproduir), mires el motor (localitzar),
            i diagnostiques abans de tocar res."</p>
          </TeacherNotes>
        </Section>

        {/* ===== SECCIÓ 8: DEBUGGING + MVC ===== */}
        <Section id="mvc-debug" number="8" title="Debugging en un projecte MVC" color="accent">
          <p>
            Quan treballem amb el patró <strong>Model-Vista-Controlador</strong>, els bugs poden
            estar a qualsevol de les tres capes. El depurador ens ajuda a identificar
            <strong>a quina capa</strong> està el problema.
          </p>

          <CompareTable
            headers={['Símptoma', 'On buscar el bug', 'Per què']}
            rows={[
              ['El càlcul dóna un resultat incorrecte', 'MODEL', 'El Model és qui fa les operacions amb les dades'],
              ['El menú no mostra una opció', 'VISTA', 'La Vista s\'encarrega de mostrar i llegir'],
              ['L\'opció fa una acció diferent de l\'esperada', 'CONTROLADOR', 'El Controlador decideix quin mètode cridar'],
              ['El valor mostrat no coincideix amb el calculat', 'VISTA o CONTROLADOR', 'Pot ser que la Vista mostri malament o que el Controlador passi dades errònies'],
            ]}
          />

          <Callout type="success">
            <strong>Avantatge del MVC per depurar:</strong> Cada capa té una responsabilitat clara.
            Això facilita saber <strong>on buscar</strong> segons el tipus d'error.
            Sense MVC, tot estaria barrejat i seria molt més difícil.
          </Callout>

          <TeacherNotes visible={teacherMode} id="tn-8">
            <p><strong>Connexió amb l'exercici pràctic:</strong> Els 3 bugs de l'exercici estan dissenyats
            per cobrir exactament aquesta taula: Bug #1 i #2 al Model, Bug #3 al Controlador.
            Fes que els alumnes identifiquin a quina capa buscar ABANS d'obrir el depurador.</p>
          </TeacherNotes>
        </Section>

        {/* ===== SECCIÓ 9: MINI QUIZ ===== */}
        <Section id="quiz" number="9" title="Comprova el que has après" color="purple">
          <Quiz />
          <TeacherNotes visible={teacherMode} id="tn-quiz">
            <p><strong>Estadístiques del quiz (localStorage d'aquest navegador):</strong></p>
            <QuizStats />
          </TeacherNotes>
        </Section>

      </main>

      <footer className="footer">
        <p>RA3 · Disseny i realització de proves — Entorns de Desenvolupament (0487)</p>
        <p>La Salle Tarragona — DAM</p>
      </footer>
    </div>
  )
}

export default App
