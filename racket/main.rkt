#lang racket

;; Racket-Variante der Beispiele aus org.uni.Main

(define PREIS-PRO-LITER 2.0)

(define (println msg)
  (displayln msg))

(define (hello-und-schleifen)
  (println "Hello World!")
  (for ([i (in-range 1 6)])
    (println (format "i = ~a" i)))
  (for ([i (in-range 1 1001)])
    (println (format "Programmieren ist toll! ~a" i)))
  (define text "Hallo Welt")
  (define hallo (substring text 1 5))
  (println hallo)
  (void (string-contains? hallo "llo")))

(define (kreisberechnung)
  (define PI 3.14159)
  (define radius 5.223465379675679)
  (define umfang (* 2 PI radius))
  (define flaeche (* PI radius radius))
  (println (format "Der Kreis mit dem Radius: ~a , hat den Umfang von: ~a LE.~nSowie den Flächeninhalt von: ~a FE."
                   radius umfang flaeche)))

(define (bmi)
  (define gewicht 62.34)
  (define groesse 1.865)
  (define wert (/ gewicht (* groesse groesse)))
  (println (format "Dein BMI Wert beträgt: ~a" wert)))

(define (noten-bewertung note)
  (case note
    [(1) "Sehr gut"]
    [(2) "Gut"]
    [(3) "Befriedigend"]
    [(4) "Ausreichend"]
    [(5) "Mangelhaft"]
    [else "Ungültige Note"]))

(define (summen-berechnung start ende)
  (define summe (for/sum ([i (in-inclusive-range start ende)]) i))
  (println (format "Die Summe von ~a bis ~a ergibt: ~a" start ende summe)))

