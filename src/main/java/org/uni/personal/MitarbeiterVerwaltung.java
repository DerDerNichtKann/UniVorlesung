package org.uni.personal;
import java.util.ArrayList;

public class MitarbeiterVerwaltung {
    private final String nameDesUnternehmens;
    private final ArrayList<Mitarbeiter> alleMitarbeiter;

    public MitarbeiterVerwaltung(String name) {
        this.nameDesUnternehmens = name;
        this.alleMitarbeiter = new ArrayList<>();
    }

    public void hinzufuegen(Mitarbeiter m) {
        if (m != null) alleMitarbeiter.add(m);
    }

    public void entferneNachNummer(int nummer) {
        alleMitarbeiter.removeIf(m -> m.getMitarbeiterNr() == nummer);
    }

    public double berechneGesamtGehalt() {
        double summe = 0;
        for (Mitarbeiter m : alleMitarbeiter) summe += m.getGehalt();
        return summe;
    }

    public Mitarbeiter findeTeuerstenMitarbeiter() {
        if (alleMitarbeiter.isEmpty()) return null;
        Mitarbeiter teuerster = alleMitarbeiter.getFirst();
        for (Mitarbeiter m : alleMitarbeiter) {
            if (m.getGehalt() > teuerster.getGehalt()) teuerster = m;
        }
        return teuerster;
    }

    public ArrayList<Mitarbeiter> filtereNachJob(String job) {
        ArrayList<Mitarbeiter> gefiltert = new ArrayList<>();
        if (job == null) return gefiltert;
        for (Mitarbeiter m : alleMitarbeiter) {
            if (job.equals(m.getJobbezeichnung())) gefiltert.add(m);
        }
        return gefiltert;
    }

    public void erhoeheAllenGehalt(double prozent) {
        int anzahlHoheErhoehungen = 0;
        for (Mitarbeiter m : alleMitarbeiter) {
            m.erhoeheGehalt(prozent);
            if (prozent > 15) anzahlHoheErhoehungen++;
        }
        IO.println("Anzahl der hohen Erhöhungen: " + anzahlHoheErhoehungen);
    }

    public void alleAnzeigen() {
        IO.println("Mitarbeiterliste Firma: " + nameDesUnternehmens);
        for (Mitarbeiter m : alleMitarbeiter) m.anzeigen();
    }
}