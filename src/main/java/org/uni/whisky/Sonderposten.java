package org.uni.whisky;

public class Sonderposten extends Artikel{
    private double rabatt;
    public Sonderposten(String artikelNr, String bezeichnung, double einkaufspreis, int lagerzeit) {
        super(artikelNr, bezeichnung, einkaufspreis, lagerzeit);
    }
    public int berechneVerkaufspreis() {
        double preisMitSpanne = this.einkaufspreis * (1 + HANDELSSPANNE);
        if (lagerzeit > 12){
            rabatt = 0.3;
        } else {
            rabatt = 0.1;
        }
        double preisMitSpanneRabatt = preisMitSpanne * (1 - rabatt);
        double verkaufspreis = preisMitSpanneRabatt * (1 + MWST);
        return (int) Math.round(verkaufspreis);
    }

    public void anzeigen() {
        int verkaufspreis = this.berechneVerkaufspreis();
        IO.println(
                this.artikelNr + " " +
                        this.bezeichnung + " " +
                        "EK:" + (int)this.einkaufspreis + " " +
                        "VK: " + verkaufspreis + " Euro " +
                        "Lagerzeit: " + this.lagerzeit + " Monate " +
                        "Rabatt: " + this.rabatt
        );
    }
}
