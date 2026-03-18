# EXERCICI: Comptador amb MVC i Debugging
## Aprèn a seguir el flux entre Model, Vista i Controlador

---

## OBJECTIU

Trobar 3 bugs usant el debugger i entendre com funciona MVC.

---

## FITXERS DEL PROJECTE

```
Main.java                  - Punt d'entrada
ControladorComptador.java  - Controlador (coordina tot)
Comptador.java             - Model (les dades)
VistaComptador.java        - Vista (la pantalla)
```

---

## QUÈ FA L'APLICACIÓ (quan funcioni bé)

És un comptador simple amb aquestes opcions:

```
=== COMPTADOR ===
1. Incrementar (+1)
2. Decrementar (-1)
3. Reiniciar (0)
4. Sortir
```

---

## QUÈ HAS DE FER

### PAS 1: Executa el programa

```bash
javac *.java
java Main
```

### PAS 2: Prova les opcions

**Prova opció 1 (Incrementar):**
- Tries 1
- El comptador hauria de passar de 0 a 1
- Però passa de 0 a -1 (ERROR!)

**Prova opció 3 (Reiniciar):**
- El comptador hauria d'anar a 0
- Però va a 1 (ERROR!)

**Prova opció 2 (Decrementar):**
- El comptador hauria de baixar 1
- Però fa coses estranyes (ERROR!)

---

## RECORDATORI: QUÈ ÉS MVC

### MODEL (Comptador.java)
- Emmagatzema les DADES (el valor del comptador)
- Fa els CÀLCULS (incrementar, decrementar)
- NO sap res de menús ni usuaris

### VISTA (VistaComptador.java)
- Mostra coses a PANTALLA
- Llegeix coses de l'USUARI
- NO fa càlculs ni guarda dades

### CONTROLADOR (ControladorComptador.java)
- COORDINA Model i Vista
- Decideix QUÈ fer segons l'opció
- TÉ el bucle principal

### MAIN (Main.java)
- Només INICIA el Controlador
- No fa res més

---

## TROBAR ELS BUGS

### BUG #1: Incrementar no funciona

**Què passa:**
Tries opció 1, el comptador BAIXA en lloc de PUJAR.

**On està el bug:**
Al MODEL (Comptador.java), mètode `incrementar()`

**Com trobar-lo amb debugger:**

1. Obre Comptador.java
2. Busca el mètode `incrementar()`
3. Posa un BREAKPOINT a la línia que fa `valor = ...`
4. Executa Main en mode DEBUG
5. Tria opció 1 al menú
6. El programa PARA al breakpoint
7. Mira el panell VARIABLES:
   - Quin valor té `valor` ABANS d'executar la línia?
   - Fes Step Over (F8/F10)
   - Quin valor té DESPRÉS?
8. ANALITZA: Si era 0 i ara és -1, què ha fet l'operació?
9. ARREGLA: Canvia l'operació perquè sumi en lloc de restar

---

### BUG #2: Reiniciar posa 1 en lloc de 0

**Què passa:**
Tries opció 3, el comptador va a 1 en lloc de 0.

**On està el bug:**
Al MODEL (Comptador.java), mètode `reiniciar()`

**Com trobar-lo:**

1. Breakpoint a `reiniciar()`
2. Debug
3. Tria opció 3
4. Observa què fa amb la variable `valor`
5. Hauria de posar-la a 0, però la posa a...?

---

### BUG #3: Decrementar fa coses rares

**Què passa:**
Tries opció 2, el comptador fa coses que no toquen.

**On està el bug:**
AL CONTROLADOR (ControladorComptador.java)

**PISTA IMPORTANT:** El mètode `decrementar()` del Model està BÉ!
El problema és que el Controlador NO EL CRIDA!

**Com trobar-lo:**

1. Obre ControladorComptador.java
2. Busca el mètode `processarOpcio()`
3. Busca el `case 2:` (opció decrementar)
4. Posa breakpoint a la línia després de `case 2:`
5. Debug, tria opció 2
6. Mira QUIN mètode del model està cridant
7. És el mètode correcte?

---

## CONSELLS

### On posar breakpoints

**BÉ:**
Dins del mètode que fa l'acció (incrementar, reiniciar, etc.)

**MALAMENT:**
Al Main (no passa res interessant allà)

---

### Què observar

**SEMPRE mira:**
- El valor de les variables ABANS de la línia
- El valor DESPRÉS de fer Step Over
- Si el valor és el que esperaves

---

### Step Over vs Step Into

**Step Over (F8 IntelliJ / F10 VS Code):**
Executa la línia i para a la següent
USA AIXÒ el 90% del temps

**Step Into (F7 / F11):**
Entra DINS del mètode
Usa això només si vols veure què fa un mètode

---

### Si et perds

**Mira el panell "Frames" o "Call Stack":**
Et diu on ets:
```
incrementar:23, Comptador
processarOpcio:45, ControladorComptador
iniciar:28, ControladorComptador
main:8, Main
```

Això vol dir: "Estàs a incrementar(), que ha estat cridat per processarOpcio(), etc."

---

## VERIFICACIÓ FINAL

Quan hagis arreglat els 3 bugs:

**Prova:**
1. Incrementar: 0 → 1 → 2 → 3 (OK!)
2. Decrementar: 3 → 2 → 1 → 0 (OK!)
3. Reiniciar: Qualsevol número → 0 (OK!)

**Si tot funciona:** HAS ACABAT!

---

## REPTE EXTRA (opcional)

Si acabes aviat, afegeix una nova funcionalitat:

**Opció 5: Multiplicar per 2**

Has de tocar 3 fitxers:
1. MODEL: Afegir mètode `multiplicarPerDos()`
2. VISTA: Afegir línia "5. Multiplicar per 2" al menú
3. CONTROLADOR: Afegir `case 5:` que cridi `model.multiplicarPerDos()`

---

## PREGUNTES FREQÜENTS

**P: El debugger no para!**
R: Has fet Debug (icona bug) i no Run (icona play)?

**P: No veig les variables**
R: Mira la part inferior de la pantalla, panell "Debug" → "Variables"

**P: M'he ficat dins de System.out.println i no sé sortir**
R: Prem Step Out (Shift+F8) o Continue (F9)

**P: He canviat el codi però segueix fallant**
R: Guarda el fitxer (Ctrl+S) i torna a compilar

---

## QUÈ HAURÀS APRÈS

Després d'aquest exercici sabràs:

1. Com Model, Vista i Controlador treballen junts
2. Com seguir el FLOW del programa amb el debugger
3. Com trobar bugs observant variables
4. Com cada capa de MVC té la seva responsabilitat

---

**IMPORTANT:** No tinguis pressa! És millor entendre 1 bug bé que trobar 3 sense entendre com.

Usa el debugger, observa, pensa, arregla. Aquest és el workflow professional!
