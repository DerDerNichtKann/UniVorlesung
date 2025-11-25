package org.uni.personal;

public class Stundenloehner extends Mitarbeiter {
    private double stundenlohn;
    private int monatlicheArbeitsstunden;

    public Stundenloehner(int mitarbeiterNr, String name, double stundenlohn, int stunden) {
        super(mitarbeiterNr, name, 0, "Stundenloehner");
        this.stundenlohn = stundenlohn;
        this.monatlicheArbeitsstunden = stunden;
        aktualisiereGehalt();
    }

    private void aktualisiereGehalt() {
        this.gehalt = this.stundenlohn * this.monatlicheArbeitsstunden;
    }

    @Override
    public void anzeigen() {
        super.anzeigen();
        IO.println("  -> Detail: Stundenlohn: " + stundenlohn + ", Stunden: " + monatlicheArbeitsstunden);
        IO.println("  -> Vollzeit: " + (istVollzeit() ? "Ja" : "Nein"));
    }

    public boolean istVollzeit() {
        return monatlicheArbeitsstunden >= 160;
    }

    @Override
    public String getJobInfo() {
        return "Stundenloehner (" + stundenlohn + " EUR/h)";
    }
}