(define (quadrat-zahlen-bis grenze)
  (for ([zahl (in-naturals 1)]
        #:break (>= (* zahl zahl) grenze))
    (println (* zahl zahl))))

(define (energie-monitor)
  (for ([level (in-range 100 -10 -10)])
    (cond
      [(>= level 70) (println (format "Energie stabil ~a" level))]
      [(>= level 30) (println (format "Warnung: Energie sinkt ~a" level))]
      [(> level 0) (println (format "Kritisch! Energie fast erschöpft! ~a" level))]
      [else (println "Systeme abgeschaltet 0")])))

(define (benzin-preis)
  (define getankte-liter 62)
  (define preis-pro-liter 1.459)
  (define brutto (* getankte-liter preis-pro-liter))
  (define netto (* brutto (/ 100.0 119.0)))
  (println (format "Brutto Betrag beträgt: ~a" brutto))
  (println (format "Der Netto Betrag beträgt: ~a" netto)))

(define (pyramiden-volumen)
  (define h 280.0)
  (define g (* 440 440))
  (define volumen-ellen3 (* (/ 1.0 3.0) g h))
  (define meter-pro-elle 0.5236)
  (define m3-pro-roemischer-scheffel 0.00873)
  (define m3-pro-elle3 (expt meter-pro-elle 3))
  (define meterhoch3 (* volumen-ellen3 m3-pro-elle3))
  (define roemische-scheffel (/ meterhoch3 m3-pro-roemischer-scheffel))
  (println (format "Das Volumen beträgt ~a Ellen hoch 3, das entspricht ~a m3."
                   volumen-ellen3 meterhoch3))
  (println (format "Das Volumen entspricht ~a römischen Scheffeln." roemische-scheffel))
  (define anzahl-bloecke (/ volumen-ellen3 8))
  (println (format "Dafür werden etwa ~a Sandsteinblöcke (a 8 Ellen³) benötigt."
                   anzahl-bloecke)))

(define (stueckzahl-in-alte-masse stuecke)
  (define original stuecke)
  (define gros (quotient stuecke 144))
  (set! stuecke (remainder stuecke 144))
  (define schock (quotient stuecke 60))
  (set! stuecke (remainder stuecke 60))
  (define dutzend (quotient stuecke 12))
  (define rest (remainder stuecke 12))
  (println (format "~a N sind ~a Gros, ~a Schock, ~a Dutzend und ~a Stück."
                   original gros schock dutzend rest)))

;; Auto-Demo ------------------------------------------------------------

(struct auto (marke farbe tankstand max-tank kilometerstand verbrauch)
  #:mutable)

(define (mk-auto)
  (auto "VW" "Grün" 400.0 500.0 0.0 0.004))

(define (auto-volle-tankung! wagen)
  (define zubetanken (- (auto-max-tank wagen) (auto-tankstand wagen)))
  (set-auto-tankstand! wagen (auto-max-tank wagen))
  (define preis (* zubetanken PREIS-PRO-LITER))
  (println (format "Du musst ~a€ zahlen und das für ~a Liter." preis zubetanken))
  preis)

(define (auto-tanken-liter! wagen liter preis-pro-liter)
  (define tankmenge (+ liter (auto-tankstand wagen)))
  (if (<= tankmenge (auto-max-tank wagen))
      (begin
        (set-auto-tankstand! wagen tankmenge)
        (define kosten (* liter preis-pro-liter))
        (println (format "Du musst ~a€ zahlen, für ~a Liter." kosten liter))
        kosten)
      (let* ([zuviel (- tankmenge (auto-max-tank wagen))]
             [akzeptiert (- liter zuviel)]
             [kosten (* akzeptiert preis-pro-liter)])
        (set-auto-tankstand! wagen (auto-max-tank wagen))
        (println (format "Du musst ~a€ zahlen, du hast ~a Liter getankt." kosten akzeptiert))
        kosten)))

(define (auto-tanken-budget! wagen euro preis-pro-liter)
  (define liter (/ euro preis-pro-liter))
  (define theoretisch (+ liter (auto-tankstand wagen)))
  (if (<= theoretisch (auto-max-tank wagen))
      (begin
        (set-auto-tankstand! wagen theoretisch)
        (println (format "Du hast für ~a€ getankt. Das sind ~a Liter." euro liter))
        liter)
      (let* ([zuviel (- theoretisch (auto-max-tank wagen))]
             [akzeptiert (- liter zuviel)]
             [preis (* akzeptiert preis-pro-liter)]
             [rueckgeld (- euro preis)])
        (set-auto-tankstand! wagen (auto-max-tank wagen))
        (println (format "Du hast für ~a€ getankt. Das sind ~a Liter. Du bekommst ~a€ zurück."
                         preis akzeptiert rueckgeld))
        akzeptiert)))

(define (auto-fahre! wagen kilometer)
  (define kraftstoffverbrauch (* kilometer (auto-verbrauch wagen)))
  (if (<= kraftstoffverbrauch (auto-tankstand wagen))
      (begin
        (set-auto-tankstand! wagen (- (auto-tankstand wagen) kraftstoffverbrauch))
        (set-auto-kilometerstand! wagen (+ (auto-kilometerstand wagen) kilometer))
        (println (format "Das Auto ist ~a km gefahren und hat noch einen Tankstand von: ~a L."
                         kilometer (auto-tankstand wagen))))
      (let loop ([rest (auto-tankstand wagen)]
                 [gefahren 0])
        (if (<= rest 0)
            (println (format "Tank ist leer nach ~a km. Dein Kilometerstand beträgt: ~a"
                             gefahren (+ (auto-kilometerstand wagen) gefahren)))
            (loop (- rest (auto-verbrauch wagen))
                  (+ gefahren 1)))))))

(define (auto-demo)
  (define wagen (mk-auto))
  (auto-tanken-liter! wagen 30.5 PREIS-PRO-LITER)
  (auto-tanken-liter! wagen 40 PREIS-PRO-LITER)
  (auto-volle-tankung! wagen)
  (auto-tanken-budget! wagen 50 PREIS-PRO-LITER)
  (auto-fahre! wagen 1000))

;; Hauptprogramm --------------------------------------------------------

(define (komische-berechnungen)
  (kreisberechnung)
  (bmi)
  (for ([note (in-range 1 7)])
    (println (noten-bewertung note)))
  (summen-berechnung 10 30)
  (quadrat-zahlen-bis 200)
  (energie-monitor)
  (benzin-preis)
  (pyramiden-volumen)
  (stueckzahl-in-alte-masse 157))

(define (run)
  (hello-und-schleifen)
  (komische-berechnungen)
  (auto-demo))

(module+ main
  (run))
