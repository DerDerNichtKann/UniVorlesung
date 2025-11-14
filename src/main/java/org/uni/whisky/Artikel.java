package org.uni.whisky;

public class Artikel {
    String artikelNr;
    String bezeichnung;
    double einkaufspreis;
    int lagerzeit;

    final double HANDELSSPANNE = 0.6;
    final double MWST = 0.19;

    public Artikel(String artikelNr, String bezeichnung, double einkaufspreis, int lagerzeit) {
        this.artikelNr = artikelNr;
        this.bezeichnung = bezeichnung;
        this.einkaufspreis = einkaufspreis;
        this.lagerzeit = lagerzeit;
    }

    public int berechneVerkaufspreis() {
        double preisMitSpanne = this.einkaufspreis * (1 + HANDELSSPANNE);
        double verkaufspreis = preisMitSpanne * (1 + MWST);
        return (int) Math.round(verkaufspreis);
    }
    public void anzeigen() {
        int verkaufspreis = this.berechneVerkaufspreis();
        IO.println(
                this.artikelNr + " " +
                        this.bezeichnung + " " +
                        "EK:" + (int)this.einkaufspreis + " " +
                        "VK: " + verkaufspreis + " Euro " +
                        "Lagerzeit: " + this.lagerzeit + " Monate"
        );
    }
}