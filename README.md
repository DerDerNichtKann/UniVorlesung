# Gabis Programmier Unterricht

Ein Maven-Projekt für die begleitenden Beispiele aus Gabis Programmierunterricht. Ziel ist es, kleine Demo-Anwendungen aufzubauen, die in der Vorlesung oder in Übungen gezeigt werden können.

## Voraussetzungen
- JDK 25 (entspricht den Build-Targets in der `pom.xml`)
- Maven 3.9+

## Projektstruktur
```
.
├── pom.xml              # Maven-Konfiguration (Java 25, Lombok als Provided)
├── src/main/java        # Platz für Beispielcode und Übungen
└── racket/              # Alternative Implementierung der Übungen in Racket
```

## Build & Run
```bash
mvn clean package
```
Das Ergebnis liegt anschließend unter `target/`. Falls eine `main`-Klasse vorhanden ist, lässt sie sich mit `mvn exec:java -Dexec.mainClass=<FQN>` starten.

## Was macht das Programm?
`org.uni.Main` bündelt mehrere kleine Übungsroutinen:
- Ausgabe- und Schleifenbeispiele (`IO.println`, for/while-Schleifen, Strings).
- Mathematische Helfer wie Kreisberechnung, BMI, Summen- und Quadrat-Rechner.
- Simulationen wie ein Energiemonitor, Benzinpreisrechner, Pyramiden-Volumen und Stückzahlumrechnung in historische Maße.
- Fahrzeug-Demo (`Auto` in `org.uni.fahrzeuge`) mit Tanken/Fahren-Logik, verschiedenen Überladungen von `tanken()` sowie Verbrauchsberechnung.

Der `main`-Einstieg ruft nacheinander alle Demos auf; beim Start erhält man somit eine Textausgabe mit den Ergebnissen der Übungen.

## Racket-Version
Alle Routinen gibt es auch in `racket/main.rkt`. Ausführen lässt sich die Übersetzung mit:
```bash
racket racket/main.rkt
```
Die Racket-Variante deckt dieselben Aufgaben ab (Ausgaben, mathematische Helfer, Energiemonitor, Umrechnungen sowie die Auto-Simulation).

## Lernziele / Inhalte
- Sprachfeatures aus modernen Java-Versionen ausprobieren
- Kleine Übungsaufgaben und Lösungen sammeln
- Gemeinsame Coding-Sessions dokumentieren (z.B. Notizen oder Snippets)

## Nächste Schritte
1. Neue Übungen (z.B. Arrays, Collections, Fehlerbehandlung) ergänzen und sauber über Methoden strukturieren.
2. Bei Bedarf Tests oder eine einfache Menüführung hinzufügen, um gezielt einzelne Demos zu starten.
